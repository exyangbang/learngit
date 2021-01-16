package cn.kingnet.utp.trade.common.dto.onebank;

import lombok.*;

import java.io.Serializable;

/**
 * @Description : 电子账户所属实体机构户查询
 * @Author : linkaigui
 * @Create : 2019/3/14 16:37
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankVirtualAccountQueryRespDTO implements Serializable {

    private OneBankRspHead rspHead;

    private RspBody rspBody;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RspBody implements Serializable {
        /**
         * X(.90)orgRealAcctName	机构核心内部账户户名	Y
         */
        private String orgRealAcctName;
        /**
         * X(.32)机构核心内部账号	Y	若可以依据账号户名查询对应的实体账户则返回，与账户状态无关。
         */
        private String orgRealAcctNo;
        /**
         * rspCode	响应状态码	N	"00 成功（可入账）
         * "00 成功（可入账） " +
         * "01 账户不存在
         * 02 账户姓名不匹配
         * 03 账户已注销
         * 04 限额检查未通过
         * 05 未激活或激活金额错误
         * 06 渠道无权限调用此业务
         * 07 机构实体账户不存在
         * 08 参数[acctNo]错误
         * 09 参数[amt]错误
         * 10 参数[exAcctNo]错误
         * 11 参数[exAcctName]错误
         * 12 参数[reqchid]错误
         * 13 根据账号在批量开户明细表中没有找到记录
         * 14 参数格式错误
         * 99 其他
         * <p>
         * 除00外，其余状态不可入账，支付系统应直接退回资金。
         * 支付系统对于返回状态注销、冻结、激活等应适当包装转换并对资金发起行进行拒收或退款操作"
         */
        private String rspCode;
    }

}
