drop table if exists t_trans_current;
create table t_trans_current (
	id  bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,channel_code varchar(20)  COMMENT '渠道编号'
	,channel_name varchar(50)  COMMENT '渠道名称'
	,channel_resp_code varchar(20)  COMMENT '渠道返回代码'
	,channel_resp_id varchar(20)  COMMENT '渠道返回流水号'
	,channel_resp_msg varchar(255)  COMMENT '渠道返回信息'
	,channel_resp_time varchar(20)  COMMENT '渠道返回时间'
	,client_trans_id varchar(20)  COMMENT '客户请求流水号'
	,client_trans_time varchar(20)  COMMENT '客户请求时间(yyyyMMddHHmmss)'
	,currency varchar(10)  COMMENT '货币类型'
	,org_code varchar(20)  COMMENT '机构编码'
	,description varchar(255)  COMMENT '备注'
	,org_name varchar(50)  COMMENT '机构名称'
	,resp_exception varchar(1024)  COMMENT '返回错误'
	,resp_message varchar(1024)  COMMENT '响应信息'
	,server_batch_no varchar(20)  COMMENT '服务端批处理号'
	,server_link_id varchar(20)  COMMENT '关联流水id'
	,server_trans_id varchar(20)  COMMENT '关联流水id'
	,reconcile_date varchar(20)  COMMENT '对账日期'
	,product_code varchar(20)  COMMENT '产品编码'
	,trade_type varchar(10)  COMMENT '交易类型'
	,trans_amount bigint(20)  COMMENT '交易金额(分)'
	,trans_callback_url varchar(255)  COMMENT '回调地址'
	,trans_date varchar(10)  COMMENT '交易日期(yyyyMMdd)'
	,trans_status varchar(10)  COMMENT '交易状态'
	,trans_time varchar(10)  COMMENT '交易时间(HHmmss)'
	,mer_no varchar(20)  COMMENT '商户编号'
	,resp_code varchar(10)  COMMENT '响应码'
	,revoke_status varchar(10)  COMMENT '撤销状态'
	,refund_status varchar(10)  COMMENT '退货状态'
	,reconcile_status varchar(10)  COMMENT '对账状态'
	,user_code varchar(50)  COMMENT '入网分配的用户名'
	,batch_sub_no varchar(50)  COMMENT '批量交易时：该批次下的明细流水号'
	,corp_no varchar(50)  COMMENT '企业入网时分配的企业编码'
) COMMENT '历史交易流水';

create  index t_trans_current_index_1 on t_trans_current(mer_no);
create  index t_trans_current_index_2 on t_trans_current(channel_code);
create  index t_trans_current_index_3 on t_trans_current(org_code);
