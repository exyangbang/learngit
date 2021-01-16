drop table if exists t_industry_amt_limit;
create table t_industry_amt_limit (
	id  int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
	,user_create varchar(250)  COMMENT '创建用户'
	,gmt_create datetime  COMMENT '创建时间'
	,user_modified varchar(250)  COMMENT '修改用户'
	,gmt_modified datetime  COMMENT '修改时间'
	,industry_code varchar(12)  COMMENT '代付客户号'
	,industry_id bigint(20)  COMMENT '代付客户id）'
	,industry_name  varchar(200)  COMMENT '名称'
	,public_individual_amt  bigint(20)  COMMENT '对公单笔限额（单位分）'
	,private_individual_amt bigint(20))  COMMENT '对私单笔限额（单位分）'
	,unit_individual_amt bigint(20))  COMMENT '单位结算卡单笔限额（单位分）'
	,industry_date_amt bigint(20))  COMMENT '客户号单日限额（单位分）'
	,subaccounts_date_amt bigint(20))  COMMENT '子账户单日限额（单位分）'
	,remark  varchar(255)  COMMENT '备注'
) COMMENT '客户交易限额表';

