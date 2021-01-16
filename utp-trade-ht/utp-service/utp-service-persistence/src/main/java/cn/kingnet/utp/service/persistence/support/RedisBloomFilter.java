package cn.kingnet.utp.service.persistence.support;

import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author WJH
 * @Date 2020/03/15
 */
@Slf4j
public class RedisBloomFilter {
    private static final String BF_KEY_PREFIX = "utp:bf:";

    private int numApproxElements;
    private double fpp;
    private int numHashFunctions;
    private int bitmapLength;

    private RedisTemplate redisTemplate;

    /**
     * 构造布隆过滤器。注意：在同一业务场景下，三个参数务必相同
     *
     * @param numApproxElements 预估元素数量
     * @param fpp               可接受的最大误差（假阳性率）
     * @param redisTemplate     Codis专用的Jedis连接池
     */
    public RedisBloomFilter(int numApproxElements, double fpp, RedisTemplate redisTemplate) {
        this.numApproxElements = numApproxElements;
        this.fpp = fpp;
        this.redisTemplate = redisTemplate;

        //guava提取
        bitmapLength = (int) (-numApproxElements * Math.log(fpp) / (Math.log(2) * Math.log(2)));
        numHashFunctions = Math.max(1, (int) Math.round((double) bitmapLength / numApproxElements * Math.log(2)));
    }

    /**
     * 取得自动计算的最优哈希函数个数
     */
    public int getNumHashFunctions() {
        return numHashFunctions;
    }

    /**
     * 取得自动计算的最优Bitmap长度
     */
    public int getBitmapLength() {
        return bitmapLength;
    }

    /**
     * 计算一个元素值哈希后映射到Bitmap的哪些bit上
     *
     * @param element 元素值
     * @return bit下标的数组
     */
    private long[] getBitIndices(String element) {
        long[] indices = new long[numHashFunctions];

        byte[] bytes = Hashing.murmur3_128()
                .hashObject(element, Funnels.stringFunnel(StandardCharsets.UTF_8))
                .asBytes();

        long hash1 = Longs.fromBytes(
                bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]
        );
        long hash2 = Longs.fromBytes(
                bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]
        );

        long combinedHash = hash1;
        for (int i = 0; i < numHashFunctions; i++) {
            indices[i] = (combinedHash & Long.MAX_VALUE) % bitmapLength;
            combinedHash += hash2;
        }

        return indices;
    }

    private String buildBfActualKey(String key) {
        return BF_KEY_PREFIX.concat(key);
    }

    /**
     * 插入元素
     *
     * @param key       原始Redis键，会自动加上'bf:'前缀
     * @param element   元素值，字符串类型
     * @param expireSec 过期时间（秒）
     */
    public void add(String key, String element, int expireSec) {
        if (key == null || element == null) {
            throw new RuntimeException("键值均不能为空");
        }
        String actualKey = buildBfActualKey(key);
        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            for (long index : getBitIndices(element)) {
                connection.setBit(actualKey.getBytes(), index, true);
            }
            return null;
        });
        redisTemplate.expire(actualKey, expireSec, TimeUnit.SECONDS);
    }

    /**
     * 检查元素在集合中是否存在 若存在则不一定真正存在， 若不存在则肯定不存在
     *
     * @param key     原始Redis键，会自动加上'bf:'前缀
     * @param element 元素值，字符串类型
     */
    public boolean mayExist(String key, String element) {
        if (key == null || element == null) {
            throw new RuntimeException("键值均不能为空");
        }
        String actualKey = buildBfActualKey(key);
        boolean result = false;

        List<Boolean> tfs = redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            for (long index : getBitIndices(element)) {
                connection.getBit(actualKey.getBytes(), index);
            }
            return null;
        });
        result = tfs.stream().allMatch(tf -> tf == true);
        return result;
    }
}
