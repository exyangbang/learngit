drop table if exists t_freezing_funds_ope_approval;
create table t_freezing_funds_ope_approval (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,account varchar(32)  COMMENT '虚拟账户账号'
	,obj_type varchar(10)  COMMENT '归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户）'
	,obj_name varchar(255)  COMMENT '账户名称'
	,code varchar(100)  COMMENT '客户号'
	,ind_name varchar(100)  COMMENT '客户名称'
	,operation_type varchar(10)  COMMENT '操作类型：0-冻结 1-解冻'
	,frozen_amount bigint(20)  COMMENT '冻结金额（单位分）'
	,bus_lic_code varchar(100)  COMMENT '证件号'
	,remark varchar(1000)  COMMENT '备注'
	,server_trans_id varchar(100)  COMMENT '服务端交易流水号'
	,clinet_trans_id varchar(100)  COMMENT '客户端交易流水号'
	,add_usr varchar(10)  COMMENT '发起人：0-后管 1-联机'
	,audit_status varchar(10)  COMMENT '状态（0-待审核 1-审核通过 2-审核驳回）'
) COMMENT '资金冻结解冻审批记录';

