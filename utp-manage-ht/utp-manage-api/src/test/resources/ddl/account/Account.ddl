drop table if exists t_account;
create table t_account (
	id  bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
        ,user_create varchar(250)  COMMENT '创建用户'
        ,gmt_create datetime  COMMENT '创建时间'
        ,user_modified varchar(250)  COMMENT '修改用户'
        ,gmt_modified datetime  COMMENT '修改时间'
        ,account varchar(20)  COMMENT '账号'
        ,obj_type varchar(10)  COMMENT '归属对象类型'
        ,obj_code varchar(20)  COMMENT '归属对象编号'
        ,obj_name varchar(200)  COMMENT '归属对象名称'
        ,balance bigint(20)  COMMENT '账户余额'
        ,frozen_amount bigint(20)  COMMENT '冻结金额'
        ,avail_amount bigint(20)  COMMENT '可用金额'
        ,status varchar(10)  COMMENT '状态'
) COMMENT '账户管理';

create  unique  index t_account_index_1 on t_account(account);
create  index t_account_index_2 on t_account(obj_code);
