package cn.kingnet.utp.reconciliation.configuration;

import cn.kingnet.framework.starter.redis.RedisJsonWraper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import org.apache.commons.io.IOUtils;
import org.redisson.client.codec.BaseCodec;
import org.redisson.client.handler.State;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Author WJH
 * @Date 2020/04/17
 */
public class FastJsonForRedisCodec extends BaseCodec {
    private final Encoder encoder;
    private final Decoder<Object> decoder;

    public FastJsonForRedisCodec() {
        ParserConfig.getGlobalInstance().addAccept("spring.");
        ParserConfig.getGlobalInstance().addAccept("org.");
        ParserConfig.getGlobalInstance().addAccept("com.");
        ParserConfig.getGlobalInstance().addAccept("cn.");
        ParserConfig.getGlobalInstance().addAccept("cn.kingnet.");

        this.encoder = new Encoder() {
            @Override
            public ByteBuf encode(Object in) throws IOException {
                ByteBuf out = ByteBufAllocator.DEFAULT.buffer();
                try {
                    ByteBufOutputStream os = new ByteBufOutputStream(out);
                    byte[] inBytes = JSON.toJSONString(new RedisJsonWraper(in), new SerializerFeature[]{SerializerFeature.WriteClassName, SerializerFeature.DisableCircularReferenceDetect}).getBytes(StandardCharsets.UTF_8);
                    IOUtils.copy(new ByteArrayInputStream(inBytes), os);
                    return os.buffer();
                } catch (IOException var4) {
                    out.release();
                    throw var4;
                }
            }
        };
        this.decoder = new Decoder<Object>() {
            @Override
            public Object decode(ByteBuf buf, State state) throws IOException {
                RedisJsonWraper wraperGet = (RedisJsonWraper) JSON.parseObject(new ByteBufInputStream(buf), RedisJsonWraper.class);
                return wraperGet.getValue();
            }
        };
    }

    @Override
    public Decoder<Object> getValueDecoder() {
        return this.decoder;
    }

    @Override
    public Encoder getValueEncoder() {
        return this.encoder;
    }


}
