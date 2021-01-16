drop table if exists t_fee_income_account_month_stat;
create table t_fee_income_account_month_stat (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,stat_month varchar(6)  COMMENT '统计月份yyyyMM'
	,account varchar(32)  COMMENT '手续费收益账户号'
	,name varchar(200)  COMMENT '手续费收益账户名称'
	,collection_status varchar(2)  COMMENT ''归集划款状态 0未划转 1已划转'
	,income_amount varchar(20)  COMMENT '入金金额（单位分）'
	,outcome_amount varchar(20)  COMMENT '出金金额（单位分）'
	,remark varchar(512)  COMMENT '客户请求流水号'
	,trans_status varchar(100)  COMMENT '交易状态'
	,trans_desc varchar(200)  COMMENT '交易状态描述'
	,server_trans_id varchar(100)  COMMENT '服务端流水号'
) COMMENT '手续费收益账户月统计表';

