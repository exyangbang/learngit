package com.scenetec.upf.operation.web.channel;


import javax.annotation.Resource;

import com.scenetec.upf.operation.model.vo.ChannelInfoVO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.SubaccountsAmtLimitApprovalVO;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channel.ChannelInfoDO;
import com.scenetec.upf.operation.service.channel.ChannelInfoService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/05
 */
@Api(value = "渠道信息表", tags = {"渠道信息表"})
@RestController
public class ChannelInfoController {

    @Resource
    ChannelInfoService service;

    @RequestMapping(value = "/api/channelInfo", method = RequestMethod.POST)
    public long create(@RequestBody ChannelInfoVO obj) {
        ChannelInfoDO channelInfoDO = service.create(obj);
        //修改额度通知联机
        service.updateToOnlineReuqest(channelInfoDO, "1");
        return channelInfoDO.getId();
    }

    @RequestMapping(value = "/api/channelInfo/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/channelInfo", method = RequestMethod.PUT)
    public void update(@RequestBody ChannelInfoVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/channelInfo/{id}", method = RequestMethod.GET)
    public ChannelInfoDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/channelInfo/pageList", method = RequestMethod.POST)
    public PageInfo<ChannelInfoDO> pageList(@RequestBody Query query) {
        return service.pageList(query);
    }

    @RequestMapping(value = "/api/channelInfo/list", method = RequestMethod.POST)
    public List<ChannelInfoDO> list(@RequestBody Map<String, Object> parameters) {
        return service.list(parameters);
    }

    /**
     * 代付客户管理，添加关联--》 过滤已经被选过的渠道
     * <p>
     * 获取商户号列表  --》 银联代付（事后划账）
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/api/channelInfo/filterList", method = RequestMethod.POST)
    public List<ChannelInfoDO> filterList(@RequestBody Query query) {
        return service.filterList(query);
    }

    /**
     * 渠道商户号列表
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/channelInfo/channelMerNoList", method = RequestMethod.POST)
    public List<ChannelInfoDO> channelMerNoList(@RequestBody Query query) {
        return service.channelMerNoList(query);
    }

    /**
     * 告知联机刷新额度
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/api/channelLimitAmountReq", method = RequestMethod.POST)
    public void subAccountLimitAmountOnlineReq(@RequestBody ChannelInfoDO obj) {
        service.updateToOnlineReuqest(obj,"0");
    }
}
