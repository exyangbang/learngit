package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.entity.Account;

public final class AccountCondition {
    private PlusEntityWrapper<Account> ew;

    public AccountCondition() {
        this.ew = new PlusEntityWrapper(Account.class);
    }

    public static AccountCondition builder() {
        return new AccountCondition();
    }

    public PlusEntityWrapper<Account> build() {
        return this.ew;
    }

    public AccountCondition or() {
        this.ew.orNew();
        return this;
    }

    public AccountCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(Account.class);
    }

    public AccountCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public AccountCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public AccountCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public AccountCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> AccountCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> AccountCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> AccountCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public AccountCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public AccountCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public AccountCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public AccountCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public AccountCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public AccountCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public AccountCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public AccountCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public AccountCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public AccountCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public AccountCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public AccountCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public AccountCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public AccountCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public AccountCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public AccountCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public AccountCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public AccountCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public AccountCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public AccountCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public AccountCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public AccountCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public AccountCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public AccountCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public AccountCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public AccountCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public AccountCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public AccountCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public AccountCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public AccountCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public AccountCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public AccountCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public AccountCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public AccountCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public AccountCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public AccountCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public AccountCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public AccountCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public AccountCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public AccountCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public AccountCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public AccountCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public AccountCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public AccountCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public AccountCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public AccountCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public AccountCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public AccountCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public AccountCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public AccountCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public AccountCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public AccountCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public AccountCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public AccountCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public AccountCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public AccountCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public AccountCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public AccountCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public AccountCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public AccountCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public AccountCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public AccountCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public AccountCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public AccountCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public AccountCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public AccountCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public AccountCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public AccountCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public AccountCondition andObjTypeIsNull() {
        ew.isNull("obj_type");
        return this;
    }

    public AccountCondition orObjTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("obj_type");
        return this;
    }

    public AccountCondition andObjTypeIsNotNull() {
        ew.isNotNull("obj_type");
        return this;
    }

    public AccountCondition orObjTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("obj_type");
        return this;
    }

    public AccountCondition andObjTypeEq(Object value) {
        ew.eq("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeNe(Object value) {
        ew.ne("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeGt(Object value) {
        ew.gt("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeGe(Object value) {
        ew.ge("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeLt(Object value) {
        ew.lt("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeLe(Object value) {
        ew.le("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeIn(Object... value) {
        ew.in("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeNotIn(Object... value) {
        ew.notIn("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeBetween(Object value, Object value1) {
        ew.between("obj_type", value, value1);
        return this;
    }

    public AccountCondition orObjTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("obj_type", value, value1);
        return this;
    }

    public AccountCondition andObjTypeNotBetween(Object value, Object value1) {
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public AccountCondition orObjTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public AccountCondition andObjTypeLike(String value) {
        ew.like("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("obj_type", value);
        return this;
    }

    public AccountCondition andObjTypeNotLike(String value) {
        ew.notLike("obj_type", value);
        return this;
    }

    public AccountCondition orObjTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("obj_type", value);
        return this;
    }

    public AccountCondition andObjCodeIsNull() {
        ew.isNull("obj_code");
        return this;
    }

    public AccountCondition orObjCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("obj_code");
        return this;
    }

    public AccountCondition andObjCodeIsNotNull() {
        ew.isNotNull("obj_code");
        return this;
    }

    public AccountCondition orObjCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("obj_code");
        return this;
    }

    public AccountCondition andObjCodeEq(Object value) {
        ew.eq("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeNe(Object value) {
        ew.ne("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeGt(Object value) {
        ew.gt("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeGe(Object value) {
        ew.ge("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeLt(Object value) {
        ew.lt("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeLe(Object value) {
        ew.le("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeIn(Object... value) {
        ew.in("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeNotIn(Object... value) {
        ew.notIn("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeBetween(Object value, Object value1) {
        ew.between("obj_code", value, value1);
        return this;
    }

    public AccountCondition orObjCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("obj_code", value, value1);
        return this;
    }

    public AccountCondition andObjCodeNotBetween(Object value, Object value1) {
        ew.notBetween("obj_code", value, value1);
        return this;
    }

    public AccountCondition orObjCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("obj_code", value, value1);
        return this;
    }

    public AccountCondition andObjCodeLike(String value) {
        ew.like("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("obj_code", value);
        return this;
    }

    public AccountCondition andObjCodeNotLike(String value) {
        ew.notLike("obj_code", value);
        return this;
    }

    public AccountCondition orObjCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("obj_code", value);
        return this;
    }

    public AccountCondition andObjNameIsNull() {
        ew.isNull("obj_name");
        return this;
    }

    public AccountCondition orObjNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("obj_name");
        return this;
    }

    public AccountCondition andObjNameIsNotNull() {
        ew.isNotNull("obj_name");
        return this;
    }

    public AccountCondition orObjNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("obj_name");
        return this;
    }

    public AccountCondition andObjNameEq(Object value) {
        ew.eq("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameNe(Object value) {
        ew.ne("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameGt(Object value) {
        ew.gt("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameGe(Object value) {
        ew.ge("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameLt(Object value) {
        ew.lt("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameLe(Object value) {
        ew.le("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameIn(Object... value) {
        ew.in("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameNotIn(Object... value) {
        ew.notIn("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameBetween(Object value, Object value1) {
        ew.between("obj_name", value, value1);
        return this;
    }

    public AccountCondition orObjNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("obj_name", value, value1);
        return this;
    }

    public AccountCondition andObjNameNotBetween(Object value, Object value1) {
        ew.notBetween("obj_name", value, value1);
        return this;
    }

    public AccountCondition orObjNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("obj_name", value, value1);
        return this;
    }

    public AccountCondition andObjNameLike(String value) {
        ew.like("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("obj_name", value);
        return this;
    }

    public AccountCondition andObjNameNotLike(String value) {
        ew.notLike("obj_name", value);
        return this;
    }

    public AccountCondition orObjNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("obj_name", value);
        return this;
    }

    public AccountCondition andFundAccountIsNull() {
        ew.isNull("fund_account");
        return this;
    }

    public AccountCondition orFundAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fund_account");
        return this;
    }

    public AccountCondition andFundAccountIsNotNull() {
        ew.isNotNull("fund_account");
        return this;
    }

    public AccountCondition orFundAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fund_account");
        return this;
    }

    public AccountCondition andFundAccountEq(Object value) {
        ew.eq("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountNe(Object value) {
        ew.ne("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountGt(Object value) {
        ew.gt("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountGe(Object value) {
        ew.ge("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountLt(Object value) {
        ew.lt("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountLe(Object value) {
        ew.le("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountIn(Object... value) {
        ew.in("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountNotIn(Object... value) {
        ew.notIn("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountBetween(Object value, Object value1) {
        ew.between("fund_account", value, value1);
        return this;
    }

    public AccountCondition orFundAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fund_account", value, value1);
        return this;
    }

    public AccountCondition andFundAccountNotBetween(Object value, Object value1) {
        ew.notBetween("fund_account", value, value1);
        return this;
    }

    public AccountCondition orFundAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fund_account", value, value1);
        return this;
    }

    public AccountCondition andFundAccountLike(String value) {
        ew.like("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fund_account", value);
        return this;
    }

    public AccountCondition andFundAccountNotLike(String value) {
        ew.notLike("fund_account", value);
        return this;
    }

    public AccountCondition orFundAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fund_account", value);
        return this;
    }

    public AccountCondition andBalanceIsNull() {
        ew.isNull("balance");
        return this;
    }

    public AccountCondition orBalanceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("balance");
        return this;
    }

    public AccountCondition andBalanceIsNotNull() {
        ew.isNotNull("balance");
        return this;
    }

    public AccountCondition orBalanceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("balance");
        return this;
    }

    public AccountCondition andBalanceEq(Object value) {
        ew.eq("balance", value);
        return this;
    }

    public AccountCondition orBalanceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("balance", value);
        return this;
    }

    public AccountCondition andBalanceNe(Object value) {
        ew.ne("balance", value);
        return this;
    }

    public AccountCondition orBalanceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("balance", value);
        return this;
    }

    public AccountCondition andBalanceGt(Object value) {
        ew.gt("balance", value);
        return this;
    }

    public AccountCondition orBalanceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("balance", value);
        return this;
    }

    public AccountCondition andBalanceGe(Object value) {
        ew.ge("balance", value);
        return this;
    }

    public AccountCondition orBalanceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("balance", value);
        return this;
    }

    public AccountCondition andBalanceLt(Object value) {
        ew.lt("balance", value);
        return this;
    }

    public AccountCondition orBalanceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("balance", value);
        return this;
    }

    public AccountCondition andBalanceLe(Object value) {
        ew.le("balance", value);
        return this;
    }

    public AccountCondition orBalanceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("balance", value);
        return this;
    }

    public AccountCondition andBalanceIn(Object... value) {
        ew.in("balance", value);
        return this;
    }

    public AccountCondition orBalanceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("balance", value);
        return this;
    }

    public AccountCondition andBalanceNotIn(Object... value) {
        ew.notIn("balance", value);
        return this;
    }

    public AccountCondition orBalanceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("balance", value);
        return this;
    }

    public AccountCondition andBalanceBetween(Object value, Object value1) {
        ew.between("balance", value, value1);
        return this;
    }

    public AccountCondition orBalanceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("balance", value, value1);
        return this;
    }

    public AccountCondition andBalanceNotBetween(Object value, Object value1) {
        ew.notBetween("balance", value, value1);
        return this;
    }

    public AccountCondition orBalanceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("balance", value, value1);
        return this;
    }

    public AccountCondition andBalanceLike(String value) {
        ew.like("balance", value);
        return this;
    }

    public AccountCondition orBalanceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("balance", value);
        return this;
    }

    public AccountCondition andBalanceNotLike(String value) {
        ew.notLike("balance", value);
        return this;
    }

    public AccountCondition orBalanceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("balance", value);
        return this;
    }

    public AccountCondition andFrozenAmountIsNull() {
        ew.isNull("frozen_amount");
        return this;
    }

    public AccountCondition orFrozenAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("frozen_amount");
        return this;
    }

    public AccountCondition andFrozenAmountIsNotNull() {
        ew.isNotNull("frozen_amount");
        return this;
    }

    public AccountCondition orFrozenAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("frozen_amount");
        return this;
    }

    public AccountCondition andFrozenAmountEq(Object value) {
        ew.eq("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountNe(Object value) {
        ew.ne("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountGt(Object value) {
        ew.gt("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountGe(Object value) {
        ew.ge("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountLt(Object value) {
        ew.lt("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountLe(Object value) {
        ew.le("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountIn(Object... value) {
        ew.in("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountNotIn(Object... value) {
        ew.notIn("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountBetween(Object value, Object value1) {
        ew.between("frozen_amount", value, value1);
        return this;
    }

    public AccountCondition orFrozenAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("frozen_amount", value, value1);
        return this;
    }

    public AccountCondition andFrozenAmountNotBetween(Object value, Object value1) {
        ew.notBetween("frozen_amount", value, value1);
        return this;
    }

    public AccountCondition orFrozenAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("frozen_amount", value, value1);
        return this;
    }

    public AccountCondition andFrozenAmountLike(String value) {
        ew.like("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("frozen_amount", value);
        return this;
    }

    public AccountCondition andFrozenAmountNotLike(String value) {
        ew.notLike("frozen_amount", value);
        return this;
    }

    public AccountCondition orFrozenAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("frozen_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountIsNull() {
        ew.isNull("avail_amount");
        return this;
    }

    public AccountCondition orAvailAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("avail_amount");
        return this;
    }

    public AccountCondition andAvailAmountIsNotNull() {
        ew.isNotNull("avail_amount");
        return this;
    }

    public AccountCondition orAvailAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("avail_amount");
        return this;
    }

    public AccountCondition andAvailAmountEq(Object value) {
        ew.eq("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountNe(Object value) {
        ew.ne("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountGt(Object value) {
        ew.gt("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountGe(Object value) {
        ew.ge("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountLt(Object value) {
        ew.lt("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountLe(Object value) {
        ew.le("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountIn(Object... value) {
        ew.in("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountNotIn(Object... value) {
        ew.notIn("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountBetween(Object value, Object value1) {
        ew.between("avail_amount", value, value1);
        return this;
    }

    public AccountCondition orAvailAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("avail_amount", value, value1);
        return this;
    }

    public AccountCondition andAvailAmountNotBetween(Object value, Object value1) {
        ew.notBetween("avail_amount", value, value1);
        return this;
    }

    public AccountCondition orAvailAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("avail_amount", value, value1);
        return this;
    }

    public AccountCondition andAvailAmountLike(String value) {
        ew.like("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("avail_amount", value);
        return this;
    }

    public AccountCondition andAvailAmountNotLike(String value) {
        ew.notLike("avail_amount", value);
        return this;
    }

    public AccountCondition orAvailAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("avail_amount", value);
        return this;
    }

    public AccountCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public AccountCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public AccountCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public AccountCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public AccountCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public AccountCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public AccountCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public AccountCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public AccountCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public AccountCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public AccountCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public AccountCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public AccountCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public AccountCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public AccountCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public AccountCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public AccountCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public AccountCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public AccountCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public AccountCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public AccountCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public AccountCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public AccountCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public AccountCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public AccountCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public AccountCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public AccountCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public AccountCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public AccountCondition andVersionIsNull() {
        ew.isNull("version");
        return this;
    }

    public AccountCondition orVersionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("version");
        return this;
    }

    public AccountCondition andVersionIsNotNull() {
        ew.isNotNull("version");
        return this;
    }

    public AccountCondition orVersionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("version");
        return this;
    }

    public AccountCondition andVersionEq(Object value) {
        ew.eq("version", value);
        return this;
    }

    public AccountCondition orVersionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("version", value);
        return this;
    }

    public AccountCondition andVersionNe(Object value) {
        ew.ne("version", value);
        return this;
    }

    public AccountCondition orVersionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("version", value);
        return this;
    }

    public AccountCondition andVersionGt(Object value) {
        ew.gt("version", value);
        return this;
    }

    public AccountCondition orVersionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("version", value);
        return this;
    }

    public AccountCondition andVersionGe(Object value) {
        ew.ge("version", value);
        return this;
    }

    public AccountCondition orVersionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("version", value);
        return this;
    }

    public AccountCondition andVersionLt(Object value) {
        ew.lt("version", value);
        return this;
    }

    public AccountCondition orVersionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("version", value);
        return this;
    }

    public AccountCondition andVersionLe(Object value) {
        ew.le("version", value);
        return this;
    }

    public AccountCondition orVersionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("version", value);
        return this;
    }

    public AccountCondition andVersionIn(Object... value) {
        ew.in("version", value);
        return this;
    }

    public AccountCondition orVersionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("version", value);
        return this;
    }

    public AccountCondition andVersionNotIn(Object... value) {
        ew.notIn("version", value);
        return this;
    }

    public AccountCondition orVersionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("version", value);
        return this;
    }

    public AccountCondition andVersionBetween(Object value, Object value1) {
        ew.between("version", value, value1);
        return this;
    }

    public AccountCondition orVersionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("version", value, value1);
        return this;
    }

    public AccountCondition andVersionNotBetween(Object value, Object value1) {
        ew.notBetween("version", value, value1);
        return this;
    }

    public AccountCondition orVersionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("version", value, value1);
        return this;
    }

    public AccountCondition andVersionLike(String value) {
        ew.like("version", value);
        return this;
    }

    public AccountCondition orVersionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("version", value);
        return this;
    }

    public AccountCondition andVersionNotLike(String value) {
        ew.notLike("version", value);
        return this;
    }

    public AccountCondition orVersionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("version", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdIsNull() {
        ew.isNull("fee_template_id");
        return this;
    }

    public AccountCondition orFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_template_id");
        return this;
    }

    public AccountCondition andFeeTemplateIdIsNotNull() {
        ew.isNotNull("fee_template_id");
        return this;
    }

    public AccountCondition orFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_template_id");
        return this;
    }

    public AccountCondition andFeeTemplateIdEq(Object value) {
        ew.eq("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdNe(Object value) {
        ew.ne("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdGt(Object value) {
        ew.gt("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdGe(Object value) {
        ew.ge("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdLt(Object value) {
        ew.lt("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdLe(Object value) {
        ew.le("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdIn(Object... value) {
        ew.in("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdNotIn(Object... value) {
        ew.notIn("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("fee_template_id", value, value1);
        return this;
    }

    public AccountCondition orFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_template_id", value, value1);
        return this;
    }

    public AccountCondition andFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("fee_template_id", value, value1);
        return this;
    }

    public AccountCondition orFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_template_id", value, value1);
        return this;
    }

    public AccountCondition andFeeTemplateIdLike(String value) {
        ew.like("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_template_id", value);
        return this;
    }

    public AccountCondition andFeeTemplateIdNotLike(String value) {
        ew.notLike("fee_template_id", value);
        return this;
    }

    public AccountCondition orFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_template_id", value);
        return this;
    }

    public AccountCondition andIndustryIdIsNull() {
        ew.isNull("industry_id");
        return this;
    }

    public AccountCondition orIndustryIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_id");
        return this;
    }

    public AccountCondition andIndustryIdIsNotNull() {
        ew.isNotNull("industry_id");
        return this;
    }

    public AccountCondition orIndustryIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_id");
        return this;
    }

    public AccountCondition andIndustryIdEq(Object value) {
        ew.eq("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdNe(Object value) {
        ew.ne("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdGt(Object value) {
        ew.gt("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdGe(Object value) {
        ew.ge("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdLt(Object value) {
        ew.lt("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdLe(Object value) {
        ew.le("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdIn(Object... value) {
        ew.in("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdNotIn(Object... value) {
        ew.notIn("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdBetween(Object value, Object value1) {
        ew.between("industry_id", value, value1);
        return this;
    }

    public AccountCondition orIndustryIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_id", value, value1);
        return this;
    }

    public AccountCondition andIndustryIdNotBetween(Object value, Object value1) {
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public AccountCondition orIndustryIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public AccountCondition andIndustryIdLike(String value) {
        ew.like("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_id", value);
        return this;
    }

    public AccountCondition andIndustryIdNotLike(String value) {
        ew.notLike("industry_id", value);
        return this;
    }

    public AccountCondition orIndustryIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_id", value);
        return this;
    }

    public AccountCondition andBankClientNoIsNull() {
        ew.isNull("bank_client_no");
        return this;
    }

    public AccountCondition orBankClientNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_client_no");
        return this;
    }

    public AccountCondition andBankClientNoIsNotNull() {
        ew.isNotNull("bank_client_no");
        return this;
    }

    public AccountCondition orBankClientNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_client_no");
        return this;
    }

    public AccountCondition andBankClientNoEq(Object value) {
        ew.eq("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoNe(Object value) {
        ew.ne("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoGt(Object value) {
        ew.gt("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoGe(Object value) {
        ew.ge("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoLt(Object value) {
        ew.lt("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoLe(Object value) {
        ew.le("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoIn(Object... value) {
        ew.in("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoNotIn(Object... value) {
        ew.notIn("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoBetween(Object value, Object value1) {
        ew.between("bank_client_no", value, value1);
        return this;
    }

    public AccountCondition orBankClientNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_client_no", value, value1);
        return this;
    }

    public AccountCondition andBankClientNoNotBetween(Object value, Object value1) {
        ew.notBetween("bank_client_no", value, value1);
        return this;
    }

    public AccountCondition orBankClientNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_client_no", value, value1);
        return this;
    }

    public AccountCondition andBankClientNoLike(String value) {
        ew.like("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_client_no", value);
        return this;
    }

    public AccountCondition andBankClientNoNotLike(String value) {
        ew.notLike("bank_client_no", value);
        return this;
    }

    public AccountCondition orBankClientNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_client_no", value);
        return this;
    }
}