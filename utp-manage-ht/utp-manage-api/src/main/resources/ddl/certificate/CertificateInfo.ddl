drop table if exists certificate_info;
create table certificate_info (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,certificate_no varchar(64) NOT NULL COMMENT '证书号'
	,certificate_seq varchar(128) NOT NULL COMMENT '证书序列号'
	,certificate_name varchar(200)  COMMENT '证书名称'
	,channel_id varchar(64)  COMMENT '渠道编号'
	,org_code varchar(64) NOT NULL COMMENT '所属收单机构代码'
	,org_name varchar(200)  COMMENT '所属收单机构名称'
	,certificate_type varchar(2) NOT NULL COMMENT '证书类型'
	,private_key text  COMMENT '私钥信息'
	,private_key_password varchar(8)  COMMENT '私钥证书密码'
	,private_store_password varchar(8)  COMMENT '私钥store密码'
	,public_key text  COMMENT '公钥信息'
	,effective_date varchar(10)  COMMENT '证书生效日期'
	,expiration_date varchar(10)  COMMENT '证书失效日期'
	,certificate_file blob  COMMENT '二进制证书文件'
	,certificate_path varchar(200)  COMMENT '证书存放路径'
	,status varchar(20) NOT NULL COMMENT '状态'
	,remark varchar(500)  COMMENT '备注信息'
) COMMENT '证书信息表';

create  index certificate_info_index_1 on certificate_info(certificate_seq);
create  index certificate_info_index_2 on certificate_info(certificate_no);
create  index certificate_info_index_3 on certificate_info(org_code);
