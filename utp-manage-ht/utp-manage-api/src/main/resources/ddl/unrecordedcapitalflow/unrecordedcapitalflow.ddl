drop table if exists t_unrecorded_capital_flow;
create table t_unrecorded_capital_flow (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,acc_no varchar(20)  COMMENT '资金账号'
	,acc_name varchar(200)  COMMENT '资金账号名称'
	,incoming_acc_no varchar(20)  COMMENT '来款账号'
	,incoming_acc_name varchar(200)  COMMENT '来款账户名称'
	,payee_opbk bigint(20)  COMMENT '操作序号'
	,amount_incurred bigint(20)  COMMENT '发生金额'
	,pre_occurrence_balance bigint(20)  COMMENT '发生前余额'
	,post_occurrence_balance bigint(20)  COMMENT '发生后余额'
) COMMENT '未入账资金流水';

