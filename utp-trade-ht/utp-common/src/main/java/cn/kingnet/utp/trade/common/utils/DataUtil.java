package cn.kingnet.utp.trade.common.utils;

import com.google.common.collect.Lists;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DataUtil {
    private static final Logger log = LoggerFactory.getLogger(DataUtil.class);

    /**
     * 文件转字节数组
     * @param file
     * @return
     */
    public static byte[] fileToByte(File file) {
        byte[] ret = null;
        try {
            if (file == null) {
                log.warn("入参文件不能为空");
                return ret;
            }
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(4096);
            byte[] b = new byte[4096];
            int n;
            while ((n = in.read(b)) != -1) {
                out.write(b, 0, n);
            }
            in.close();
            out.close();
            ret = out.toByteArray();
        } catch (Exception e) {
            log.error("文件转字节数据异常：", e);
        }
        return ret;
    }

    /**
     * 字节数组转文件保存
     * @param buf
     * @param filePath
     * @param fileName
     */
    public static File byte2File(byte[] buf, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        } catch (Exception e) {
            log.error("字节数组转文件保存异常：", e);
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    /**
     * @param textBytes txt文本字节数组
     * @param charSet
     * @return
     */
    public static List<String> byte2List(byte[] textBytes, String charSet) {
        ArrayList<String> list = Lists.newArrayList();
        InputStreamReader inReader = null;
        BufferedReader bufReader = null;
        try {
            inReader = new InputStreamReader(new ByteArrayInputStream(textBytes), charSet);
            bufReader = new BufferedReader(inReader);
            String line = null;
            while ((line = bufReader.readLine()) != null) {
                //过滤掉整行为空值的记录
                if (StringUtils.isNoneEmpty(line.trim())) {
                    list.add(line.concat(" "));
                }
            }
        } catch (Exception e) {
            log.error("字节数组转List集合异常：", e);
            throw new RuntimeException("字节数组转List集合异常", e);
        } finally {
            if (bufReader != null) {
                try {
                    bufReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inReader != null) {
                try {
                    inReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 解压缩.
     * @param inputByte byte[]数组类型的数据
     * @return 解压缩后的数据
     * @throws IOException
     */
    public static byte[] inflater(final byte[] inputByte) throws IOException {
        try {
            int compressedDataLength = 0;
            Inflater compresser = new Inflater(false);
            compresser.setInput(inputByte, 0, inputByte.length);
            ByteArrayOutputStream o = new ByteArrayOutputStream(inputByte.length);
            byte[] result = new byte[1024];
            try {
                while (!compresser.finished()) {
                    compressedDataLength = compresser.inflate(result);
                    if (compressedDataLength == 0) {
                        break;
                    }
                    o.write(result, 0, compressedDataLength);
                }
            } catch (Exception ex) {
                throw new RuntimeException("Inflater 解压缩数据异常：", ex);
            } finally {
                o.close();
            }
            compresser.end();
            return o.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Inflater 解压缩数据异常：", e);
        }
    }

    /**
     * base64解码后再解压缩
     * @param defalterAndEncode64Str 压缩后再base64编码字符串
     * @return 原字节数组
     */
    public static byte[] inflaterAndDecode64(String defalterAndEncode64Str) {
        try {
            byte[] deflaterAy = Base64.getDecoder().decode(defalterAndEncode64Str);
            return inflater(deflaterAy);
        } catch (IOException e) {
            throw new RuntimeException("base64解码解压缩异常:", e);
        }
    }

    /**
     * 压缩.
     * @param inputByte 需要解压缩的byte[]数组
     * @return 压缩后的数据
     * @throws IOException
     */
    public static byte[] deflater(final byte[] inputByte) throws IOException {
        try {
            int compressedDataLength = 0;
            Deflater compresser = new Deflater();
            compresser.setInput(inputByte);
            compresser.finish();
            ByteArrayOutputStream o = new ByteArrayOutputStream(inputByte.length);
            byte[] result = new byte[1024];
            try {
                while (!compresser.finished()) {
                    compressedDataLength = compresser.deflate(result);
                    o.write(result, 0, compressedDataLength);
                }
            } finally {
                o.close();
            }
            compresser.end();
            return o.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Deflater 压缩数据异常：", e);
        }
    }

    /**
     * 数据进行压缩后再base64编码
     * @param inputByte 数据
     * @return
     */
    public static String deflaterAndEncode64(byte[] inputByte) {
        try {
            byte[] deflaterAy = deflater(inputByte);
            return Base64.getEncoder().encodeToString(deflaterAy);
        } catch (IOException e) {
            throw new RuntimeException("数据压缩、base64编码异常:", e);
        }
    }

    /**
     * base64解码解压缩
     * @param defalterAndEncode64
     * @return
     */
    public static byte[] inflaterAndDecode64Byte(byte[] defalterAndEncode64) {
        try {
            byte[] deflaterAy = Base64.getDecoder().decode(defalterAndEncode64);
            return inflater(deflaterAy);
        } catch (IOException e) {
            throw new RuntimeException("base64解码解压缩异常:", e);
        }
    }

    /**
     * 数据压缩，BASE64编码
     * @param inputByte
     * @return
     */
    public static byte[] deflaterAndEncode64Byte(byte[] inputByte) {
        try {
            byte[] deflaterAy = deflater(inputByte);
            return Base64.getEncoder().encode(deflaterAy);
        } catch (IOException e) {
            throw new RuntimeException("数据压缩、base64编码异常:", e);
        }
    }

    /**
     * 将文件转换为Base64编码
     * @param filePath 文件路径
     * @return Base64编码
     */
    public static String fileToBase64Content(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        BASE64Encoder encoder = new BASE64Encoder();
        try (FileInputStream fin = new FileInputStream(file);
             BufferedInputStream bin = new BufferedInputStream(fin);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             BufferedOutputStream bout = new BufferedOutputStream(baos)) {
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while (len != -1) {
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节
            bout.flush();
            byte[] bytes = baos.toByteArray();
            String result = encoder.encodeBuffer(bytes).trim();
            // System.out.println("Base64编码：" + result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("文件转换为Base64编码异常:", e);
        }
    }

    /**
     * 将base64编码内容保存为文件
     * @param base64Content
     * @param targetPath    保存路径，包含文件名(文件格式需和原始base64文件格式一致)
     * @return 文件保存路径
     */
    public static String base64ContentToFile(String base64Content, String targetPath) {
        if (!isBase64Format(base64Content)) {
            return base64Content;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return base64ContentToFile(decoder.decodeBuffer(base64Content), targetPath);
        } catch (IOException e) {
            throw new RuntimeException("base64编码内容转换为文件异常:", e);
        }
    }

    /**
     * 将base64编码内容保存为文件
     * @param base64Byte
     * @param targetPath 保存路径，包含文件名(文件格式需和原始base64文件格式一致)
     * @return 文件保存路径
     */
    public static String base64ContentToFile(byte[] base64Byte, String targetPath) {
        File file;
        try {
            file = new File(targetPath);
            File path = file.getParentFile();
            if (!path.exists()) {
                path.mkdirs();
            }
        } catch (Exception e) {
            throw new RuntimeException("文件目录创建异常:", e);
        }

        try (ByteArrayInputStream byteInputStream = new ByteArrayInputStream(base64Byte);
             BufferedInputStream bis = new BufferedInputStream(byteInputStream);
             FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            //base64编码内容转换为字节数组
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
            return targetPath;
        } catch (Exception e) {
            throw new RuntimeException("base64编码内容转换为文件异常:", e);
        }
    }

    /**
     * 根据路径转为base64图片字符串
     * @param filePath 源图片路径，包含文件名
     * @return 图片base64字符串，未带前缀：data:image/jpg;base64,
     */
    public static String imageToBase64(String filePath) {
        Assert.hasText(filePath, "参数[filePath]不能为空");
        try {
            byte[] b = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(b);
        } catch (Exception e) {
            log.error("路径：[{}]，图片转base64异常==>{}", filePath, e.getMessage(), e);
            throw new RuntimeException("图片转换异常", e);
        }
    }

    /**
     * 判断是否为base64编码
     * @param content base64内容
     * @return
     */
    public static Boolean isBase64Format(String content) {
        content = content.trim();
        content = content.replaceAll("\r|\n", "");
        if (content.lastIndexOf(",") != -1) {
            content = content.substring(content.lastIndexOf(",") + 1);
        }
        String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
        return Pattern.matches(base64Pattern, content);
    }

    /**
     * 判断是否为存在真实文件的路径
     * @param filePath
     * @return true 文件格式正确
     */
    public static boolean isFilePath(String filePath) {
        Assert.hasText(filePath, "参数[filePath]不能为空");
        try {
            //判断是否为base64编码内容
            if (isBase64Format(filePath) || filePath.length() > 300) {
                return false;
            }
            String path = filePath.trim();
            if (filePath.contains("data:")) {
                return false;
            }
            Path file = new File(path).toPath();
            return Files.isRegularFile(file);
        } catch (Exception e) {
            log.error("文件路径==>{}，校验异常==>{}", filePath, e.getMessage());
            //throw new RuntimeException("文件路径校验异常", e);
        }
        return false;
    }
}