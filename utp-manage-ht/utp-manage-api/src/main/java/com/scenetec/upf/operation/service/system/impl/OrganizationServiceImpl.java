package com.scenetec.upf.operation.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.system.Organization;
import com.scenetec.upf.operation.model.domain.system.status.DelFlagEnum;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.system.OrganizationMapper;
import com.scenetec.upf.operation.service.system.OrganizationService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author linkaigui on 2018-07-13.
 * @ 创建日期：2018-07-13
 */
@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private UserService userService;

    @Resource
    private IndustryMapper industryMapper;
    /**
     * 新增机构
     * @param organization 机构信息
     */
    @Override
    public void createOrganization(Organization organization){
        String orgCode = organization.getOrgCode();
        String fullName = organization.getFullName();
        if(StringUtils.isBlank(orgCode)){
            log.error("机构代码不能为空");
            throw new SystemRuntimeException(ErrorCode.BSMOM001);
        }
        if(StringUtils.isBlank(fullName)){
            log.error("机构全称不能为空");
            throw new SystemRuntimeException(ErrorCode.BSMOM001);
        }
        if(organization.getParentId() == null){
            organization.setParentId(0L);
        }
        organization.setDelFlag(DelFlagEnum.NORMAL.getValue());
        organization.setGmtCreate(new Date());
        organization.setUserCreate(userService.getUserContext().getUsername());
        organization.setGmtModified(new Date());
        organization.setUserModified(userService.getUserContext().getUsername());
        Organization org = organizationMapper.findOneByFullName(fullName);
        if(org!=null){
            throw new SystemRuntimeException(ErrorCode.BSMOM004);
        }
        org=organizationMapper.findOneByOrgCode(orgCode,null);
        if(org==null) {
            organization.setId(IdGenerate.getId());
            organizationMapper.insert(organization);
        }else if(org.getDelFlag().equals(DelFlagEnum.DELETE.getValue())){
            organization.setId(org.getId());
            organizationMapper.updateById(organization);
        }else {
            throw new SystemRuntimeException(ErrorCode.BSMOM004);
        }
    }

    /**
     * 查询机构列表
     * @param name 机构名称(模糊查询)
     * @param orgCode 机构代码
     * @param pageNum 当前页码
     * @param pageSize 页面大小
     * @return 分页机构数据
     */

    @Override
    public PageInfo<Organization> findOrganizationByPage(Query obj){
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        Map parMap = obj.getParameters();
        parMap.put("delFlag",DelFlagEnum.NORMAL.getValue());
        List<Organization> page = organizationMapper.findByNameLikeAndOrgCodeAndDelFlag(obj.getParameters());
//        Page<Organization> organizations = PageHelper.startPage(obj.getPageNo(), obj.getPageSize())
//                .doSelectPage(()->organizationMapper.findByNameLikeAndOrgCodeAndDelFlag(name,orgCode,DelFlagEnum.NORMAL.getValue()));
        return new PageInfo<>(page);
    }

    /**
     * 获取机构详情信息
     * @param id 机构ID
     * @return id 对应机构
     */
    @Override
    public Organization getOrganization(Long id){
        return organizationMapper.findOne(id);
    }

    /**
     * 修改机构信息
     * @param organization 机构信息
     */
    @Override
    @Transactional
    public void modifyOrganization(Organization organization){
        Long id = organization.getId();
        if(id == null){
            log.error("机构不存在或已被删除");
            throw new SystemRuntimeException(ErrorCode.BSMOM003);
        }
        Organization tempOrg = organizationMapper.findOne(id);
        if(tempOrg == null || tempOrg.getDelFlag().equals(DelFlagEnum.DELETE.getValue())){
            log.error("机构不存在或已被删除");
            throw new SystemRuntimeException(ErrorCode.BSMOM003);
        }

        String orgCode = organization.getOrgCode();
        String fullName = organization.getFullName();
        if(StringUtils.isBlank(orgCode)){
            log.error("机构代码不能为空");
            throw new SystemRuntimeException(ErrorCode.BSMOM001);
        }
        if(StringUtils.isBlank(fullName)){
            log.error("机构全称不能为空");
            throw new SystemRuntimeException(ErrorCode.BSMOM001);
        }
        Organization org = organizationMapper.findOneByFullName(fullName);
        if(org!=null&&!org.getId().equals(id)){
            throw new SystemRuntimeException(ErrorCode.BSMOM004);
        }
        org = organizationMapper.findOneByOrgCode(orgCode,null);
        if(org!=null&&!org.getId().equals(id)){
            throw new SystemRuntimeException(ErrorCode.BSMOM004);
        }

        if(organization.getParentId() == null){
            organization.setParentId(0L);
        }
        Map<String,Object> industryDOMap = new HashMap<>();
        industryDOMap.put("orgCode",tempOrg.getOrgCode());
        List<IndustryDO> list = industryMapper.list(industryDOMap);
        for (int i = 0; i < list.size(); i++) {//代付客户的机构代码和机构名称要一起修改
            IndustryDO temp = list.get(i);
            temp.setOrgCode(organization.getOrgCode());
            temp.setOrgName(organization.getFullName());
            industryMapper.update(temp);
        }
        organization.setGmtModified(new Date());
        organization.setUserModified(userService.getUserContext().getUsername());
        organizationMapper.updateById(organization);
    }

    /**
     * 删除机构
     * 被代付客户关联的机构无法删除
     * @param id 机构ID
     */
    @Override
    public void deleteOrganization(Long id){
        Organization organization = organizationMapper.findOne(id);
        IndustryDO industryDO = new IndustryDO();
        industryDO.setOrgCode(organization.getOrgCode());
        industryDO.setStatus("1");
        if (industryMapper.count(industryDO)>0){
            throw new SystemRuntimeException(ErrorCode.BSMOM005);
        }
        organizationMapper.updateDelFlagById(id,DelFlagEnum.DELETE.getValue());
    }
}
