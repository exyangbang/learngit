drop table if exists merchant_certification_info;
create table merchant_certification_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,mer_no varchar(64)  COMMENT '商户号'
	,cert_type varchar(2)  COMMENT '证件类型'
	,legal_id_type varchar(2)  COMMENT '法人代表证件类型'
	,cert_code varchar(32)  COMMENT '证件号'
	,cert_name varchar(255)  COMMENT '证件名称'
	,cert_expiration_date_start varchar(10)  COMMENT '证件有效起始日期'
	,cert_expiration_date_end varchar(10)  COMMENT '证件有效截止日期'
) COMMENT '商户证件信息表';

create  index merchant_certification_info_index_1 on merchant_certification_info(mer_no);
create  index merchant_certification_info_index_2 on merchant_certification_info(cert_type);
