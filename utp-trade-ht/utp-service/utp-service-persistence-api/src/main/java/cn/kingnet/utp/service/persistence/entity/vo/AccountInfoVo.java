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
public class AccountInfoVo implements java.io.Serializable {
    private Long id;

    /**
     * 虚拟账户账号
     */
    private String account;

    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户 8-个体工商户账户 9-待结算账户 10-小额打款支出账户）
     */
    private String objType;

    /**
     * 用户类型|0-个人 1-商户
     */
    private String userType;

    private String businessScope;

    /**
     * 企业注册资金
     */
    private String registerFund;

    /**
     * 营业执照有效期（yyyy-MM-dd）
     */
    private String businessIndate;

    /**
     * 法人证件有效期（yyyy-MM-dd）
     */
    private String legalIndate;

    /**
     * 控股股东或者实际控制人姓名
     */
    private String controlName;

    /**
     * 控股股东或者实际控制人证件类型
     */
    private String controlCerfileType;

    /**
     * 控股股东或者实际控制人证件号
     */
    private String controlCerfileNo;

    /**
     * 控股股东或者实际控制人证件有效期（yyyy-MM-dd）
     */
    private String controlIndate;

    /**
     * 负责人姓名
     */
    private String chargeName;

    /**
     * 负责人证件类型
     */
    private String chargeCerfileType;

    /**
     * 负责人证件号
     */
    private String chargeCerfileNo;

    /**
     * 负责人证件有效期（yyyy-MM-dd）
     */
    private String chargeIndate;

    /**
     * 授权办理业务人员姓名
     */
    private String authBusName;

    /**
     * 授权办理业务人员证件类型
     */
    private String authBusType;

    /**
     * 授权办理业务人员证件号
     */
    private String authBusNo;

    /**
     * 授权办理业务人员证件有效期（yyyy-MM-dd）
     */
    private String authBusIndate;

    /**
     * 客户经理
     */
    private String customerManager;

    /**
     * 客户经理联系方式（固话或者手机号码）
     */
    private String customerManagerPhone;

    /**
     * 企业类型
     */
    private String enterpriseType;

    /**
     * 企业规模
     */
    private String enterpriseSale;

    /**
     * 企业经济性质
     */
    private String enterpriseEcoNature;

    /**
     * 上市类型
     */
    private String listingType;

    /**
     * 居民类型 0非居民 1居民
     */
    private String residentType;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改用户
     */
    private String userModified;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 联系地址
     */
    private String contactAddress;

    /**
     * 营业执照生效日期
     */
    private String businessStartDate;

    /**
     * 法人证件生效日期
     */
    private String legalStartDate;

    /**
     * 实际控制人证件生效日期
     */
    private String controlStartDate;

    /**
     * 授权代理人证件生效日期
     */
    private String authBusStartDate;

    /**
     * 受益人1姓名
     */
    private String owneroneName;

    /**
     * 受益人1证件类型
     */
    private String owneroneCerfileType;

    /**
     * 受益人1证件号
     */
    private String owneroneCerfileNo;

    /**
     * 受益人1证件生效日期
     */
    private String owneroneStartDate;

    /**
     * 受益人1证件失效日期
     */
    private String owneroneInDate;

    /**
     * 受益人2姓名
     */
    private String ownertwoName;

    /**
     * 受益人2证件类型
     */
    private String ownertwoCerfileType;

    /**
     * 受益人2证件号
     */
    private String ownertwoCerfileNo;

    /**
     * 受益人2证件生效日期
     */
    private String ownertwoStartDate;

    /**
     * 受益人2证件失效日期
     */
    private String ownertwoInDate;

    /**
     * 受益人3姓名
     */
    private String ownerthreeName;

    /**
     * 受益人3证件类型
     */
    private String ownerthreeCerfileType;

    /**
     * 受益人3证件号
     */
    private String ownerthreeCerfileNo;

    /**
     * 受益人3证件生效日期
     */
    private String ownerthreeStartDate;

    /**
     * 受益人3证件失效日期
     */
    private String ownerthreeInDate;

    /**
     * 受益人4姓名
     */
    private String ownerfourName;

    /**
     * 受益人4证件类型
     */
    private String ownerfourCerfileType;

    /**
     * 受益人4证件号
     */
    private String ownerfourCerfileNo;

    /**
     * 受益人4证件生效日期
     */
    private String ownerfourStartDate;

    /**
     * 受益人4证件失效日期
     */
    private String ownerfourInDate;

    /**
     * 联系地址省
     */
    private String contactProvince;

    /**
     * 联系地址市
     */
    private String contactCity;

    /**
     * 联系地址区
     */
    private String contactArea;

    /**
     * 注册地址省
     */
    private String regProvince;

    /**
     * 注册地址市
     */
    private String regCity;

    /**
     * 注册地址区
     */
    private String regArea;
}