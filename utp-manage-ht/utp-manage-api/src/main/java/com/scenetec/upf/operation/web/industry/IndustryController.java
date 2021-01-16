package com.scenetec.upf.operation.web.industry;


import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.vo.industry.IndustryDataVO;
import com.scenetec.upf.operation.model.vo.industry.IndustrySyncLogVO;
import com.scenetec.upf.operation.model.vo.industry.IndustryVO;
import com.scenetec.upf.operation.service.industry.IndustryService;
import com.scenetec.upf.operation.service.industry.IndustrySyncLogService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@Api(value = "代付客户管理", tags = {"代付客户管理"})
@RestController
public class IndustryController {

    @Resource
    IndustryService service;

    @Resource
    IndustrySyncLogService industrySyncLogService;

    @RequestMapping(value = "/api/industry", method = RequestMethod.POST)
    public long create(@RequestBody IndustryVO obj) {
        return service.create(obj);
    }

    @RequestMapping(value = "/api/industry/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/industry", method = RequestMethod.PUT)
    public void update(@RequestBody IndustryVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/industry/exist/{fundAccount}", method = RequestMethod.GET)
    public boolean existFundAccount(@PathVariable String fundAccount) {
        return service.isExistFundAccount(fundAccount);
    }

    /**
     * exImage  == exImage 表示不需要图片。
     * @param id
     * @param exImage
     * @return
     */
    @RequestMapping(value = "/api/industry/{id}", method = RequestMethod.GET)
    public IndustryDO get(@PathVariable Long id,@RequestParam(value = "exImage",required = false) String exImage) {

        return service.getById(id,exImage);
    }


    @RequestMapping(value = "/api/industry/pageList", method = RequestMethod.POST)
    public PageInfo<IndustryDO> pageList(@RequestBody Query query) {
        return service.pageList(query);
    }
    /**
     *1.同一个客户号手续费支出账户/手续费收益账户/小额打款验证账户对应的资金账户必须和客户号配置的一样；
     * 归集账户对应的资金账户必须和客户号配置的不一样。
     * 2.手续费支出账户/小额打款支出账户和客户号是一对一绑定关系；
     * 手续费收益账户/手续费归集可以被多个客户号关联。
     * 3.客户号新增和修改的--》手续费支出账户/小额打款验证账户列表都是通过这个请求
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/industry/pageListFeeAndAuthAccount", method = RequestMethod.POST)
    public PageInfo<IndustryDO> pageListFeeAndAuthAccount(@RequestBody Query query) {
        return service.pageListFeeAndAuthAccount(query);
    }
    /**
     * 资金同步特殊名单配置查询 新增列表 排除已选过的账号
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/industry/pageListExclude", method = RequestMethod.POST)
    public PageInfo<IndustryDO> pageListExclude(@RequestBody Query query) {
        return service.pageListExclude(query);
    }
    /**
     * 后管代付客户号那边新增一条校验规则：
     * 1.手续费收益账户 和 归集账户必须对应。
     * 也就是不同的代付客户号如果 选的是同一个手续费收益账户   那边归集账户也必须选同一个
     *  2.归集账户的对应的资金账户必须和客户号配置的不一样
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/industry/pageCollectionList", method = RequestMethod.POST)
    public PageInfo<IndustryDO> pageCollectionList(@RequestBody Query query) {
        return service.pageCollectionList(query);
    }

    @RequestMapping(value = "/api/industry/list", method = RequestMethod.POST)
    public List<IndustryDO> list(@RequestBody Query query) {

        return service.list(query);
    }

    @RequestMapping(value = "/api/industry/queryListWithCertId", method = RequestMethod.POST)
    public PageInfo<IndustryDO> queryListWithCertId(@RequestBody Query query) {
        return service.selectListWithCert(query);
    }

    /**
     * 如果之前未绑定的来款账户，已经给该账户打过款了，这时候平台无法入账，等到添加了来款账户后，再调用这个
     * 接口，更新刷新时间，会对没有入账的资金从未入账流水资金划出。
     *
     * @param industrySyncLogVO
     */
    @RequestMapping(value = "/api/industry/updateSyncLastDate", method = RequestMethod.POST)
    public void updateSyncLastDate(@RequestBody IndustrySyncLogVO industrySyncLogVO) {
        if (StringUtils.isBlank(industrySyncLogVO.getIndustryCode())
                && StringUtils.isBlank(industrySyncLogVO.getFundAccountNo())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "请检查参数");
        }

        if (StringUtils.isBlank(industrySyncLogVO.getLastDate())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "上次同步日期不能为空");
        }

        if (!DateUtilities.isYyyyMMdd(industrySyncLogVO.getLastDate())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "上次同步日期格式错误");
        }
        int results = industrySyncLogService.updateSyncLastDate(industrySyncLogVO);

        if (results <= 0) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "更新失败");
        }
    }

    /**
     * 费用账户
     * industry_type '1:平台|行业账户,4-手续费收入账户 5-手续费支出账户',
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/industry/pageListFeeAccount", method = RequestMethod.POST)
    public PageInfo<IndustryDO> pageListFeeAccount(@RequestBody Query query) {
        return service.pageListFeeAccount(query);
    }

    /**
     * 审核
     *
     * @param obj
     */
    @RequestMapping(value = "/api/examine/upd", method = RequestMethod.PUT)
    public void updateExamine(@RequestBody IndustryVO obj) {
        service.updateAuditStatus(obj);
    }

    /**
     * 完善平台信息资料
     *
     * @param obj
     */
    @RequestMapping(value = "/api/industry/createIndustryAccountInfo", method = RequestMethod.PUT)
    public void createIndustryAccountInfo(@Validated @RequestBody IndustryDataVO obj) {
        service.createIndustryAccountInfo(obj);
    }
    /**
     * 获取分账业务的信息列表
     */
    @RequestMapping(value = "/api/industry/industryListOnlyAccountSplittingBusiness", method = RequestMethod.POST)
    public PageInfo<IndustryDO> industryListOnlyAccountSplittingBusiness(@RequestBody Query query) {
        return service.industryListOnlyAccountSplittingBusiness(query);
    }


    /**
     * 获取代付客户号，交易限额已经选过，不能出现
     */
    @RequestMapping(value = "/api/industry/industryUnTransactionLimitList", method = RequestMethod.POST)
    public PageInfo<IndustryDO> industryUnTransactionLimitList(@RequestBody Query query) {
        return service.industryUnTransactionLimitList(query);
    }

}
