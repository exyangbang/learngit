package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 开户认证审核
 * @Author : linkaigui
 * @Create : 2020/3/24 17:43
 */
@Getter
@Setter
public class AccountAuditBO implements Serializable {

    private MerchantInfo merchantInfo;
}
