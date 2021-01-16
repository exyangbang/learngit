drop table if exists t_industry_fee_account_info;
create table t_industry_fee_account_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,industry_code varchar(12)  COMMENT '平台号'
	,account_no varchar(32)  COMMENT '来款账号'
	,account_name varchar(300)  COMMENT '来款账户名称'
	,bank_code varchar(32)  COMMENT '开户行行号'
	,bank_name varchar(300)  COMMENT '开户行行名称'
	,account_type int(2)  COMMENT '1.手续费账户_来款账户'
) COMMENT '手续费账户来款账户信息表';

create  index fee_account_index_1 on t_industry_fee_account_info(industry_code);
