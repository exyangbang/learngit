package com.scenetec.upf.operation.web.whitelist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.subpaypayeewhitelist.SubPayPayeeWhiteListDO;
import com.scenetec.upf.operation.model.vo.whitelist.SubPayPayeeWhiteListVO;
import com.scenetec.upf.operation.service.whitelist.SubPayPayeeWhiteListService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api(value = "子账户单笔付款收款白名单", tags = {"子账户单笔付款收款白名单"})
@RestController
public class SubPayPayeeWhiteListController {
    @Resource
    SubPayPayeeWhiteListService service;

    /**
     * 导入excel信息
     * @param file
     * @param id
     */
    @RequestMapping(value = "/api/subPayPayeeWhiteList", method = RequestMethod.POST)
    public void runSql(@RequestParam("file") MultipartFile file, Long id) {
        service.create(file, id);
    }

    @RequestMapping(value = "/api/subPayPayeeWhiteList/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/subPayPayeeWhiteList", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody SubPayPayeeWhiteListVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/subPayPayeeWhiteList/{id}", method = RequestMethod.GET)
    public SubPayPayeeWhiteListDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/subPayPayeeWhiteList/list", method = RequestMethod.POST)
    public PageInfo<SubPayPayeeWhiteListDO> list(@RequestBody Query query) {
        return service.list(query);
    }
}
