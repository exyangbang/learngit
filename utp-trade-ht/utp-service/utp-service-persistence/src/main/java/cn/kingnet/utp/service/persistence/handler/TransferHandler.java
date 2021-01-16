package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.ITransferHander;
import cn.kingnet.utp.service.persistence.entity.Transfer;
import cn.kingnet.utp.service.persistence.mapper.TransferMapper;
import cn.kingnet.utp.service.persistence.service.MsgNoticeService;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jason
 * @Description:
 * @date 2018-12-03 11:32
 */

@RestController
@RequestMapping("/spi/persistence/transfer")
@Slf4j
public class TransferHandler implements ITransferHander {

    @Resource
    private TransferMapper mapper;
    @Autowired
    MsgNoticeService msgNoticeService;

    @Override
    public void saveTransfer(@RequestBody(required = false) Transfer transfer) {
        mapper.insert(transfer);
    }

    @Override
    public void updateByIndustryCodeAndServerTransId(@RequestBody(required = false) Transfer transfer, @RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "serverTransId", required = false) String serverTransId) {
        if (StringUtil.isEmpty(industryCode) || StringUtil.isEmpty(serverTransId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "代付客户号或服务端流水号不能为空");
        }
        if (transfer != null) {
            Wrapper wrapper = new EntityWrapper<Transfer>()
                    .where("payer_industry_code = {0}", industryCode)
                    .andNew(" server_trans_id = {0}", serverTransId);
            mapper.update(transfer, wrapper);
        }
    }

    @Override
    public Transfer getByServerTradeId(String serverTransId) {
        Transfer transfer = new Transfer();
        transfer.setServerTransId(serverTransId);
        return mapper.selectOne(transfer);
    }


}
