drop table if exists t_channel_merchant;
create table t_channel_merchant (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,channel_code varchar(50)  COMMENT '渠道代码'
	,product_no varchar(50)  COMMENT '支付产品编码'
	,mer_no varchar(50)  COMMENT '商户号'
	,mer_fee_template_id bigint(20)  COMMENT '商户手续费模板Id'
	,chn_fee_template_id bigint(20)  COMMENT '渠道手续费模板Id'
) COMMENT '渠道商户管理';

create  index t_channel_info_index_1 on t_channel_merchant(channel_code);
create  index t_channel_info_index_2 on t_channel_merchant(mer_no);
create  index t_channel_info_index_3 on t_channel_merchant(product_no);
