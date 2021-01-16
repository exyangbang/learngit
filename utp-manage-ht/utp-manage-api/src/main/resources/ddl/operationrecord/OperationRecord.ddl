drop table if exists t_operation_record;
create table t_operation_record (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,account varchar(20)  COMMENT '虚拟账户'
	,obj_type varchar(10)  COMMENT '账户类型（1-行业 2-商户 3-个人）'
	,bus_lic_code  varchar(20)  COMMENT '证件号'
	,obj_name  varchar(200)  COMMENT '账户名称'
	,code  varchar(20)  COMMENT '代付客户号'
	,ind_name  varchar(200)  COMMENT '代付客名称'
	,bank_account_no  varchar(32)  COMMENT '资金账号'
	,bank_account_name  varchar(200)  COMMENT '资金账号名称'
	,remarks  varchar(500)  COMMENT '备注'
	,status  varchar(10)  COMMENT '状态（0-冻结 1-正常）'
	,operation_type  varchar(32)  COMMENT '状态（0-审批驳回 1-审批通过 2-冻结审核 3-解冻待审核）'
) COMMENT '审批操作记录';

