drop table if exists t_withdrawals_record ;
create table t_withdrawals_record  (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,client_trans_id varchar(100)  COMMENT '提现客户端流水号'
	,fee_account_no varchar(40)  COMMENT '手续费客户号'
	,fee_account_name varchar(200)  COMMENT '手续费客户名称'
	,bank_account_no varchar(40)  COMMENT '资金账号'
	,bank_account_name varchar(100)  COMMENT '资金账户户名'
	,recive_account_no varchar(40)  COMMENT '收款方账号'
	,recive_account_name varchar(200)  COMMENT '资金账户户名'
	,account varchar(20)  COMMENT '收款方名称'
	,amount  bigint(20)  COMMENT '提现金额（单位分）'
	,status  varchar(2)  COMMENT '状态（0-不可用 1-可用）'
	,audit_status  varchar(2)  COMMENT '状态（0-待审核 1-审核通过 2-审核驳回）'
) COMMENT '手续费收益提现申请记录表';

create  unique  index client_trans_index_1 on t_withdrawals_record (client_trans_id);
