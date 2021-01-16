package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ClearBankCodeCondition {
    private PlusEntityWrapper<ClearBankCode> ew;

    public ClearBankCodeCondition() {
        this.ew = new PlusEntityWrapper(ClearBankCode.class);
    }

    public static ClearBankCodeCondition builder() {
        return new ClearBankCodeCondition();
    }

    public PlusEntityWrapper<ClearBankCode> build() {
        return this.ew;
    }

    public ClearBankCodeCondition or() {
        this.ew.orNew();
        return this;
    }

    public ClearBankCodeCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ClearBankCode.class);
    }

    public ClearBankCodeCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ClearBankCodeCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ClearBankCodeCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ClearBankCodeCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ClearBankCodeCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ClearBankCodeCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ClearBankCodeCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ClearBankCodeCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ClearBankCodeCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ClearBankCodeCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ClearBankCodeCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ClearBankCodeCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ClearBankCodeCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ClearBankCodeCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ClearBankCodeCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ClearBankCodeCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ClearBankCodeCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ClearBankCodeCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ClearBankCodeCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ClearBankCodeCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ClearBankCodeCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ClearBankCodeCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ClearBankCodeCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ClearBankCodeCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ClearBankCodeCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ClearBankCodeCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ClearBankCodeCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ClearBankCodeCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ClearBankCodeCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ClearBankCodeCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ClearBankCodeCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ClearBankCodeCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ClearBankCodeCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ClearBankCodeCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeIsNull() {
        ew.isNull("op_bank_code");
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("op_bank_code");
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeIsNotNull() {
        ew.isNotNull("op_bank_code");
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("op_bank_code");
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeEq(Object value) {
        ew.eq("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeNe(Object value) {
        ew.ne("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeGt(Object value) {
        ew.gt("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeGe(Object value) {
        ew.ge("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeLt(Object value) {
        ew.lt("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeLe(Object value) {
        ew.le("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeIn(Object... value) {
        ew.in("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeNotIn(Object... value) {
        ew.notIn("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeBetween(Object value, Object value1) {
        ew.between("op_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("op_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("op_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("op_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeLike(String value) {
        ew.like("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankCodeNotLike(String value) {
        ew.notLike("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("op_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameIsNull() {
        ew.isNull("op_bank_name");
        return this;
    }

    public ClearBankCodeCondition orOpBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("op_bank_name");
        return this;
    }

    public ClearBankCodeCondition andOpBankNameIsNotNull() {
        ew.isNotNull("op_bank_name");
        return this;
    }

    public ClearBankCodeCondition orOpBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("op_bank_name");
        return this;
    }

    public ClearBankCodeCondition andOpBankNameEq(Object value) {
        ew.eq("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameNe(Object value) {
        ew.ne("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameGt(Object value) {
        ew.gt("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameGe(Object value) {
        ew.ge("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameLt(Object value) {
        ew.lt("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameLe(Object value) {
        ew.le("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameIn(Object... value) {
        ew.in("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameNotIn(Object... value) {
        ew.notIn("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameBetween(Object value, Object value1) {
        ew.between("op_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("op_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("op_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("op_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameLike(String value) {
        ew.like("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andOpBankNameNotLike(String value) {
        ew.notLike("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orOpBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("op_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeIsNull() {
        ew.isNull("cl_bank_code");
        return this;
    }

    public ClearBankCodeCondition orClBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cl_bank_code");
        return this;
    }

    public ClearBankCodeCondition andClBankCodeIsNotNull() {
        ew.isNotNull("cl_bank_code");
        return this;
    }

    public ClearBankCodeCondition orClBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cl_bank_code");
        return this;
    }

    public ClearBankCodeCondition andClBankCodeEq(Object value) {
        ew.eq("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeNe(Object value) {
        ew.ne("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeGt(Object value) {
        ew.gt("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeGe(Object value) {
        ew.ge("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeLt(Object value) {
        ew.lt("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeLe(Object value) {
        ew.le("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeIn(Object... value) {
        ew.in("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeNotIn(Object... value) {
        ew.notIn("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeBetween(Object value, Object value1) {
        ew.between("cl_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cl_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("cl_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cl_bank_code", value, value1);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeLike(String value) {
        ew.like("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankCodeNotLike(String value) {
        ew.notLike("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition orClBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cl_bank_code", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameIsNull() {
        ew.isNull("cl_bank_name");
        return this;
    }

    public ClearBankCodeCondition orClBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cl_bank_name");
        return this;
    }

    public ClearBankCodeCondition andClBankNameIsNotNull() {
        ew.isNotNull("cl_bank_name");
        return this;
    }

    public ClearBankCodeCondition orClBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cl_bank_name");
        return this;
    }

    public ClearBankCodeCondition andClBankNameEq(Object value) {
        ew.eq("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameNe(Object value) {
        ew.ne("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameGt(Object value) {
        ew.gt("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameGe(Object value) {
        ew.ge("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameLt(Object value) {
        ew.lt("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameLe(Object value) {
        ew.le("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameIn(Object... value) {
        ew.in("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameNotIn(Object... value) {
        ew.notIn("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameBetween(Object value, Object value1) {
        ew.between("cl_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition orClBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cl_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition andClBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("cl_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition orClBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cl_bank_name", value, value1);
        return this;
    }

    public ClearBankCodeCondition andClBankNameLike(String value) {
        ew.like("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition andClBankNameNotLike(String value) {
        ew.notLike("cl_bank_name", value);
        return this;
    }

    public ClearBankCodeCondition orClBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cl_bank_name", value);
        return this;
    }
}