package com.scenetec.upf.operation.service.common.impl;


import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.service.common.AttachmentService;
import com.scenetec.upf.operation.utils.FtpUtils;
import com.scenetec.upf.operation.utils.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/11 下午5:01
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    private Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    @Resource
    private FtpUtils ftpUtils;

    @Override
    public String uploadImage(MultipartFile file) {
        if (logger.isDebugEnabled()) {
            logger.debug("开始上传图片");
        }
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new SystemRuntimeException(ErrorCode.BSMAU001);
        }
        String picNewName = UploadUtil.generateRandomFileName(file.getOriginalFilename());
        String imagePath = UploadUtil.generateRandomDir();

        boolean isUploadSuccess = ftpUtils.uploadFile(picNewName, inputStream, imagePath);

        if (!isUploadSuccess) {
            throw new SystemRuntimeException(ErrorCode.BSMAU002);
        }
        return imagePath+File.separator+picNewName;
    }

}
