drop table if exists t_code_dictionary;
create table t_code_dictionary (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,type varchar(255)  COMMENT '字典类型 0001:支付机构 0003:行业 0003:职业'
	,code varchar(100)  COMMENT 'key值'
	,value varchar(1000)  COMMENT '信息名称'
	,remark varchar(1000)  COMMENT '备注信息'
) COMMENT '业务编码字典';

create  unique  index t_code_dictionary_type on t_code_dictionary(type,code);
