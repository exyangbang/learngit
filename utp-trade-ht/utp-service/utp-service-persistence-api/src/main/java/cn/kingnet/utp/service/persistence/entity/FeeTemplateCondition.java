package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class FeeTemplateCondition {
    private PlusEntityWrapper<FeeTemplate> ew;

    public FeeTemplateCondition() {
        this.ew = new PlusEntityWrapper(FeeTemplate.class);
    }

    public static FeeTemplateCondition builder() {
        return new FeeTemplateCondition();
    }

    public PlusEntityWrapper<FeeTemplate> build() {
        return this.ew;
    }

    public FeeTemplateCondition or() {
        this.ew.orNew();
        return this;
    }

    public FeeTemplateCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(FeeTemplate.class);
    }

    public FeeTemplateCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public FeeTemplateCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public FeeTemplateCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public FeeTemplateCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> FeeTemplateCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> FeeTemplateCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> FeeTemplateCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public FeeTemplateCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public FeeTemplateCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public FeeTemplateCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public FeeTemplateCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public FeeTemplateCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public FeeTemplateCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public FeeTemplateCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public FeeTemplateCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public FeeTemplateCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public FeeTemplateCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public FeeTemplateCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public FeeTemplateCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public FeeTemplateCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public FeeTemplateCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public FeeTemplateCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public FeeTemplateCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public FeeTemplateCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public FeeTemplateCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public FeeTemplateCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public FeeTemplateCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public FeeTemplateCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public FeeTemplateCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public FeeTemplateCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public FeeTemplateCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public FeeTemplateCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public FeeTemplateCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public FeeTemplateCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public FeeTemplateCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public FeeTemplateCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public FeeTemplateCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public FeeTemplateCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public FeeTemplateCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public FeeTemplateCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public FeeTemplateCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public FeeTemplateCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public FeeTemplateCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public FeeTemplateCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FeeTemplateCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FeeTemplateCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public FeeTemplateCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public FeeTemplateCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public FeeTemplateCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public FeeTemplateCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public FeeTemplateCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public FeeTemplateCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FeeTemplateCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FeeTemplateCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FeeTemplateCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FeeTemplateCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public FeeTemplateCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public FeeTemplateCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public FeeTemplateCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public FeeTemplateCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public FeeTemplateCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public FeeTemplateCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public FeeTemplateCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FeeTemplateCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FeeTemplateCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FeeTemplateCondition andNameIsNull() {
        ew.isNull("name");
        return this;
    }

    public FeeTemplateCondition orNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("name");
        return this;
    }

    public FeeTemplateCondition andNameIsNotNull() {
        ew.isNotNull("name");
        return this;
    }

    public FeeTemplateCondition orNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("name");
        return this;
    }

    public FeeTemplateCondition andNameEq(Object value) {
        ew.eq("name", value);
        return this;
    }

    public FeeTemplateCondition orNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("name", value);
        return this;
    }

    public FeeTemplateCondition andNameNe(Object value) {
        ew.ne("name", value);
        return this;
    }

    public FeeTemplateCondition orNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("name", value);
        return this;
    }

    public FeeTemplateCondition andNameGt(Object value) {
        ew.gt("name", value);
        return this;
    }

    public FeeTemplateCondition orNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("name", value);
        return this;
    }

    public FeeTemplateCondition andNameGe(Object value) {
        ew.ge("name", value);
        return this;
    }

    public FeeTemplateCondition orNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("name", value);
        return this;
    }

    public FeeTemplateCondition andNameLt(Object value) {
        ew.lt("name", value);
        return this;
    }

    public FeeTemplateCondition orNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("name", value);
        return this;
    }

    public FeeTemplateCondition andNameLe(Object value) {
        ew.le("name", value);
        return this;
    }

    public FeeTemplateCondition orNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("name", value);
        return this;
    }

    public FeeTemplateCondition andNameIn(Object... value) {
        ew.in("name", value);
        return this;
    }

    public FeeTemplateCondition orNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("name", value);
        return this;
    }

    public FeeTemplateCondition andNameNotIn(Object... value) {
        ew.notIn("name", value);
        return this;
    }

    public FeeTemplateCondition orNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("name", value);
        return this;
    }

    public FeeTemplateCondition andNameBetween(Object value, Object value1) {
        ew.between("name", value, value1);
        return this;
    }

    public FeeTemplateCondition orNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("name", value, value1);
        return this;
    }

    public FeeTemplateCondition andNameNotBetween(Object value, Object value1) {
        ew.notBetween("name", value, value1);
        return this;
    }

    public FeeTemplateCondition orNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("name", value, value1);
        return this;
    }

    public FeeTemplateCondition andNameLike(String value) {
        ew.like("name", value);
        return this;
    }

    public FeeTemplateCondition orNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("name", value);
        return this;
    }

    public FeeTemplateCondition andNameNotLike(String value) {
        ew.notLike("name", value);
        return this;
    }

    public FeeTemplateCondition orNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("name", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeIsNull() {
        ew.isNull("settle_type");
        return this;
    }

    public FeeTemplateCondition orSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_type");
        return this;
    }

    public FeeTemplateCondition andSettleTypeIsNotNull() {
        ew.isNotNull("settle_type");
        return this;
    }

    public FeeTemplateCondition orSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_type");
        return this;
    }

    public FeeTemplateCondition andSettleTypeEq(Object value) {
        ew.eq("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeNe(Object value) {
        ew.ne("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeGt(Object value) {
        ew.gt("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeGe(Object value) {
        ew.ge("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeLt(Object value) {
        ew.lt("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeLe(Object value) {
        ew.le("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeIn(Object... value) {
        ew.in("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeNotIn(Object... value) {
        ew.notIn("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeBetween(Object value, Object value1) {
        ew.between("settle_type", value, value1);
        return this;
    }

    public FeeTemplateCondition orSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_type", value, value1);
        return this;
    }

    public FeeTemplateCondition andSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("settle_type", value, value1);
        return this;
    }

    public FeeTemplateCondition orSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_type", value, value1);
        return this;
    }

    public FeeTemplateCondition andSettleTypeLike(String value) {
        ew.like("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andSettleTypeNotLike(String value) {
        ew.notLike("settle_type", value);
        return this;
    }

    public FeeTemplateCondition orSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_type", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeIsNull() {
        ew.isNull("charge_mode");
        return this;
    }

    public FeeTemplateCondition orChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("charge_mode");
        return this;
    }

    public FeeTemplateCondition andChargeModeIsNotNull() {
        ew.isNotNull("charge_mode");
        return this;
    }

    public FeeTemplateCondition orChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("charge_mode");
        return this;
    }

    public FeeTemplateCondition andChargeModeEq(Object value) {
        ew.eq("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeNe(Object value) {
        ew.ne("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeGt(Object value) {
        ew.gt("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeGe(Object value) {
        ew.ge("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeLt(Object value) {
        ew.lt("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeLe(Object value) {
        ew.le("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeIn(Object... value) {
        ew.in("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeNotIn(Object... value) {
        ew.notIn("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeBetween(Object value, Object value1) {
        ew.between("charge_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition orChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("charge_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition andChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("charge_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition orChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("charge_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition andChargeModeLike(String value) {
        ew.like("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andChargeModeNotLike(String value) {
        ew.notLike("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition orChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("charge_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeIsNull() {
        ew.isNull("calculate_mode");
        return this;
    }

    public FeeTemplateCondition orCalculateModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("calculate_mode");
        return this;
    }

    public FeeTemplateCondition andCalculateModeIsNotNull() {
        ew.isNotNull("calculate_mode");
        return this;
    }

    public FeeTemplateCondition orCalculateModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("calculate_mode");
        return this;
    }

    public FeeTemplateCondition andCalculateModeEq(Object value) {
        ew.eq("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeNe(Object value) {
        ew.ne("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeGt(Object value) {
        ew.gt("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeGe(Object value) {
        ew.ge("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeLt(Object value) {
        ew.lt("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeLe(Object value) {
        ew.le("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeIn(Object... value) {
        ew.in("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeNotIn(Object... value) {
        ew.notIn("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeBetween(Object value, Object value1) {
        ew.between("calculate_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition orCalculateModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("calculate_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition andCalculateModeNotBetween(Object value, Object value1) {
        ew.notBetween("calculate_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition orCalculateModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("calculate_mode", value, value1);
        return this;
    }

    public FeeTemplateCondition andCalculateModeLike(String value) {
        ew.like("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andCalculateModeNotLike(String value) {
        ew.notLike("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition orCalculateModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("calculate_mode", value);
        return this;
    }

    public FeeTemplateCondition andFeeIsNull() {
        ew.isNull("fee");
        return this;
    }

    public FeeTemplateCondition orFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee");
        return this;
    }

    public FeeTemplateCondition andFeeIsNotNull() {
        ew.isNotNull("fee");
        return this;
    }

    public FeeTemplateCondition orFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee");
        return this;
    }

    public FeeTemplateCondition andFeeEq(Object value) {
        ew.eq("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeNe(Object value) {
        ew.ne("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeGt(Object value) {
        ew.gt("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeGe(Object value) {
        ew.ge("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeLt(Object value) {
        ew.lt("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeLe(Object value) {
        ew.le("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeIn(Object... value) {
        ew.in("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeNotIn(Object... value) {
        ew.notIn("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeBetween(Object value, Object value1) {
        ew.between("fee", value, value1);
        return this;
    }

    public FeeTemplateCondition orFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee", value, value1);
        return this;
    }

    public FeeTemplateCondition andFeeNotBetween(Object value, Object value1) {
        ew.notBetween("fee", value, value1);
        return this;
    }

    public FeeTemplateCondition orFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee", value, value1);
        return this;
    }

    public FeeTemplateCondition andFeeLike(String value) {
        ew.like("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee", value);
        return this;
    }

    public FeeTemplateCondition andFeeNotLike(String value) {
        ew.notLike("fee", value);
        return this;
    }

    public FeeTemplateCondition orFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeIsNull() {
        ew.isNull("min_fee");
        return this;
    }

    public FeeTemplateCondition orMinFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("min_fee");
        return this;
    }

    public FeeTemplateCondition andMinFeeIsNotNull() {
        ew.isNotNull("min_fee");
        return this;
    }

    public FeeTemplateCondition orMinFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("min_fee");
        return this;
    }

    public FeeTemplateCondition andMinFeeEq(Object value) {
        ew.eq("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeNe(Object value) {
        ew.ne("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeGt(Object value) {
        ew.gt("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeGe(Object value) {
        ew.ge("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeLt(Object value) {
        ew.lt("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeLe(Object value) {
        ew.le("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeIn(Object... value) {
        ew.in("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeNotIn(Object... value) {
        ew.notIn("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeBetween(Object value, Object value1) {
        ew.between("min_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition orMinFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("min_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition andMinFeeNotBetween(Object value, Object value1) {
        ew.notBetween("min_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition orMinFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("min_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition andMinFeeLike(String value) {
        ew.like("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMinFeeNotLike(String value) {
        ew.notLike("min_fee", value);
        return this;
    }

    public FeeTemplateCondition orMinFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("min_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeIsNull() {
        ew.isNull("max_fee");
        return this;
    }

    public FeeTemplateCondition orMaxFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("max_fee");
        return this;
    }

    public FeeTemplateCondition andMaxFeeIsNotNull() {
        ew.isNotNull("max_fee");
        return this;
    }

    public FeeTemplateCondition orMaxFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("max_fee");
        return this;
    }

    public FeeTemplateCondition andMaxFeeEq(Object value) {
        ew.eq("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeNe(Object value) {
        ew.ne("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeGt(Object value) {
        ew.gt("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeGe(Object value) {
        ew.ge("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeLt(Object value) {
        ew.lt("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeLe(Object value) {
        ew.le("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeIn(Object... value) {
        ew.in("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeNotIn(Object... value) {
        ew.notIn("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeBetween(Object value, Object value1) {
        ew.between("max_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition orMaxFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("max_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition andMaxFeeNotBetween(Object value, Object value1) {
        ew.notBetween("max_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition orMaxFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("max_fee", value, value1);
        return this;
    }

    public FeeTemplateCondition andMaxFeeLike(String value) {
        ew.like("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andMaxFeeNotLike(String value) {
        ew.notLike("max_fee", value);
        return this;
    }

    public FeeTemplateCondition orMaxFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("max_fee", value);
        return this;
    }

    public FeeTemplateCondition andContentIsNull() {
        ew.isNull("content");
        return this;
    }

    public FeeTemplateCondition orContentIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("content");
        return this;
    }

    public FeeTemplateCondition andContentIsNotNull() {
        ew.isNotNull("content");
        return this;
    }

    public FeeTemplateCondition orContentIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("content");
        return this;
    }

    public FeeTemplateCondition andContentEq(Object value) {
        ew.eq("content", value);
        return this;
    }

    public FeeTemplateCondition orContentEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("content", value);
        return this;
    }

    public FeeTemplateCondition andContentNe(Object value) {
        ew.ne("content", value);
        return this;
    }

    public FeeTemplateCondition orContentNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("content", value);
        return this;
    }

    public FeeTemplateCondition andContentGt(Object value) {
        ew.gt("content", value);
        return this;
    }

    public FeeTemplateCondition orContentGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("content", value);
        return this;
    }

    public FeeTemplateCondition andContentGe(Object value) {
        ew.ge("content", value);
        return this;
    }

    public FeeTemplateCondition orContentGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("content", value);
        return this;
    }

    public FeeTemplateCondition andContentLt(Object value) {
        ew.lt("content", value);
        return this;
    }

    public FeeTemplateCondition orContentLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("content", value);
        return this;
    }

    public FeeTemplateCondition andContentLe(Object value) {
        ew.le("content", value);
        return this;
    }

    public FeeTemplateCondition orContentLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("content", value);
        return this;
    }

    public FeeTemplateCondition andContentIn(Object... value) {
        ew.in("content", value);
        return this;
    }

    public FeeTemplateCondition orContentIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("content", value);
        return this;
    }

    public FeeTemplateCondition andContentNotIn(Object... value) {
        ew.notIn("content", value);
        return this;
    }

    public FeeTemplateCondition orContentNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("content", value);
        return this;
    }

    public FeeTemplateCondition andContentBetween(Object value, Object value1) {
        ew.between("content", value, value1);
        return this;
    }

    public FeeTemplateCondition orContentBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("content", value, value1);
        return this;
    }

    public FeeTemplateCondition andContentNotBetween(Object value, Object value1) {
        ew.notBetween("content", value, value1);
        return this;
    }

    public FeeTemplateCondition orContentNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("content", value, value1);
        return this;
    }

    public FeeTemplateCondition andContentLike(String value) {
        ew.like("content", value);
        return this;
    }

    public FeeTemplateCondition orContentLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("content", value);
        return this;
    }

    public FeeTemplateCondition andContentNotLike(String value) {
        ew.notLike("content", value);
        return this;
    }

    public FeeTemplateCondition orContentNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("content", value);
        return this;
    }

    public FeeTemplateCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public FeeTemplateCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public FeeTemplateCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public FeeTemplateCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public FeeTemplateCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public FeeTemplateCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public FeeTemplateCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public FeeTemplateCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public FeeTemplateCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public FeeTemplateCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public FeeTemplateCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }
}