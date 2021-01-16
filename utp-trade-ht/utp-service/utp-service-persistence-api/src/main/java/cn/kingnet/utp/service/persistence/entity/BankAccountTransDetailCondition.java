package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class BankAccountTransDetailCondition {
    private PlusEntityWrapper<BankAccountTransDetail> ew;

    public BankAccountTransDetailCondition() {
        this.ew = new PlusEntityWrapper(BankAccountTransDetail.class);
    }

    public static BankAccountTransDetailCondition builder() {
        return new BankAccountTransDetailCondition();
    }

    public PlusEntityWrapper<BankAccountTransDetail> build() {
        return this.ew;
    }

    public BankAccountTransDetailCondition or() {
        this.ew.orNew();
        return this;
    }

    public BankAccountTransDetailCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(BankAccountTransDetail.class);
    }

    public BankAccountTransDetailCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public BankAccountTransDetailCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public BankAccountTransDetailCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public BankAccountTransDetailCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> BankAccountTransDetailCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> BankAccountTransDetailCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> BankAccountTransDetailCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public BankAccountTransDetailCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public BankAccountTransDetailCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public BankAccountTransDetailCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public BankAccountTransDetailCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public BankAccountTransDetailCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public BankAccountTransDetailCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public BankAccountTransDetailCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public BankAccountTransDetailCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public BankAccountTransDetailCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberIsNull() {
        ew.isNull("card_number");
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("card_number");
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberIsNotNull() {
        ew.isNotNull("card_number");
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("card_number");
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberEq(Object value) {
        ew.eq("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberNe(Object value) {
        ew.ne("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberGt(Object value) {
        ew.gt("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberGe(Object value) {
        ew.ge("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberLt(Object value) {
        ew.lt("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberLe(Object value) {
        ew.le("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberIn(Object... value) {
        ew.in("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberNotIn(Object... value) {
        ew.notIn("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberBetween(Object value, Object value1) {
        ew.between("card_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("card_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberNotBetween(Object value, Object value1) {
        ew.notBetween("card_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("card_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberLike(String value) {
        ew.like("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCardNumberNotLike(String value) {
        ew.notLike("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orCardNumberNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("card_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoIsNull() {
        ew.isNull("cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoIsNotNull() {
        ew.isNotNull("cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoEq(Object value) {
        ew.eq("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoNe(Object value) {
        ew.ne("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoGt(Object value) {
        ew.gt("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoGe(Object value) {
        ew.ge("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoLt(Object value) {
        ew.lt("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoLe(Object value) {
        ew.le("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoIn(Object... value) {
        ew.in("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoNotIn(Object... value) {
        ew.notIn("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoBetween(Object value, Object value1) {
        ew.between("cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoLike(String value) {
        ew.like("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNoNotLike(String value) {
        ew.notLike("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameIsNull() {
        ew.isNull("cust_account_name");
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cust_account_name");
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameIsNotNull() {
        ew.isNotNull("cust_account_name");
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cust_account_name");
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameEq(Object value) {
        ew.eq("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameNe(Object value) {
        ew.ne("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameGt(Object value) {
        ew.gt("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameGe(Object value) {
        ew.ge("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameLt(Object value) {
        ew.lt("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameLe(Object value) {
        ew.le("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameIn(Object... value) {
        ew.in("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameNotIn(Object... value) {
        ew.notIn("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameBetween(Object value, Object value1) {
        ew.between("cust_account_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cust_account_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("cust_account_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cust_account_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameLike(String value) {
        ew.like("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andCustAccountNameNotLike(String value) {
        ew.notLike("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orCustAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cust_account_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateIsNull() {
        ew.isNull("txn_date");
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("txn_date");
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateIsNotNull() {
        ew.isNotNull("txn_date");
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("txn_date");
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateEq(Object value) {
        ew.eq("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateNe(Object value) {
        ew.ne("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateGt(Object value) {
        ew.gt("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateGe(Object value) {
        ew.ge("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateLt(Object value) {
        ew.lt("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateLe(Object value) {
        ew.le("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateIn(Object... value) {
        ew.in("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateNotIn(Object... value) {
        ew.notIn("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateBetween(Object value, Object value1) {
        ew.between("txn_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("txn_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateNotBetween(Object value, Object value1) {
        ew.notBetween("txn_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("txn_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateLike(String value) {
        ew.like("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnDateNotLike(String value) {
        ew.notLike("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("txn_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateIsNull() {
        ew.isNull("nature_date");
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("nature_date");
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateIsNotNull() {
        ew.isNotNull("nature_date");
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("nature_date");
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateEq(Object value) {
        ew.eq("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateNe(Object value) {
        ew.ne("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateGt(Object value) {
        ew.gt("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateGe(Object value) {
        ew.ge("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateLt(Object value) {
        ew.lt("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateLe(Object value) {
        ew.le("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateIn(Object... value) {
        ew.in("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateNotIn(Object... value) {
        ew.notIn("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateBetween(Object value, Object value1) {
        ew.between("nature_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("nature_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateNotBetween(Object value, Object value1) {
        ew.notBetween("nature_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("nature_date", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateLike(String value) {
        ew.like("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andNatureDateNotLike(String value) {
        ew.notLike("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition orNatureDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("nature_date", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberIsNull() {
        ew.isNull("detail_serial_number");
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("detail_serial_number");
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberIsNotNull() {
        ew.isNotNull("detail_serial_number");
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("detail_serial_number");
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberEq(Object value) {
        ew.eq("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberNe(Object value) {
        ew.ne("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberGt(Object value) {
        ew.gt("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberGe(Object value) {
        ew.ge("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberLt(Object value) {
        ew.lt("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberLe(Object value) {
        ew.le("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberIn(Object... value) {
        ew.in("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberNotIn(Object... value) {
        ew.notIn("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberBetween(Object value, Object value1) {
        ew.between("detail_serial_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("detail_serial_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberNotBetween(Object value, Object value1) {
        ew.notBetween("detail_serial_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("detail_serial_number", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberLike(String value) {
        ew.like("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDetailSerialNumberNotLike(String value) {
        ew.notLike("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition orDetailSerialNumberNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("detail_serial_number", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagIsNull() {
        ew.isNull("drcr_flag");
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("drcr_flag");
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagIsNotNull() {
        ew.isNotNull("drcr_flag");
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("drcr_flag");
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagEq(Object value) {
        ew.eq("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagNe(Object value) {
        ew.ne("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagGt(Object value) {
        ew.gt("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagGe(Object value) {
        ew.ge("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagLt(Object value) {
        ew.lt("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagLe(Object value) {
        ew.le("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagIn(Object... value) {
        ew.in("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagNotIn(Object... value) {
        ew.notIn("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagBetween(Object value, Object value1) {
        ew.between("drcr_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("drcr_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagNotBetween(Object value, Object value1) {
        ew.notBetween("drcr_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("drcr_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagLike(String value) {
        ew.like("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andDrcrFlagNotLike(String value) {
        ew.notLike("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orDrcrFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("drcr_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountIsNull() {
        ew.isNull("txn_amount");
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("txn_amount");
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountIsNotNull() {
        ew.isNotNull("txn_amount");
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("txn_amount");
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountEq(Object value) {
        ew.eq("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountNe(Object value) {
        ew.ne("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountGt(Object value) {
        ew.gt("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountGe(Object value) {
        ew.ge("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountLt(Object value) {
        ew.lt("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountLe(Object value) {
        ew.le("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountIn(Object... value) {
        ew.in("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountNotIn(Object... value) {
        ew.notIn("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountBetween(Object value, Object value1) {
        ew.between("txn_amount", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("txn_amount", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountNotBetween(Object value, Object value1) {
        ew.notBetween("txn_amount", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("txn_amount", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountLike(String value) {
        ew.like("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnAmountNotLike(String value) {
        ew.notLike("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("txn_amount", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceIsNull() {
        ew.isNull("account_balance");
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_balance");
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceIsNotNull() {
        ew.isNotNull("account_balance");
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_balance");
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceEq(Object value) {
        ew.eq("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceNe(Object value) {
        ew.ne("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceGt(Object value) {
        ew.gt("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceGe(Object value) {
        ew.ge("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceLt(Object value) {
        ew.lt("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceLe(Object value) {
        ew.le("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceIn(Object... value) {
        ew.in("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceNotIn(Object... value) {
        ew.notIn("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceBetween(Object value, Object value1) {
        ew.between("account_balance", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_balance", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceNotBetween(Object value, Object value1) {
        ew.notBetween("account_balance", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_balance", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceLike(String value) {
        ew.like("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBalanceNotLike(String value) {
        ew.notLike("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBalanceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_balance", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoIsNull() {
        ew.isNull("other_cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoIsNotNull() {
        ew.isNotNull("other_cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_cust_account_no");
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoEq(Object value) {
        ew.eq("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoNe(Object value) {
        ew.ne("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoGt(Object value) {
        ew.gt("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoGe(Object value) {
        ew.ge("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoLt(Object value) {
        ew.lt("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoLe(Object value) {
        ew.le("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoIn(Object... value) {
        ew.in("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoNotIn(Object... value) {
        ew.notIn("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoBetween(Object value, Object value1) {
        ew.between("other_cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("other_cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_cust_account_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoLike(String value) {
        ew.like("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustAccountNoNotLike(String value) {
        ew.notLike("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_cust_account_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameIsNull() {
        ew.isNull("other_cust_name");
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_cust_name");
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameIsNotNull() {
        ew.isNotNull("other_cust_name");
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_cust_name");
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameEq(Object value) {
        ew.eq("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameNe(Object value) {
        ew.ne("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameGt(Object value) {
        ew.gt("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameGe(Object value) {
        ew.ge("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameLt(Object value) {
        ew.lt("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameLe(Object value) {
        ew.le("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameIn(Object... value) {
        ew.in("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameNotIn(Object... value) {
        ew.notIn("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameBetween(Object value, Object value1) {
        ew.between("other_cust_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_cust_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameNotBetween(Object value, Object value1) {
        ew.notBetween("other_cust_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_cust_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameLike(String value) {
        ew.like("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherCustNameNotLike(String value) {
        ew.notLike("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherCustNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_cust_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagIsNull() {
        ew.isNull("reversed_flag");
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reversed_flag");
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagIsNotNull() {
        ew.isNotNull("reversed_flag");
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reversed_flag");
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagEq(Object value) {
        ew.eq("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagNe(Object value) {
        ew.ne("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagGt(Object value) {
        ew.gt("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagGe(Object value) {
        ew.ge("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagLt(Object value) {
        ew.lt("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagLe(Object value) {
        ew.le("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagIn(Object... value) {
        ew.in("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagNotIn(Object... value) {
        ew.notIn("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagBetween(Object value, Object value1) {
        ew.between("reversed_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reversed_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagNotBetween(Object value, Object value1) {
        ew.notBetween("reversed_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reversed_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagLike(String value) {
        ew.like("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andReversedFlagNotLike(String value) {
        ew.notLike("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orReversedFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reversed_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailIsNull() {
        ew.isNull("remark_detail");
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark_detail");
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailIsNotNull() {
        ew.isNotNull("remark_detail");
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark_detail");
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailEq(Object value) {
        ew.eq("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailNe(Object value) {
        ew.ne("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailGt(Object value) {
        ew.gt("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailGe(Object value) {
        ew.ge("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailLt(Object value) {
        ew.lt("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailLe(Object value) {
        ew.le("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailIn(Object... value) {
        ew.in("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailNotIn(Object... value) {
        ew.notIn("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailBetween(Object value, Object value1) {
        ew.between("remark_detail", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark_detail", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailNotBetween(Object value, Object value1) {
        ew.notBetween("remark_detail", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark_detail", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailLike(String value) {
        ew.like("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andRemarkDetailNotLike(String value) {
        ew.notLike("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition orRemarkDetailNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark_detail", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeIsNull() {
        ew.isNull("txn_time");
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("txn_time");
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeIsNotNull() {
        ew.isNotNull("txn_time");
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("txn_time");
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeEq(Object value) {
        ew.eq("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeNe(Object value) {
        ew.ne("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeGt(Object value) {
        ew.gt("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeGe(Object value) {
        ew.ge("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeLt(Object value) {
        ew.lt("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeLe(Object value) {
        ew.le("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeIn(Object... value) {
        ew.in("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeNotIn(Object... value) {
        ew.notIn("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeBetween(Object value, Object value1) {
        ew.between("txn_time", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("txn_time", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeNotBetween(Object value, Object value1) {
        ew.notBetween("txn_time", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("txn_time", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeLike(String value) {
        ew.like("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andTxnTimeNotLike(String value) {
        ew.notLike("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition orTxnTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("txn_time", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoIsNull() {
        ew.isNull("sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoIsNotNull() {
        ew.isNotNull("sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoEq(Object value) {
        ew.eq("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoNe(Object value) {
        ew.ne("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoGt(Object value) {
        ew.gt("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoGe(Object value) {
        ew.ge("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoLt(Object value) {
        ew.lt("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoLe(Object value) {
        ew.le("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoIn(Object... value) {
        ew.in("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoNotIn(Object... value) {
        ew.notIn("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoBetween(Object value, Object value1) {
        ew.between("sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoNotBetween(Object value, Object value1) {
        ew.notBetween("sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoLike(String value) {
        ew.like("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andSysReferenceNoNotLike(String value) {
        ew.notLike("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orSysReferenceNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoIsNull() {
        ew.isNull("org_sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoIsNotNull() {
        ew.isNotNull("org_sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_sys_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoEq(Object value) {
        ew.eq("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoNe(Object value) {
        ew.ne("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoGt(Object value) {
        ew.gt("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoGe(Object value) {
        ew.ge("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoLt(Object value) {
        ew.lt("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoLe(Object value) {
        ew.le("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoIn(Object... value) {
        ew.in("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoNotIn(Object... value) {
        ew.notIn("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoBetween(Object value, Object value1) {
        ew.between("org_sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoNotBetween(Object value, Object value1) {
        ew.notBetween("org_sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_sys_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoLike(String value) {
        ew.like("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrgSysReferenceNoNotLike(String value) {
        ew.notLike("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrgSysReferenceNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_sys_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameIsNull() {
        ew.isNull("other_bank_name");
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_bank_name");
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameIsNotNull() {
        ew.isNotNull("other_bank_name");
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_bank_name");
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameEq(Object value) {
        ew.eq("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameNe(Object value) {
        ew.ne("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameGt(Object value) {
        ew.gt("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameGe(Object value) {
        ew.ge("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameLt(Object value) {
        ew.lt("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameLe(Object value) {
        ew.le("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameIn(Object... value) {
        ew.in("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameNotIn(Object... value) {
        ew.notIn("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameBetween(Object value, Object value1) {
        ew.between("other_bank_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_bank_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("other_bank_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_bank_name", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameLike(String value) {
        ew.like("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNameNotLike(String value) {
        ew.notLike("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_bank_name", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkIsNull() {
        ew.isNull("other_remark");
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_remark");
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkIsNotNull() {
        ew.isNotNull("other_remark");
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_remark");
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkEq(Object value) {
        ew.eq("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkNe(Object value) {
        ew.ne("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkGt(Object value) {
        ew.gt("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkGe(Object value) {
        ew.ge("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkLt(Object value) {
        ew.lt("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkLe(Object value) {
        ew.le("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkIn(Object... value) {
        ew.in("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkNotIn(Object... value) {
        ew.notIn("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkBetween(Object value, Object value1) {
        ew.between("other_remark", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_remark", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("other_remark", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_remark", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkLike(String value) {
        ew.like("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRemarkNotLike(String value) {
        ew.notLike("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_remark", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusIsNull() {
        ew.isNull("oper_status");
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("oper_status");
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusIsNotNull() {
        ew.isNotNull("oper_status");
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("oper_status");
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusEq(Object value) {
        ew.eq("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusNe(Object value) {
        ew.ne("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusGt(Object value) {
        ew.gt("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusGe(Object value) {
        ew.ge("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusLt(Object value) {
        ew.lt("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusLe(Object value) {
        ew.le("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusIn(Object... value) {
        ew.in("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusNotIn(Object... value) {
        ew.notIn("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusBetween(Object value, Object value1) {
        ew.between("oper_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("oper_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusNotBetween(Object value, Object value1) {
        ew.notBetween("oper_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("oper_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusLike(String value) {
        ew.like("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOperStatusNotLike(String value) {
        ew.notLike("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOperStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("oper_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionIsNull() {
        ew.isNull("summary_description");
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("summary_description");
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionIsNotNull() {
        ew.isNotNull("summary_description");
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("summary_description");
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionEq(Object value) {
        ew.eq("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionNe(Object value) {
        ew.ne("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionGt(Object value) {
        ew.gt("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionGe(Object value) {
        ew.ge("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionLt(Object value) {
        ew.lt("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionLe(Object value) {
        ew.le("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionIn(Object... value) {
        ew.in("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionNotIn(Object... value) {
        ew.notIn("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionBetween(Object value, Object value1) {
        ew.between("summary_description", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("summary_description", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionLike(String value) {
        ew.like("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andSummaryDescriptionNotLike(String value) {
        ew.notLike("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition orSummaryDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("summary_description", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public BankAccountTransDetailCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public BankAccountTransDetailCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public BankAccountTransDetailCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public BankAccountTransDetailCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public BankAccountTransDetailCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusIsNull() {
        ew.isNull("order_status");
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_status");
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusIsNotNull() {
        ew.isNotNull("order_status");
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_status");
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusEq(Object value) {
        ew.eq("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusNe(Object value) {
        ew.ne("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusGt(Object value) {
        ew.gt("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusGe(Object value) {
        ew.ge("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusLt(Object value) {
        ew.lt("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusLe(Object value) {
        ew.le("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusIn(Object... value) {
        ew.in("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusNotIn(Object... value) {
        ew.notIn("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusBetween(Object value, Object value1) {
        ew.between("order_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusNotBetween(Object value, Object value1) {
        ew.notBetween("order_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusLike(String value) {
        ew.like("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andOrderStatusNotLike(String value) {
        ew.notLike("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orOrderStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagIsNull() {
        ew.isNull("source_flag");
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("source_flag");
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagIsNotNull() {
        ew.isNotNull("source_flag");
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("source_flag");
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagEq(Object value) {
        ew.eq("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagNe(Object value) {
        ew.ne("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagGt(Object value) {
        ew.gt("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagGe(Object value) {
        ew.ge("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagLt(Object value) {
        ew.lt("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagLe(Object value) {
        ew.le("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagIn(Object... value) {
        ew.in("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagNotIn(Object... value) {
        ew.notIn("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagBetween(Object value, Object value1) {
        ew.between("source_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("source_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagNotBetween(Object value, Object value1) {
        ew.notBetween("source_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("source_flag", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagLike(String value) {
        ew.like("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andSourceFlagNotLike(String value) {
        ew.notLike("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition orSourceFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("source_flag", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusIsNull() {
        ew.isNull("audit_status");
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("audit_status");
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusIsNotNull() {
        ew.isNotNull("audit_status");
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("audit_status");
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusEq(Object value) {
        ew.eq("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusNe(Object value) {
        ew.ne("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusGt(Object value) {
        ew.gt("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusGe(Object value) {
        ew.ge("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusLt(Object value) {
        ew.lt("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusLe(Object value) {
        ew.le("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusIn(Object... value) {
        ew.in("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusNotIn(Object... value) {
        ew.notIn("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusBetween(Object value, Object value1) {
        ew.between("audit_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("audit_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusNotBetween(Object value, Object value1) {
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusLike(String value) {
        ew.like("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andAuditStatusNotLike(String value) {
        ew.notLike("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition orAuditStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("audit_status", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoIsNull() {
        ew.isNull("biz_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("biz_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoIsNotNull() {
        ew.isNotNull("biz_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("biz_reference_no");
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoEq(Object value) {
        ew.eq("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoNe(Object value) {
        ew.ne("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoGt(Object value) {
        ew.gt("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoGe(Object value) {
        ew.ge("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoLt(Object value) {
        ew.lt("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoLe(Object value) {
        ew.le("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoIn(Object... value) {
        ew.in("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoNotIn(Object... value) {
        ew.notIn("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoBetween(Object value, Object value1) {
        ew.between("biz_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("biz_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoNotBetween(Object value, Object value1) {
        ew.notBetween("biz_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("biz_reference_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoLike(String value) {
        ew.like("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andBizReferenceNoNotLike(String value) {
        ew.notLike("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orBizReferenceNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("biz_reference_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoIsNull() {
        ew.isNull("other_bank_no");
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_bank_no");
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoIsNotNull() {
        ew.isNotNull("other_bank_no");
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_bank_no");
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoEq(Object value) {
        ew.eq("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoNe(Object value) {
        ew.ne("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoGt(Object value) {
        ew.gt("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoGe(Object value) {
        ew.ge("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoLt(Object value) {
        ew.lt("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoLe(Object value) {
        ew.le("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoIn(Object... value) {
        ew.in("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoNotIn(Object... value) {
        ew.notIn("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoBetween(Object value, Object value1) {
        ew.between("other_bank_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_bank_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoNotBetween(Object value, Object value1) {
        ew.notBetween("other_bank_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_bank_no", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoLike(String value) {
        ew.like("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherBankNoNotLike(String value) {
        ew.notLike("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherBankNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_bank_no", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidIsNull() {
        ew.isNull("other_rid");
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_rid");
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidIsNotNull() {
        ew.isNotNull("other_rid");
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_rid");
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidEq(Object value) {
        ew.eq("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidNe(Object value) {
        ew.ne("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidGt(Object value) {
        ew.gt("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidGe(Object value) {
        ew.ge("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidLt(Object value) {
        ew.lt("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidLe(Object value) {
        ew.le("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidIn(Object... value) {
        ew.in("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidNotIn(Object... value) {
        ew.notIn("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidBetween(Object value, Object value1) {
        ew.between("other_rid", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_rid", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidNotBetween(Object value, Object value1) {
        ew.notBetween("other_rid", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_rid", value, value1);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidLike(String value) {
        ew.like("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition andOtherRidNotLike(String value) {
        ew.notLike("other_rid", value);
        return this;
    }

    public BankAccountTransDetailCondition orOtherRidNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_rid", value);
        return this;
    }
}