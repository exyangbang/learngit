drop table if exists merchant_contact_info;
create table merchant_contact_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,mer_no varchar(64)  COMMENT '商户号'
	,contact_name varchar(100)  COMMENT '商户联系人'
	,contact_phone varchar(32)  COMMENT '商户联系人电话'
	,contact_email varchar(100)  COMMENT '商户联系人邮箱'
) COMMENT '商户联系人信息表';

create  index merchant_contact_info_index_1 on merchant_contact_info(mer_no);
