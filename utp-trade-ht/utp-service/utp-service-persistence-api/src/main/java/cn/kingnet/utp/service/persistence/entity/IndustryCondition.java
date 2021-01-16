package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class IndustryCondition {
    private PlusEntityWrapper<Industry> ew;

    public IndustryCondition() {
        this.ew = new PlusEntityWrapper(Industry.class);
    }

    public static IndustryCondition builder() {
        return new IndustryCondition();
    }

    public PlusEntityWrapper<Industry> build() {
        return this.ew;
    }

    public IndustryCondition or() {
        this.ew.orNew();
        return this;
    }

    public IndustryCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(Industry.class);
    }

    public IndustryCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public IndustryCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public IndustryCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public IndustryCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> IndustryCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> IndustryCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> IndustryCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public IndustryCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public IndustryCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public IndustryCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public IndustryCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public IndustryCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public IndustryCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public IndustryCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public IndustryCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public IndustryCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public IndustryCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public IndustryCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public IndustryCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public IndustryCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public IndustryCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public IndustryCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public IndustryCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public IndustryCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public IndustryCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public IndustryCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public IndustryCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public IndustryCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public IndustryCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public IndustryCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public IndustryCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public IndustryCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public IndustryCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustryCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustryCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public IndustryCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public IndustryCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public IndustryCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public IndustryCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public IndustryCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public IndustryCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public IndustryCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public IndustryCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustryCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustryCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustryCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustryCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public IndustryCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public IndustryCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public IndustryCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public IndustryCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustryCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustryCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustryCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustryCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustryCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustryCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public IndustryCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustryCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustryCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public IndustryCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public IndustryCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustryCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustryCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustryCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustryCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustryCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustryCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public IndustryCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public IndustryCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustryCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustryCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustryCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustryCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustryCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustryCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustryCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustryCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustryCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustryCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustryCondition andNameIsNull() {
        ew.isNull("name");
        return this;
    }

    public IndustryCondition orNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("name");
        return this;
    }

    public IndustryCondition andNameIsNotNull() {
        ew.isNotNull("name");
        return this;
    }

    public IndustryCondition orNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("name");
        return this;
    }

    public IndustryCondition andNameEq(Object value) {
        ew.eq("name", value);
        return this;
    }

    public IndustryCondition orNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("name", value);
        return this;
    }

    public IndustryCondition andNameNe(Object value) {
        ew.ne("name", value);
        return this;
    }

    public IndustryCondition orNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("name", value);
        return this;
    }

    public IndustryCondition andNameGt(Object value) {
        ew.gt("name", value);
        return this;
    }

    public IndustryCondition orNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("name", value);
        return this;
    }

    public IndustryCondition andNameGe(Object value) {
        ew.ge("name", value);
        return this;
    }

    public IndustryCondition orNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("name", value);
        return this;
    }

    public IndustryCondition andNameLt(Object value) {
        ew.lt("name", value);
        return this;
    }

    public IndustryCondition orNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("name", value);
        return this;
    }

    public IndustryCondition andNameLe(Object value) {
        ew.le("name", value);
        return this;
    }

    public IndustryCondition orNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("name", value);
        return this;
    }

    public IndustryCondition andNameIn(Object... value) {
        ew.in("name", value);
        return this;
    }

    public IndustryCondition orNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("name", value);
        return this;
    }

    public IndustryCondition andNameNotIn(Object... value) {
        ew.notIn("name", value);
        return this;
    }

    public IndustryCondition orNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("name", value);
        return this;
    }

    public IndustryCondition andNameBetween(Object value, Object value1) {
        ew.between("name", value, value1);
        return this;
    }

    public IndustryCondition orNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("name", value, value1);
        return this;
    }

    public IndustryCondition andNameNotBetween(Object value, Object value1) {
        ew.notBetween("name", value, value1);
        return this;
    }

    public IndustryCondition orNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("name", value, value1);
        return this;
    }

    public IndustryCondition andNameLike(String value) {
        ew.like("name", value);
        return this;
    }

    public IndustryCondition orNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("name", value);
        return this;
    }

    public IndustryCondition andNameNotLike(String value) {
        ew.notLike("name", value);
        return this;
    }

    public IndustryCondition orNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("name", value);
        return this;
    }

    public IndustryCondition andSimpleNameIsNull() {
        ew.isNull("simple_name");
        return this;
    }

    public IndustryCondition orSimpleNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("simple_name");
        return this;
    }

    public IndustryCondition andSimpleNameIsNotNull() {
        ew.isNotNull("simple_name");
        return this;
    }

    public IndustryCondition orSimpleNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("simple_name");
        return this;
    }

    public IndustryCondition andSimpleNameEq(Object value) {
        ew.eq("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameNe(Object value) {
        ew.ne("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameGt(Object value) {
        ew.gt("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameGe(Object value) {
        ew.ge("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameLt(Object value) {
        ew.lt("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameLe(Object value) {
        ew.le("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameIn(Object... value) {
        ew.in("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameNotIn(Object... value) {
        ew.notIn("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameBetween(Object value, Object value1) {
        ew.between("simple_name", value, value1);
        return this;
    }

    public IndustryCondition orSimpleNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("simple_name", value, value1);
        return this;
    }

    public IndustryCondition andSimpleNameNotBetween(Object value, Object value1) {
        ew.notBetween("simple_name", value, value1);
        return this;
    }

    public IndustryCondition orSimpleNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("simple_name", value, value1);
        return this;
    }

    public IndustryCondition andSimpleNameLike(String value) {
        ew.like("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("simple_name", value);
        return this;
    }

    public IndustryCondition andSimpleNameNotLike(String value) {
        ew.notLike("simple_name", value);
        return this;
    }

    public IndustryCondition orSimpleNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("simple_name", value);
        return this;
    }

    public IndustryCondition andCodeIsNull() {
        ew.isNull("code");
        return this;
    }

    public IndustryCondition orCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("code");
        return this;
    }

    public IndustryCondition andCodeIsNotNull() {
        ew.isNotNull("code");
        return this;
    }

    public IndustryCondition orCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("code");
        return this;
    }

    public IndustryCondition andCodeEq(Object value) {
        ew.eq("code", value);
        return this;
    }

    public IndustryCondition orCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("code", value);
        return this;
    }

    public IndustryCondition andCodeNe(Object value) {
        ew.ne("code", value);
        return this;
    }

    public IndustryCondition orCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("code", value);
        return this;
    }

    public IndustryCondition andCodeGt(Object value) {
        ew.gt("code", value);
        return this;
    }

    public IndustryCondition orCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("code", value);
        return this;
    }

    public IndustryCondition andCodeGe(Object value) {
        ew.ge("code", value);
        return this;
    }

    public IndustryCondition orCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("code", value);
        return this;
    }

    public IndustryCondition andCodeLt(Object value) {
        ew.lt("code", value);
        return this;
    }

    public IndustryCondition orCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("code", value);
        return this;
    }

    public IndustryCondition andCodeLe(Object value) {
        ew.le("code", value);
        return this;
    }

    public IndustryCondition orCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("code", value);
        return this;
    }

    public IndustryCondition andCodeIn(Object... value) {
        ew.in("code", value);
        return this;
    }

    public IndustryCondition orCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("code", value);
        return this;
    }

    public IndustryCondition andCodeNotIn(Object... value) {
        ew.notIn("code", value);
        return this;
    }

    public IndustryCondition orCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("code", value);
        return this;
    }

    public IndustryCondition andCodeBetween(Object value, Object value1) {
        ew.between("code", value, value1);
        return this;
    }

    public IndustryCondition orCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("code", value, value1);
        return this;
    }

    public IndustryCondition andCodeNotBetween(Object value, Object value1) {
        ew.notBetween("code", value, value1);
        return this;
    }

    public IndustryCondition orCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("code", value, value1);
        return this;
    }

    public IndustryCondition andCodeLike(String value) {
        ew.like("code", value);
        return this;
    }

    public IndustryCondition orCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("code", value);
        return this;
    }

    public IndustryCondition andCodeNotLike(String value) {
        ew.notLike("code", value);
        return this;
    }

    public IndustryCondition orCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeIsNull() {
        ew.isNull("province_code");
        return this;
    }

    public IndustryCondition orProvinceCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("province_code");
        return this;
    }

    public IndustryCondition andProvinceCodeIsNotNull() {
        ew.isNotNull("province_code");
        return this;
    }

    public IndustryCondition orProvinceCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("province_code");
        return this;
    }

    public IndustryCondition andProvinceCodeEq(Object value) {
        ew.eq("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeNe(Object value) {
        ew.ne("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeGt(Object value) {
        ew.gt("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeGe(Object value) {
        ew.ge("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeLt(Object value) {
        ew.lt("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeLe(Object value) {
        ew.le("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeIn(Object... value) {
        ew.in("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeNotIn(Object... value) {
        ew.notIn("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeBetween(Object value, Object value1) {
        ew.between("province_code", value, value1);
        return this;
    }

    public IndustryCondition orProvinceCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("province_code", value, value1);
        return this;
    }

    public IndustryCondition andProvinceCodeNotBetween(Object value, Object value1) {
        ew.notBetween("province_code", value, value1);
        return this;
    }

    public IndustryCondition orProvinceCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("province_code", value, value1);
        return this;
    }

    public IndustryCondition andProvinceCodeLike(String value) {
        ew.like("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("province_code", value);
        return this;
    }

    public IndustryCondition andProvinceCodeNotLike(String value) {
        ew.notLike("province_code", value);
        return this;
    }

    public IndustryCondition orProvinceCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("province_code", value);
        return this;
    }

    public IndustryCondition andCityCodeIsNull() {
        ew.isNull("city_code");
        return this;
    }

    public IndustryCondition orCityCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("city_code");
        return this;
    }

    public IndustryCondition andCityCodeIsNotNull() {
        ew.isNotNull("city_code");
        return this;
    }

    public IndustryCondition orCityCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("city_code");
        return this;
    }

    public IndustryCondition andCityCodeEq(Object value) {
        ew.eq("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeNe(Object value) {
        ew.ne("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeGt(Object value) {
        ew.gt("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeGe(Object value) {
        ew.ge("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeLt(Object value) {
        ew.lt("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeLe(Object value) {
        ew.le("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeIn(Object... value) {
        ew.in("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeNotIn(Object... value) {
        ew.notIn("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeBetween(Object value, Object value1) {
        ew.between("city_code", value, value1);
        return this;
    }

    public IndustryCondition orCityCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("city_code", value, value1);
        return this;
    }

    public IndustryCondition andCityCodeNotBetween(Object value, Object value1) {
        ew.notBetween("city_code", value, value1);
        return this;
    }

    public IndustryCondition orCityCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("city_code", value, value1);
        return this;
    }

    public IndustryCondition andCityCodeLike(String value) {
        ew.like("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("city_code", value);
        return this;
    }

    public IndustryCondition andCityCodeNotLike(String value) {
        ew.notLike("city_code", value);
        return this;
    }

    public IndustryCondition orCityCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("city_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeIsNull() {
        ew.isNull("county_code");
        return this;
    }

    public IndustryCondition orCountyCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("county_code");
        return this;
    }

    public IndustryCondition andCountyCodeIsNotNull() {
        ew.isNotNull("county_code");
        return this;
    }

    public IndustryCondition orCountyCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("county_code");
        return this;
    }

    public IndustryCondition andCountyCodeEq(Object value) {
        ew.eq("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeNe(Object value) {
        ew.ne("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeGt(Object value) {
        ew.gt("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeGe(Object value) {
        ew.ge("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeLt(Object value) {
        ew.lt("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeLe(Object value) {
        ew.le("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeIn(Object... value) {
        ew.in("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeNotIn(Object... value) {
        ew.notIn("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeBetween(Object value, Object value1) {
        ew.between("county_code", value, value1);
        return this;
    }

    public IndustryCondition orCountyCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("county_code", value, value1);
        return this;
    }

    public IndustryCondition andCountyCodeNotBetween(Object value, Object value1) {
        ew.notBetween("county_code", value, value1);
        return this;
    }

    public IndustryCondition orCountyCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("county_code", value, value1);
        return this;
    }

    public IndustryCondition andCountyCodeLike(String value) {
        ew.like("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("county_code", value);
        return this;
    }

    public IndustryCondition andCountyCodeNotLike(String value) {
        ew.notLike("county_code", value);
        return this;
    }

    public IndustryCondition orCountyCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("county_code", value);
        return this;
    }

    public IndustryCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public IndustryCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public IndustryCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public IndustryCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public IndustryCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public IndustryCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public IndustryCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public IndustryCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public IndustryCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public IndustryCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public IndustryCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public IndustryCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public IndustryCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public IndustryCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public IndustryCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public IndustryCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public IndustryCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public IndustryCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public IndustryCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public IndustryCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public IndustryCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public IndustryCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public IndustryCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public IndustryCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public IndustryCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public IndustryCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public IndustryCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public IndustryCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public IndustryCondition andAccountNameIsNull() {
        ew.isNull("account_name");
        return this;
    }

    public IndustryCondition orAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_name");
        return this;
    }

    public IndustryCondition andAccountNameIsNotNull() {
        ew.isNotNull("account_name");
        return this;
    }

    public IndustryCondition orAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_name");
        return this;
    }

    public IndustryCondition andAccountNameEq(Object value) {
        ew.eq("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameNe(Object value) {
        ew.ne("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameGt(Object value) {
        ew.gt("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameGe(Object value) {
        ew.ge("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameLt(Object value) {
        ew.lt("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameLe(Object value) {
        ew.le("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameIn(Object... value) {
        ew.in("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameNotIn(Object... value) {
        ew.notIn("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameBetween(Object value, Object value1) {
        ew.between("account_name", value, value1);
        return this;
    }

    public IndustryCondition orAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_name", value, value1);
        return this;
    }

    public IndustryCondition andAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public IndustryCondition orAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public IndustryCondition andAccountNameLike(String value) {
        ew.like("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_name", value);
        return this;
    }

    public IndustryCondition andAccountNameNotLike(String value) {
        ew.notLike("account_name", value);
        return this;
    }

    public IndustryCondition orAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_name", value);
        return this;
    }

    public IndustryCondition andBankNameIsNull() {
        ew.isNull("bank_name");
        return this;
    }

    public IndustryCondition orBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_name");
        return this;
    }

    public IndustryCondition andBankNameIsNotNull() {
        ew.isNotNull("bank_name");
        return this;
    }

    public IndustryCondition orBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_name");
        return this;
    }

    public IndustryCondition andBankNameEq(Object value) {
        ew.eq("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameNe(Object value) {
        ew.ne("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameGt(Object value) {
        ew.gt("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameGe(Object value) {
        ew.ge("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameLt(Object value) {
        ew.lt("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameLe(Object value) {
        ew.le("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameIn(Object... value) {
        ew.in("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameNotIn(Object... value) {
        ew.notIn("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameBetween(Object value, Object value1) {
        ew.between("bank_name", value, value1);
        return this;
    }

    public IndustryCondition orBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_name", value, value1);
        return this;
    }

    public IndustryCondition andBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public IndustryCondition orBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public IndustryCondition andBankNameLike(String value) {
        ew.like("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_name", value);
        return this;
    }

    public IndustryCondition andBankNameNotLike(String value) {
        ew.notLike("bank_name", value);
        return this;
    }

    public IndustryCondition orBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_name", value);
        return this;
    }

    public IndustryCondition andBankCodeIsNull() {
        ew.isNull("bank_code");
        return this;
    }

    public IndustryCondition orBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_code");
        return this;
    }

    public IndustryCondition andBankCodeIsNotNull() {
        ew.isNotNull("bank_code");
        return this;
    }

    public IndustryCondition orBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_code");
        return this;
    }

    public IndustryCondition andBankCodeEq(Object value) {
        ew.eq("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeNe(Object value) {
        ew.ne("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeGt(Object value) {
        ew.gt("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeGe(Object value) {
        ew.ge("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeLt(Object value) {
        ew.lt("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeLe(Object value) {
        ew.le("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeIn(Object... value) {
        ew.in("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeNotIn(Object... value) {
        ew.notIn("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeBetween(Object value, Object value1) {
        ew.between("bank_code", value, value1);
        return this;
    }

    public IndustryCondition orBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_code", value, value1);
        return this;
    }

    public IndustryCondition andBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public IndustryCondition orBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public IndustryCondition andBankCodeLike(String value) {
        ew.like("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_code", value);
        return this;
    }

    public IndustryCondition andBankCodeNotLike(String value) {
        ew.notLike("bank_code", value);
        return this;
    }

    public IndustryCondition orBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_code", value);
        return this;
    }

    public IndustryCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public IndustryCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public IndustryCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public IndustryCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public IndustryCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public IndustryCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public IndustryCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public IndustryCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public IndustryCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public IndustryCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public IndustryCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public IndustryCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public IndustryCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public IndustryCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public IndustryCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public IndustryCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public IndustryCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public IndustryCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public IndustryCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public IndustryCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public IndustryCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public IndustryCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public IndustryCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public IndustryCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public IndustryCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public IndustryCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public IndustryCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public IndustryCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public IndustryCondition andCustNumberIsNull() {
        ew.isNull("cust_number");
        return this;
    }

    public IndustryCondition orCustNumberIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cust_number");
        return this;
    }

    public IndustryCondition andCustNumberIsNotNull() {
        ew.isNotNull("cust_number");
        return this;
    }

    public IndustryCondition orCustNumberIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cust_number");
        return this;
    }

    public IndustryCondition andCustNumberEq(Object value) {
        ew.eq("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberNe(Object value) {
        ew.ne("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberGt(Object value) {
        ew.gt("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberGe(Object value) {
        ew.ge("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberLt(Object value) {
        ew.lt("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberLe(Object value) {
        ew.le("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberIn(Object... value) {
        ew.in("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberNotIn(Object... value) {
        ew.notIn("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberBetween(Object value, Object value1) {
        ew.between("cust_number", value, value1);
        return this;
    }

    public IndustryCondition orCustNumberBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cust_number", value, value1);
        return this;
    }

    public IndustryCondition andCustNumberNotBetween(Object value, Object value1) {
        ew.notBetween("cust_number", value, value1);
        return this;
    }

    public IndustryCondition orCustNumberNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cust_number", value, value1);
        return this;
    }

    public IndustryCondition andCustNumberLike(String value) {
        ew.like("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cust_number", value);
        return this;
    }

    public IndustryCondition andCustNumberNotLike(String value) {
        ew.notLike("cust_number", value);
        return this;
    }

    public IndustryCondition orCustNumberNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cust_number", value);
        return this;
    }

    public IndustryCondition andCustAccountNoIsNull() {
        ew.isNull("cust_account_no");
        return this;
    }

    public IndustryCondition orCustAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cust_account_no");
        return this;
    }

    public IndustryCondition andCustAccountNoIsNotNull() {
        ew.isNotNull("cust_account_no");
        return this;
    }

    public IndustryCondition orCustAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cust_account_no");
        return this;
    }

    public IndustryCondition andCustAccountNoEq(Object value) {
        ew.eq("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoNe(Object value) {
        ew.ne("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoGt(Object value) {
        ew.gt("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoGe(Object value) {
        ew.ge("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoLt(Object value) {
        ew.lt("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoLe(Object value) {
        ew.le("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoIn(Object... value) {
        ew.in("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoNotIn(Object... value) {
        ew.notIn("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoBetween(Object value, Object value1) {
        ew.between("cust_account_no", value, value1);
        return this;
    }

    public IndustryCondition orCustAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cust_account_no", value, value1);
        return this;
    }

    public IndustryCondition andCustAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("cust_account_no", value, value1);
        return this;
    }

    public IndustryCondition orCustAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cust_account_no", value, value1);
        return this;
    }

    public IndustryCondition andCustAccountNoLike(String value) {
        ew.like("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNoNotLike(String value) {
        ew.notLike("cust_account_no", value);
        return this;
    }

    public IndustryCondition orCustAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cust_account_no", value);
        return this;
    }

    public IndustryCondition andCustAccountNameIsNull() {
        ew.isNull("cust_account_name");
        return this;
    }

    public IndustryCondition orCustAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cust_account_name");
        return this;
    }

    public IndustryCondition andCustAccountNameIsNotNull() {
        ew.isNotNull("cust_account_name");
        return this;
    }

    public IndustryCondition orCustAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cust_account_name");
        return this;
    }

    public IndustryCondition andCustAccountNameEq(Object value) {
        ew.eq("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameNe(Object value) {
        ew.ne("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameGt(Object value) {
        ew.gt("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameGe(Object value) {
        ew.ge("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameLt(Object value) {
        ew.lt("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameLe(Object value) {
        ew.le("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameIn(Object... value) {
        ew.in("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameNotIn(Object... value) {
        ew.notIn("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameBetween(Object value, Object value1) {
        ew.between("cust_account_name", value, value1);
        return this;
    }

    public IndustryCondition orCustAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cust_account_name", value, value1);
        return this;
    }

    public IndustryCondition andCustAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("cust_account_name", value, value1);
        return this;
    }

    public IndustryCondition orCustAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cust_account_name", value, value1);
        return this;
    }

    public IndustryCondition andCustAccountNameLike(String value) {
        ew.like("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cust_account_name", value);
        return this;
    }

    public IndustryCondition andCustAccountNameNotLike(String value) {
        ew.notLike("cust_account_name", value);
        return this;
    }

    public IndustryCondition orCustAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cust_account_name", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlIsNull() {
        ew.isNull("inner_notice_url");
        return this;
    }

    public IndustryCondition orInnerNoticeUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("inner_notice_url");
        return this;
    }

    public IndustryCondition andInnerNoticeUrlIsNotNull() {
        ew.isNotNull("inner_notice_url");
        return this;
    }

    public IndustryCondition orInnerNoticeUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("inner_notice_url");
        return this;
    }

    public IndustryCondition andInnerNoticeUrlEq(Object value) {
        ew.eq("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlNe(Object value) {
        ew.ne("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlGt(Object value) {
        ew.gt("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlGe(Object value) {
        ew.ge("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlLt(Object value) {
        ew.lt("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlLe(Object value) {
        ew.le("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlIn(Object... value) {
        ew.in("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlNotIn(Object... value) {
        ew.notIn("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlBetween(Object value, Object value1) {
        ew.between("inner_notice_url", value, value1);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("inner_notice_url", value, value1);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlNotBetween(Object value, Object value1) {
        ew.notBetween("inner_notice_url", value, value1);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("inner_notice_url", value, value1);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlLike(String value) {
        ew.like("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andInnerNoticeUrlNotLike(String value) {
        ew.notLike("inner_notice_url", value);
        return this;
    }

    public IndustryCondition orInnerNoticeUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("inner_notice_url", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountIsNull() {
        ew.isNull("fee_expenditure_account");
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_expenditure_account");
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountIsNotNull() {
        ew.isNotNull("fee_expenditure_account");
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_expenditure_account");
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountEq(Object value) {
        ew.eq("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountNe(Object value) {
        ew.ne("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountGt(Object value) {
        ew.gt("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountGe(Object value) {
        ew.ge("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountLt(Object value) {
        ew.lt("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountLe(Object value) {
        ew.le("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountIn(Object... value) {
        ew.in("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountNotIn(Object... value) {
        ew.notIn("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountBetween(Object value, Object value1) {
        ew.between("fee_expenditure_account", value, value1);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_expenditure_account", value, value1);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountNotBetween(Object value, Object value1) {
        ew.notBetween("fee_expenditure_account", value, value1);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_expenditure_account", value, value1);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountLike(String value) {
        ew.like("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andFeeExpenditureAccountNotLike(String value) {
        ew.notLike("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition orFeeExpenditureAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_expenditure_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountIsNull() {
        ew.isNull("processing_fee_income_account");
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("processing_fee_income_account");
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountIsNotNull() {
        ew.isNotNull("processing_fee_income_account");
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("processing_fee_income_account");
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountEq(Object value) {
        ew.eq("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountNe(Object value) {
        ew.ne("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountGt(Object value) {
        ew.gt("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountGe(Object value) {
        ew.ge("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountLt(Object value) {
        ew.lt("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountLe(Object value) {
        ew.le("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountIn(Object... value) {
        ew.in("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountNotIn(Object... value) {
        ew.notIn("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountBetween(Object value, Object value1) {
        ew.between("processing_fee_income_account", value, value1);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("processing_fee_income_account", value, value1);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("processing_fee_income_account", value, value1);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("processing_fee_income_account", value, value1);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountLike(String value) {
        ew.like("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andProcessingFeeIncomeAccountNotLike(String value) {
        ew.notLike("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition orProcessingFeeIncomeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("processing_fee_income_account", value);
        return this;
    }

    public IndustryCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public IndustryCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public IndustryCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public IndustryCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public IndustryCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public IndustryCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public IndustryCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public IndustryCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public IndustryCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public IndustryCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public IndustryCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public IndustryCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public IndustryCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public IndustryCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public IndustryCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public IndustryCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public IndustryCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public IndustryCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public IndustryCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public IndustryCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public IndustryCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public IndustryCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public IndustryCondition andIndustryTypeIsNull() {
        ew.isNull("industry_type");
        return this;
    }

    public IndustryCondition orIndustryTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_type");
        return this;
    }

    public IndustryCondition andIndustryTypeIsNotNull() {
        ew.isNotNull("industry_type");
        return this;
    }

    public IndustryCondition orIndustryTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_type");
        return this;
    }

    public IndustryCondition andIndustryTypeEq(Object value) {
        ew.eq("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeNe(Object value) {
        ew.ne("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeGt(Object value) {
        ew.gt("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeGe(Object value) {
        ew.ge("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeLt(Object value) {
        ew.lt("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeLe(Object value) {
        ew.le("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeIn(Object... value) {
        ew.in("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeNotIn(Object... value) {
        ew.notIn("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeBetween(Object value, Object value1) {
        ew.between("industry_type", value, value1);
        return this;
    }

    public IndustryCondition orIndustryTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_type", value, value1);
        return this;
    }

    public IndustryCondition andIndustryTypeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_type", value, value1);
        return this;
    }

    public IndustryCondition orIndustryTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_type", value, value1);
        return this;
    }

    public IndustryCondition andIndustryTypeLike(String value) {
        ew.like("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_type", value);
        return this;
    }

    public IndustryCondition andIndustryTypeNotLike(String value) {
        ew.notLike("industry_type", value);
        return this;
    }

    public IndustryCondition orIndustryTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_type", value);
        return this;
    }

    public IndustryCondition andWhetherExternalIsNull() {
        ew.isNull("whether_external");
        return this;
    }

    public IndustryCondition orWhetherExternalIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("whether_external");
        return this;
    }

    public IndustryCondition andWhetherExternalIsNotNull() {
        ew.isNotNull("whether_external");
        return this;
    }

    public IndustryCondition orWhetherExternalIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("whether_external");
        return this;
    }

    public IndustryCondition andWhetherExternalEq(Object value) {
        ew.eq("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalNe(Object value) {
        ew.ne("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalGt(Object value) {
        ew.gt("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalGe(Object value) {
        ew.ge("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalLt(Object value) {
        ew.lt("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalLe(Object value) {
        ew.le("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalIn(Object... value) {
        ew.in("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalNotIn(Object... value) {
        ew.notIn("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalBetween(Object value, Object value1) {
        ew.between("whether_external", value, value1);
        return this;
    }

    public IndustryCondition orWhetherExternalBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("whether_external", value, value1);
        return this;
    }

    public IndustryCondition andWhetherExternalNotBetween(Object value, Object value1) {
        ew.notBetween("whether_external", value, value1);
        return this;
    }

    public IndustryCondition orWhetherExternalNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("whether_external", value, value1);
        return this;
    }

    public IndustryCondition andWhetherExternalLike(String value) {
        ew.like("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("whether_external", value);
        return this;
    }

    public IndustryCondition andWhetherExternalNotLike(String value) {
        ew.notLike("whether_external", value);
        return this;
    }

    public IndustryCondition orWhetherExternalNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("whether_external", value);
        return this;
    }

    public IndustryCondition andFundAccountIsNull() {
        ew.isNull("fund_account");
        return this;
    }

    public IndustryCondition orFundAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fund_account");
        return this;
    }

    public IndustryCondition andFundAccountIsNotNull() {
        ew.isNotNull("fund_account");
        return this;
    }

    public IndustryCondition orFundAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fund_account");
        return this;
    }

    public IndustryCondition andFundAccountEq(Object value) {
        ew.eq("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountNe(Object value) {
        ew.ne("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountGt(Object value) {
        ew.gt("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountGe(Object value) {
        ew.ge("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountLt(Object value) {
        ew.lt("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountLe(Object value) {
        ew.le("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountIn(Object... value) {
        ew.in("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountNotIn(Object... value) {
        ew.notIn("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountBetween(Object value, Object value1) {
        ew.between("fund_account", value, value1);
        return this;
    }

    public IndustryCondition orFundAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fund_account", value, value1);
        return this;
    }

    public IndustryCondition andFundAccountNotBetween(Object value, Object value1) {
        ew.notBetween("fund_account", value, value1);
        return this;
    }

    public IndustryCondition orFundAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fund_account", value, value1);
        return this;
    }

    public IndustryCondition andFundAccountLike(String value) {
        ew.like("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fund_account", value);
        return this;
    }

    public IndustryCondition andFundAccountNotLike(String value) {
        ew.notLike("fund_account", value);
        return this;
    }

    public IndustryCondition orFundAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fund_account", value);
        return this;
    }

    public IndustryCondition andAuditStatusIsNull() {
        ew.isNull("audit_status");
        return this;
    }

    public IndustryCondition orAuditStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("audit_status");
        return this;
    }

    public IndustryCondition andAuditStatusIsNotNull() {
        ew.isNotNull("audit_status");
        return this;
    }

    public IndustryCondition orAuditStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("audit_status");
        return this;
    }

    public IndustryCondition andAuditStatusEq(Object value) {
        ew.eq("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusNe(Object value) {
        ew.ne("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusGt(Object value) {
        ew.gt("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusGe(Object value) {
        ew.ge("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusLt(Object value) {
        ew.lt("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusLe(Object value) {
        ew.le("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusIn(Object... value) {
        ew.in("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusNotIn(Object... value) {
        ew.notIn("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusBetween(Object value, Object value1) {
        ew.between("audit_status", value, value1);
        return this;
    }

    public IndustryCondition orAuditStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("audit_status", value, value1);
        return this;
    }

    public IndustryCondition andAuditStatusNotBetween(Object value, Object value1) {
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public IndustryCondition orAuditStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public IndustryCondition andAuditStatusLike(String value) {
        ew.like("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("audit_status", value);
        return this;
    }

    public IndustryCondition andAuditStatusNotLike(String value) {
        ew.notLike("audit_status", value);
        return this;
    }

    public IndustryCondition orAuditStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("audit_status", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdIsNull() {
        ew.isNull("collection_industry_id");
        return this;
    }

    public IndustryCondition orCollectionIndustryIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("collection_industry_id");
        return this;
    }

    public IndustryCondition andCollectionIndustryIdIsNotNull() {
        ew.isNotNull("collection_industry_id");
        return this;
    }

    public IndustryCondition orCollectionIndustryIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("collection_industry_id");
        return this;
    }

    public IndustryCondition andCollectionIndustryIdEq(Object value) {
        ew.eq("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdNe(Object value) {
        ew.ne("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdGt(Object value) {
        ew.gt("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdGe(Object value) {
        ew.ge("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdLt(Object value) {
        ew.lt("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdLe(Object value) {
        ew.le("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdIn(Object... value) {
        ew.in("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdNotIn(Object... value) {
        ew.notIn("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdBetween(Object value, Object value1) {
        ew.between("collection_industry_id", value, value1);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("collection_industry_id", value, value1);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdNotBetween(Object value, Object value1) {
        ew.notBetween("collection_industry_id", value, value1);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("collection_industry_id", value, value1);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdLike(String value) {
        ew.like("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andCollectionIndustryIdNotLike(String value) {
        ew.notLike("collection_industry_id", value);
        return this;
    }

    public IndustryCondition orCollectionIndustryIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("collection_industry_id", value);
        return this;
    }

    public IndustryCondition andEntNameIsNull() {
        ew.isNull("ent_name");
        return this;
    }

    public IndustryCondition orEntNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ent_name");
        return this;
    }

    public IndustryCondition andEntNameIsNotNull() {
        ew.isNotNull("ent_name");
        return this;
    }

    public IndustryCondition orEntNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ent_name");
        return this;
    }

    public IndustryCondition andEntNameEq(Object value) {
        ew.eq("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameNe(Object value) {
        ew.ne("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameGt(Object value) {
        ew.gt("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameGe(Object value) {
        ew.ge("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameLt(Object value) {
        ew.lt("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameLe(Object value) {
        ew.le("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameIn(Object... value) {
        ew.in("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameNotIn(Object... value) {
        ew.notIn("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameBetween(Object value, Object value1) {
        ew.between("ent_name", value, value1);
        return this;
    }

    public IndustryCondition orEntNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ent_name", value, value1);
        return this;
    }

    public IndustryCondition andEntNameNotBetween(Object value, Object value1) {
        ew.notBetween("ent_name", value, value1);
        return this;
    }

    public IndustryCondition orEntNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ent_name", value, value1);
        return this;
    }

    public IndustryCondition andEntNameLike(String value) {
        ew.like("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ent_name", value);
        return this;
    }

    public IndustryCondition andEntNameNotLike(String value) {
        ew.notLike("ent_name", value);
        return this;
    }

    public IndustryCondition orEntNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ent_name", value);
        return this;
    }

    public IndustryCondition andRegAddressIsNull() {
        ew.isNull("reg_address");
        return this;
    }

    public IndustryCondition orRegAddressIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reg_address");
        return this;
    }

    public IndustryCondition andRegAddressIsNotNull() {
        ew.isNotNull("reg_address");
        return this;
    }

    public IndustryCondition orRegAddressIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reg_address");
        return this;
    }

    public IndustryCondition andRegAddressEq(Object value) {
        ew.eq("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressNe(Object value) {
        ew.ne("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressGt(Object value) {
        ew.gt("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressGe(Object value) {
        ew.ge("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressLt(Object value) {
        ew.lt("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressLe(Object value) {
        ew.le("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressIn(Object... value) {
        ew.in("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressNotIn(Object... value) {
        ew.notIn("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressBetween(Object value, Object value1) {
        ew.between("reg_address", value, value1);
        return this;
    }

    public IndustryCondition orRegAddressBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reg_address", value, value1);
        return this;
    }

    public IndustryCondition andRegAddressNotBetween(Object value, Object value1) {
        ew.notBetween("reg_address", value, value1);
        return this;
    }

    public IndustryCondition orRegAddressNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reg_address", value, value1);
        return this;
    }

    public IndustryCondition andRegAddressLike(String value) {
        ew.like("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reg_address", value);
        return this;
    }

    public IndustryCondition andRegAddressNotLike(String value) {
        ew.notLike("reg_address", value);
        return this;
    }

    public IndustryCondition orRegAddressNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reg_address", value);
        return this;
    }

    public IndustryCondition andBusLicCodeIsNull() {
        ew.isNull("bus_lic_code");
        return this;
    }

    public IndustryCondition orBusLicCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bus_lic_code");
        return this;
    }

    public IndustryCondition andBusLicCodeIsNotNull() {
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public IndustryCondition orBusLicCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public IndustryCondition andBusLicCodeEq(Object value) {
        ew.eq("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeNe(Object value) {
        ew.ne("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeGt(Object value) {
        ew.gt("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeGe(Object value) {
        ew.ge("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeLt(Object value) {
        ew.lt("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeLe(Object value) {
        ew.le("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeIn(Object... value) {
        ew.in("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeNotIn(Object... value) {
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeBetween(Object value, Object value1) {
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public IndustryCondition orBusLicCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public IndustryCondition andBusLicCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public IndustryCondition orBusLicCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public IndustryCondition andBusLicCodeLike(String value) {
        ew.like("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andBusLicCodeNotLike(String value) {
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public IndustryCondition orBusLicCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public IndustryCondition andIdTypeIsNull() {
        ew.isNull("id_type");
        return this;
    }

    public IndustryCondition orIdTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id_type");
        return this;
    }

    public IndustryCondition andIdTypeIsNotNull() {
        ew.isNotNull("id_type");
        return this;
    }

    public IndustryCondition orIdTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id_type");
        return this;
    }

    public IndustryCondition andIdTypeEq(Object value) {
        ew.eq("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeNe(Object value) {
        ew.ne("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeGt(Object value) {
        ew.gt("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeGe(Object value) {
        ew.ge("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeLt(Object value) {
        ew.lt("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeLe(Object value) {
        ew.le("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeIn(Object... value) {
        ew.in("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeNotIn(Object... value) {
        ew.notIn("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeBetween(Object value, Object value1) {
        ew.between("id_type", value, value1);
        return this;
    }

    public IndustryCondition orIdTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id_type", value, value1);
        return this;
    }

    public IndustryCondition andIdTypeNotBetween(Object value, Object value1) {
        ew.notBetween("id_type", value, value1);
        return this;
    }

    public IndustryCondition orIdTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id_type", value, value1);
        return this;
    }

    public IndustryCondition andIdTypeLike(String value) {
        ew.like("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id_type", value);
        return this;
    }

    public IndustryCondition andIdTypeNotLike(String value) {
        ew.notLike("id_type", value);
        return this;
    }

    public IndustryCondition orIdTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id_type", value);
        return this;
    }

    public IndustryCondition andIdCodeIsNull() {
        ew.isNull("id_code");
        return this;
    }

    public IndustryCondition orIdCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id_code");
        return this;
    }

    public IndustryCondition andIdCodeIsNotNull() {
        ew.isNotNull("id_code");
        return this;
    }

    public IndustryCondition orIdCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id_code");
        return this;
    }

    public IndustryCondition andIdCodeEq(Object value) {
        ew.eq("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeNe(Object value) {
        ew.ne("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeGt(Object value) {
        ew.gt("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeGe(Object value) {
        ew.ge("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeLt(Object value) {
        ew.lt("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeLe(Object value) {
        ew.le("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeIn(Object... value) {
        ew.in("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeNotIn(Object... value) {
        ew.notIn("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeBetween(Object value, Object value1) {
        ew.between("id_code", value, value1);
        return this;
    }

    public IndustryCondition orIdCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id_code", value, value1);
        return this;
    }

    public IndustryCondition andIdCodeNotBetween(Object value, Object value1) {
        ew.notBetween("id_code", value, value1);
        return this;
    }

    public IndustryCondition orIdCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id_code", value, value1);
        return this;
    }

    public IndustryCondition andIdCodeLike(String value) {
        ew.like("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id_code", value);
        return this;
    }

    public IndustryCondition andIdCodeNotLike(String value) {
        ew.notLike("id_code", value);
        return this;
    }

    public IndustryCondition orIdCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id_code", value);
        return this;
    }

    public IndustryCondition andAccountNoIsNull() {
        ew.isNull("account_no");
        return this;
    }

    public IndustryCondition orAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_no");
        return this;
    }

    public IndustryCondition andAccountNoIsNotNull() {
        ew.isNotNull("account_no");
        return this;
    }

    public IndustryCondition orAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_no");
        return this;
    }

    public IndustryCondition andAccountNoEq(Object value) {
        ew.eq("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoNe(Object value) {
        ew.ne("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoGt(Object value) {
        ew.gt("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoGe(Object value) {
        ew.ge("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoLt(Object value) {
        ew.lt("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoLe(Object value) {
        ew.le("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoIn(Object... value) {
        ew.in("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoNotIn(Object... value) {
        ew.notIn("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoBetween(Object value, Object value1) {
        ew.between("account_no", value, value1);
        return this;
    }

    public IndustryCondition orAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_no", value, value1);
        return this;
    }

    public IndustryCondition andAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public IndustryCondition orAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public IndustryCondition andAccountNoLike(String value) {
        ew.like("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_no", value);
        return this;
    }

    public IndustryCondition andAccountNoNotLike(String value) {
        ew.notLike("account_no", value);
        return this;
    }

    public IndustryCondition orAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_no", value);
        return this;
    }

    public IndustryCondition andBusinessTypeIsNull() {
        ew.isNull("business_type");
        return this;
    }

    public IndustryCondition orBusinessTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("business_type");
        return this;
    }

    public IndustryCondition andBusinessTypeIsNotNull() {
        ew.isNotNull("business_type");
        return this;
    }

    public IndustryCondition orBusinessTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("business_type");
        return this;
    }

    public IndustryCondition andBusinessTypeEq(Object value) {
        ew.eq("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeNe(Object value) {
        ew.ne("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeGt(Object value) {
        ew.gt("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeGe(Object value) {
        ew.ge("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeLt(Object value) {
        ew.lt("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeLe(Object value) {
        ew.le("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeIn(Object... value) {
        ew.in("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeNotIn(Object... value) {
        ew.notIn("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeBetween(Object value, Object value1) {
        ew.between("business_type", value, value1);
        return this;
    }

    public IndustryCondition orBusinessTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("business_type", value, value1);
        return this;
    }

    public IndustryCondition andBusinessTypeNotBetween(Object value, Object value1) {
        ew.notBetween("business_type", value, value1);
        return this;
    }

    public IndustryCondition orBusinessTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("business_type", value, value1);
        return this;
    }

    public IndustryCondition andBusinessTypeLike(String value) {
        ew.like("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("business_type", value);
        return this;
    }

    public IndustryCondition andBusinessTypeNotLike(String value) {
        ew.notLike("business_type", value);
        return this;
    }

    public IndustryCondition orBusinessTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("business_type", value);
        return this;
    }

    public IndustryCondition andDnIsNull() {
        ew.isNull("dn");
        return this;
    }

    public IndustryCondition orDnIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("dn");
        return this;
    }

    public IndustryCondition andDnIsNotNull() {
        ew.isNotNull("dn");
        return this;
    }

    public IndustryCondition orDnIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("dn");
        return this;
    }

    public IndustryCondition andDnEq(Object value) {
        ew.eq("dn", value);
        return this;
    }

    public IndustryCondition orDnEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("dn", value);
        return this;
    }

    public IndustryCondition andDnNe(Object value) {
        ew.ne("dn", value);
        return this;
    }

    public IndustryCondition orDnNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("dn", value);
        return this;
    }

    public IndustryCondition andDnGt(Object value) {
        ew.gt("dn", value);
        return this;
    }

    public IndustryCondition orDnGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("dn", value);
        return this;
    }

    public IndustryCondition andDnGe(Object value) {
        ew.ge("dn", value);
        return this;
    }

    public IndustryCondition orDnGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("dn", value);
        return this;
    }

    public IndustryCondition andDnLt(Object value) {
        ew.lt("dn", value);
        return this;
    }

    public IndustryCondition orDnLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("dn", value);
        return this;
    }

    public IndustryCondition andDnLe(Object value) {
        ew.le("dn", value);
        return this;
    }

    public IndustryCondition orDnLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("dn", value);
        return this;
    }

    public IndustryCondition andDnIn(Object... value) {
        ew.in("dn", value);
        return this;
    }

    public IndustryCondition orDnIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("dn", value);
        return this;
    }

    public IndustryCondition andDnNotIn(Object... value) {
        ew.notIn("dn", value);
        return this;
    }

    public IndustryCondition orDnNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("dn", value);
        return this;
    }

    public IndustryCondition andDnBetween(Object value, Object value1) {
        ew.between("dn", value, value1);
        return this;
    }

    public IndustryCondition orDnBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("dn", value, value1);
        return this;
    }

    public IndustryCondition andDnNotBetween(Object value, Object value1) {
        ew.notBetween("dn", value, value1);
        return this;
    }

    public IndustryCondition orDnNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("dn", value, value1);
        return this;
    }

    public IndustryCondition andDnLike(String value) {
        ew.like("dn", value);
        return this;
    }

    public IndustryCondition orDnLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("dn", value);
        return this;
    }

    public IndustryCondition andDnNotLike(String value) {
        ew.notLike("dn", value);
        return this;
    }

    public IndustryCondition orDnNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("dn", value);
        return this;
    }

    public IndustryCondition andLegalPersonIsNull() {
        ew.isNull("legal_person");
        return this;
    }

    public IndustryCondition orLegalPersonIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("legal_person");
        return this;
    }

    public IndustryCondition andLegalPersonIsNotNull() {
        ew.isNotNull("legal_person");
        return this;
    }

    public IndustryCondition orLegalPersonIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("legal_person");
        return this;
    }

    public IndustryCondition andLegalPersonEq(Object value) {
        ew.eq("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonNe(Object value) {
        ew.ne("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonGt(Object value) {
        ew.gt("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonGe(Object value) {
        ew.ge("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonLt(Object value) {
        ew.lt("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonLe(Object value) {
        ew.le("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonIn(Object... value) {
        ew.in("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonNotIn(Object... value) {
        ew.notIn("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonBetween(Object value, Object value1) {
        ew.between("legal_person", value, value1);
        return this;
    }

    public IndustryCondition orLegalPersonBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("legal_person", value, value1);
        return this;
    }

    public IndustryCondition andLegalPersonNotBetween(Object value, Object value1) {
        ew.notBetween("legal_person", value, value1);
        return this;
    }

    public IndustryCondition orLegalPersonNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("legal_person", value, value1);
        return this;
    }

    public IndustryCondition andLegalPersonLike(String value) {
        ew.like("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("legal_person", value);
        return this;
    }

    public IndustryCondition andLegalPersonNotLike(String value) {
        ew.notLike("legal_person", value);
        return this;
    }

    public IndustryCondition orLegalPersonNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("legal_person", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateIsNull() {
        ew.isNull("max_brokerage_rate");
        return this;
    }

    public IndustryCondition orMaxBrokerageRateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("max_brokerage_rate");
        return this;
    }

    public IndustryCondition andMaxBrokerageRateIsNotNull() {
        ew.isNotNull("max_brokerage_rate");
        return this;
    }

    public IndustryCondition orMaxBrokerageRateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("max_brokerage_rate");
        return this;
    }

    public IndustryCondition andMaxBrokerageRateEq(Object value) {
        ew.eq("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateNe(Object value) {
        ew.ne("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateGt(Object value) {
        ew.gt("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateGe(Object value) {
        ew.ge("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateLt(Object value) {
        ew.lt("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateLe(Object value) {
        ew.le("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateIn(Object... value) {
        ew.in("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateNotIn(Object... value) {
        ew.notIn("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateBetween(Object value, Object value1) {
        ew.between("max_brokerage_rate", value, value1);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("max_brokerage_rate", value, value1);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateNotBetween(Object value, Object value1) {
        ew.notBetween("max_brokerage_rate", value, value1);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("max_brokerage_rate", value, value1);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateLike(String value) {
        ew.like("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andMaxBrokerageRateNotLike(String value) {
        ew.notLike("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition orMaxBrokerageRateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("max_brokerage_rate", value);
        return this;
    }

    public IndustryCondition andNationalityIsNull() {
        ew.isNull("nationality");
        return this;
    }

    public IndustryCondition orNationalityIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("nationality");
        return this;
    }

    public IndustryCondition andNationalityIsNotNull() {
        ew.isNotNull("nationality");
        return this;
    }

    public IndustryCondition orNationalityIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("nationality");
        return this;
    }

    public IndustryCondition andNationalityEq(Object value) {
        ew.eq("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityNe(Object value) {
        ew.ne("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityGt(Object value) {
        ew.gt("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityGe(Object value) {
        ew.ge("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityLt(Object value) {
        ew.lt("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityLe(Object value) {
        ew.le("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityIn(Object... value) {
        ew.in("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityNotIn(Object... value) {
        ew.notIn("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityBetween(Object value, Object value1) {
        ew.between("nationality", value, value1);
        return this;
    }

    public IndustryCondition orNationalityBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("nationality", value, value1);
        return this;
    }

    public IndustryCondition andNationalityNotBetween(Object value, Object value1) {
        ew.notBetween("nationality", value, value1);
        return this;
    }

    public IndustryCondition orNationalityNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("nationality", value, value1);
        return this;
    }

    public IndustryCondition andNationalityLike(String value) {
        ew.like("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("nationality", value);
        return this;
    }

    public IndustryCondition andNationalityNotLike(String value) {
        ew.notLike("nationality", value);
        return this;
    }

    public IndustryCondition orNationalityNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("nationality", value);
        return this;
    }

    public IndustryCondition andPhoneIsNull() {
        ew.isNull("phone");
        return this;
    }

    public IndustryCondition orPhoneIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("phone");
        return this;
    }

    public IndustryCondition andPhoneIsNotNull() {
        ew.isNotNull("phone");
        return this;
    }

    public IndustryCondition orPhoneIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("phone");
        return this;
    }

    public IndustryCondition andPhoneEq(Object value) {
        ew.eq("phone", value);
        return this;
    }

    public IndustryCondition orPhoneEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("phone", value);
        return this;
    }

    public IndustryCondition andPhoneNe(Object value) {
        ew.ne("phone", value);
        return this;
    }

    public IndustryCondition orPhoneNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("phone", value);
        return this;
    }

    public IndustryCondition andPhoneGt(Object value) {
        ew.gt("phone", value);
        return this;
    }

    public IndustryCondition orPhoneGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("phone", value);
        return this;
    }

    public IndustryCondition andPhoneGe(Object value) {
        ew.ge("phone", value);
        return this;
    }

    public IndustryCondition orPhoneGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("phone", value);
        return this;
    }

    public IndustryCondition andPhoneLt(Object value) {
        ew.lt("phone", value);
        return this;
    }

    public IndustryCondition orPhoneLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("phone", value);
        return this;
    }

    public IndustryCondition andPhoneLe(Object value) {
        ew.le("phone", value);
        return this;
    }

    public IndustryCondition orPhoneLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("phone", value);
        return this;
    }

    public IndustryCondition andPhoneIn(Object... value) {
        ew.in("phone", value);
        return this;
    }

    public IndustryCondition orPhoneIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("phone", value);
        return this;
    }

    public IndustryCondition andPhoneNotIn(Object... value) {
        ew.notIn("phone", value);
        return this;
    }

    public IndustryCondition orPhoneNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("phone", value);
        return this;
    }

    public IndustryCondition andPhoneBetween(Object value, Object value1) {
        ew.between("phone", value, value1);
        return this;
    }

    public IndustryCondition orPhoneBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("phone", value, value1);
        return this;
    }

    public IndustryCondition andPhoneNotBetween(Object value, Object value1) {
        ew.notBetween("phone", value, value1);
        return this;
    }

    public IndustryCondition orPhoneNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("phone", value, value1);
        return this;
    }

    public IndustryCondition andPhoneLike(String value) {
        ew.like("phone", value);
        return this;
    }

    public IndustryCondition orPhoneLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("phone", value);
        return this;
    }

    public IndustryCondition andPhoneNotLike(String value) {
        ew.notLike("phone", value);
        return this;
    }

    public IndustryCondition orPhoneNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("phone", value);
        return this;
    }

    public IndustryCondition andCustomerTradeIsNull() {
        ew.isNull("customer_trade");
        return this;
    }

    public IndustryCondition orCustomerTradeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("customer_trade");
        return this;
    }

    public IndustryCondition andCustomerTradeIsNotNull() {
        ew.isNotNull("customer_trade");
        return this;
    }

    public IndustryCondition orCustomerTradeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("customer_trade");
        return this;
    }

    public IndustryCondition andCustomerTradeEq(Object value) {
        ew.eq("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeNe(Object value) {
        ew.ne("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeGt(Object value) {
        ew.gt("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeGe(Object value) {
        ew.ge("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeLt(Object value) {
        ew.lt("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeLe(Object value) {
        ew.le("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeIn(Object... value) {
        ew.in("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeNotIn(Object... value) {
        ew.notIn("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeBetween(Object value, Object value1) {
        ew.between("customer_trade", value, value1);
        return this;
    }

    public IndustryCondition orCustomerTradeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("customer_trade", value, value1);
        return this;
    }

    public IndustryCondition andCustomerTradeNotBetween(Object value, Object value1) {
        ew.notBetween("customer_trade", value, value1);
        return this;
    }

    public IndustryCondition orCustomerTradeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("customer_trade", value, value1);
        return this;
    }

    public IndustryCondition andCustomerTradeLike(String value) {
        ew.like("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("customer_trade", value);
        return this;
    }

    public IndustryCondition andCustomerTradeNotLike(String value) {
        ew.notLike("customer_trade", value);
        return this;
    }

    public IndustryCondition orCustomerTradeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("customer_trade", value);
        return this;
    }

    public IndustryCondition andFileTypeIsNull() {
        ew.isNull("file_type");
        return this;
    }

    public IndustryCondition orFileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_type");
        return this;
    }

    public IndustryCondition andFileTypeIsNotNull() {
        ew.isNotNull("file_type");
        return this;
    }

    public IndustryCondition orFileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_type");
        return this;
    }

    public IndustryCondition andFileTypeEq(Object value) {
        ew.eq("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeNe(Object value) {
        ew.ne("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeGt(Object value) {
        ew.gt("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeGe(Object value) {
        ew.ge("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeLt(Object value) {
        ew.lt("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeLe(Object value) {
        ew.le("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeIn(Object... value) {
        ew.in("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeNotIn(Object... value) {
        ew.notIn("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeBetween(Object value, Object value1) {
        ew.between("file_type", value, value1);
        return this;
    }

    public IndustryCondition orFileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_type", value, value1);
        return this;
    }

    public IndustryCondition andFileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("file_type", value, value1);
        return this;
    }

    public IndustryCondition orFileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_type", value, value1);
        return this;
    }

    public IndustryCondition andFileTypeLike(String value) {
        ew.like("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_type", value);
        return this;
    }

    public IndustryCondition andFileTypeNotLike(String value) {
        ew.notLike("file_type", value);
        return this;
    }

    public IndustryCondition orFileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeIsNull() {
        ew.isNull("other_file_type");
        return this;
    }

    public IndustryCondition orOtherFileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_file_type");
        return this;
    }

    public IndustryCondition andOtherFileTypeIsNotNull() {
        ew.isNotNull("other_file_type");
        return this;
    }

    public IndustryCondition orOtherFileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_file_type");
        return this;
    }

    public IndustryCondition andOtherFileTypeEq(Object value) {
        ew.eq("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeNe(Object value) {
        ew.ne("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeGt(Object value) {
        ew.gt("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeGe(Object value) {
        ew.ge("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeLt(Object value) {
        ew.lt("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeLe(Object value) {
        ew.le("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeIn(Object... value) {
        ew.in("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeNotIn(Object... value) {
        ew.notIn("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeBetween(Object value, Object value1) {
        ew.between("other_file_type", value, value1);
        return this;
    }

    public IndustryCondition orOtherFileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_file_type", value, value1);
        return this;
    }

    public IndustryCondition andOtherFileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("other_file_type", value, value1);
        return this;
    }

    public IndustryCondition orOtherFileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_file_type", value, value1);
        return this;
    }

    public IndustryCondition andOtherFileTypeLike(String value) {
        ew.like("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_file_type", value);
        return this;
    }

    public IndustryCondition andOtherFileTypeNotLike(String value) {
        ew.notLike("other_file_type", value);
        return this;
    }

    public IndustryCondition orOtherFileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_file_type", value);
        return this;
    }

    public IndustryCondition andFileNumIsNull() {
        ew.isNull("file_num");
        return this;
    }

    public IndustryCondition orFileNumIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_num");
        return this;
    }

    public IndustryCondition andFileNumIsNotNull() {
        ew.isNotNull("file_num");
        return this;
    }

    public IndustryCondition orFileNumIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_num");
        return this;
    }

    public IndustryCondition andFileNumEq(Object value) {
        ew.eq("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumNe(Object value) {
        ew.ne("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumGt(Object value) {
        ew.gt("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumGe(Object value) {
        ew.ge("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumLt(Object value) {
        ew.lt("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumLe(Object value) {
        ew.le("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumIn(Object... value) {
        ew.in("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumNotIn(Object... value) {
        ew.notIn("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumBetween(Object value, Object value1) {
        ew.between("file_num", value, value1);
        return this;
    }

    public IndustryCondition orFileNumBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_num", value, value1);
        return this;
    }

    public IndustryCondition andFileNumNotBetween(Object value, Object value1) {
        ew.notBetween("file_num", value, value1);
        return this;
    }

    public IndustryCondition orFileNumNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_num", value, value1);
        return this;
    }

    public IndustryCondition andFileNumLike(String value) {
        ew.like("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_num", value);
        return this;
    }

    public IndustryCondition andFileNumNotLike(String value) {
        ew.notLike("file_num", value);
        return this;
    }

    public IndustryCondition orFileNumNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_num", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodIsNull() {
        ew.isNull("balance_pay_period");
        return this;
    }

    public IndustryCondition orBalancePayPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("balance_pay_period");
        return this;
    }

    public IndustryCondition andBalancePayPeriodIsNotNull() {
        ew.isNotNull("balance_pay_period");
        return this;
    }

    public IndustryCondition orBalancePayPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("balance_pay_period");
        return this;
    }

    public IndustryCondition andBalancePayPeriodEq(Object value) {
        ew.eq("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodNe(Object value) {
        ew.ne("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodGt(Object value) {
        ew.gt("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodGe(Object value) {
        ew.ge("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodLt(Object value) {
        ew.lt("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodLe(Object value) {
        ew.le("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodIn(Object... value) {
        ew.in("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodNotIn(Object... value) {
        ew.notIn("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodBetween(Object value, Object value1) {
        ew.between("balance_pay_period", value, value1);
        return this;
    }

    public IndustryCondition orBalancePayPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("balance_pay_period", value, value1);
        return this;
    }

    public IndustryCondition andBalancePayPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("balance_pay_period", value, value1);
        return this;
    }

    public IndustryCondition orBalancePayPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("balance_pay_period", value, value1);
        return this;
    }

    public IndustryCondition andBalancePayPeriodLike(String value) {
        ew.like("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andBalancePayPeriodNotLike(String value) {
        ew.notLike("balance_pay_period", value);
        return this;
    }

    public IndustryCondition orBalancePayPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("balance_pay_period", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccIsNull() {
        ew.isNull("is_opne_double_acc");
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("is_opne_double_acc");
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccIsNotNull() {
        ew.isNotNull("is_opne_double_acc");
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("is_opne_double_acc");
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccEq(Object value) {
        ew.eq("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccNe(Object value) {
        ew.ne("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccGt(Object value) {
        ew.gt("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccGe(Object value) {
        ew.ge("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccLt(Object value) {
        ew.lt("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccLe(Object value) {
        ew.le("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccIn(Object... value) {
        ew.in("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccNotIn(Object... value) {
        ew.notIn("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccBetween(Object value, Object value1) {
        ew.between("is_opne_double_acc", value, value1);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("is_opne_double_acc", value, value1);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccNotBetween(Object value, Object value1) {
        ew.notBetween("is_opne_double_acc", value, value1);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("is_opne_double_acc", value, value1);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccLike(String value) {
        ew.like("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneDoubleAccNotLike(String value) {
        ew.notLike("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition orIsOpneDoubleAccNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("is_opne_double_acc", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayIsNull() {
        ew.isNull("is_opne_balance_pay");
        return this;
    }

    public IndustryCondition orIsOpneBalancePayIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("is_opne_balance_pay");
        return this;
    }

    public IndustryCondition andIsOpneBalancePayIsNotNull() {
        ew.isNotNull("is_opne_balance_pay");
        return this;
    }

    public IndustryCondition orIsOpneBalancePayIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("is_opne_balance_pay");
        return this;
    }

    public IndustryCondition andIsOpneBalancePayEq(Object value) {
        ew.eq("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayNe(Object value) {
        ew.ne("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayGt(Object value) {
        ew.gt("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayGe(Object value) {
        ew.ge("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayLt(Object value) {
        ew.lt("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayLe(Object value) {
        ew.le("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayIn(Object... value) {
        ew.in("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayNotIn(Object... value) {
        ew.notIn("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayBetween(Object value, Object value1) {
        ew.between("is_opne_balance_pay", value, value1);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("is_opne_balance_pay", value, value1);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayNotBetween(Object value, Object value1) {
        ew.notBetween("is_opne_balance_pay", value, value1);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("is_opne_balance_pay", value, value1);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayLike(String value) {
        ew.like("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andIsOpneBalancePayNotLike(String value) {
        ew.notLike("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition orIsOpneBalancePayNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("is_opne_balance_pay", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeIsNull() {
        ew.isNull("authentication_mode");
        return this;
    }

    public IndustryCondition orAuthenticationModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("authentication_mode");
        return this;
    }

    public IndustryCondition andAuthenticationModeIsNotNull() {
        ew.isNotNull("authentication_mode");
        return this;
    }

    public IndustryCondition orAuthenticationModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("authentication_mode");
        return this;
    }

    public IndustryCondition andAuthenticationModeEq(Object value) {
        ew.eq("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeNe(Object value) {
        ew.ne("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeGt(Object value) {
        ew.gt("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeGe(Object value) {
        ew.ge("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeLt(Object value) {
        ew.lt("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeLe(Object value) {
        ew.le("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeIn(Object... value) {
        ew.in("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeNotIn(Object... value) {
        ew.notIn("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeBetween(Object value, Object value1) {
        ew.between("authentication_mode", value, value1);
        return this;
    }

    public IndustryCondition orAuthenticationModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("authentication_mode", value, value1);
        return this;
    }

    public IndustryCondition andAuthenticationModeNotBetween(Object value, Object value1) {
        ew.notBetween("authentication_mode", value, value1);
        return this;
    }

    public IndustryCondition orAuthenticationModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("authentication_mode", value, value1);
        return this;
    }

    public IndustryCondition andAuthenticationModeLike(String value) {
        ew.like("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("authentication_mode", value);
        return this;
    }

    public IndustryCondition andAuthenticationModeNotLike(String value) {
        ew.notLike("authentication_mode", value);
        return this;
    }

    public IndustryCondition orAuthenticationModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("authentication_mode", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtIsNull() {
        ew.isNull("need_public_auth_amt");
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("need_public_auth_amt");
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtIsNotNull() {
        ew.isNotNull("need_public_auth_amt");
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("need_public_auth_amt");
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtEq(Object value) {
        ew.eq("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtNe(Object value) {
        ew.ne("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtGt(Object value) {
        ew.gt("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtGe(Object value) {
        ew.ge("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtLt(Object value) {
        ew.lt("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtLe(Object value) {
        ew.le("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtIn(Object... value) {
        ew.in("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtNotIn(Object... value) {
        ew.notIn("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtBetween(Object value, Object value1) {
        ew.between("need_public_auth_amt", value, value1);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("need_public_auth_amt", value, value1);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtNotBetween(Object value, Object value1) {
        ew.notBetween("need_public_auth_amt", value, value1);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("need_public_auth_amt", value, value1);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtLike(String value) {
        ew.like("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andNeedPublicAuthAmtNotLike(String value) {
        ew.notLike("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition orNeedPublicAuthAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("need_public_auth_amt", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardIsNull() {
        ew.isNull("able_bind_multi_card");
        return this;
    }

    public IndustryCondition orAbleBindMultiCardIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("able_bind_multi_card");
        return this;
    }

    public IndustryCondition andAbleBindMultiCardIsNotNull() {
        ew.isNotNull("able_bind_multi_card");
        return this;
    }

    public IndustryCondition orAbleBindMultiCardIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("able_bind_multi_card");
        return this;
    }

    public IndustryCondition andAbleBindMultiCardEq(Object value) {
        ew.eq("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardNe(Object value) {
        ew.ne("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardGt(Object value) {
        ew.gt("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardGe(Object value) {
        ew.ge("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardLt(Object value) {
        ew.lt("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardLe(Object value) {
        ew.le("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardIn(Object... value) {
        ew.in("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardNotIn(Object... value) {
        ew.notIn("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardBetween(Object value, Object value1) {
        ew.between("able_bind_multi_card", value, value1);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("able_bind_multi_card", value, value1);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardNotBetween(Object value, Object value1) {
        ew.notBetween("able_bind_multi_card", value, value1);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("able_bind_multi_card", value, value1);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardLike(String value) {
        ew.like("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAbleBindMultiCardNotLike(String value) {
        ew.notLike("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition orAbleBindMultiCardNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("able_bind_multi_card", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdIsNull() {
        ew.isNull("auth_payment_account_id");
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_payment_account_id");
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdIsNotNull() {
        ew.isNotNull("auth_payment_account_id");
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_payment_account_id");
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdEq(Object value) {
        ew.eq("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdNe(Object value) {
        ew.ne("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdGt(Object value) {
        ew.gt("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdGe(Object value) {
        ew.ge("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdLt(Object value) {
        ew.lt("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdLe(Object value) {
        ew.le("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdIn(Object... value) {
        ew.in("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdNotIn(Object... value) {
        ew.notIn("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdBetween(Object value, Object value1) {
        ew.between("auth_payment_account_id", value, value1);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_payment_account_id", value, value1);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdNotBetween(Object value, Object value1) {
        ew.notBetween("auth_payment_account_id", value, value1);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_payment_account_id", value, value1);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdLike(String value) {
        ew.like("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andAuthPaymentAccountIdNotLike(String value) {
        ew.notLike("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition orAuthPaymentAccountIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_payment_account_id", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayIsNull() {
        ew.isNull("open_sub_single_pay");
        return this;
    }

    public IndustryCondition orOpenSubSinglePayIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("open_sub_single_pay");
        return this;
    }

    public IndustryCondition andOpenSubSinglePayIsNotNull() {
        ew.isNotNull("open_sub_single_pay");
        return this;
    }

    public IndustryCondition orOpenSubSinglePayIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("open_sub_single_pay");
        return this;
    }

    public IndustryCondition andOpenSubSinglePayEq(Object value) {
        ew.eq("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayNe(Object value) {
        ew.ne("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayGt(Object value) {
        ew.gt("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayGe(Object value) {
        ew.ge("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayLt(Object value) {
        ew.lt("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayLe(Object value) {
        ew.le("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayIn(Object... value) {
        ew.in("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayNotIn(Object... value) {
        ew.notIn("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayBetween(Object value, Object value1) {
        ew.between("open_sub_single_pay", value, value1);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("open_sub_single_pay", value, value1);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayNotBetween(Object value, Object value1) {
        ew.notBetween("open_sub_single_pay", value, value1);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("open_sub_single_pay", value, value1);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayLike(String value) {
        ew.like("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andOpenSubSinglePayNotLike(String value) {
        ew.notLike("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition orOpenSubSinglePayNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("open_sub_single_pay", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignIsNull() {
        ew.isNull("verify_payee_account_sign");
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("verify_payee_account_sign");
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignIsNotNull() {
        ew.isNotNull("verify_payee_account_sign");
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("verify_payee_account_sign");
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignEq(Object value) {
        ew.eq("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignNe(Object value) {
        ew.ne("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignGt(Object value) {
        ew.gt("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignGe(Object value) {
        ew.ge("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignLt(Object value) {
        ew.lt("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignLe(Object value) {
        ew.le("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignIn(Object... value) {
        ew.in("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignNotIn(Object... value) {
        ew.notIn("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignBetween(Object value, Object value1) {
        ew.between("verify_payee_account_sign", value, value1);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("verify_payee_account_sign", value, value1);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignNotBetween(Object value, Object value1) {
        ew.notBetween("verify_payee_account_sign", value, value1);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("verify_payee_account_sign", value, value1);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignLike(String value) {
        ew.like("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeAccountSignNotLike(String value) {
        ew.notLike("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeAccountSignNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("verify_payee_account_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignIsNull() {
        ew.isNull("verify_payee_white_list_sign");
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("verify_payee_white_list_sign");
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignIsNotNull() {
        ew.isNotNull("verify_payee_white_list_sign");
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("verify_payee_white_list_sign");
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignEq(Object value) {
        ew.eq("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignNe(Object value) {
        ew.ne("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignGt(Object value) {
        ew.gt("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignGe(Object value) {
        ew.ge("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignLt(Object value) {
        ew.lt("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignLe(Object value) {
        ew.le("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignIn(Object... value) {
        ew.in("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignNotIn(Object... value) {
        ew.notIn("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignBetween(Object value, Object value1) {
        ew.between("verify_payee_white_list_sign", value, value1);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("verify_payee_white_list_sign", value, value1);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignNotBetween(Object value, Object value1) {
        ew.notBetween("verify_payee_white_list_sign", value, value1);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("verify_payee_white_list_sign", value, value1);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignLike(String value) {
        ew.like("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andVerifyPayeeWhiteListSignNotLike(String value) {
        ew.notLike("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition orVerifyPayeeWhiteListSignNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("verify_payee_white_list_sign", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeIsNull() {
        ew.isNull("payer_sub_type");
        return this;
    }

    public IndustryCondition orPayerSubTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_sub_type");
        return this;
    }

    public IndustryCondition andPayerSubTypeIsNotNull() {
        ew.isNotNull("payer_sub_type");
        return this;
    }

    public IndustryCondition orPayerSubTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_sub_type");
        return this;
    }

    public IndustryCondition andPayerSubTypeEq(Object value) {
        ew.eq("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeNe(Object value) {
        ew.ne("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeGt(Object value) {
        ew.gt("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeGe(Object value) {
        ew.ge("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeLt(Object value) {
        ew.lt("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeLe(Object value) {
        ew.le("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeIn(Object... value) {
        ew.in("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeNotIn(Object... value) {
        ew.notIn("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeBetween(Object value, Object value1) {
        ew.between("payer_sub_type", value, value1);
        return this;
    }

    public IndustryCondition orPayerSubTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_sub_type", value, value1);
        return this;
    }

    public IndustryCondition andPayerSubTypeNotBetween(Object value, Object value1) {
        ew.notBetween("payer_sub_type", value, value1);
        return this;
    }

    public IndustryCondition orPayerSubTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_sub_type", value, value1);
        return this;
    }

    public IndustryCondition andPayerSubTypeLike(String value) {
        ew.like("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andPayerSubTypeNotLike(String value) {
        ew.notLike("payer_sub_type", value);
        return this;
    }

    public IndustryCondition orPayerSubTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_sub_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeIsNull() {
        ew.isNull("sub_income_type");
        return this;
    }

    public IndustryCondition orSubIncomeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sub_income_type");
        return this;
    }

    public IndustryCondition andSubIncomeTypeIsNotNull() {
        ew.isNotNull("sub_income_type");
        return this;
    }

    public IndustryCondition orSubIncomeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sub_income_type");
        return this;
    }

    public IndustryCondition andSubIncomeTypeEq(Object value) {
        ew.eq("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeNe(Object value) {
        ew.ne("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeGt(Object value) {
        ew.gt("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeGe(Object value) {
        ew.ge("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeLt(Object value) {
        ew.lt("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeLe(Object value) {
        ew.le("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeIn(Object... value) {
        ew.in("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeNotIn(Object... value) {
        ew.notIn("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeBetween(Object value, Object value1) {
        ew.between("sub_income_type", value, value1);
        return this;
    }

    public IndustryCondition orSubIncomeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sub_income_type", value, value1);
        return this;
    }

    public IndustryCondition andSubIncomeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("sub_income_type", value, value1);
        return this;
    }

    public IndustryCondition orSubIncomeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sub_income_type", value, value1);
        return this;
    }

    public IndustryCondition andSubIncomeTypeLike(String value) {
        ew.like("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sub_income_type", value);
        return this;
    }

    public IndustryCondition andSubIncomeTypeNotLike(String value) {
        ew.notLike("sub_income_type", value);
        return this;
    }

    public IndustryCondition orSubIncomeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sub_income_type", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitIsNull() {
        ew.isNull("able_trans_order_init");
        return this;
    }

    public IndustryCondition orAbleTransOrderInitIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("able_trans_order_init");
        return this;
    }

    public IndustryCondition andAbleTransOrderInitIsNotNull() {
        ew.isNotNull("able_trans_order_init");
        return this;
    }

    public IndustryCondition orAbleTransOrderInitIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("able_trans_order_init");
        return this;
    }

    public IndustryCondition andAbleTransOrderInitEq(Object value) {
        ew.eq("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitNe(Object value) {
        ew.ne("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitGt(Object value) {
        ew.gt("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitGe(Object value) {
        ew.ge("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitLt(Object value) {
        ew.lt("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitLe(Object value) {
        ew.le("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitIn(Object... value) {
        ew.in("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitNotIn(Object... value) {
        ew.notIn("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitBetween(Object value, Object value1) {
        ew.between("able_trans_order_init", value, value1);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("able_trans_order_init", value, value1);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitNotBetween(Object value, Object value1) {
        ew.notBetween("able_trans_order_init", value, value1);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("able_trans_order_init", value, value1);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitLike(String value) {
        ew.like("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andAbleTransOrderInitNotLike(String value) {
        ew.notLike("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition orAbleTransOrderInitNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("able_trans_order_init", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxIsNull() {
        ew.isNull("sub_account_open_max");
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sub_account_open_max");
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxIsNotNull() {
        ew.isNotNull("sub_account_open_max");
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sub_account_open_max");
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxEq(Object value) {
        ew.eq("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxNe(Object value) {
        ew.ne("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxGt(Object value) {
        ew.gt("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxGe(Object value) {
        ew.ge("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxLt(Object value) {
        ew.lt("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxLe(Object value) {
        ew.le("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxIn(Object... value) {
        ew.in("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxNotIn(Object... value) {
        ew.notIn("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxBetween(Object value, Object value1) {
        ew.between("sub_account_open_max", value, value1);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sub_account_open_max", value, value1);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxNotBetween(Object value, Object value1) {
        ew.notBetween("sub_account_open_max", value, value1);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sub_account_open_max", value, value1);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxLike(String value) {
        ew.like("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andSubAccountOpenMaxNotLike(String value) {
        ew.notLike("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition orSubAccountOpenMaxNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sub_account_open_max", value);
        return this;
    }

    public IndustryCondition andReconciliationModeIsNull() {
        ew.isNull("reconciliation_mode");
        return this;
    }

    public IndustryCondition orReconciliationModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconciliation_mode");
        return this;
    }

    public IndustryCondition andReconciliationModeIsNotNull() {
        ew.isNotNull("reconciliation_mode");
        return this;
    }

    public IndustryCondition orReconciliationModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconciliation_mode");
        return this;
    }

    public IndustryCondition andReconciliationModeEq(Object value) {
        ew.eq("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeNe(Object value) {
        ew.ne("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeGt(Object value) {
        ew.gt("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeGe(Object value) {
        ew.ge("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeLt(Object value) {
        ew.lt("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeLe(Object value) {
        ew.le("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeIn(Object... value) {
        ew.in("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeNotIn(Object... value) {
        ew.notIn("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeBetween(Object value, Object value1) {
        ew.between("reconciliation_mode", value, value1);
        return this;
    }

    public IndustryCondition orReconciliationModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconciliation_mode", value, value1);
        return this;
    }

    public IndustryCondition andReconciliationModeNotBetween(Object value, Object value1) {
        ew.notBetween("reconciliation_mode", value, value1);
        return this;
    }

    public IndustryCondition orReconciliationModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconciliation_mode", value, value1);
        return this;
    }

    public IndustryCondition andReconciliationModeLike(String value) {
        ew.like("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andReconciliationModeNotLike(String value) {
        ew.notLike("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition orReconciliationModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconciliation_mode", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceIsNull() {
        ew.isNull("able_download_daily_balance");
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("able_download_daily_balance");
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceIsNotNull() {
        ew.isNotNull("able_download_daily_balance");
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("able_download_daily_balance");
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceEq(Object value) {
        ew.eq("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceNe(Object value) {
        ew.ne("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceGt(Object value) {
        ew.gt("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceGe(Object value) {
        ew.ge("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceLt(Object value) {
        ew.lt("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceLe(Object value) {
        ew.le("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceIn(Object... value) {
        ew.in("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceNotIn(Object... value) {
        ew.notIn("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceBetween(Object value, Object value1) {
        ew.between("able_download_daily_balance", value, value1);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("able_download_daily_balance", value, value1);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceNotBetween(Object value, Object value1) {
        ew.notBetween("able_download_daily_balance", value, value1);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("able_download_daily_balance", value, value1);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceLike(String value) {
        ew.like("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andAbleDownloadDailyBalanceNotLike(String value) {
        ew.notLike("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition orAbleDownloadDailyBalanceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("able_download_daily_balance", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeIsNull() {
        ew.isNull("open_account_mode");
        return this;
    }

    public IndustryCondition orOpenAccountModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("open_account_mode");
        return this;
    }

    public IndustryCondition andOpenAccountModeIsNotNull() {
        ew.isNotNull("open_account_mode");
        return this;
    }

    public IndustryCondition orOpenAccountModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("open_account_mode");
        return this;
    }

    public IndustryCondition andOpenAccountModeEq(Object value) {
        ew.eq("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeNe(Object value) {
        ew.ne("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeGt(Object value) {
        ew.gt("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeGe(Object value) {
        ew.ge("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeLt(Object value) {
        ew.lt("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeLe(Object value) {
        ew.le("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeIn(Object... value) {
        ew.in("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeNotIn(Object... value) {
        ew.notIn("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeBetween(Object value, Object value1) {
        ew.between("open_account_mode", value, value1);
        return this;
    }

    public IndustryCondition orOpenAccountModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("open_account_mode", value, value1);
        return this;
    }

    public IndustryCondition andOpenAccountModeNotBetween(Object value, Object value1) {
        ew.notBetween("open_account_mode", value, value1);
        return this;
    }

    public IndustryCondition orOpenAccountModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("open_account_mode", value, value1);
        return this;
    }

    public IndustryCondition andOpenAccountModeLike(String value) {
        ew.like("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("open_account_mode", value);
        return this;
    }

    public IndustryCondition andOpenAccountModeNotLike(String value) {
        ew.notLike("open_account_mode", value);
        return this;
    }

    public IndustryCondition orOpenAccountModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("open_account_mode", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeIsNull() {
        ew.isNull("industry_income_type");
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_income_type");
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeIsNotNull() {
        ew.isNotNull("industry_income_type");
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_income_type");
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeEq(Object value) {
        ew.eq("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeNe(Object value) {
        ew.ne("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeGt(Object value) {
        ew.gt("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeGe(Object value) {
        ew.ge("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeLt(Object value) {
        ew.lt("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeLe(Object value) {
        ew.le("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeIn(Object... value) {
        ew.in("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeNotIn(Object... value) {
        ew.notIn("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeBetween(Object value, Object value1) {
        ew.between("industry_income_type", value, value1);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_income_type", value, value1);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_income_type", value, value1);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_income_type", value, value1);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeLike(String value) {
        ew.like("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_income_type", value);
        return this;
    }

    public IndustryCondition andIndustryIncomeTypeNotLike(String value) {
        ew.notLike("industry_income_type", value);
        return this;
    }

    public IndustryCondition orIndustryIncomeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_income_type", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagIsNull() {
        ew.isNull("open_show_custom_flag");
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("open_show_custom_flag");
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagIsNotNull() {
        ew.isNotNull("open_show_custom_flag");
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("open_show_custom_flag");
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagEq(Object value) {
        ew.eq("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagNe(Object value) {
        ew.ne("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagGt(Object value) {
        ew.gt("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagGe(Object value) {
        ew.ge("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagLt(Object value) {
        ew.lt("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagLe(Object value) {
        ew.le("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagIn(Object... value) {
        ew.in("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagNotIn(Object... value) {
        ew.notIn("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagBetween(Object value, Object value1) {
        ew.between("open_show_custom_flag", value, value1);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("open_show_custom_flag", value, value1);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagNotBetween(Object value, Object value1) {
        ew.notBetween("open_show_custom_flag", value, value1);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("open_show_custom_flag", value, value1);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagLike(String value) {
        ew.like("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andOpenShowCustomFlagNotLike(String value) {
        ew.notLike("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition orOpenShowCustomFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("open_show_custom_flag", value);
        return this;
    }

    public IndustryCondition andBusLicPicIsNull() {
        ew.isNull("bus_lic_pic");
        return this;
    }

    public IndustryCondition orBusLicPicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bus_lic_pic");
        return this;
    }

    public IndustryCondition andBusLicPicIsNotNull() {
        ew.isNotNull("bus_lic_pic");
        return this;
    }

    public IndustryCondition orBusLicPicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bus_lic_pic");
        return this;
    }

    public IndustryCondition andBusLicPicEq(Object value) {
        ew.eq("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicNe(Object value) {
        ew.ne("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicGt(Object value) {
        ew.gt("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicGe(Object value) {
        ew.ge("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicLt(Object value) {
        ew.lt("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicLe(Object value) {
        ew.le("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicIn(Object... value) {
        ew.in("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicNotIn(Object... value) {
        ew.notIn("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicBetween(Object value, Object value1) {
        ew.between("bus_lic_pic", value, value1);
        return this;
    }

    public IndustryCondition orBusLicPicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bus_lic_pic", value, value1);
        return this;
    }

    public IndustryCondition andBusLicPicNotBetween(Object value, Object value1) {
        ew.notBetween("bus_lic_pic", value, value1);
        return this;
    }

    public IndustryCondition orBusLicPicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bus_lic_pic", value, value1);
        return this;
    }

    public IndustryCondition andBusLicPicLike(String value) {
        ew.like("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andBusLicPicNotLike(String value) {
        ew.notLike("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition orBusLicPicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bus_lic_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicIsNull() {
        ew.isNull("person_pic");
        return this;
    }

    public IndustryCondition orPersonPicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("person_pic");
        return this;
    }

    public IndustryCondition andPersonPicIsNotNull() {
        ew.isNotNull("person_pic");
        return this;
    }

    public IndustryCondition orPersonPicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("person_pic");
        return this;
    }

    public IndustryCondition andPersonPicEq(Object value) {
        ew.eq("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicNe(Object value) {
        ew.ne("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicGt(Object value) {
        ew.gt("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicGe(Object value) {
        ew.ge("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicLt(Object value) {
        ew.lt("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicLe(Object value) {
        ew.le("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicIn(Object... value) {
        ew.in("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicNotIn(Object... value) {
        ew.notIn("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicBetween(Object value, Object value1) {
        ew.between("person_pic", value, value1);
        return this;
    }

    public IndustryCondition orPersonPicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("person_pic", value, value1);
        return this;
    }

    public IndustryCondition andPersonPicNotBetween(Object value, Object value1) {
        ew.notBetween("person_pic", value, value1);
        return this;
    }

    public IndustryCondition orPersonPicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("person_pic", value, value1);
        return this;
    }

    public IndustryCondition andPersonPicLike(String value) {
        ew.like("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonPicNotLike(String value) {
        ew.notLike("person_pic", value);
        return this;
    }

    public IndustryCondition orPersonPicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("person_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicIsNull() {
        ew.isNull("person_reverse_pic");
        return this;
    }

    public IndustryCondition orPersonReversePicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("person_reverse_pic");
        return this;
    }

    public IndustryCondition andPersonReversePicIsNotNull() {
        ew.isNotNull("person_reverse_pic");
        return this;
    }

    public IndustryCondition orPersonReversePicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("person_reverse_pic");
        return this;
    }

    public IndustryCondition andPersonReversePicEq(Object value) {
        ew.eq("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicNe(Object value) {
        ew.ne("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicGt(Object value) {
        ew.gt("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicGe(Object value) {
        ew.ge("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicLt(Object value) {
        ew.lt("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicLe(Object value) {
        ew.le("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicIn(Object... value) {
        ew.in("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicNotIn(Object... value) {
        ew.notIn("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicBetween(Object value, Object value1) {
        ew.between("person_reverse_pic", value, value1);
        return this;
    }

    public IndustryCondition orPersonReversePicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("person_reverse_pic", value, value1);
        return this;
    }

    public IndustryCondition andPersonReversePicNotBetween(Object value, Object value1) {
        ew.notBetween("person_reverse_pic", value, value1);
        return this;
    }

    public IndustryCondition orPersonReversePicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("person_reverse_pic", value, value1);
        return this;
    }

    public IndustryCondition andPersonReversePicLike(String value) {
        ew.like("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andPersonReversePicNotLike(String value) {
        ew.notLike("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition orPersonReversePicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("person_reverse_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicIsNull() {
        ew.isNull("license_pic");
        return this;
    }

    public IndustryCondition orLicensePicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("license_pic");
        return this;
    }

    public IndustryCondition andLicensePicIsNotNull() {
        ew.isNotNull("license_pic");
        return this;
    }

    public IndustryCondition orLicensePicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("license_pic");
        return this;
    }

    public IndustryCondition andLicensePicEq(Object value) {
        ew.eq("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicNe(Object value) {
        ew.ne("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicGt(Object value) {
        ew.gt("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicGe(Object value) {
        ew.ge("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicLt(Object value) {
        ew.lt("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicLe(Object value) {
        ew.le("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicIn(Object... value) {
        ew.in("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicNotIn(Object... value) {
        ew.notIn("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicBetween(Object value, Object value1) {
        ew.between("license_pic", value, value1);
        return this;
    }

    public IndustryCondition orLicensePicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("license_pic", value, value1);
        return this;
    }

    public IndustryCondition andLicensePicNotBetween(Object value, Object value1) {
        ew.notBetween("license_pic", value, value1);
        return this;
    }

    public IndustryCondition orLicensePicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("license_pic", value, value1);
        return this;
    }

    public IndustryCondition andLicensePicLike(String value) {
        ew.like("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("license_pic", value);
        return this;
    }

    public IndustryCondition andLicensePicNotLike(String value) {
        ew.notLike("license_pic", value);
        return this;
    }

    public IndustryCondition orLicensePicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("license_pic", value);
        return this;
    }
}