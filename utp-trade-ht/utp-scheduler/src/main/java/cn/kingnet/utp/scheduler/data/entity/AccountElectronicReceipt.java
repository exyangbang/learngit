package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_account_electronic_receipt")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.AccountElectronicReceiptMapper")
public class AccountElectronicReceipt extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 电子回单号
     */
    @TableField(value = "receipt_no")
    private String receiptNo;

    /**
     * 校验值
     */
    @TableField(value = "md5_hex")
    private String md5Hex;

    /**
     * pdf文件路径
     */
    @TableField(value = "file_path")
    private String filePath;

    /**
     * 虚拟账户
     */
    @TableField(value = "account")
    private String account;

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
     * pdf文件内容
     */
    @TableField(value = "file_content")
    private byte[] fileContent;
}