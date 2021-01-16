drop table if exists merchant_info;
create table merchant_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,mer_no varchar(64)  COMMENT '商户号'
	,mer_name varchar(300)  COMMENT '商户名称'
	,name_abbreviation varchar(100)  COMMENT '商户简称'
	,administrative_code varchar(32)  COMMENT '行政区划代码'
	,org_code varchar(64)  COMMENT '所属收单机构代码'
	,org_name varchar(300)  COMMENT '所属收单机构名称'
	,province_code varchar(20)  COMMENT '所属省'
	,city_code varchar(20)  COMMENT '所属市'
	,county_code varchar(20)  COMMENT '所属县'
	,reg_address varchar(300)  COMMENT '注册地址'
	,business_address varchar(300)  COMMENT '营业地址'
	,legal_name varchar(100)  COMMENT '法人代表姓名'
	,status varchar(32)  COMMENT '商户状态'
	,website_name varchar(300)  COMMENT '商户网站名称'
	,pay_merchant_no varchar(32)  COMMENT '支出商户号'
	,template_id varchar(32)  COMMENT '模板ID'
) COMMENT '商户基本信息表';

create  unique  index merchant_info_index_1 on merchant_info(mer_no);
create  index merchant_info_index_2 on merchant_info(status);
create  index merchant_info_index_3 on merchant_info(org_code);
