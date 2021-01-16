package cn.kingnet.utp.trade.common.enums;


import org.springframework.lang.Nullable;

/**
 * Created on 2018/5/18
 * 参考spring 的 HttpRespStatus
 *
 * @author by linkaigui
 */
public enum HttpRespStatus {

    OK(200, "交易成功"),
    MULTIPLE_CHOICES(300, "处理中"),
    BAD_REQUEST(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "拒绝访问"),
    NOT_FOUND(404, "接口不存在"),
    NOT_ACCEPTABLE(406, "请求资源不可访问"),
    SERVER_ERROR(451,"服务错误"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),
    BALANCE_INSUFFICIENT(499, "虚账户余额不足"),
    INTERNAL_SERVER_ERROR(500, "服务端未知错误"),
    BAD_GATEWAY(502, "Bad Gateway"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout");


    private final int value;

    private final String reasonPhrase;


    HttpRespStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public static HttpRespStatus valueOf(int statusCode) {
        HttpRespStatus status = resolve(statusCode);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        }
        return status;
    }

    @Nullable
    public static HttpRespStatus resolve(String statusCode) {
        return resolve(Integer.valueOf(statusCode).intValue());
    }


    @Nullable
    public static HttpRespStatus resolve(int statusCode) {
        for (HttpRespStatus status : values()) {
            if (status.value == statusCode) {
                return status;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }

    public String valueStr() {
        return String.valueOf(this.value);
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public boolean is1xxInformational() {
        return HttpRespStatus.Series.INFORMATIONAL.equals(series());
    }

    public boolean is2xxSuccessful() {
        return HttpRespStatus.Series.SUCCESSFUL.equals(series());
    }

    public boolean is3xxRedirection() {
        return HttpRespStatus.Series.REDIRECTION.equals(series());
    }

    public boolean is4xxClientError() {
        return HttpRespStatus.Series.CLIENT_ERROR.equals(series());
    }

    public boolean is5xxServerError() {
        return HttpRespStatus.Series.SERVER_ERROR.equals(series());
    }

    public boolean isError() {
        return is4xxClientError() || is5xxServerError();
    }

    public HttpRespStatus.Series series() {
        return HttpRespStatus.Series.valueOf(this);
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    public enum Series {
        INFORMATIONAL(1),
        SUCCESSFUL(2),
        REDIRECTION(3),
        CLIENT_ERROR(4),
        SERVER_ERROR(5);
        private final int value;

        Series(int value) {
            this.value = value;
        }

        public static HttpRespStatus.Series valueOf(int status) {
            int seriesCode = status / 100;
            for (HttpRespStatus.Series series : values()) {
                if (series.value == seriesCode) {
                    return series;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + status + "]");
        }

        public static HttpRespStatus.Series valueOf(HttpRespStatus status) {
            return valueOf(status.value);
        }

        public int value() {
            return this.value;
        }
    }
}
