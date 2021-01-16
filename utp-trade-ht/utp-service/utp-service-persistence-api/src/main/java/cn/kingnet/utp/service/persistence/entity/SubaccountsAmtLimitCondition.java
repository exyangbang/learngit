package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class SubaccountsAmtLimitCondition {
    private PlusEntityWrapper<SubaccountsAmtLimit> ew;

    public SubaccountsAmtLimitCondition() {
        this.ew = new PlusEntityWrapper(SubaccountsAmtLimit.class);
    }

    public static SubaccountsAmtLimitCondition builder() {
        return new SubaccountsAmtLimitCondition();
    }

    public PlusEntityWrapper<SubaccountsAmtLimit> build() {
        return this.ew;
    }

    public SubaccountsAmtLimitCondition or() {
        this.ew.orNew();
        return this;
    }

    public SubaccountsAmtLimitCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(SubaccountsAmtLimit.class);
    }

    public SubaccountsAmtLimitCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public SubaccountsAmtLimitCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public SubaccountsAmtLimitCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public SubaccountsAmtLimitCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> SubaccountsAmtLimitCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> SubaccountsAmtLimitCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> SubaccountsAmtLimitCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public SubaccountsAmtLimitCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public SubaccountsAmtLimitCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public SubaccountsAmtLimitCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public SubaccountsAmtLimitCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public SubaccountsAmtLimitCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public SubaccountsAmtLimitCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public SubaccountsAmtLimitCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdIsNull() {
        ew.isNull("industry_id");
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_id");
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdIsNotNull() {
        ew.isNotNull("industry_id");
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_id");
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdEq(Object value) {
        ew.eq("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdNe(Object value) {
        ew.ne("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdGt(Object value) {
        ew.gt("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdGe(Object value) {
        ew.ge("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdLt(Object value) {
        ew.lt("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdLe(Object value) {
        ew.le("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdIn(Object... value) {
        ew.in("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdNotIn(Object... value) {
        ew.notIn("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdBetween(Object value, Object value1) {
        ew.between("industry_id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdNotBetween(Object value, Object value1) {
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdLike(String value) {
        ew.like("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andIndustryIdNotLike(String value) {
        ew.notLike("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orIndustryIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_id", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameIsNull() {
        ew.isNull("sub_obj_name");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sub_obj_name");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameIsNotNull() {
        ew.isNotNull("sub_obj_name");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sub_obj_name");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameEq(Object value) {
        ew.eq("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameNe(Object value) {
        ew.ne("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameGt(Object value) {
        ew.gt("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameGe(Object value) {
        ew.ge("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameLt(Object value) {
        ew.lt("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameLe(Object value) {
        ew.le("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameIn(Object... value) {
        ew.in("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameNotIn(Object... value) {
        ew.notIn("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameBetween(Object value, Object value1) {
        ew.between("sub_obj_name", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sub_obj_name", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameNotBetween(Object value, Object value1) {
        ew.notBetween("sub_obj_name", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sub_obj_name", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameLike(String value) {
        ew.like("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubObjNameNotLike(String value) {
        ew.notLike("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubObjNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sub_obj_name", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountIsNull() {
        ew.isNull("sub_account");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sub_account");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountIsNotNull() {
        ew.isNotNull("sub_account");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sub_account");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountEq(Object value) {
        ew.eq("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountNe(Object value) {
        ew.ne("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountGt(Object value) {
        ew.gt("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountGe(Object value) {
        ew.ge("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountLt(Object value) {
        ew.lt("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountLe(Object value) {
        ew.le("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountIn(Object... value) {
        ew.in("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountNotIn(Object... value) {
        ew.notIn("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountBetween(Object value, Object value1) {
        ew.between("sub_account", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sub_account", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountNotBetween(Object value, Object value1) {
        ew.notBetween("sub_account", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sub_account", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountLike(String value) {
        ew.like("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubAccountNotLike(String value) {
        ew.notLike("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sub_account", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtIsNull() {
        ew.isNull("subaccounts_individual_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("subaccounts_individual_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtIsNotNull() {
        ew.isNotNull("subaccounts_individual_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("subaccounts_individual_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtEq(Object value) {
        ew.eq("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtNe(Object value) {
        ew.ne("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtGt(Object value) {
        ew.gt("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtGe(Object value) {
        ew.ge("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtLt(Object value) {
        ew.lt("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtLe(Object value) {
        ew.le("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtIn(Object... value) {
        ew.in("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtNotIn(Object... value) {
        ew.notIn("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtBetween(Object value, Object value1) {
        ew.between("subaccounts_individual_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("subaccounts_individual_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtNotBetween(Object value, Object value1) {
        ew.notBetween("subaccounts_individual_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("subaccounts_individual_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtLike(String value) {
        ew.like("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsIndividualAmtNotLike(String value) {
        ew.notLike("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsIndividualAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("subaccounts_individual_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtIsNull() {
        ew.isNull("subaccounts_date_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("subaccounts_date_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtIsNotNull() {
        ew.isNotNull("subaccounts_date_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("subaccounts_date_amt");
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtEq(Object value) {
        ew.eq("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtNe(Object value) {
        ew.ne("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtGt(Object value) {
        ew.gt("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtGe(Object value) {
        ew.ge("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtLt(Object value) {
        ew.lt("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtLe(Object value) {
        ew.le("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtIn(Object... value) {
        ew.in("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtNotIn(Object... value) {
        ew.notIn("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtBetween(Object value, Object value1) {
        ew.between("subaccounts_date_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("subaccounts_date_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtNotBetween(Object value, Object value1) {
        ew.notBetween("subaccounts_date_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("subaccounts_date_amt", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtLike(String value) {
        ew.like("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andSubaccountsDateAmtNotLike(String value) {
        ew.notLike("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orSubaccountsDateAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("subaccounts_date_amt", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public SubaccountsAmtLimitCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }
}