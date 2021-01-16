package com.scenetec.upf.operation.model.domain.system;

import lombok.Data;

import java.util.List;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 * update by sunquanhu 2018年7月11日12:03:32
 */
@Data
public class Permission {

    /** 权限编号*/
    private Long id;
   /**权限名称*/
    private String title;
   /**权限描述*/
    private String desc;
   /**权限路径*/
    private String path;
    /**父节点id*/
    private Long parentId;
    /**子节点列表*/
    private List<Permission> children;

    /**是否存在,用于角色模块*/
    private boolean checked = false;

}
