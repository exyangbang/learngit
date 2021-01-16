package com.scenetec.upf.operation.service.common;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/11 下午5:07
 */
public interface AttachmentService {
    /**
     * 保存图片
     * @param file 图片文件
     * @return 图片相对路径
     */
    String uploadImage(MultipartFile file);
}
