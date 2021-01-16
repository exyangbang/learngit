package cn.kingnet.utp.trade.common.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * 内部回调
 *
 * @Auther: zhongli
 * @Date: 2018/7/20
 */
@Setter
@Getter
public class InternalResponse {
    /**
     * key 标识 表示属于此类 private boolean internalResponse = true;
     */
    public static final String INTERNAL_RESPONSE = "internalResponse";
    private boolean internalResponse = true;
    /**
     * 状态码
     */
    private int status = HttpStatus.OK.value();
    /**
     * 错误信息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    /**
     * 是否成功
     */
    private boolean success = true;

    public InternalResponse() {
    }

    public InternalResponse(int status, String message) {
        if (status != HttpStatus.OK.value()) {
            this.success = false;
        }
        this.status = status;
        this.message = message;
    }

    public InternalResponse(Object data) {
        this.data = data;
    }


}
