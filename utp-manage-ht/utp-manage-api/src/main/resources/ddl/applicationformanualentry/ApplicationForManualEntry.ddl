drop table if exists t_application_for_manual_entry;
create table t_application_for_manual_entry (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,cust_account_no varchar(32)  COMMENT '客户账号'
	,cust_account_name varchar(32)  COMMENT '客户名称'
	,txn_amount bigint(20)  COMMENT '交易金额（单位分)'
	,account_balance bigint(20)  COMMENT '账户余额（单位分）'
	,other_cust_account_no varchar(50)  COMMENT '对方账号'
	,other_cust_name varchar(50)  COMMENT '对方客户名称'
	,account varchar(50)  COMMENT '入账虚拟账号'
	,account_name varchar(200)  COMMENT '入账户名'
	,sys_reference_no varchar(34)  COMMENT '华通系统交易流水号'
	,trans_id bigint(20)  COMMENT '平台专用银行账户交易明细表对应id'
	,status  varchar(2)  COMMENT '状态（0-不可用 1-可用）'
	,audit_status  varchar(2)  COMMENT '状态（0-待审核 1-审核通过 2-审核驳回）'
) COMMENT '手工入账申请记录表';

