package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.AccountInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_account_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.AccountInfoMapper")
public class AccountInfo extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 虚拟账户账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户 8-个体工商户账户 9-待结算账户 10-小额打款支出账户）
     */
    @TableField(value = "obj_type")
    private String objType;

    /**
     * 用户类型|0-个人 1-商户
     */
    @TableField(value = "user_type")
    private String userType;

    @TableField(value = "business_scope")
    private String businessScope;

    /**
     * 企业注册资金
     */
    @TableField(value = "register_fund")
    private String registerFund;

    /**
     * 营业执照有效期（yyyy-MM-dd）
     */
    @TableField(value = "business_indate")
    private String businessIndate;

    /**
     * 法人证件有效期（yyyy-MM-dd）
     */
    @TableField(value = "legal_indate")
    private String legalIndate;

    /**
     * 控股股东或者实际控制人姓名
     */
    @TableField(value = "control_name")
    private String controlName;

    /**
     * 控股股东或者实际控制人证件类型
     */
    @TableField(value = "control_cerfile_type")
    private String controlCerfileType;

    /**
     * 控股股东或者实际控制人证件号
     */
    @TableField(value = "control_cerfile_no")
    private String controlCerfileNo;

    /**
     * 控股股东或者实际控制人证件有效期（yyyy-MM-dd）
     */
    @TableField(value = "control_indate")
    private String controlIndate;

    /**
     * 负责人姓名
     */
    @TableField(value = "charge_name")
    private String chargeName;

    /**
     * 负责人证件类型
     */
    @TableField(value = "charge_cerfile_type")
    private String chargeCerfileType;

    /**
     * 负责人证件号
     */
    @TableField(value = "charge_cerfile_no")
    private String chargeCerfileNo;

    /**
     * 负责人证件有效期（yyyy-MM-dd）
     */
    @TableField(value = "charge_indate")
    private String chargeIndate;

    /**
     * 授权办理业务人员姓名
     */
    @TableField(value = "auth_bus_name")
    private String authBusName;

    /**
     * 授权办理业务人员证件类型
     */
    @TableField(value = "auth_bus_type")
    private String authBusType;

    /**
     * 授权办理业务人员证件号
     */
    @TableField(value = "auth_bus_no")
    private String authBusNo;

    /**
     * 授权办理业务人员证件有效期（yyyy-MM-dd）
     */
    @TableField(value = "auth_bus_indate")
    private String authBusIndate;

    /**
     * 客户经理
     */
    @TableField(value = "customer_manager")
    private String customerManager;

    /**
     * 客户经理联系方式（固话或者手机号码）
     */
    @TableField(value = "customer_manager_phone")
    private String customerManagerPhone;

    /**
     * 企业类型
     */
    @TableField(value = "enterprise_type")
    private String enterpriseType;

    /**
     * 企业规模
     */
    @TableField(value = "enterprise_sale")
    private String enterpriseSale;

    /**
     * 企业经济性质
     */
    @TableField(value = "enterprise_eco_nature")
    private String enterpriseEcoNature;

    /**
     * 上市类型
     */
    @TableField(value = "listing_type")
    private String listingType;

    /**
     * 居民类型 0非居民 1居民
     */
    @TableField(value = "resident_type")
    private String residentType;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 联系地址
     */
    @TableField(value = "contact_address")
    private String contactAddress;

    /**
     * 营业执照生效日期
     */
    @TableField(value = "business_start_date")
    private String businessStartDate;

    /**
     * 法人证件生效日期
     */
    @TableField(value = "legal_start_date")
    private String legalStartDate;

    /**
     * 实际控制人证件生效日期
     */
    @TableField(value = "control_start_date")
    private String controlStartDate;

    /**
     * 授权代理人证件生效日期
     */
    @TableField(value = "auth_bus_start_date")
    private String authBusStartDate;

    /**
     * 受益人1姓名
     */
    @TableField(value = "ownerone_name")
    private String owneroneName;

    /**
     * 受益人1证件类型
     */
    @TableField(value = "ownerone_cerfile_type")
    private String owneroneCerfileType;

    /**
     * 受益人1证件号
     */
    @TableField(value = "ownerone_cerfile_no")
    private String owneroneCerfileNo;

    /**
     * 受益人1证件生效日期
     */
    @TableField(value = "ownerone_start_date")
    private String owneroneStartDate;

    /**
     * 受益人1证件失效日期
     */
    @TableField(value = "ownerone_in_date")
    private String owneroneInDate;

    /**
     * 受益人2姓名
     */
    @TableField(value = "ownertwo_name")
    private String ownertwoName;

    /**
     * 受益人2证件类型
     */
    @TableField(value = "ownertwo_cerfile_type")
    private String ownertwoCerfileType;

    /**
     * 受益人2证件号
     */
    @TableField(value = "ownertwo_cerfile_no")
    private String ownertwoCerfileNo;

    /**
     * 受益人2证件生效日期
     */
    @TableField(value = "ownertwo_start_date")
    private String ownertwoStartDate;

    /**
     * 受益人2证件失效日期
     */
    @TableField(value = "ownertwo_in_date")
    private String ownertwoInDate;

    /**
     * 受益人3姓名
     */
    @TableField(value = "ownerthree_name")
    private String ownerthreeName;

    /**
     * 受益人3证件类型
     */
    @TableField(value = "ownerthree_cerfile_type")
    private String ownerthreeCerfileType;

    /**
     * 受益人3证件号
     */
    @TableField(value = "ownerthree_cerfile_no")
    private String ownerthreeCerfileNo;

    /**
     * 受益人3证件生效日期
     */
    @TableField(value = "ownerthree_start_date")
    private String ownerthreeStartDate;

    /**
     * 受益人3证件失效日期
     */
    @TableField(value = "ownerthree_in_date")
    private String ownerthreeInDate;

    /**
     * 受益人4姓名
     */
    @TableField(value = "ownerfour_name")
    private String ownerfourName;

    /**
     * 受益人4证件类型
     */
    @TableField(value = "ownerfour_cerfile_type")
    private String ownerfourCerfileType;

    /**
     * 受益人4证件号
     */
    @TableField(value = "ownerfour_cerfile_no")
    private String ownerfourCerfileNo;

    /**
     * 受益人4证件生效日期
     */
    @TableField(value = "ownerfour_start_date")
    private String ownerfourStartDate;

    /**
     * 受益人4证件失效日期
     */
    @TableField(value = "ownerfour_in_date")
    private String ownerfourInDate;

    /**
     * 联系地址省
     */
    @TableField(value = "contact_province")
    private String contactProvince;

    /**
     * 联系地址市
     */
    @TableField(value = "contact_city")
    private String contactCity;

    /**
     * 联系地址区
     */
    @TableField(value = "contact_area")
    private String contactArea;

    /**
     * 注册地址省
     */
    @TableField(value = "reg_province")
    private String regProvince;

    /**
     * 注册地址市
     */
    @TableField(value = "reg_city")
    private String regCity;

    /**
     * 注册地址区
     */
    @TableField(value = "reg_area")
    private String regArea;

    public AccountInfoVo buildVo() {
        return new AccountInfoVo(id, account, objType, userType, businessScope, registerFund, businessIndate, legalIndate, controlName, controlCerfileType, controlCerfileNo, controlIndate, chargeName, chargeCerfileType, chargeCerfileNo, chargeIndate, authBusName, authBusType, authBusNo, authBusIndate, customerManager, customerManagerPhone, enterpriseType, enterpriseSale, enterpriseEcoNature, listingType, residentType, userCreate, gmtCreate, userModified, gmtModified, contactAddress, businessStartDate, legalStartDate, controlStartDate, authBusStartDate, owneroneName, owneroneCerfileType, owneroneCerfileNo, owneroneStartDate, owneroneInDate, ownertwoName, ownertwoCerfileType, ownertwoCerfileNo, ownertwoStartDate, ownertwoInDate, ownerthreeName, ownerthreeCerfileType, ownerthreeCerfileNo, ownerthreeStartDate, ownerthreeInDate, ownerfourName, ownerfourCerfileType, ownerfourCerfileNo, ownerfourStartDate, ownerfourInDate, contactProvince, contactCity, contactArea, regProvince, regCity, regArea);
    }

    public static AccountInfo of(AccountInfoVo vo) {
        return new AccountInfo(vo.getId(), vo.getAccount(), vo.getObjType(), vo.getUserType(), vo.getBusinessScope(), vo.getRegisterFund(), vo.getBusinessIndate(), vo.getLegalIndate(), vo.getControlName(), vo.getControlCerfileType(), vo.getControlCerfileNo(), vo.getControlIndate(), vo.getChargeName(), vo.getChargeCerfileType(), vo.getChargeCerfileNo(), vo.getChargeIndate(), vo.getAuthBusName(), vo.getAuthBusType(), vo.getAuthBusNo(), vo.getAuthBusIndate(), vo.getCustomerManager(), vo.getCustomerManagerPhone(), vo.getEnterpriseType(), vo.getEnterpriseSale(), vo.getEnterpriseEcoNature(), vo.getListingType(), vo.getResidentType(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getContactAddress(), vo.getBusinessStartDate(), vo.getLegalStartDate(), vo.getControlStartDate(), vo.getAuthBusStartDate(), vo.getOwneroneName(), vo.getOwneroneCerfileType(), vo.getOwneroneCerfileNo(), vo.getOwneroneStartDate(), vo.getOwneroneInDate(), vo.getOwnertwoName(), vo.getOwnertwoCerfileType(), vo.getOwnertwoCerfileNo(), vo.getOwnertwoStartDate(), vo.getOwnertwoInDate(), vo.getOwnerthreeName(), vo.getOwnerthreeCerfileType(), vo.getOwnerthreeCerfileNo(), vo.getOwnerthreeStartDate(), vo.getOwnerthreeInDate(), vo.getOwnerfourName(), vo.getOwnerfourCerfileType(), vo.getOwnerfourCerfileNo(), vo.getOwnerfourStartDate(), vo.getOwnerfourInDate(), vo.getContactProvince(), vo.getContactCity(), vo.getContactArea(), vo.getRegProvince(), vo.getRegCity(), vo.getRegArea());
    }
}
