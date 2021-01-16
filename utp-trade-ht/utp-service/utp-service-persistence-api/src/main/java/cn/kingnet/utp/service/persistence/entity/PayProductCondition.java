package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class PayProductCondition {
    private PlusEntityWrapper<PayProduct> ew;

    public PayProductCondition() {
        this.ew = new PlusEntityWrapper(PayProduct.class);
    }

    public static PayProductCondition builder() {
        return new PayProductCondition();
    }

    public PlusEntityWrapper<PayProduct> build() {
        return this.ew;
    }

    public PayProductCondition or() {
        this.ew.orNew();
        return this;
    }

    public PayProductCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(PayProduct.class);
    }

    public PayProductCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public PayProductCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public PayProductCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public PayProductCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> PayProductCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> PayProductCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> PayProductCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public PayProductCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public PayProductCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public PayProductCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public PayProductCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public PayProductCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public PayProductCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public PayProductCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public PayProductCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public PayProductCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public PayProductCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public PayProductCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public PayProductCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public PayProductCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public PayProductCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public PayProductCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public PayProductCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public PayProductCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public PayProductCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public PayProductCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public PayProductCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public PayProductCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public PayProductCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public PayProductCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public PayProductCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public PayProductCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public PayProductCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public PayProductCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public PayProductCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public PayProductCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public PayProductCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public PayProductCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public PayProductCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public PayProductCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public PayProductCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public PayProductCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public PayProductCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public PayProductCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public PayProductCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public PayProductCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public PayProductCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public PayProductCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public PayProductCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public PayProductCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public PayProductCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public PayProductCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public PayProductCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public PayProductCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public PayProductCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public PayProductCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public PayProductCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public PayProductCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public PayProductCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public PayProductCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public PayProductCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public PayProductCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public PayProductCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public PayProductCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public PayProductCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public PayProductCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public PayProductCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public PayProductCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public PayProductCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public PayProductCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public PayProductCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public PayProductCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public PayProductCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public PayProductCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public PayProductCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public PayProductCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public PayProductCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public PayProductCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public PayProductCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public PayProductCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public PayProductCondition andCodeIsNull() {
        ew.isNull("code");
        return this;
    }

    public PayProductCondition orCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("code");
        return this;
    }

    public PayProductCondition andCodeIsNotNull() {
        ew.isNotNull("code");
        return this;
    }

    public PayProductCondition orCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("code");
        return this;
    }

    public PayProductCondition andCodeEq(Object value) {
        ew.eq("code", value);
        return this;
    }

    public PayProductCondition orCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("code", value);
        return this;
    }

    public PayProductCondition andCodeNe(Object value) {
        ew.ne("code", value);
        return this;
    }

    public PayProductCondition orCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("code", value);
        return this;
    }

    public PayProductCondition andCodeGt(Object value) {
        ew.gt("code", value);
        return this;
    }

    public PayProductCondition orCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("code", value);
        return this;
    }

    public PayProductCondition andCodeGe(Object value) {
        ew.ge("code", value);
        return this;
    }

    public PayProductCondition orCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("code", value);
        return this;
    }

    public PayProductCondition andCodeLt(Object value) {
        ew.lt("code", value);
        return this;
    }

    public PayProductCondition orCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("code", value);
        return this;
    }

    public PayProductCondition andCodeLe(Object value) {
        ew.le("code", value);
        return this;
    }

    public PayProductCondition orCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("code", value);
        return this;
    }

    public PayProductCondition andCodeIn(Object... value) {
        ew.in("code", value);
        return this;
    }

    public PayProductCondition orCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("code", value);
        return this;
    }

    public PayProductCondition andCodeNotIn(Object... value) {
        ew.notIn("code", value);
        return this;
    }

    public PayProductCondition orCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("code", value);
        return this;
    }

    public PayProductCondition andCodeBetween(Object value, Object value1) {
        ew.between("code", value, value1);
        return this;
    }

    public PayProductCondition orCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("code", value, value1);
        return this;
    }

    public PayProductCondition andCodeNotBetween(Object value, Object value1) {
        ew.notBetween("code", value, value1);
        return this;
    }

    public PayProductCondition orCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("code", value, value1);
        return this;
    }

    public PayProductCondition andCodeLike(String value) {
        ew.like("code", value);
        return this;
    }

    public PayProductCondition orCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("code", value);
        return this;
    }

    public PayProductCondition andCodeNotLike(String value) {
        ew.notLike("code", value);
        return this;
    }

    public PayProductCondition orCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("code", value);
        return this;
    }

    public PayProductCondition andNameIsNull() {
        ew.isNull("name");
        return this;
    }

    public PayProductCondition orNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("name");
        return this;
    }

    public PayProductCondition andNameIsNotNull() {
        ew.isNotNull("name");
        return this;
    }

    public PayProductCondition orNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("name");
        return this;
    }

    public PayProductCondition andNameEq(Object value) {
        ew.eq("name", value);
        return this;
    }

    public PayProductCondition orNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("name", value);
        return this;
    }

    public PayProductCondition andNameNe(Object value) {
        ew.ne("name", value);
        return this;
    }

    public PayProductCondition orNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("name", value);
        return this;
    }

    public PayProductCondition andNameGt(Object value) {
        ew.gt("name", value);
        return this;
    }

    public PayProductCondition orNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("name", value);
        return this;
    }

    public PayProductCondition andNameGe(Object value) {
        ew.ge("name", value);
        return this;
    }

    public PayProductCondition orNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("name", value);
        return this;
    }

    public PayProductCondition andNameLt(Object value) {
        ew.lt("name", value);
        return this;
    }

    public PayProductCondition orNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("name", value);
        return this;
    }

    public PayProductCondition andNameLe(Object value) {
        ew.le("name", value);
        return this;
    }

    public PayProductCondition orNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("name", value);
        return this;
    }

    public PayProductCondition andNameIn(Object... value) {
        ew.in("name", value);
        return this;
    }

    public PayProductCondition orNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("name", value);
        return this;
    }

    public PayProductCondition andNameNotIn(Object... value) {
        ew.notIn("name", value);
        return this;
    }

    public PayProductCondition orNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("name", value);
        return this;
    }

    public PayProductCondition andNameBetween(Object value, Object value1) {
        ew.between("name", value, value1);
        return this;
    }

    public PayProductCondition orNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("name", value, value1);
        return this;
    }

    public PayProductCondition andNameNotBetween(Object value, Object value1) {
        ew.notBetween("name", value, value1);
        return this;
    }

    public PayProductCondition orNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("name", value, value1);
        return this;
    }

    public PayProductCondition andNameLike(String value) {
        ew.like("name", value);
        return this;
    }

    public PayProductCondition orNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("name", value);
        return this;
    }

    public PayProductCondition andNameNotLike(String value) {
        ew.notLike("name", value);
        return this;
    }

    public PayProductCondition orNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("name", value);
        return this;
    }

    public PayProductCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public PayProductCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public PayProductCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public PayProductCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public PayProductCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public PayProductCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public PayProductCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public PayProductCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public PayProductCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public PayProductCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public PayProductCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public PayProductCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public PayProductCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public PayProductCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public PayProductCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public PayProductCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public PayProductCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public PayProductCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public PayProductCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public PayProductCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public PayProductCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public PayProductCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public PayProductCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public PayProductCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public PayProductCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public PayProductCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public PayProductCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public PayProductCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public PayProductCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public PayProductCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public PayProductCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public PayProductCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public PayProductCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public PayProductCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public PayProductCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public PayProductCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public PayProductCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public PayProductCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public PayProductCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public PayProductCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public PayProductCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public PayProductCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public PayProductCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public PayProductCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public PayProductCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public PayProductCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public PayProductCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public PayProductCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public PayProductCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public PayProductCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public PayProductCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public PayProductCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public PayProductCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public PayProductCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public PayProductCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public PayProductCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }
}