package com.scenetec.upf.operation.service.codedictionary.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import com.scenetec.upf.operation.repository.codedictionary.CodeDictionaryMapper;
import com.scenetec.upf.operation.service.codedictionary.CodeDictionaryService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CodeDictionaryServiceImpl implements CodeDictionaryService {
    Logger logger = LoggerFactory.getLogger(CodeDictionaryServiceImpl.class);
    @Resource
    CodeDictionaryMapper mapper;
    @Resource
    UserService userService;

    @Override
    public long create(CodeDictionaryDO obj) {
        CodeDictionaryDO tem = new CodeDictionaryDO();
        tem.setCode(obj.getCode());
        tem.setType(obj.getType());
        Integer resCount = mapper.count(tem);
        if (resCount > 0){
            throw new SystemRuntimeException(ErrorCode.BSMSC006,"子项目编码已经存在");
        }
        try {
            obj.setId(IdGenerate.getId());
            obj.setGmtCreate(new Date());
            obj.setUserCreate(userService.getUserContext().getUsername());
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            return mapper.create(obj);
        } catch (Exception e) {
            logger.error("信息添加异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC008);
        }

    }

    @Override
    public int delete(Long id) {
        try {
            return mapper.delete(id);
        } catch (Exception e) {
            logger.error("信息删除异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC010);
        }

    }

    @Override
    public void update(CodeDictionaryDO obj) {
        try {
            CodeDictionaryDO temOb = new CodeDictionaryDO();
            temOb.setId(obj.getId());
            temOb.setRemark(obj.getRemark());
            temOb.setValue(obj.getValue());
            temOb.setGmtModified(new Date());
            temOb.setUserModified(userService.getUserContext().getUsername());
            mapper.update(temOb);
        } catch (Exception e) {
            logger.error("信息更新异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC007);
        }

    }

    @Override
    public CodeDictionaryDO getById(Long id) {
        try {
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error("信息获取异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC009);
        }

    }

    @Override
    public PageInfo<CodeDictionaryDO> pageList(Query query) {
        try {
            query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
            query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
            PageHelper.startPage(query.getPageNo(), query.getPageSize());
            List<CodeDictionaryDO> list = mapper.pageList(query.getParameters());
            return new PageInfo<>(list);
        } catch (Exception e) {
            logger.error("信息获取异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC009);
        }

    }
}
