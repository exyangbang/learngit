package cn.buyforyou.sign.crypto.api;

import cn.buyforyou.sign.crypto.api.UnionCSSP.Recv;
import com.union.utils.Checker;
import com.union.utils.Hex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批量加解密
 */
public final class UnionCipherForMC {

    private final String       mode            = "1";
    private final String       keyName;
    private final String       keyValue        = "";
    private final String       algorithmID;
    private final String       iv;
    private final String       format;
    private final String       dataType        = "1";
    private final String       separator       = "|";
    private final String       exportFlag      = "1";
    protected List<Integer>    split;

    private static UnionCSSP   cssp            = new UnionCSSP();

    public static final String algorithmID_ECB = "0";
    public static final String algorithmID_CBC = "1";
    public static final int    MAX_BUFFER_SIZE = 8192;

    /**
     * 初始化
     * 
     * @param keyName
     *            用于加解密的密钥名称
     * @param algorithmID
     *            {@link #algorithmID_ECB} ECB 模式， {@link #algorithmID_CBC} CBC 模式
     * @param iv
     *            初始向量，当algorithmID为1时存在，且当算法为SM4时，iv=32H，当算法为DES时，iv =
     *            16H，当算法为AES时，iv = 32H
     * @param format
     *            密文数据格式，可选：默认为0 0：不带填充 1：4字节明文长度+明文+补位‘0’ 2：填充0x00 3：填充0x80
     */
    public UnionCipherForMC(String keyName, String algorithmID, String iv, String format) {
        this.keyName = Checker.checkNotNull(keyName);
        this.algorithmID = Checker.checkNotNull(algorithmID);
        this.iv = Checker.checkNotNull(iv);
        this.format = Checker.checkNotNull(format);
    }

    public List<byte[]> mapToList(Map<String, byte[]> map, boolean flag) {
        List<byte[]> list = new ArrayList<byte[]>();
        if (!flag) {
            for (Map.Entry<String, byte[]> entr : map.entrySet()) {
                list.add(entr.getValue());
            }
        } else {
            for (Map.Entry<String, byte[]> entr : map.entrySet()) {
                list.add(Hex.decode(new String(entr.getValue())));
            }
        }

        return list;
    }

    public Map<String, byte[]> listToMap(Map<String, byte[]> maps, List<byte[]> list, boolean flag) {
        Map<String, byte[]> result = new HashMap<String, byte[]>();
        int i = 0;
        if (!flag) {
            for (Map.Entry<String, byte[]> map : maps.entrySet()) {
                result.put(map.getKey(), Hex.encode(list.get(i)).getBytes());
                i++;
            }
        } else {
            for (Map.Entry<String, byte[]> map : maps.entrySet()) {
                result.put(map.getKey(), list.get(i));
                i++;
            }
        }
        return result;
    }

    /**
     * 批量加密数据
     * 
     * @param plaintexts
     *            明文数据，参数类型Map中，String表示需要加密的字段的字段名，byte[]表示需要加密的明文数据
     * @return 加密后的数据，Map中的String表示需要加密的字段的字段名，byte[]表示该字段对应的加密数据
     * @throws NullPointerException
     *             {@code plaintexts}为{@code null} 或 {@code recv}为{@code null}
     * @throws IllegalStateException
     *             {@code servE160}服务错误
     */
    public final Map<String, byte[]> encrypt(Map<String, byte[]> plaintexts) {
        Checker.checkNotNull(plaintexts, "plaintexts is null");
        try {
            final String plaintext = encode(mapToList(plaintexts, false));
            final StringBuilder builder = new StringBuilder();
            for (int i = 1, size = split.size(); i < size; i++) {
                final String data = plaintext.substring(split.get(i - 1), split.get(i));
                Recv recv = cssp.servE160(mode, keyName, keyValue, algorithmID, data.getBytes(), iv, format, dataType, separator);
                Checker.checkNotNull(recv, "recv is null.");
                Checker.checkState(recv.getResponseCode() == 0, recv.getResponseRemark());
                builder.append(new String(recv.getData()));
            }
            split.clear();
            return listToMap(plaintexts, decode(builder.toString()), false);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    /**
     * 批量解密数据
     * 
     * @param ciphertexts
     *            密文数据，参数类型Map中，String表示需要解密的字段的字段名，byte[]表示需要解密的密文数据
     * @return 明文数据，Map中的String表示需要解密的字段的字段名，byte[]表示该字段对应的明文数据
     * @throws NullPointerException
     *             {@code ciphertexts}为{@code null} 或 {@code recv}为{@code null}
     * @throws IllegalStateException
     *             {@code servE161}服务错误
     */
    public Map<String, byte[]> decrypt(Map<String, byte[]> ciphertexts) {
        Checker.checkNotNull(ciphertexts, "plaintexts is null");
        try {
            final String ciphertext = encode(mapToList(ciphertexts, true));
            final StringBuilder builder = new StringBuilder();
            for (int i = 1, size = split.size(); i < size; i++) {
                final String data = ciphertext.substring(split.get(i - 1), split.get(i));
                Recv recv = cssp.servE161(mode, keyName, keyValue, algorithmID, exportFlag, data.getBytes(), iv, format, separator);
                Checker.checkNotNull(recv, "recv is null.");
                Checker.checkState(recv.getResponseCode() == 0, recv.getResponseRemark());
                builder.append(new String(recv.getData()));
            }
            split.clear();
            return listToMap(ciphertexts, decode(builder.toString()), true);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    final String encode(List<byte[]> bytes) {
        final StringBuilder builder = new StringBuilder();
        split = new ArrayList<Integer>();
        split.add(0);
        for (int i = 0, size = bytes.size(); i < size; i++) {
            final String temp = Hex.encode(Checker.checkNotNull(bytes.get(i))) + separator;
            if (temp.length() + (builder.length() - split.get(split.size() - 1)) > MAX_BUFFER_SIZE) {
                split.add(builder.length());
            }
            builder.append(temp);
        }
        split.add(builder.length());
        return builder.toString();
    }

    final List<byte[]> decode(String string) {
        int postion = 0, index = 0;
        final List<byte[]> list = new ArrayList<byte[]>();
        do {
            byte[] bytes = new byte[0];
            index = string.indexOf(separator, postion);
            index = index == -1 ? string.length() : index;
            bytes = Hex.decode(string.substring(postion, index));
            list.add(bytes);
            postion = index + 1;
        } while (postion < string.length());
        return list;
    }
}
