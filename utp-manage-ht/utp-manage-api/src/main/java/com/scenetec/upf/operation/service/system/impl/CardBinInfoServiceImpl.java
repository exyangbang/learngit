package com.scenetec.upf.operation.service.system.impl;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.TrueOrFalseEnum;
import com.scenetec.upf.operation.model.domain.system.CardBinInfoDO;

import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scenetec.upf.operation.repository.system.CardBinInfoMapper;
import com.scenetec.upf.operation.service.system.CardBinInfoService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/11/08
 */
@Service
public class CardBinInfoServiceImpl implements CardBinInfoService{

    @Resource
    CardBinInfoMapper mapper;

    @Resource
    UserService userService;

    @Override
    public long create(CardBinInfoDO obj) {
        obj.setCreateTime(new Timestamp(System.currentTimeMillis()));
        obj.setCreateor(userService.getUserContext().getUsername());
        obj.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        obj.setUpdateor(userService.getUserContext().getUsername());
        obj.setId(IdGenerate.getId());
        obj.setStatus(TrueOrFalseEnum.TRUE.getValue());
        mapper.create(obj);
        return obj.getId();
	}

    @Override
    public int delete(Long id) {
	    return mapper.delete(id);
	}

    @Override
	public void update(CardBinInfoDO obj) {
        obj.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        obj.setUpdateor(userService.getUserContext().getUsername());
	    mapper.update(obj);
	}
	
    @Override
    public CardBinInfoDO getById(Long id) {
         return mapper.getById(id);
    }

    @Override
    public PageInfo<CardBinInfoDO> pageList(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());        
	    Page<CardBinInfoDO> page = mapper.pageList(query.getParameters());
	    return new PageInfo<>(page);
	}

    @Override
    public List<CardBinInfoDO> list(Map<String, Object> params) {
        return mapper.list(params);
    }

    @Override
    public void runSql(MultipartFile file) {
        if(file==null){
            throw new SystemRuntimeException(ErrorCode.BSCRD001);
        }
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            StringBuffer sql = new StringBuffer();
            String line=br.readLine();
            if(line.startsWith("\uFEFF")){
                line = line.replace("\uFEFF", "");
            }
            while (line != null) {
                sql.append(line);
                line = br.readLine();
            }
            if(StringUtils.isEmpty(sql.toString())){
                throw new SystemRuntimeException(ErrorCode.BSCRD001);
            }
            mapper.runSql(sql.toString());
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSCRD002);
        }
    }
}
