package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.AccountSettleDetail;
import cn.kingnet.utp.service.persistence.entity.FileUploadLog;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description : 清算批量文件对象
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 16:03
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountSettleBatchBO implements Serializable {

    private FileUploadLog fileUploadLog;

    private List<AccountSettleDetail> accountSettleDetailList;
}
