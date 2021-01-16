package com.scenetec.upf.operation.web.system;

import com.scenetec.upf.operation.model.domain.system.CommonDictionary;
import com.scenetec.upf.operation.service.system.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(value="数据字典接口",tags={"数据字典"})
@RestController
/**
  @author linkaigui on 2018-07-13.
 */
public class DictionaryController {

    @Resource
    private DictionaryService dictionaryService;

    @ApiOperation(value = "查询数据字典")
    @RequestMapping(value = "/api/dictionaries", method = RequestMethod.GET)
    public Map<String,List<CommonDictionary>> findAll() {

        return dictionaryService.getDictionary();
    }

}
