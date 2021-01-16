drop table if exists merchant_account_info;
create table merchant_account_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,mer_no varchar(64)  COMMENT '商户号'
	,account_type varchar(2)  COMMENT '账户类型'
	,account_no varchar(32)  COMMENT '账号'
	,account_name varchar(300)  COMMENT '账户名称'
	,bank_code varchar(32)  COMMENT '开户行行号'
	,bank_name varchar(300)  COMMENT '开户行行名称'
	,receive_bank_code varchar(32)  COMMENT '接收行号/结算结构代码'
) COMMENT '商户账户信息表';

create  index merchant_account_info_index_1 on merchant_account_info(mer_no);
create  index merchant_account_info_index_2 on merchant_account_info(account_type);
