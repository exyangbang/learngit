drop table if exists merchant_certification_pic_info;
create table merchant_certification_pic_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,mer_no varchar(64)  COMMENT '商户号'
	,cert_code varchar(32)  COMMENT '证件号'
	,cert_pic blob  COMMENT '证件照片'
	,cert_pic_path varchar(255)  COMMENT '证件照片路径'
) COMMENT '商户证件照片信息表';

create  index merchant_certification_pic_info_index_1 on merchant_certification_pic_info(mer_no);
create  index merchant_certification_pic_info_index_2 on merchant_certification_pic_info(cert_code);
