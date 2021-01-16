drop table if exists t_white_list;
create table t_white_list (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,mer_name varchar(200)  COMMENT '客户名称'
	,mer_abb varchar(200)  COMMENT '客户简称'
	,industry_code varchar(12)  COMMENT '代付客户号'
	,account_name varchar(200)  COMMENT '来款方户名'
) COMMENT '来款账户白名单';

