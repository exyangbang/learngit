package com.scenetec.upf.operation.service.whitelist.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.subpaypayeewhitelist.SubPayPayeeWhiteListDO;
import com.scenetec.upf.operation.model.vo.whitelist.SubPayPayeeWhiteListVO;
import com.scenetec.upf.operation.repository.subpaypayeewhitelist.SubPayPayeeWhiteListMapper;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.service.whitelist.SubPayPayeeWhiteListService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.apache.commons.lang3.StringUtils;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SubPayPayeeWhiteListServiceImpl implements SubPayPayeeWhiteListService {
    @Autowired
    SubPayPayeeWhiteListMapper mapper;
    @Autowired
    UserService userService;
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public long create(MultipartFile file, Long id) {
        InputStream is = null;
        InputStream xml = null;
        try {
            List<SubPayPayeeWhiteListDO> cardBinInfoDOS = new ArrayList<>();
            if (id == 0) {
                throw new SystemRuntimeException(ErrorCode.BSMCM001);
            }
            try {
                Resource resource = resourceLoader.getResource("classpath:tabledefines_created/template/SubPayPayeeWhiteListConfig.xml");
                is = file.getInputStream();
                xml = resource.getInputStream();
                XLSReader mainReader = ReaderBuilder.buildFromXML(xml);
                Map beans = new HashMap();
                beans.put("items", cardBinInfoDOS);
                ReaderConfig.getInstance().setSkipErrors(true);
                mainReader.read(is, beans);
            } catch (Exception e) {
                e.printStackTrace();
//            throw new SystemRuntimeException(ErrorCode.BSMCB001);
            }
            if (cardBinInfoDOS.size() == 0) {
                throw new SystemRuntimeException(ErrorCode.BSMCM001);
            }

            AtomicInteger count = new AtomicInteger();
            cardBinInfoDOS.forEach(cardBinInfoDO -> {
                String payaccount = new BigDecimal(cardBinInfoDO.getPayeeAccount()).toPlainString();
                SubPayPayeeWhiteListDO subPayPayeeWhiteListDO = new SubPayPayeeWhiteListDO();
                subPayPayeeWhiteListDO.setPayeeAccount(payaccount);
                subPayPayeeWhiteListDO.setIndustryId(id);
                Integer resCount = mapper.count(subPayPayeeWhiteListDO);
                if (resCount > 0 ||
                        StringUtils.isBlank(payaccount) ||
                        StringUtils.isBlank(cardBinInfoDO.getPayeeName())) {
                    count.getAndIncrement();
                } else {
                    SubPayPayeeWhiteListDO nepayee = new SubPayPayeeWhiteListDO();
                    nepayee.setId(IdGenerate.getId());
                    nepayee.setIndustryId(id);
                    nepayee.setPayeeAccount(payaccount);
                    nepayee.setPayeeName(cardBinInfoDO.getPayeeName());
                    nepayee.setGmtCreate(new Date());
                    nepayee.setUserCreate(userService.getUserContext().getUsername());
                    nepayee.setGmtModified(new Date());
                    nepayee.setUserModified(userService.getUserContext().getUsername());
                    mapper.create(nepayee);
                }
            });
            return count.get();
        } finally {
            try {
                is.close();
                xml.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public int delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public void update(SubPayPayeeWhiteListVO obj) {
        SubPayPayeeWhiteListDO subPayPayeeWhiteListDO = new SubPayPayeeWhiteListDO();
        subPayPayeeWhiteListDO.setPayeeAccount(obj.getPayeeAccount());
        subPayPayeeWhiteListDO.setId(obj.getId());
        Integer resCount = mapper.countExSelf(subPayPayeeWhiteListDO);
        if (resCount > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCD100, "收款账号");
        }
        BeanUtils.copyProperties(obj, subPayPayeeWhiteListDO);
        subPayPayeeWhiteListDO.setGmtModified(new Date());
        subPayPayeeWhiteListDO.setUserModified(userService.getUserContext().getUsername());
        mapper.update(subPayPayeeWhiteListDO);
    }

    @Override
    public SubPayPayeeWhiteListDO getById(Long id) {
        return mapper.getById(id);
    }

    @Override
    public PageInfo<SubPayPayeeWhiteListDO> list(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        List<SubPayPayeeWhiteListDO> page = mapper.listPage(obj.getParameters());
        return new PageInfo<>(page);
    }
}
