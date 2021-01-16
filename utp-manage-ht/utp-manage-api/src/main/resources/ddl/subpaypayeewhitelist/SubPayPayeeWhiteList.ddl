drop table if exists t_sub_pay_payee_white_list;
create table t_sub_pay_payee_white_list (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,payee_account varchar(100)  COMMENT '收款账号'
	,payee_name varchar(250)  COMMENT '收款户名'
	,industry_id int(20)  COMMENT '代付客户号'
) COMMENT '子账户单笔付款收款白名单';

