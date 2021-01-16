package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.CardBinInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("kkpay_card_bin_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.CardBinInfoMapper")
public class CardBinInfo extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 发卡行机构代码
     */
    @TableField(value = "ISSUERCODE")
    private String issuercode;

    /**
     * 发卡机构名称
     */
    @TableField(value = "ISSUERNAME")
    private String issuername;

    /**
     * 卡名称
     */
    @TableField(value = "CARDNAME")
    private String cardname;

    /**
     * 主账号读取磁道
     */
    @TableField(value = "CARDNOTRACK")
    private String cardnotrack;

    /**
     * 主账号起始字节
     */
    @TableField(value = "CARDNOSTART_POS")
    private String cardnostartPos;

    /**
     * 主账号长度
     */
    @TableField(value = "CARDNOLEN")
    private String cardnolen;

    /**
     * 卡BIN号
     */
    @TableField(value = "BINNUM")
    private String binnum;

    /**
     * 卡BIN读取磁道
     */
    @TableField(value = "BINTRACK")
    private String bintrack;

    /**
     * 卡BIN起始字节
     */
    @TableField(value = "BINSTARTPOS")
    private String binstartpos;

    /**
     * 卡BIN长度
     */
    @TableField(value = "BINLEN")
    private String binlen;

    /**
     * 全部磁道信息
     */
    @TableField(value = "ALLTRACK")
    private String alltrack;

    /**
     * 全部磁道起始字节
     */
    @TableField(value = "ALLTRACKSTARTPOS")
    private String alltrackstartpos;

    /**
     * 第2以及3磁道长度
     */
    @TableField(value = "ALLTRACKLEN")
    private String alltracklen;

    /**
     * 是否银联卡品牌
     */
    @TableField(value = "CUPLOGOFLAG")
    private String cuplogoflag;

    /**
     * 卡种(D-借记卡;C-贷记卡;Z-准贷记卡;Y-预付卡)
     */
    @TableField(value = "debitcreditflag")
    private String debitcreditflag;

    /**
     * 本期增减状态
     */
    @TableField(value = "ADDDELETESTAT")
    private String adddeletestat;

    /**
     * 人行清算行行号
     */
    @TableField(value = "CLEARBANKNO")
    private String clearbankno;

    /**
     * 人行清算行行名
     */
    @TableField(value = "CLEARBANKNAME")
    private String clearbankname;

    /**
     * 状态
     */
    @TableField(value = "STATUS")
    private String status;

    /**
     * 保留使用
     */
    @TableField(value = "ADDDATA")
    private String adddata;

    /**
     * 备注1
     */
    @TableField(value = "REMARK1")
    private String remark1;

    /**
     * 备注2
     */
    @TableField(value = "REMARK2")
    private String remark2;

    /**
     * 备注3
     */
    @TableField(value = "REMARK3")
    private String remark3;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(value = "CREATEOR")
    private String createor;

    /**
     * 修改人
     */
    @TableField(value = "UPDATEOR")
    private String updateor;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 所属行行号
     */
    @TableField(value = "bankcode")
    private String bankcode;

    /**
     * 所属行行名
     */
    @TableField(value = "bankname")
    private String bankname;

    /**
     * 所属行分类标识(0-一般银行,1-村镇银行,2-港澳外资银行)
     */
    @TableField(value = "banktypeflag")
    private String banktypeflag;

    public CardBinInfoVo buildVo() {
        return new CardBinInfoVo(id, issuercode, issuername, cardname, cardnotrack, cardnostartPos, cardnolen, binnum, bintrack, binstartpos, binlen, alltrack, alltrackstartpos, alltracklen, cuplogoflag, debitcreditflag, adddeletestat, clearbankno, clearbankname, status, adddata, remark1, remark2, remark3, createTime, createor, updateor, updateTime, bankcode, bankname, banktypeflag);
    }

    public static CardBinInfo of(CardBinInfoVo vo) {
        return new CardBinInfo(vo.getId(), vo.getIssuercode(), vo.getIssuername(), vo.getCardname(), vo.getCardnotrack(), vo.getCardnostartPos(), vo.getCardnolen(), vo.getBinnum(), vo.getBintrack(), vo.getBinstartpos(), vo.getBinlen(), vo.getAlltrack(), vo.getAlltrackstartpos(), vo.getAlltracklen(), vo.getCuplogoflag(), vo.getDebitcreditflag(), vo.getAdddeletestat(), vo.getClearbankno(), vo.getClearbankname(), vo.getStatus(), vo.getAdddata(), vo.getRemark1(), vo.getRemark2(), vo.getRemark3(), vo.getCreateTime(), vo.getCreateor(), vo.getUpdateor(), vo.getUpdateTime(), vo.getBankcode(), vo.getBankname(), vo.getBanktypeflag());
    }
}