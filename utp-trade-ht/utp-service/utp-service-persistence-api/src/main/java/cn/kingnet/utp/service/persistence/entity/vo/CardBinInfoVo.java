package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CardBinInfoVo implements java.io.Serializable {
    private Long id;

    /**
     * 发卡行机构代码
     */
    private String issuercode;

    /**
     * 发卡机构名称
     */
    private String issuername;

    /**
     * 卡名称
     */
    private String cardname;

    /**
     * 主账号读取磁道
     */
    private String cardnotrack;

    /**
     * 主账号起始字节
     */
    private String cardnostartPos;

    /**
     * 主账号长度
     */
    private String cardnolen;

    /**
     * 卡BIN号
     */
    private String binnum;

    /**
     * 卡BIN读取磁道
     */
    private String bintrack;

    /**
     * 卡BIN起始字节
     */
    private String binstartpos;

    /**
     * 卡BIN长度
     */
    private String binlen;

    /**
     * 全部磁道信息
     */
    private String alltrack;

    /**
     * 全部磁道起始字节
     */
    private String alltrackstartpos;

    /**
     * 第2以及3磁道长度
     */
    private String alltracklen;

    /**
     * 是否银联卡品牌
     */
    private String cuplogoflag;

    /**
     * 卡种(D-借记卡;C-贷记卡;Z-准贷记卡;Y-预付卡)
     */
    private String debitcreditflag;

    /**
     * 本期增减状态
     */
    private String adddeletestat;

    /**
     * 人行清算行行号
     */
    private String clearbankno;

    /**
     * 人行清算行行名
     */
    private String clearbankname;

    /**
     * 状态
     */
    private String status;

    /**
     * 保留使用
     */
    private String adddata;

    /**
     * 备注1
     */
    private String remark1;

    /**
     * 备注2
     */
    private String remark2;

    /**
     * 备注3
     */
    private String remark3;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createor;

    /**
     * 修改人
     */
    private String updateor;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 所属行行号
     */
    private String bankcode;

    /**
     * 所属行行名
     */
    private String bankname;

    /**
     * 所属行分类标识(0-一般银行,1-村镇银行,2-港澳外资银行)
     */
    private String banktypeflag;
}