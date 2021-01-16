drop table if exists t_blacklist;
create table t_blacklist (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,name varchar(20)  COMMENT '姓名'
	,bus_lic_code varchar(200)  COMMENT '证件号'
	,remark varchar(1000)  COMMENT '备注'
) COMMENT '黑名单审批操作记录';

create  unique  index t_blacklist_operation_record_bus_lic_code on t_blacklist(bus_lic_code);
