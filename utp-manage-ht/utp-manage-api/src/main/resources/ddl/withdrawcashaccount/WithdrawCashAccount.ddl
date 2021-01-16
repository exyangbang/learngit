drop table if exists t_withdraw_cash_account ;
create table t_withdraw_cash_account  (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,account_no varchar(40)  COMMENT '收款方账号'
	,account_name varchar(200)  COMMENT '收款方名称'
	,industry_id  bigint(20)  COMMENT 'industry表id'
	,payee_opbk  bigint(20)  COMMENT '清算行号'
	,status  varchar(2)  COMMENT '状态（0-不可用 1-可用）'
	,fund_account  varchar(32)  COMMENT '资金账户'
) COMMENT '提现账户表';

create  unique  index account_info_index_1 on t_withdraw_cash_account (account_no);
