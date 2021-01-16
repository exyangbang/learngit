drop table if exists t_country;
create table t_country (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,two_bit_letters varchar(2)  COMMENT '账号'
	,three_bit_letters varchar(3)  COMMENT '归属对象类型'
	,num_code varchar(3)  COMMENT '数字代码'
	,eng_name varchar(256)  COMMENT '英文名称'
	,ch_name bigint(256)  COMMENT '中文名称'
) COMMENT '国家代码';

