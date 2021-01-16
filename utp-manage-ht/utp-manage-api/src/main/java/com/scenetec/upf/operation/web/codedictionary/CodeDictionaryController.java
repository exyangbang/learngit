package com.scenetec.upf.operation.web.codedictionary;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import com.scenetec.upf.operation.model.vo.codedictionary.CodeDictionaryVO;
import com.scenetec.upf.operation.service.codedictionary.CodeDictionaryService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "数据字典管理", tags = {"数据字典管理"})
@RestController
public class CodeDictionaryController {
    @Resource
    CodeDictionaryService service;

    @RequestMapping(value = "/api/codeDictionary", method = RequestMethod.POST)
    public long create(@Validated @RequestBody CodeDictionaryVO obj) {
        CodeDictionaryDO codeDictionaryDO = new CodeDictionaryDO();
        BeanUtils.copyProperties(obj,codeDictionaryDO);
        return service.create(codeDictionaryDO);
    }

    @RequestMapping(value = "/api/codeDictionary/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/codeDictionary", method = RequestMethod.PUT)
    public void update(@RequestBody CodeDictionaryDO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/codeDictionary/{id}", method = RequestMethod.GET)
    public CodeDictionaryDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/codeDictionary/list", method = RequestMethod.POST)
    public PageInfo<CodeDictionaryDO> list(@RequestBody Query query) {
        return service.pageList(query);
    }
}
