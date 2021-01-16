package cn.kingnet.utp.channel.api.onebank;

import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhongli
 * @date 2018/10/12feign
 */
@FeignClient(value = "${feign.name.onebank}")
@RequestMapping("/onebank/payment")
public interface IPaymentService {

    @PostMapping("private")
    ChannelResponseDTO tradePivate(@RequestBody final OneBankTransferReq oneBankTransferReq);

    @PostMapping("public")
    ChannelResponseDTO tradePublic(@RequestBody final OneBankTransferReq oneBankTransferReq);

    /**
     * 客户账号余额查询接口|暂没用到
     *
     * @param oneBankAccountBalanceQueryReqDTO
     * @return
     */
    @PostMapping("accountBalanceQuery")
    ChannelResponseDTO accountBalanceQuery(@RequestBody(required = false) final OneBankAccountBalanceQueryReqDTO oneBankAccountBalanceQueryReqDTO);

    /**
     * 一般户：资金账户交易资金明细查询
     *
     * @param oneBankAccountTransDetailQueryReqDTO
     * @return
     */
    @PostMapping("accountTransDetailQuery")
    ChannelResponseDTO accountTransDetailQuery(@RequestBody(required = false) final OneBankAccountTransDetailQueryReqDTO oneBankAccountTransDetailQueryReqDTO);


    /**
     * 内部户余额查询接口|暂没用到
     *
     * @param oneBankInnerAccountBalanceQueryReqDTO
     * @return
     */
    @PostMapping("innerAccountBalanceQuery")
    ChannelResponseDTO innerAccountBalanceQuery(@RequestBody(required = false) final OneBankInnerAccountBalanceQueryReqDTO oneBankInnerAccountBalanceQueryReqDTO);

    /**
     * 内部户：交易资金明细查询
     *
     * @param oneBankInnerAccountTransDetailQueryReqDTO
     * @return
     */
    @PostMapping("innerAccountTransDetailQuery")
    ChannelResponseDTO innerAccountTransDetailQuery(@RequestBody(required = false) final OneBankInnerAccountTransDetailQueryReqDTO oneBankInnerAccountTransDetailQueryReqDTO);


    /**
     * 对私转账结果查询
     *
     * @param oneBankTransQueryReqDTO
     * @return
     */
    @PostMapping("privateTransQuery")
    ChannelResponseDTO privateTransQuery(@RequestBody final OneBankTransQueryReqDTO oneBankTransQueryReqDTO);

    /**
     * 对公转账结果查询
     *
     * @param oneBankTransQueryReqDTO
     * @return
     */
    @PostMapping("publicTransQuery")
    ChannelResponseDTO publicTransQuery(@RequestBody final OneBankTransQueryReqDTO oneBankTransQueryReqDTO);

    /**
     * 获取对账文件ID
     *
     * @param settleDate
     * @return
     */
    @PostMapping("statementDownload")
    ChannelResponseDTO statementDownload(@RequestParam(value = "settleDate") final String settleDate);


    @PostMapping("bind")
    ChannelResponseDTO bind(@RequestBody final OneBankBindReq oneBankBindReq);

    /**
     * 一般户信息查询 校验其账号+账户名称是否一致
     *
     * @param oneBankAccountInfoQueryReqDTO
     * @return
     */
    @PostMapping("accountInfoQuery")
    ChannelResponseDTO accountInfoQuery(@RequestBody(required = false) final OneBankAccountInfoQueryReqDTO oneBankAccountInfoQueryReqDTO);

    /**
     * 查询个人客户热点信息
     *
     * @param oneBankGetPersonHotspotReqDTO
     * @return
     */
    @PostMapping("getPersonHotspot")
    ChannelResponseDTO getPersonHotspot(@RequestBody(required = false) final OneBankGetPersonHotspotReqDTO oneBankGetPersonHotspotReqDTO);

    /**
     * 查询企业客户热点信息
     *
     * @param oneBankGetOrgHotspotReqDTO
     * @return
     */
    @PostMapping("getOrgHotspot")
    ChannelResponseDTO getOrgHotspot(@RequestBody(required = false) final OneBankGetOrgHotspotReqDTO oneBankGetOrgHotspotReqDTO);


    /**
     * 建立个人客户热点信息
     *
     * @param oneBankAddPersonReqDTO
     * @return
     */
    @PostMapping("addPerson")
    ChannelResponseDTO addPerson(@RequestBody(required = false) final OneBankAddPersonReqDTO oneBankAddPersonReqDTO);


    /**
     * 建立企业客户热点信息
     *
     * @param oneBankAddOrgReqDTO
     * @return
     */
    @PostMapping("addOrg")
    ChannelResponseDTO addOrg(@RequestBody(required = false) final OneBankAddOrgReqDTO oneBankAddOrgReqDTO);

    /**
     * 更新ecif个人账户信息
     * @param oneBankUpdatePersonReqDTO
     * @return
     */
    @PostMapping("updatePerson")
    ChannelResponseDTO updatePerson(@RequestBody(required = false) final OneBankUpdatePersonReqDTO oneBankUpdatePersonReqDTO);

    /**
     * 更新ecif企业账户信息
     * @param oneBankUpdateOrgReqDTO
     * @return
     */
    @PostMapping("updateOrg")
    ChannelResponseDTO updateOrg(@RequestBody(required = false) final OneBankUpdateOrgReqDTO oneBankUpdateOrgReqDTO);

    /**
     * ocr身份识别
     * @param oneBankOrcIdentityReqDTO
     * @return
     */
    @PostMapping("orcIdentity")
    ChannelResponseDTO orcIdentity(@RequestBody(required = false) final OneBankOrcIdentityReqDTO oneBankOrcIdentityReqDTO);

    /**
     * 联网核查
     * @param oneBankOnlineCheckReqDTO
     * @return
     */
    @PostMapping("onlineCheck")
    ChannelResponseDTO onlineCheck(@RequestBody(required = false) final OneBankOnlineCheckReqDTO oneBankOnlineCheckReqDTO);

    /**
     * 合成业务数据到模板生成单据，业务数据包括文本、图片；返回合成后pdf文件
     * @param oneBankSynthesizeAutoTemplateReqDTO
     * @return
     */
    @PostMapping("synthesizeAutoTemplate")
    ChannelResponseDTO synthesizeAutoTemplate(@RequestBody(required = false) final OneBankSynthesizeAutoTemplateReqDTO oneBankSynthesizeAutoTemplateReqDTO);

    /**
     * 合成业务数据到模板生成单据，业务数据包括文本、图片；不返回合成后pdf文件，只返回保存在临时表中的pdfId
     * @param oneBankSynthesizeTemplateWithPdfIdReqDTO
     * @return
     */
    @PostMapping("synthesizeTemplateWithPdfId")
    ChannelResponseDTO synthesizeTemplateWithPdfId(@RequestBody(required = false) final OneBankSynthesizeTemplateWithPdfIdReqDTO oneBankSynthesizeTemplateWithPdfIdReqDTO);

    /**
     * PDF自动化签章接口
     * @param oneBankSealAutoPdfReqDTO
     * @return
     */
    @PostMapping("sealAutoPdf")
    ChannelResponseDTO sealAutoPdf(@RequestBody(required = false) final OneBankSealAutoPdfReqDTO oneBankSealAutoPdfReqDTO);
}