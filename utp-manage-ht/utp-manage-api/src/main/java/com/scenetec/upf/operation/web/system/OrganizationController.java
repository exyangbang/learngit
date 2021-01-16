package com.scenetec.upf.operation.web.system;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.Organization;
import com.scenetec.upf.operation.model.vo.system.CreateOrganizationVo;
import com.scenetec.upf.operation.model.vo.system.UpdateOrganizationVo;
import com.scenetec.upf.operation.service.system.OrganizationService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author linkaigui on 2018-07-13.
 * @ 创建日期：2018-07-13
 */
@Api(value="机构管理接口",tags={"机构管理"})
@RestController
public class OrganizationController {

    @Resource
    private OrganizationService organizationService;

    @ApiOperation(value = "新增机构")
    @RequestMapping(value = "/api/organization", method = RequestMethod.POST)
    public void createOrganization(@RequestBody CreateOrganizationVo createOrganizationVo){
        Organization organization = new Organization();
        BeanCopier copier = BeanCopier.create(CreateOrganizationVo.class,Organization.class,false);
        copier.copy(createOrganizationVo,organization,null);
        organizationService.createOrganization(organization);
    }

    @ApiOperation(value = "查询机构列表",notes = "根据机构名称(模糊查找)、机构代码查询机构列表")
    @RequestMapping(value = "/api/organization/list", method = RequestMethod.POST)
    public PageInfo<Organization> findAll(@RequestBody Query query) {
        return organizationService.findOrganizationByPage(query);
    }

    @ApiOperation(value = "获取机构详情")
    @RequestMapping(value = "/api/organization/{id}", method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable Long id){
        return organizationService.getOrganization(id);
    }

    @ApiOperation(value = "修改机构信息")
    @RequestMapping(value = "/api/organization", method = RequestMethod.PUT)
    public void updateOrganization(@RequestBody UpdateOrganizationVo updateOrganizationVo){
        Organization organization = new Organization();
        BeanCopier copier = BeanCopier.create(UpdateOrganizationVo.class,Organization.class,false);
        copier.copy(updateOrganizationVo,organization,null);
        organizationService.modifyOrganization(organization);
    }

    @ApiOperation(value = "删除机构")
    @RequestMapping(value = "/api/organization/{id}", method = RequestMethod.DELETE)
    public void deleteOrganization(@PathVariable Long id){
        organizationService.deleteOrganization(id);
    }
}
