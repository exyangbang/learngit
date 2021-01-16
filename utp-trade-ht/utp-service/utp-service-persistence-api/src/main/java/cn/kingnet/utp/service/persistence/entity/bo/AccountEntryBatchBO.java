package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.AccountEntryDetail;
import cn.kingnet.utp.service.persistence.entity.FileUploadLog;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description : 入账批量对象
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/17 18:48
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntryBatchBO implements Serializable {

    private FileUploadLog fileUploadLog;

    private List<AccountEntryDetail> accountEntryDetailList;
}
