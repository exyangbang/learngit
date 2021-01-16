drop table if exists certificate_merchant_info;
create table certificate_merchant_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,cert_id varchar(64)  COMMENT '证书主键编号'
	,mer_no varchar(64)  COMMENT '商户号'
) COMMENT '证书商户映射表';

create  index certificate_merchant_info_index_1 on certificate_merchant_info(cert_id);
create  index certificate_merchant_info_index_2 on certificate_merchant_info(mer_no);
