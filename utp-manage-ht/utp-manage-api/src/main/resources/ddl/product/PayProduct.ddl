drop table if exists t_pay_product;
create table t_pay_product (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,code varchar(30)  COMMENT '产品编码'
	,name varchar(50)  COMMENT '产品名称'
	,remark varchar(255)  COMMENT '备注信息'
	,status varchar(20)  COMMENT '状态'
) COMMENT '支付产品表';

create  index t_pay_product_index_1 on t_pay_product(code);
create  index t_pay_product_index_2 on t_pay_product(name);
