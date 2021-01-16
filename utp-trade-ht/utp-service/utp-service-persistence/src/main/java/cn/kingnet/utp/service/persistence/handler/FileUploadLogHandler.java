package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IFileUploadLogHandler;
import cn.kingnet.utp.service.persistence.entity.FileUploadLogCondition;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/17 10:42
 */
@RestController
@RequestMapping("/spi/persistence/fileUploadLog")
@Slf4j
public class FileUploadLogHandler extends DefaultFeginExceptionHandler implements IFileUploadLogHandler {

    @Override
    @PostMapping("/isExistFileUploadLogByBatchId")
    public int countFileUploadLogByBatchId(@RequestParam(value = "industryCode", required = false) String industryCode,@RequestParam(value = "batchId", required = false) String batchId,@RequestParam(value = "transStatus", required = false) String transStatus) {
        FileUploadLogCondition fileUploadLogCondition = FileUploadLogCondition.builder();
        fileUploadLogCondition.andIndustryCodeEq(industryCode).andBatchIdEq(batchId);
        if(StringUtil.isNotBlank(transStatus)){
            fileUploadLogCondition.andTransStatusEq(transStatus);
        }
        return MybatisDaoImpl.run().selectCount(fileUploadLogCondition.build());
    }

    @Override
    @PostMapping("/isExistFileUploadLogByClientTransId")
    public int countFileUploadLogByClientTransId(@RequestParam(value = "industryCode", required = false) String industryCode,@RequestParam(value = "clientTransId", required = false) String clientTransId,@RequestParam(value = "transStatus", required = false) String transStatus) {
        FileUploadLogCondition fileUploadLogCondition = FileUploadLogCondition.builder();
        fileUploadLogCondition.andIndustryCodeEq(industryCode).andClientTransIdEq(clientTransId);
        if(StringUtil.isNotBlank(transStatus)){
            fileUploadLogCondition.andTransStatusEq(transStatus);
        }
        return MybatisDaoImpl.run().selectCount(fileUploadLogCondition.build());
    }
}
