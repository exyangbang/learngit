drop table if exists t_blacklist_approval;
create table t_blacklist_approval (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,name varchar(20)  COMMENT '姓名'
	,bus_lic_code varchar(200)  COMMENT '证件号'
	,remark varchar(1000)  COMMENT '备注'
	,audit_status varchar(10)  COMMENT '状态（0-待审核 1-审核通过 2-审核驳回）'
	,operation_type varchar(10)  COMMENT '0-删除 1-修改 2-增加'
) COMMENT '黑名单审批操作记录';

