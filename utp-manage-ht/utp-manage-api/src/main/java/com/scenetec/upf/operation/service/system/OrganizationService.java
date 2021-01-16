package com.scenetec.upf.operation.service.system;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.Organization;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author linkaigui on 2018-07-13.
 * @ 创建日期：2018-07-13
 */
public interface OrganizationService {

    /**
     * 新增机构
     * @param organization 机构信息
     */
    public void createOrganization(Organization organization);

    /**
     * 查询机构列表
     * @param name 机构名称(模糊查询)
     * @param orgCode 机构代码
     * @param pageNum 当前页码
     * @param pageSize 页面大小
     * @return
     */
    public PageInfo<Organization> findOrganizationByPage(Query obj);

    /**
     * 获取机构详情信息
     * @param id 机构ID
     * @return
     */
    public Organization getOrganization(Long id);

    /**
     * 修改机构信息
     * @param organization 机构信息
     */
    public void modifyOrganization(Organization organization);

    /**
     * 删除机构
     * @param id 机构ID
     */
    public void deleteOrganization(Long id);
}
