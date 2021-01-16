package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.vo.AccountDetailVo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * @author zhongli
 * @date 2019-02-25 
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EleReceiptNoticeBO extends AccountDetailVo {
    private Long id;

    private String time;

    private String serverTransId;

    private String tradeType;
    /**
     * 报文内容
     */
    private Map<String, String> content;

}
