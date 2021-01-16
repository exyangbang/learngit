drop table if exists t_special_industry_sync_config;
create table t_special_industry_sync_config (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,industry_code varchar(50)  COMMENT '客户名称'
	,name varchar(200)  COMMENT '客户名称'
	,remark varchar(1000)  COMMENT '备注'
) COMMENT '特殊客户同步名单配置';

