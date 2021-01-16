package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhongli
 * @date 2019-02-21 
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BindBo {
    MerchantInfo merchantInfo;
    MerchantAccountInfo merchantAccountInfo;
}
