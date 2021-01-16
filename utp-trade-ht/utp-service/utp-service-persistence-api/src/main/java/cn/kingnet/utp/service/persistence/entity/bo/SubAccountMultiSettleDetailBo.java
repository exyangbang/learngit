package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.SubAccountMulTiSettleDetail;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import lombok.*;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @Description 子账户多级清算分账文件信息
 * @Author WJH
 * @Date 2018年10月18日
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubAccountMultiSettleDetailBo implements Serializable {
    /**
     * 请求日期：yyyyMMdd
     */
    private String reqDate;
    /**
     * 请求时间：HHmmss
     */
    private String reqTime;
    /**
     * 代付客户号
     */
    private String industryCode;
    private String userAccount;
    /**
     * 批次ID/批次号
     */
    private String batchNo;
    /**
     * 1结算 2退款 3撤销
     */
    private String type;
    /**
     * 清算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * 总笔数：
     */
    private long totalCount;
    /**
     * 0=T0 n=Tn
     */
    private String period;

    private List<SubAccountMulTiSettleDetail> subAccountMulTiSettleDetailList;
    /**
     * 该客户号下子账户信息：
     */
    private Map<String, UserAccountInfo> subAccountMap;

    private int maxSplitSettleRows = 1000;


    private void parseHeadLine(List<String> list) {
        String firstLine = list.get(0);
        Assert.hasText(firstLine, () -> "首行内容不能为空");
        List<String> firstList = Splitter.on("|").trimResults().splitToList(firstLine);
        Assert.isTrue(firstList.size() >= 4, () -> "子账户多级清分文件首行格式有误[列数不足4列]");

        String headMark = firstList.get(0);
        String txType = firstList.get(1);
        String applyDate = firstList.get(2);
        String rowCount = firstList.get(3);
        Assert.isTrue(UDPSettleSplitFeature.HEADMARK.equals(headMark), () -> "文件头标志位必须为H");
        Assert.isTrue(UDPSettleSplitFeature.TxType.SUBACCOUNT_SETTLE.getType().equals(txType), () -> "标志文件类型必须为subaccount_settle");
        Assert.isTrue(DateUtil.isYyyyMMdd(applyDate), () -> "日期格式必须为yyyyMMdd");
        Assert.isTrue(settleDate.equals(applyDate), () -> "清分文件首行清算日期与报文上送清算日期不一致");

        ValidateUtils.isPositiveInteger(rowCount, 5, true, "总行数");

        long totalCount = Long.valueOf(rowCount);
        this.setTotalCount(totalCount);
        //校验总笔数是否一致
        long dSumCount = CollectionUtils.isEmpty(list) ? 0L : list.size() - 1;
        Assert.isTrue(totalCount == dSumCount, () -> "清分文件总笔数与明细行数不相符");
        Assert.isTrue(totalCount <= maxSplitSettleRows, "清分文件总笔数超过最大限制"+maxSplitSettleRows+"笔");

    }

    public void parseContent(List<String> list) {
        parseHeadLine(list);

        AtomicBoolean firstLine = new AtomicBoolean(true);

        List<SubAccountMulTiSettleDetail> detailList = list.stream().skip(1).map(line -> {
            if (StringUtil.isBlank(line)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "清分文件该明细行内容不能为空");
            }

            List<String> lineList = Splitter.on("|").trimResults().splitToList(line);
            if (lineList.size() < 12) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "清分文件该明细行内容列数不足12列");
            }

            if (firstLine.getAndSet(false)) {
                Assert.isTrue("1".equals(lineList.get(0)), () -> "数据行序号必须从1开始");
            }

            SubAccountMulTiSettleDetail detail;
            try {
                detail = SubAccountMulTiSettleDetail.builder().id(IdGenerate.getId()).reqDate(reqDate).reqTime(reqTime)
                        .industryCode(industryCode).userAccount(userAccount).batchNo(batchNo).type(type)
                        .seqNo(Integer.parseInt(lineList.get(0))).settleDate(lineList.get(1)).clientTransId(lineList.get(2))
                        .payerSubAccount(lineList.get(3)).payeeSubAccount(lineList.get(4)).amount(Long.valueOf(lineList.get(5)))
                        .settleMode(lineList.get(6)).period(Integer.valueOf(lineList.get(7)))
                        .remark(lineList.get(8)).transOrderIds(lineList.get(9)).extend2(lineList.get(10)).extend3(lineList.get(11)).build();
                Assert.isTrue(!detail.getPayerSubAccount().equals(detail.getPayeeSubAccount()), "转出子账户不能与转出子账户相同");
            } catch (NumberFormatException e) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("金额|账期 必须为数字"));
            }
            return detail;
        }).collect(Collectors.toList());

        if (detailList == null || detailList.size() == 0) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "子账户多级清分文件有效数据行不能为空");
        }
        this.setSubAccountMulTiSettleDetailList(detailList);
    }
}
