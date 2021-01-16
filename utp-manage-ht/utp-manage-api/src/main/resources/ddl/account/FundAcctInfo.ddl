drop table if exists fund_acct_info;
create table fund_acct_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,id int(11)  COMMENT '主键ID'
	,industry_code varchar(64)  COMMENT '客户号'
	,fund_acct varchar(48)  COMMENT '内部户账号'
	,fund_acct_name varchar(64)  COMMENT '内部户账号名称'
) COMMENT '反洗钱控制名单';

create  unique  index fun_acct on fund_acct_info(fund_acct);
