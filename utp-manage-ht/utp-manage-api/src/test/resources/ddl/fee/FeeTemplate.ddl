drop table if exists t_fee_template;
create table t_fee_template (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,name varchar(50)  COMMENT '模板名称'
	,settle_type varchar(10)  COMMENT '结算类型'
	,charge_mode varchar(10)  COMMENT '收费模式'
	,calculate_mode varchar(10)  COMMENT '计算方式'
	,fee double  COMMENT '手续费'
	,min_fee double  COMMENT '最小手续费'
	,max_fee double  COMMENT '最大手续费'
	,remark varchar(255)  COMMENT '备注信息'
) COMMENT '手续费模板管理';

create  index t_fee_template_index_1 on t_fee_template(name);
