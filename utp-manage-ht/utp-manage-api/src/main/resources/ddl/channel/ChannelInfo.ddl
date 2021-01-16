drop table if exists t_channel_info;
create table t_channel_info (
	id  bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,channel_key varchar(100)  COMMENT '渠道标识'
	,channel_name varchar(100)  COMMENT '渠道名称'
	,channel_code varchar(50)  COMMENT '渠道编码'
	,mer_no varchar(50)  COMMENT '商户编号'
	,product_no varchar(50)  COMMENT '支付产品编码'
	,join_type varchar(10)  COMMENT '接入类型'
	,front_url varchar(255)  COMMENT '请求前台地址'
	,back_url varchar(255)  COMMENT '请求后台地址'
	,trid varchar(50)  COMMENT 'trid参数'
	,trtp varchar(50)  COMMENT 'trtp参数'
	,org_code varchar(50)  COMMENT '机构号'
	,chn_fee_template_id bigint(20)  COMMENT '渠道手续费模板Id'
	,status varchar(20)  COMMENT '状态'
) COMMENT '渠道信息表';

create  index t_channel_info_index_1 on t_channel_info(channel_code);
create  index t_channel_info_index_2 on t_channel_info(channel_name);
