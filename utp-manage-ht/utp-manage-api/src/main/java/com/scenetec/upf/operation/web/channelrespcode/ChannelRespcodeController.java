package com.scenetec.upf.operation.web.channelrespcode;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channelrespcode.ChannelRespcodeDO;
import com.scenetec.upf.operation.model.domain.withdrawcashaccount.WithdrawCashAccountDO;
import com.scenetec.upf.operation.model.vo.channelrespcode.ChannelRespcodeVO;
import com.scenetec.upf.operation.model.vo.withdrawcashaccount.WithdrawCashAccountVO;
import com.scenetec.upf.operation.service.channelrespcode.ChannelRespcodeService;
import com.scenetec.upf.operation.service.withdrawcashaccount.WithdrawCashAccountService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "错误码管理", tags = {"错误码管理"})
@RestController
public class ChannelRespcodeController {
    @Resource
    ChannelRespcodeService service;

    @RequestMapping(value = "/api/channelRespcode", method = RequestMethod.POST)
    public long create(@Validated @RequestBody ChannelRespcodeVO obj) {
        ChannelRespcodeDO channelRespcodeDO = new ChannelRespcodeDO();
        BeanUtils.copyProperties(obj,channelRespcodeDO);
        return service.create(channelRespcodeDO);
    }

    @RequestMapping(value = "/api/channelRespcode/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/channelRespcode", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody ChannelRespcodeVO obj) {
        ChannelRespcodeDO channelRespcodeDO = new ChannelRespcodeDO();
        BeanUtils.copyProperties(obj,channelRespcodeDO);
        service.update(channelRespcodeDO);
    }

    @RequestMapping(value = "/api/channelRespcode/{id}", method = RequestMethod.GET)
    public ChannelRespcodeDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/channelRespcode/list", method = RequestMethod.POST)
    public PageInfo<ChannelRespcodeDO> list(@RequestBody Query query) {
        return service.pageList(query);
    }

}
