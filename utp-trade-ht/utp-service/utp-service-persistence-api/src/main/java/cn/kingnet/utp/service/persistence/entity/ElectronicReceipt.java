package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.ElectronicReceiptVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_electronic_receipt")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.ElectronicReceiptMapper")
public class ElectronicReceipt extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 电子回单号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 校验值
     */
    @TableField(value = "md5_hex")
    private String md5Hex;

    /**
     * json参数字符串
     */
    @TableField(value = "params")
    private String params;

    /**
     * pdf文件路径
     */
    @TableField(value = "file_path")
    private String filePath;

    /**
     * 交易流水ID
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 交易类型
     */
    @TableField(value = "trade_type")
    private String tradeType;

    /**
     * 客户请求流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 平台号
     */
    @TableField(value = "industry_code")
    private String industryCode;

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

    public ElectronicReceiptVo buildVo() {
        return new ElectronicReceiptVo(id, orderNo, md5Hex, params, filePath, serverTransId, tradeType, clientTransId, industryCode, userCreate, gmtCreate, userModified, gmtModified, fileContent);
    }

    public static ElectronicReceipt of(ElectronicReceiptVo vo) {
        return new ElectronicReceipt(vo.getId(), vo.getOrderNo(), vo.getMd5Hex(), vo.getParams(), vo.getFilePath(), vo.getServerTransId(), vo.getTradeType(), vo.getClientTransId(), vo.getIndustryCode(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getFileContent());
    }
}