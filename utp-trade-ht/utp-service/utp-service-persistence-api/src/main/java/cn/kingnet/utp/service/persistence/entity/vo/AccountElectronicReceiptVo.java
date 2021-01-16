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
public class AccountElectronicReceiptVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 电子回单号
     */
    private String receiptNo;

    /**
     * 校验值
     */
    private String md5Hex;

    /**
     * pdf文件路径
     */
    private String filePath;

    /**
     * 虚拟账户
     */
    private String account;

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
     * pdf文件内容
     */
    private byte[] fileContent;
}