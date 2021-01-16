package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/10/30
 */
@Getter
@Setter
@AllArgsConstructor
public class Address implements Serializable {
    /**
     * 详细地址	STRING(200)	Y	开户必输
     */
    private String address;
    /**
     * 地址类型	STRING(20)	Y	开户必输（301）
     */
    private String AdrUsageTpCd = "301";
    /**
     * 省	STRING(10)	Y	开户必输 前端控制，兼容存量数据与ecif交互时只校验address必填即可
     */
    private String AdrOneCode;
    /**
     * 市	STRING(10)	Y	开户必输
     */
    private String AdrTwoCode;
    /**
     * 区	STRING(10)	Y	开户必输
     */
    private String AdrThreeCode;

}
