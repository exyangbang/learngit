package cn.kingnet.utp.service.persistence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 文件上送日志接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/16 20:10
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/fileUploadLog")
public interface IFileUploadLogHandler {

    /**
     * 文件上送日志：是否存在
     *
     * @param industryCode
     * @param batchId
     * @return
     */
    @PostMapping("/isExistFileUploadLogByBatchId")
    int countFileUploadLogByBatchId(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "batchId", required = false) String batchId,
            @RequestParam(value = "transStatus", required = false) String transStatus
    );

    /**
     * 文件上送日志：是否存在
     *
     * @param industryCode
     * @param clientTransId
     * @return
     */
    @PostMapping("/isExistFileUploadLogByClientTransId")
    int countFileUploadLogByClientTransId(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "clientTransId", required = false) String clientTransId,
            @RequestParam(value = "transStatus", required = false) String transStatus
    );
}
