drop table if exists t_electronic_receipt;
create table t_electronic_receipt (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,order_no varchar(32)  COMMENT '电子回单号'
	,md5_hex varchar(32)  COMMENT '校验值'
	,params varchar(2000)  COMMENT 'json参数字符串'
	,file_content mediumblob  COMMENT 'pdf文件内容'
	,server_trans_id varchar(32)  COMMENT '交易流水ID'
	,trade_type varchar(20)  COMMENT '交易类型'
	,client_trans_id varchar(100)  COMMENT '客户请求流水号'
	,industry_code varchar(12)  COMMENT '平台号'
) COMMENT '电子回单';

create  unique  index idx_ele_recp_stid on t_electronic_receipt(server_trans_id);
create  unique  index idx_ele_recp_ic_ctid on t_electronic_receipt(industry_code,client_trans_id);
