drop table if exists t_split_info;
create table t_split_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,settle_date varchar(20)  COMMENT '清算日期 格式为yyyyMMdd'
	,mer_no varchar(20)  COMMENT '商户号'
	,amount bigint(20)  COMMENT '产品编码'
	,period int(11)  COMMENT 'M	数字， 例如： 1 表示账期为 T+1'
	,split_date varchar(20)  COMMENT '入账日期 格式yyyyMMdd(清算日期+实际账期天数)'
	,account_type varchar(10)  COMMENT '账户类型0-对私 1-对公'
	,account_no bigint(50)  COMMENT '收款人账号'
	,account_name varchar(50)  COMMENT '收款人名称'
	,bank_code varchar(20)  COMMENT '收款人清算行行号'
	,remark varchar(1024)  COMMENT '备注说明'
	,channel_resp_code varchar(10)  COMMENT '渠道返回代码'
	,extend1 varchar(1024)  COMMENT '关联支付订单号列表 trans_order_ids'
	,extend2 varchar(200)  COMMENT '扩展字段2'
	,extend3 varchar(200)  COMMENT '扩展字段3'
	,status varchar(10)  COMMENT '虚账户分账入账状态（0-未入账 1-已入账）'
	,provider_code varchar(50)  COMMENT '文件提供商'
	,batch_id varchar(50)  COMMENT '批次Id'
	,trans_date varchar(10)  COMMENT '发起提现交易日期yyyyMMdd'
	,server_trans_id varchar(50)  COMMENT '服务端交易流水号'
	,client_trans_id varchar(50)  COMMENT '客户端交易流水号'
	,trans_status varchar(30)  COMMENT '交易状态|同交易表状态'
	,query_times varchar(11)  COMMENT '提现结果查询次数'
	,trans_desc varchar(1024)  COMMENT '提现结果描述'
	,subject varchar(255)  COMMENT '分账主体0-个人 1商户'
	,reconcile_date varchar(20)  COMMENT '华通清算对账日'
	,user_account varchar(20)  COMMENT '用户账户'
	,settle_mode varchar(1)  COMMENT '结算方式0=代付结算 1=记账结算'
	,industry_code varchar(50)  COMMENT '代付客户号'
) COMMENT '';

create  unique  index t_settle_check_info_index_1 on t_split_info(mer_no);
create  index t_split_info_settle_date on t_split_info(settle_date);
create  index t_split_info_industryCodeAndSettleDateAndbatchId on t_split_info(industry_code,settle_date,batch_id);
create  index t_split_info_extend_1_index on t_split_info(extend1);
