drop table if exists t_white_list_payments;
create table t_white_list_payments (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,industry_id bigint(12)  COMMENT '代付客户号id'
	,industry_code String(12)  COMMENT '代付客户号'
	,receiver_account varchar(50)  COMMENT '收款方账号'
	,receiver_name varchar(200)  COMMENT '收款方户名'
	,one_day_trading_quota bigint(20)  COMMENT '单日交易限额'
	,current_transaction_amount bigint(20)  COMMENT '当前交易金额'
	,begin_date varchar(100)  COMMENT '生效日期(yyyyMMdd)'
	,end_date varchar(100)  COMMENT '失效日期(yyyyMMdd)'
	,remark varchar(255)  COMMENT '备注'
	,white_list_payments_audit_id bigint(20)  COMMENT '审核列表的id'
) COMMENT '出款账户白名单';

