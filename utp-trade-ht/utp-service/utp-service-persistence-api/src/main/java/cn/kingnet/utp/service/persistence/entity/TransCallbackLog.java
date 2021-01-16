package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.TransCallbackLogVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_trans_callback_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.TransCallbackLogMapper")
public class TransCallbackLog extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 回调内容
     */
    @TableField(value = "callback_resp")
    private String callbackResp;

    public TransCallbackLogVo buildVo() {
        return new TransCallbackLogVo(id, gmtCreate, gmtModified, userCreate, userModified, callbackResp);
    }

    public static TransCallbackLog of(TransCallbackLogVo vo) {
        return new TransCallbackLog(vo.getId(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getCallbackResp());
    }
}