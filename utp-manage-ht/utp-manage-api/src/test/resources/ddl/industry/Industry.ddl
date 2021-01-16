drop table if exists t_industry;
create table t_industry (
	id  bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
        ,user_create varchar(250)  COMMENT '创建用户'
        ,gmt_create datetime  COMMENT '创建时间'
        ,user_modified varchar(250)  COMMENT '修改用户'
        ,gmt_modified datetime  COMMENT '修改时间'
        ,name varchar(200)  COMMENT '名称'
        ,simple_name varchar(200)  COMMENT '简称'
        ,code varchar(12)  COMMENT '行业代码'
        ,province_code varchar(10)  COMMENT '省代码'
        ,city_code varchar(10)  COMMENT '市代码'
        ,county_code varchar(10)  COMMENT '县代码'
        ,account varchar(20)  COMMENT '来款账户'
        ,account_name varchar(200)  COMMENT '来款账户名称'
        ,bank_name varchar(200)  COMMENT '来款银行名称'
        ,bank_code varchar(20)  COMMENT '来款银行行号'
        ,status varchar(10)  COMMENT '状态'
) COMMENT '行业管理';

create  unique  index t_industry_index_1 on t_industry(name);
create  unique  index t_industry_index_2 on t_industry(code);
