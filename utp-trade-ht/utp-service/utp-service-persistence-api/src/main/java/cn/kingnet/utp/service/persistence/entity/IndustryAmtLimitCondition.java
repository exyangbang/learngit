package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class IndustryAmtLimitCondition {
    private PlusEntityWrapper<IndustryAmtLimit> ew;

    public IndustryAmtLimitCondition() {
        this.ew = new PlusEntityWrapper(IndustryAmtLimit.class);
    }

    public static IndustryAmtLimitCondition builder() {
        return new IndustryAmtLimitCondition();
    }

    public PlusEntityWrapper<IndustryAmtLimit> build() {
        return this.ew;
    }

    public IndustryAmtLimitCondition or() {
        this.ew.orNew();
        return this;
    }

    public IndustryAmtLimitCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(IndustryAmtLimit.class);
    }

    public IndustryAmtLimitCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public IndustryAmtLimitCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public IndustryAmtLimitCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public IndustryAmtLimitCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> IndustryAmtLimitCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> IndustryAmtLimitCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> IndustryAmtLimitCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public IndustryAmtLimitCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public IndustryAmtLimitCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public IndustryAmtLimitCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public IndustryAmtLimitCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public IndustryAmtLimitCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public IndustryAmtLimitCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public IndustryAmtLimitCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public IndustryAmtLimitCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdIsNull() {
        ew.isNull("industry_id");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_id");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdIsNotNull() {
        ew.isNotNull("industry_id");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_id");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdEq(Object value) {
        ew.eq("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdNe(Object value) {
        ew.ne("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdGt(Object value) {
        ew.gt("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdGe(Object value) {
        ew.ge("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdLt(Object value) {
        ew.lt("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdLe(Object value) {
        ew.le("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdIn(Object... value) {
        ew.in("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdNotIn(Object... value) {
        ew.notIn("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdBetween(Object value, Object value1) {
        ew.between("industry_id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdNotBetween(Object value, Object value1) {
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdLike(String value) {
        ew.like("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryIdNotLike(String value) {
        ew.notLike("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_id", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameIsNull() {
        ew.isNull("industry_name");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_name");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameIsNotNull() {
        ew.isNotNull("industry_name");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_name");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameEq(Object value) {
        ew.eq("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameNe(Object value) {
        ew.ne("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameGt(Object value) {
        ew.gt("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameGe(Object value) {
        ew.ge("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameLt(Object value) {
        ew.lt("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameLe(Object value) {
        ew.le("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameIn(Object... value) {
        ew.in("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameNotIn(Object... value) {
        ew.notIn("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameBetween(Object value, Object value1) {
        ew.between("industry_name", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_name", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameNotBetween(Object value, Object value1) {
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameLike(String value) {
        ew.like("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryNameNotLike(String value) {
        ew.notLike("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_name", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtIsNull() {
        ew.isNull("public_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("public_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtIsNotNull() {
        ew.isNotNull("public_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("public_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtEq(Object value) {
        ew.eq("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtNe(Object value) {
        ew.ne("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtGt(Object value) {
        ew.gt("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtGe(Object value) {
        ew.ge("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtLt(Object value) {
        ew.lt("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtLe(Object value) {
        ew.le("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtIn(Object... value) {
        ew.in("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtNotIn(Object... value) {
        ew.notIn("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtBetween(Object value, Object value1) {
        ew.between("public_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("public_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtNotBetween(Object value, Object value1) {
        ew.notBetween("public_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("public_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtLike(String value) {
        ew.like("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicIndividualAmtNotLike(String value) {
        ew.notLike("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicIndividualAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("public_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtIsNull() {
        ew.isNull("private_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("private_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtIsNotNull() {
        ew.isNotNull("private_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("private_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtEq(Object value) {
        ew.eq("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtNe(Object value) {
        ew.ne("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtGt(Object value) {
        ew.gt("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtGe(Object value) {
        ew.ge("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtLt(Object value) {
        ew.lt("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtLe(Object value) {
        ew.le("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtIn(Object... value) {
        ew.in("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtNotIn(Object... value) {
        ew.notIn("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtBetween(Object value, Object value1) {
        ew.between("private_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("private_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtNotBetween(Object value, Object value1) {
        ew.notBetween("private_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("private_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtLike(String value) {
        ew.like("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateIndividualAmtNotLike(String value) {
        ew.notLike("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateIndividualAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("private_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtIsNull() {
        ew.isNull("unit_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("unit_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtIsNotNull() {
        ew.isNotNull("unit_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("unit_individual_amt");
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtEq(Object value) {
        ew.eq("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtNe(Object value) {
        ew.ne("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtGt(Object value) {
        ew.gt("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtGe(Object value) {
        ew.ge("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtLt(Object value) {
        ew.lt("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtLe(Object value) {
        ew.le("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtIn(Object... value) {
        ew.in("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtNotIn(Object... value) {
        ew.notIn("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtBetween(Object value, Object value1) {
        ew.between("unit_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("unit_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtNotBetween(Object value, Object value1) {
        ew.notBetween("unit_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("unit_individual_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtLike(String value) {
        ew.like("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andUnitIndividualAmtNotLike(String value) {
        ew.notLike("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orUnitIndividualAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("unit_individual_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtIsNull() {
        ew.isNull("industry_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtIsNotNull() {
        ew.isNotNull("industry_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtEq(Object value) {
        ew.eq("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtNe(Object value) {
        ew.ne("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtGt(Object value) {
        ew.gt("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtGe(Object value) {
        ew.ge("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtLt(Object value) {
        ew.lt("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtLe(Object value) {
        ew.le("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtIn(Object... value) {
        ew.in("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtNotIn(Object... value) {
        ew.notIn("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtBetween(Object value, Object value1) {
        ew.between("industry_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtNotBetween(Object value, Object value1) {
        ew.notBetween("industry_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtLike(String value) {
        ew.like("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryDateAmtNotLike(String value) {
        ew.notLike("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryDateAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtIsNull() {
        ew.isNull("subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtIsNotNull() {
        ew.isNotNull("subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtEq(Object value) {
        ew.eq("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtNe(Object value) {
        ew.ne("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtGt(Object value) {
        ew.gt("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtGe(Object value) {
        ew.ge("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtLt(Object value) {
        ew.lt("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtLe(Object value) {
        ew.le("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtIn(Object... value) {
        ew.in("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtNotIn(Object... value) {
        ew.notIn("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtBetween(Object value, Object value1) {
        ew.between("subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtNotBetween(Object value, Object value1) {
        ew.notBetween("subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtLike(String value) {
        ew.like("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSubaccountsDateAmtNotLike(String value) {
        ew.notLike("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSubaccountsDateAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public IndustryAmtLimitCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public IndustryAmtLimitCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public IndustryAmtLimitCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public IndustryAmtLimitCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtIsNull() {
        ew.isNull("same_order_max_spe_amt");
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("same_order_max_spe_amt");
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtIsNotNull() {
        ew.isNotNull("same_order_max_spe_amt");
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("same_order_max_spe_amt");
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtEq(Object value) {
        ew.eq("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtNe(Object value) {
        ew.ne("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtGt(Object value) {
        ew.gt("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtGe(Object value) {
        ew.ge("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtLt(Object value) {
        ew.lt("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtLe(Object value) {
        ew.le("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtIn(Object... value) {
        ew.in("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtNotIn(Object... value) {
        ew.notIn("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtBetween(Object value, Object value1) {
        ew.between("same_order_max_spe_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("same_order_max_spe_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtNotBetween(Object value, Object value1) {
        ew.notBetween("same_order_max_spe_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("same_order_max_spe_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtLike(String value) {
        ew.like("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameOrderMaxSpeAmtNotLike(String value) {
        ew.notLike("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameOrderMaxSpeAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("same_order_max_spe_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtIsNull() {
        ew.isNull("same_cash_max_amt");
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("same_cash_max_amt");
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtIsNotNull() {
        ew.isNotNull("same_cash_max_amt");
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("same_cash_max_amt");
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtEq(Object value) {
        ew.eq("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtNe(Object value) {
        ew.ne("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtGt(Object value) {
        ew.gt("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtGe(Object value) {
        ew.ge("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtLt(Object value) {
        ew.lt("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtLe(Object value) {
        ew.le("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtIn(Object... value) {
        ew.in("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtNotIn(Object... value) {
        ew.notIn("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtBetween(Object value, Object value1) {
        ew.between("same_cash_max_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("same_cash_max_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtNotBetween(Object value, Object value1) {
        ew.notBetween("same_cash_max_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("same_cash_max_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtLike(String value) {
        ew.like("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andSameCashMaxAmtNotLike(String value) {
        ew.notLike("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orSameCashMaxAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("same_cash_max_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtIsNull() {
        ew.isNull("minute_max_cash_tran_amt");
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("minute_max_cash_tran_amt");
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtIsNotNull() {
        ew.isNotNull("minute_max_cash_tran_amt");
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("minute_max_cash_tran_amt");
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtEq(Object value) {
        ew.eq("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtNe(Object value) {
        ew.ne("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtGt(Object value) {
        ew.gt("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtGe(Object value) {
        ew.ge("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtLt(Object value) {
        ew.lt("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtLe(Object value) {
        ew.le("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtIn(Object... value) {
        ew.in("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtNotIn(Object... value) {
        ew.notIn("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtBetween(Object value, Object value1) {
        ew.between("minute_max_cash_tran_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("minute_max_cash_tran_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtNotBetween(Object value, Object value1) {
        ew.notBetween("minute_max_cash_tran_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("minute_max_cash_tran_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtLike(String value) {
        ew.like("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andMinuteMaxCashTranAmtNotLike(String value) {
        ew.notLike("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orMinuteMaxCashTranAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("minute_max_cash_tran_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtIsNull() {
        ew.isNull("public_subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("public_subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtIsNotNull() {
        ew.isNotNull("public_subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("public_subaccounts_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtEq(Object value) {
        ew.eq("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtNe(Object value) {
        ew.ne("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtGt(Object value) {
        ew.gt("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtGe(Object value) {
        ew.ge("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtLt(Object value) {
        ew.lt("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtLe(Object value) {
        ew.le("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtIn(Object... value) {
        ew.in("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtNotIn(Object... value) {
        ew.notIn("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtBetween(Object value, Object value1) {
        ew.between("public_subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("public_subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtNotBetween(Object value, Object value1) {
        ew.notBetween("public_subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("public_subaccounts_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtLike(String value) {
        ew.like("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsDateAmtNotLike(String value) {
        ew.notLike("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsDateAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("public_subaccounts_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtIsNull() {
        ew.isNull("industry_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtIsNotNull() {
        ew.isNotNull("industry_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtEq(Object value) {
        ew.eq("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtNe(Object value) {
        ew.ne("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtGt(Object value) {
        ew.gt("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtGe(Object value) {
        ew.ge("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtLt(Object value) {
        ew.lt("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtLe(Object value) {
        ew.le("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtIn(Object... value) {
        ew.in("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtNotIn(Object... value) {
        ew.notIn("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtBetween(Object value, Object value1) {
        ew.between("industry_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtNotBetween(Object value, Object value1) {
        ew.notBetween("industry_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtLike(String value) {
        ew.like("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andIndustryBalanceDateAmtNotLike(String value) {
        ew.notLike("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orIndustryBalanceDateAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtIsNull() {
        ew.isNull("private_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("private_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtIsNotNull() {
        ew.isNotNull("private_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("private_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtEq(Object value) {
        ew.eq("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtNe(Object value) {
        ew.ne("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtGt(Object value) {
        ew.gt("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtGe(Object value) {
        ew.ge("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtLt(Object value) {
        ew.lt("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtLe(Object value) {
        ew.le("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtIn(Object... value) {
        ew.in("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtNotIn(Object... value) {
        ew.notIn("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtBetween(Object value, Object value1) {
        ew.between("private_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("private_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtNotBetween(Object value, Object value1) {
        ew.notBetween("private_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("private_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtLike(String value) {
        ew.like("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPrivateSubaccountsBalanceDateAmtNotLike(String value) {
        ew.notLike("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPrivateSubaccountsBalanceDateAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("private_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtIsNull() {
        ew.isNull("public_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("public_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtIsNotNull() {
        ew.isNotNull("public_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("public_subaccounts_balance_date_amt");
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtEq(Object value) {
        ew.eq("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtNe(Object value) {
        ew.ne("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtGt(Object value) {
        ew.gt("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtGe(Object value) {
        ew.ge("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtLt(Object value) {
        ew.lt("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtLe(Object value) {
        ew.le("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtIn(Object... value) {
        ew.in("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtNotIn(Object... value) {
        ew.notIn("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtBetween(Object value, Object value1) {
        ew.between("public_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("public_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtNotBetween(Object value, Object value1) {
        ew.notBetween("public_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("public_subaccounts_balance_date_amt", value, value1);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtLike(String value) {
        ew.like("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition andPublicSubaccountsBalanceDateAmtNotLike(String value) {
        ew.notLike("public_subaccounts_balance_date_amt", value);
        return this;
    }

    public IndustryAmtLimitCondition orPublicSubaccountsBalanceDateAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("public_subaccounts_balance_date_amt", value);
        return this;
    }
}