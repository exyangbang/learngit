package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class OutsideTransOrderCondition {
    private PlusEntityWrapper<OutsideTransOrder> ew;

    public OutsideTransOrderCondition() {
        this.ew = new PlusEntityWrapper(OutsideTransOrder.class);
    }

    public static OutsideTransOrderCondition builder() {
        return new OutsideTransOrderCondition();
    }

    public PlusEntityWrapper<OutsideTransOrder> build() {
        return this.ew;
    }

    public OutsideTransOrderCondition or() {
        this.ew.orNew();
        return this;
    }

    public OutsideTransOrderCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(OutsideTransOrder.class);
    }

    public OutsideTransOrderCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public OutsideTransOrderCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public OutsideTransOrderCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public OutsideTransOrderCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> OutsideTransOrderCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> OutsideTransOrderCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> OutsideTransOrderCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public OutsideTransOrderCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public OutsideTransOrderCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public OutsideTransOrderCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public OutsideTransOrderCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public OutsideTransOrderCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public OutsideTransOrderCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public OutsideTransOrderCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public OutsideTransOrderCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public OutsideTransOrderCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public OutsideTransOrderCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public OutsideTransOrderCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public OutsideTransOrderCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public OutsideTransOrderCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public OutsideTransOrderCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdIsNull() {
        ew.isNull("batch_id");
        return this;
    }

    public OutsideTransOrderCondition orBatchIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_id");
        return this;
    }

    public OutsideTransOrderCondition andBatchIdIsNotNull() {
        ew.isNotNull("batch_id");
        return this;
    }

    public OutsideTransOrderCondition orBatchIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_id");
        return this;
    }

    public OutsideTransOrderCondition andBatchIdEq(Object value) {
        ew.eq("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdNe(Object value) {
        ew.ne("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdGt(Object value) {
        ew.gt("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdGe(Object value) {
        ew.ge("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdLt(Object value) {
        ew.lt("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdLe(Object value) {
        ew.le("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdIn(Object... value) {
        ew.in("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdNotIn(Object... value) {
        ew.notIn("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdBetween(Object value, Object value1) {
        ew.between("batch_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdNotBetween(Object value, Object value1) {
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdLike(String value) {
        ew.like("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBatchIdNotLike(String value) {
        ew.notLike("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBatchIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_id", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateIsNull() {
        ew.isNull("req_date");
        return this;
    }

    public OutsideTransOrderCondition orReqDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_date");
        return this;
    }

    public OutsideTransOrderCondition andReqDateIsNotNull() {
        ew.isNotNull("req_date");
        return this;
    }

    public OutsideTransOrderCondition orReqDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_date");
        return this;
    }

    public OutsideTransOrderCondition andReqDateEq(Object value) {
        ew.eq("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateNe(Object value) {
        ew.ne("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateGt(Object value) {
        ew.gt("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateGe(Object value) {
        ew.ge("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateLt(Object value) {
        ew.lt("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateLe(Object value) {
        ew.le("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateIn(Object... value) {
        ew.in("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateNotIn(Object... value) {
        ew.notIn("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateBetween(Object value, Object value1) {
        ew.between("req_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orReqDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andReqDateNotBetween(Object value, Object value1) {
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orReqDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andReqDateLike(String value) {
        ew.like("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqDateNotLike(String value) {
        ew.notLike("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition orReqDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_date", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeIsNull() {
        ew.isNull("req_time");
        return this;
    }

    public OutsideTransOrderCondition orReqTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_time");
        return this;
    }

    public OutsideTransOrderCondition andReqTimeIsNotNull() {
        ew.isNotNull("req_time");
        return this;
    }

    public OutsideTransOrderCondition orReqTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_time");
        return this;
    }

    public OutsideTransOrderCondition andReqTimeEq(Object value) {
        ew.eq("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeNe(Object value) {
        ew.ne("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeGt(Object value) {
        ew.gt("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeGe(Object value) {
        ew.ge("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeLt(Object value) {
        ew.lt("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeLe(Object value) {
        ew.le("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeIn(Object... value) {
        ew.in("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeNotIn(Object... value) {
        ew.notIn("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeBetween(Object value, Object value1) {
        ew.between("req_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeNotBetween(Object value, Object value1) {
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeLike(String value) {
        ew.like("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andReqTimeNotLike(String value) {
        ew.notLike("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition orReqTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public OutsideTransOrderCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public OutsideTransOrderCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public OutsideTransOrderCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public OutsideTransOrderCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public OutsideTransOrderCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public OutsideTransOrderCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public OutsideTransOrderCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public OutsideTransOrderCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdIsNull() {
        ew.isNull("trans_order_id");
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_order_id");
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdIsNotNull() {
        ew.isNotNull("trans_order_id");
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_order_id");
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdEq(Object value) {
        ew.eq("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdNe(Object value) {
        ew.ne("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdGt(Object value) {
        ew.gt("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdGe(Object value) {
        ew.ge("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdLt(Object value) {
        ew.lt("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdLe(Object value) {
        ew.le("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdIn(Object... value) {
        ew.in("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdNotIn(Object... value) {
        ew.notIn("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdBetween(Object value, Object value1) {
        ew.between("trans_order_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_order_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("trans_order_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_order_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdLike(String value) {
        ew.like("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andTransOrderIdNotLike(String value) {
        ew.notLike("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition orTransOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_order_id", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public OutsideTransOrderCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public OutsideTransOrderCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public OutsideTransOrderCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public OutsideTransOrderCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeIsNull() {
        ew.isNull("pay_mode");
        return this;
    }

    public OutsideTransOrderCondition orPayModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pay_mode");
        return this;
    }

    public OutsideTransOrderCondition andPayModeIsNotNull() {
        ew.isNotNull("pay_mode");
        return this;
    }

    public OutsideTransOrderCondition orPayModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pay_mode");
        return this;
    }

    public OutsideTransOrderCondition andPayModeEq(Object value) {
        ew.eq("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeNe(Object value) {
        ew.ne("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeGt(Object value) {
        ew.gt("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeGe(Object value) {
        ew.ge("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeLt(Object value) {
        ew.lt("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeLe(Object value) {
        ew.le("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeIn(Object... value) {
        ew.in("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeNotIn(Object... value) {
        ew.notIn("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeBetween(Object value, Object value1) {
        ew.between("pay_mode", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orPayModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pay_mode", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andPayModeNotBetween(Object value, Object value1) {
        ew.notBetween("pay_mode", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orPayModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pay_mode", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andPayModeLike(String value) {
        ew.like("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andPayModeNotLike(String value) {
        ew.notLike("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition orPayModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pay_mode", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountIsNull() {
        ew.isNull("trans_amount");
        return this;
    }

    public OutsideTransOrderCondition orTransAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_amount");
        return this;
    }

    public OutsideTransOrderCondition andTransAmountIsNotNull() {
        ew.isNotNull("trans_amount");
        return this;
    }

    public OutsideTransOrderCondition orTransAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_amount");
        return this;
    }

    public OutsideTransOrderCondition andTransAmountEq(Object value) {
        ew.eq("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountNe(Object value) {
        ew.ne("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountGt(Object value) {
        ew.gt("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountGe(Object value) {
        ew.ge("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountLt(Object value) {
        ew.lt("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountLe(Object value) {
        ew.le("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountIn(Object... value) {
        ew.in("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountNotIn(Object... value) {
        ew.notIn("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountBetween(Object value, Object value1) {
        ew.between("trans_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountNotBetween(Object value, Object value1) {
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountLike(String value) {
        ew.like("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andTransAmountNotLike(String value) {
        ew.notLike("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orTransAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameIsNull() {
        ew.isNull("seller_name");
        return this;
    }

    public OutsideTransOrderCondition orSellerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("seller_name");
        return this;
    }

    public OutsideTransOrderCondition andSellerNameIsNotNull() {
        ew.isNotNull("seller_name");
        return this;
    }

    public OutsideTransOrderCondition orSellerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("seller_name");
        return this;
    }

    public OutsideTransOrderCondition andSellerNameEq(Object value) {
        ew.eq("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameNe(Object value) {
        ew.ne("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameGt(Object value) {
        ew.gt("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameGe(Object value) {
        ew.ge("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameLt(Object value) {
        ew.lt("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameLe(Object value) {
        ew.le("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameIn(Object... value) {
        ew.in("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameNotIn(Object... value) {
        ew.notIn("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameBetween(Object value, Object value1) {
        ew.between("seller_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("seller_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameNotBetween(Object value, Object value1) {
        ew.notBetween("seller_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("seller_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameLike(String value) {
        ew.like("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andSellerNameNotLike(String value) {
        ew.notLike("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition orSellerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("seller_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameIsNull() {
        ew.isNull("buyer_name");
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("buyer_name");
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameIsNotNull() {
        ew.isNotNull("buyer_name");
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("buyer_name");
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameEq(Object value) {
        ew.eq("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameNe(Object value) {
        ew.ne("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameGt(Object value) {
        ew.gt("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameGe(Object value) {
        ew.ge("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameLt(Object value) {
        ew.lt("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameLe(Object value) {
        ew.le("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameIn(Object... value) {
        ew.in("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameNotIn(Object... value) {
        ew.notIn("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameBetween(Object value, Object value1) {
        ew.between("buyer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("buyer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameNotBetween(Object value, Object value1) {
        ew.notBetween("buyer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("buyer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameLike(String value) {
        ew.like("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerNameNotLike(String value) {
        ew.notLike("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("buyer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoIsNull() {
        ew.isNull("goods_info");
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("goods_info");
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoIsNotNull() {
        ew.isNotNull("goods_info");
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("goods_info");
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoEq(Object value) {
        ew.eq("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoNe(Object value) {
        ew.ne("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoGt(Object value) {
        ew.gt("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoGe(Object value) {
        ew.ge("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoLt(Object value) {
        ew.lt("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoLe(Object value) {
        ew.le("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoIn(Object... value) {
        ew.in("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoNotIn(Object... value) {
        ew.notIn("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoBetween(Object value, Object value1) {
        ew.between("goods_info", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("goods_info", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoNotBetween(Object value, Object value1) {
        ew.notBetween("goods_info", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("goods_info", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoLike(String value) {
        ew.like("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andGoodsInfoNotLike(String value) {
        ew.notLike("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition orGoodsInfoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("goods_info", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusIsNull() {
        ew.isNull("upload_status");
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("upload_status");
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusIsNotNull() {
        ew.isNotNull("upload_status");
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("upload_status");
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusEq(Object value) {
        ew.eq("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusNe(Object value) {
        ew.ne("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusGt(Object value) {
        ew.gt("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusGe(Object value) {
        ew.ge("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusLt(Object value) {
        ew.lt("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusLe(Object value) {
        ew.le("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusIn(Object... value) {
        ew.in("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusNotIn(Object... value) {
        ew.notIn("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusBetween(Object value, Object value1) {
        ew.between("upload_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("upload_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusNotBetween(Object value, Object value1) {
        ew.notBetween("upload_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("upload_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusLike(String value) {
        ew.like("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadStatusNotLike(String value) {
        ew.notLike("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("upload_status", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescIsNull() {
        ew.isNull("upload_desc");
        return this;
    }

    public OutsideTransOrderCondition orUploadDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("upload_desc");
        return this;
    }

    public OutsideTransOrderCondition andUploadDescIsNotNull() {
        ew.isNotNull("upload_desc");
        return this;
    }

    public OutsideTransOrderCondition orUploadDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("upload_desc");
        return this;
    }

    public OutsideTransOrderCondition andUploadDescEq(Object value) {
        ew.eq("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescNe(Object value) {
        ew.ne("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescGt(Object value) {
        ew.gt("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescGe(Object value) {
        ew.ge("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescLt(Object value) {
        ew.lt("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescLe(Object value) {
        ew.le("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescIn(Object... value) {
        ew.in("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescNotIn(Object... value) {
        ew.notIn("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescBetween(Object value, Object value1) {
        ew.between("upload_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("upload_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescNotBetween(Object value, Object value1) {
        ew.notBetween("upload_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("upload_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescLike(String value) {
        ew.like("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andUploadDescNotLike(String value) {
        ew.notLike("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orUploadDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("upload_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusIsNull() {
        ew.isNull("split_status");
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_status");
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusIsNotNull() {
        ew.isNotNull("split_status");
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_status");
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusEq(Object value) {
        ew.eq("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusNe(Object value) {
        ew.ne("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusGt(Object value) {
        ew.gt("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusGe(Object value) {
        ew.ge("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusLt(Object value) {
        ew.lt("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusLe(Object value) {
        ew.le("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusIn(Object... value) {
        ew.in("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusNotIn(Object... value) {
        ew.notIn("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusBetween(Object value, Object value1) {
        ew.between("split_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusNotBetween(Object value, Object value1) {
        ew.notBetween("split_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_status", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusLike(String value) {
        ew.like("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andSplitStatusNotLike(String value) {
        ew.notLike("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition orSplitStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_status", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumIsNull() {
        ew.isNull("linked_split_num");
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("linked_split_num");
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumIsNotNull() {
        ew.isNotNull("linked_split_num");
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("linked_split_num");
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumEq(Object value) {
        ew.eq("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumNe(Object value) {
        ew.ne("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumGt(Object value) {
        ew.gt("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumGe(Object value) {
        ew.ge("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumLt(Object value) {
        ew.lt("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumLe(Object value) {
        ew.le("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumIn(Object... value) {
        ew.in("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumNotIn(Object... value) {
        ew.notIn("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumBetween(Object value, Object value1) {
        ew.between("linked_split_num", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("linked_split_num", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumNotBetween(Object value, Object value1) {
        ew.notBetween("linked_split_num", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("linked_split_num", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumLike(String value) {
        ew.like("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andLinkedSplitNumNotLike(String value) {
        ew.notLike("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition orLinkedSplitNumNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("linked_split_num", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameIsNull() {
        ew.isNull("mer_name");
        return this;
    }

    public OutsideTransOrderCondition orMerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_name");
        return this;
    }

    public OutsideTransOrderCondition andMerNameIsNotNull() {
        ew.isNotNull("mer_name");
        return this;
    }

    public OutsideTransOrderCondition orMerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_name");
        return this;
    }

    public OutsideTransOrderCondition andMerNameEq(Object value) {
        ew.eq("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameNe(Object value) {
        ew.ne("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameGt(Object value) {
        ew.gt("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameGe(Object value) {
        ew.ge("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameLt(Object value) {
        ew.lt("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameLe(Object value) {
        ew.le("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameIn(Object... value) {
        ew.in("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameNotIn(Object... value) {
        ew.notIn("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameBetween(Object value, Object value1) {
        ew.between("mer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orMerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andMerNameNotBetween(Object value, Object value1) {
        ew.notBetween("mer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orMerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_name", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andMerNameLike(String value) {
        ew.like("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerNameNotLike(String value) {
        ew.notLike("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition orMerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_name", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneIsNull() {
        ew.isNull("mer_phone");
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_phone");
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneIsNotNull() {
        ew.isNotNull("mer_phone");
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_phone");
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneEq(Object value) {
        ew.eq("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneNe(Object value) {
        ew.ne("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneGt(Object value) {
        ew.gt("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneGe(Object value) {
        ew.ge("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneLt(Object value) {
        ew.lt("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneLe(Object value) {
        ew.le("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneIn(Object... value) {
        ew.in("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneNotIn(Object... value) {
        ew.notIn("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneBetween(Object value, Object value1) {
        ew.between("mer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneNotBetween(Object value, Object value1) {
        ew.notBetween("mer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneLike(String value) {
        ew.like("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andMerPhoneNotLike(String value) {
        ew.notLike("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orMerPhoneNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelIsNull() {
        ew.isNull("txn_channel");
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("txn_channel");
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelIsNotNull() {
        ew.isNotNull("txn_channel");
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("txn_channel");
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelEq(Object value) {
        ew.eq("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelNe(Object value) {
        ew.ne("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelGt(Object value) {
        ew.gt("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelGe(Object value) {
        ew.ge("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelLt(Object value) {
        ew.lt("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelLe(Object value) {
        ew.le("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelIn(Object... value) {
        ew.in("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelNotIn(Object... value) {
        ew.notIn("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelBetween(Object value, Object value1) {
        ew.between("txn_channel", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("txn_channel", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelNotBetween(Object value, Object value1) {
        ew.notBetween("txn_channel", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("txn_channel", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelLike(String value) {
        ew.like("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelNotLike(String value) {
        ew.notLike("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("txn_channel", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoIsNull() {
        ew.isNull("txn_channel_trade_no");
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("txn_channel_trade_no");
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoIsNotNull() {
        ew.isNotNull("txn_channel_trade_no");
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("txn_channel_trade_no");
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoEq(Object value) {
        ew.eq("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoNe(Object value) {
        ew.ne("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoGt(Object value) {
        ew.gt("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoGe(Object value) {
        ew.ge("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoLt(Object value) {
        ew.lt("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoLe(Object value) {
        ew.le("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoIn(Object... value) {
        ew.in("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoNotIn(Object... value) {
        ew.notIn("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoBetween(Object value, Object value1) {
        ew.between("txn_channel_trade_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("txn_channel_trade_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoNotBetween(Object value, Object value1) {
        ew.notBetween("txn_channel_trade_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("txn_channel_trade_no", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoLike(String value) {
        ew.like("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andTxnChannelTradeNoNotLike(String value) {
        ew.notLike("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition orTxnChannelTradeNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("txn_channel_trade_no", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountIsNull() {
        ew.isNull("discount_amount");
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("discount_amount");
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountIsNotNull() {
        ew.isNotNull("discount_amount");
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("discount_amount");
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountEq(Object value) {
        ew.eq("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountNe(Object value) {
        ew.ne("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountGt(Object value) {
        ew.gt("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountGe(Object value) {
        ew.ge("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountLt(Object value) {
        ew.lt("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountLe(Object value) {
        ew.le("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountIn(Object... value) {
        ew.in("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountNotIn(Object... value) {
        ew.notIn("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountBetween(Object value, Object value1) {
        ew.between("discount_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("discount_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountNotBetween(Object value, Object value1) {
        ew.notBetween("discount_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("discount_amount", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountLike(String value) {
        ew.like("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andDiscountAmountNotLike(String value) {
        ew.notLike("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition orDiscountAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("discount_amount", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdIsNull() {
        ew.isNull("buyer_id");
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("buyer_id");
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdIsNotNull() {
        ew.isNotNull("buyer_id");
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("buyer_id");
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdEq(Object value) {
        ew.eq("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdNe(Object value) {
        ew.ne("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdGt(Object value) {
        ew.gt("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdGe(Object value) {
        ew.ge("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdLt(Object value) {
        ew.lt("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdLe(Object value) {
        ew.le("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdIn(Object... value) {
        ew.in("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdNotIn(Object... value) {
        ew.notIn("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdBetween(Object value, Object value1) {
        ew.between("buyer_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("buyer_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdNotBetween(Object value, Object value1) {
        ew.notBetween("buyer_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("buyer_id", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdLike(String value) {
        ew.like("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerIdNotLike(String value) {
        ew.notLike("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("buyer_id", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneIsNull() {
        ew.isNull("buyer_phone");
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("buyer_phone");
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneIsNotNull() {
        ew.isNotNull("buyer_phone");
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("buyer_phone");
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneEq(Object value) {
        ew.eq("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneNe(Object value) {
        ew.ne("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneGt(Object value) {
        ew.gt("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneGe(Object value) {
        ew.ge("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneLt(Object value) {
        ew.lt("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneLe(Object value) {
        ew.le("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneIn(Object... value) {
        ew.in("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneNotIn(Object... value) {
        ew.notIn("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneBetween(Object value, Object value1) {
        ew.between("buyer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("buyer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneNotBetween(Object value, Object value1) {
        ew.notBetween("buyer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("buyer_phone", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneLike(String value) {
        ew.like("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andBuyerPhoneNotLike(String value) {
        ew.notLike("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition orBuyerPhoneNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("buyer_phone", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsIsNull() {
        ew.isNull("logistics");
        return this;
    }

    public OutsideTransOrderCondition orLogisticsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("logistics");
        return this;
    }

    public OutsideTransOrderCondition andLogisticsIsNotNull() {
        ew.isNotNull("logistics");
        return this;
    }

    public OutsideTransOrderCondition orLogisticsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("logistics");
        return this;
    }

    public OutsideTransOrderCondition andLogisticsEq(Object value) {
        ew.eq("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsNe(Object value) {
        ew.ne("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsGt(Object value) {
        ew.gt("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsGe(Object value) {
        ew.ge("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsLt(Object value) {
        ew.lt("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsLe(Object value) {
        ew.le("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsIn(Object... value) {
        ew.in("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsNotIn(Object... value) {
        ew.notIn("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsBetween(Object value, Object value1) {
        ew.between("logistics", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("logistics", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsNotBetween(Object value, Object value1) {
        ew.notBetween("logistics", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("logistics", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsLike(String value) {
        ew.like("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andLogisticsNotLike(String value) {
        ew.notLike("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition orLogisticsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("logistics", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagIsNull() {
        ew.isNull("file_convert_flag");
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_convert_flag");
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagIsNotNull() {
        ew.isNotNull("file_convert_flag");
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_convert_flag");
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagEq(Object value) {
        ew.eq("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagNe(Object value) {
        ew.ne("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagGt(Object value) {
        ew.gt("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagGe(Object value) {
        ew.ge("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagLt(Object value) {
        ew.lt("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagLe(Object value) {
        ew.le("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagIn(Object... value) {
        ew.in("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagNotIn(Object... value) {
        ew.notIn("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagBetween(Object value, Object value1) {
        ew.between("file_convert_flag", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_convert_flag", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagNotBetween(Object value, Object value1) {
        ew.notBetween("file_convert_flag", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_convert_flag", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagLike(String value) {
        ew.like("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertFlagNotLike(String value) {
        ew.notLike("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_convert_flag", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescIsNull() {
        ew.isNull("file_convert_desc");
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_convert_desc");
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescIsNotNull() {
        ew.isNotNull("file_convert_desc");
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_convert_desc");
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescEq(Object value) {
        ew.eq("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescNe(Object value) {
        ew.ne("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescGt(Object value) {
        ew.gt("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescGe(Object value) {
        ew.ge("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescLt(Object value) {
        ew.lt("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescLe(Object value) {
        ew.le("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescIn(Object... value) {
        ew.in("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescNotIn(Object... value) {
        ew.notIn("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescBetween(Object value, Object value1) {
        ew.between("file_convert_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_convert_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescNotBetween(Object value, Object value1) {
        ew.notBetween("file_convert_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_convert_desc", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescLike(String value) {
        ew.like("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andFileConvertDescNotLike(String value) {
        ew.notLike("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition orFileConvertDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_convert_desc", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlIsNull() {
        ew.isNull("callback_url");
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_url");
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlIsNotNull() {
        ew.isNotNull("callback_url");
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_url");
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlEq(Object value) {
        ew.eq("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlNe(Object value) {
        ew.ne("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlGt(Object value) {
        ew.gt("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlGe(Object value) {
        ew.ge("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlLt(Object value) {
        ew.lt("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlLe(Object value) {
        ew.le("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlIn(Object... value) {
        ew.in("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlNotIn(Object... value) {
        ew.notIn("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlBetween(Object value, Object value1) {
        ew.between("callback_url", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_url", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlLike(String value) {
        ew.like("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andCallbackUrlNotLike(String value) {
        ew.notLike("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition orCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_url", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public OutsideTransOrderCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public OutsideTransOrderCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public OutsideTransOrderCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public OutsideTransOrderCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public OutsideTransOrderCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public OutsideTransOrderCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public OutsideTransOrderCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public OutsideTransOrderCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }
}