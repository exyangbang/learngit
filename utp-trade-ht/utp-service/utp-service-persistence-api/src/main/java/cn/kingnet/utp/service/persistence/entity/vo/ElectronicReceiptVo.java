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
public class ElectronicReceiptVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 电子回单号
     */
    private String orderNo;

    /**
     * 校验值
     */
    private String md5Hex;

    /**
     * json参数字符串
     */
    private String params;

    /**
     * pdf文件路径
     */
    private String filePath;

    /**
     * 交易流水ID
     */
    private String serverTransId;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 客户请求流水号
     */
    private String clientTransId;

    /**
     * 平台号
     */
    private String industryCode;

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