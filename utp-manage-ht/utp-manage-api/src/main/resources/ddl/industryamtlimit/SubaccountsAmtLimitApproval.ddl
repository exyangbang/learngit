drop table if exists t_subaccounts_amt_limit_approval;
create table t_subaccounts_amt_limit_approval (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,industry_code varchar(12)  COMMENT '代付客户号'
	,industry_id bigint(20)  COMMENT '代付客户id）'
	,sub_obj_name  varchar(200)  COMMENT '归属对象名称'
	,sub_account  varchar(32)  COMMENT '虚拟账户账号'
	,subaccounts_individual_amt bigint(20))  COMMENT '子账户单笔限额（单位分）'
	,subaccounts_date_amt bigint(20))  COMMENT '子账户单日限额（单位分）'
	,remark  varchar(255)  COMMENT '备注'
	,audit_status  varchar(2)  COMMENT '状态（0-待审核 1-审核通过 2-审核驳回）'
	,operation_type  varchar(2)  COMMENT '操作类型（0-删除 1-修改 2-添加）'
) COMMENT '子账户交易限额审批记录表';

