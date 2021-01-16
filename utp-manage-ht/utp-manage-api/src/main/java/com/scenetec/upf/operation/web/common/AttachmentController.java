package com.scenetec.upf.operation.web.common;

import com.scenetec.upf.operation.config.ImageUploadConfig;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.service.common.AttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/11 下午4:55
 */
@RestController
@Api(value="上传文件",tags={"上传文件"})
public class AttachmentController {

    @Resource
    private AttachmentService attachmentService;

    @Resource
    private ImageUploadConfig imageUploadConfig;

    @RequestMapping(value = "/api/upload/image", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传图片,文件不能为空，大小不能超过10M")
    public String uploadImage(@RequestParam("file")MultipartFile file) {

        if (file.isEmpty()) {
            throw new SystemRuntimeException(ErrorCode.BSMAU004);
        }
        if (file.getSize() > imageUploadConfig.getMaxSize()) {
            throw new SystemRuntimeException(ErrorCode.BSMAU005);
        }

        String fileName = file.getOriginalFilename();
        String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
        fileExt = fileExt.toLowerCase();
        if (!imageUploadConfig.getType().contains(fileExt)) {
            throw  new SystemRuntimeException(ErrorCode.BSMAU006, fileExt);
        }

        return attachmentService.uploadImage(file);
    }
}
