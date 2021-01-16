drop table if exists t_bank_account_trans_detail;
create table t_bank_account_trans_detail (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,industry_code varchar(32)  COMMENT '平台编码'
	,card_number varchar(32)  COMMENT '卡号'
	,cust_account_no varchar(32)  COMMENT '客户账号'
	,cust_account_name varchar(32)  COMMENT '客户名称'
	,txn_date varchar(8)  COMMENT '交易账务日期，清算日期'
	,nature_date varchar(8)  COMMENT '交易自然日期，交易日期'
	,detail_serial_number bigint(20)  COMMENT '明细序号'
	,drcr_flag varchar(10)  COMMENT '借贷标志 0-借方 1-贷方'
	,txn_amount bigint(20)  COMMENT '交易金额（单位分)'
	,account_balance bigint(20)  COMMENT '账户余额（单位分)'
	,other_cust_account_no varchar(50)  COMMENT '对方账号'
	,other_cust_name varchar(50)  COMMENT '对方客户名称'
	,reversed_flag varchar(10)  COMMENT '0-正常 1-被冲账 2-冲账'
	,remark_detail varchar(1024)  COMMENT '备注信息'
	,txn_time varchar(6)  COMMENT '交易时间HHmmss'
	,sys_reference_no varchar(34)  COMMENT '华通系统交易流水号'
	,org_sys_reference_no varchar(34)  COMMENT '华通原系统交易流水号'
	,other_bank_name varchar(80)  COMMENT '对方行名'
	,other_remark varchar(80)  COMMENT '对方银行备注'
	,oper_status varchar(2)  COMMENT '操作状态 0-未入账 1-已入账'
) COMMENT '未入账资金流水查询';

create  unique  index t_bank_account_trans_detail_industry_code on t_bank_account_trans_detail(industry_code);
create  index t_bank_account_trans_detail_detail_serial_number on t_bank_account_trans_detail(detail_serial_number);
create  index t_bank_account_trans_detail_cust_account_noAndTxn_date on t_bank_account_trans_detail(cust_account_no,txn_date);
create  index t_bank_account_trans_detail_accountNoAndTxnDateAndSeialNumber_UK on t_bank_account_trans_detail(cust_account_no,txn_date,detail_serial_number);
