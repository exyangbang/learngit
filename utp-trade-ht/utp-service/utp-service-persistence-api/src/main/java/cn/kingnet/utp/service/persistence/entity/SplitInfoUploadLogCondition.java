package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class SplitInfoUploadLogCondition {
    private PlusEntityWrapper<SplitInfoUploadLog> ew;

    public SplitInfoUploadLogCondition() {
        this.ew = new PlusEntityWrapper(SplitInfoUploadLog.class);
    }

    public static SplitInfoUploadLogCondition builder() {
        return new SplitInfoUploadLogCondition();
    }

    public PlusEntityWrapper<SplitInfoUploadLog> build() {
        return this.ew;
    }

    public SplitInfoUploadLogCondition or() {
        this.ew.orNew();
        return this;
    }

    public SplitInfoUploadLogCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(SplitInfoUploadLog.class);
    }

    public SplitInfoUploadLogCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public SplitInfoUploadLogCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public SplitInfoUploadLogCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public SplitInfoUploadLogCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> SplitInfoUploadLogCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> SplitInfoUploadLogCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> SplitInfoUploadLogCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public SplitInfoUploadLogCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public SplitInfoUploadLogCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public SplitInfoUploadLogCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public SplitInfoUploadLogCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public SplitInfoUploadLogCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public SplitInfoUploadLogCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public SplitInfoUploadLogCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public SplitInfoUploadLogCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeIsNull() {
        ew.isNull("provider_code");
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("provider_code");
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeIsNotNull() {
        ew.isNotNull("provider_code");
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("provider_code");
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeEq(Object value) {
        ew.eq("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeNe(Object value) {
        ew.ne("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeGt(Object value) {
        ew.gt("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeGe(Object value) {
        ew.ge("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeLt(Object value) {
        ew.lt("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeLe(Object value) {
        ew.le("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeIn(Object... value) {
        ew.in("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeNotIn(Object... value) {
        ew.notIn("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeBetween(Object value, Object value1) {
        ew.between("provider_code", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("provider_code", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeNotBetween(Object value, Object value1) {
        ew.notBetween("provider_code", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("provider_code", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeLike(String value) {
        ew.like("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andProviderCodeNotLike(String value) {
        ew.notLike("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition orProviderCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("provider_code", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateIsNull() {
        ew.isNull("settle_date");
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_date");
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateIsNotNull() {
        ew.isNotNull("settle_date");
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_date");
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateEq(Object value) {
        ew.eq("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateNe(Object value) {
        ew.ne("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateGt(Object value) {
        ew.gt("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateGe(Object value) {
        ew.ge("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateLt(Object value) {
        ew.lt("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateLe(Object value) {
        ew.le("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateIn(Object... value) {
        ew.in("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateNotIn(Object... value) {
        ew.notIn("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateBetween(Object value, Object value1) {
        ew.between("settle_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateLike(String value) {
        ew.like("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andSettleDateNotLike(String value) {
        ew.notLike("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdIsNull() {
        ew.isNull("batch_id");
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_id");
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdIsNotNull() {
        ew.isNotNull("batch_id");
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_id");
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdEq(Object value) {
        ew.eq("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdNe(Object value) {
        ew.ne("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdGt(Object value) {
        ew.gt("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdGe(Object value) {
        ew.ge("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdLt(Object value) {
        ew.lt("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdLe(Object value) {
        ew.le("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdIn(Object... value) {
        ew.in("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdNotIn(Object... value) {
        ew.notIn("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdBetween(Object value, Object value1) {
        ew.between("batch_id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdNotBetween(Object value, Object value1) {
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdLike(String value) {
        ew.like("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andBatchIdNotLike(String value) {
        ew.notLike("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition orBatchIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_id", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountIsNull() {
        ew.isNull("count");
        return this;
    }

    public SplitInfoUploadLogCondition orCountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("count");
        return this;
    }

    public SplitInfoUploadLogCondition andCountIsNotNull() {
        ew.isNotNull("count");
        return this;
    }

    public SplitInfoUploadLogCondition orCountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("count");
        return this;
    }

    public SplitInfoUploadLogCondition andCountEq(Object value) {
        ew.eq("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountNe(Object value) {
        ew.ne("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountGt(Object value) {
        ew.gt("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountGe(Object value) {
        ew.ge("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountLt(Object value) {
        ew.lt("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountLe(Object value) {
        ew.le("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountIn(Object... value) {
        ew.in("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountNotIn(Object... value) {
        ew.notIn("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountBetween(Object value, Object value1) {
        ew.between("count", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orCountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("count", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andCountNotBetween(Object value, Object value1) {
        ew.notBetween("count", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orCountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("count", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andCountLike(String value) {
        ew.like("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCountNotLike(String value) {
        ew.notLike("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("count", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlIsNull() {
        ew.isNull("callback_url");
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_url");
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlIsNotNull() {
        ew.isNotNull("callback_url");
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_url");
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlEq(Object value) {
        ew.eq("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlNe(Object value) {
        ew.ne("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlGt(Object value) {
        ew.gt("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlGe(Object value) {
        ew.ge("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlLt(Object value) {
        ew.lt("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlLe(Object value) {
        ew.le("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlIn(Object... value) {
        ew.in("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlNotIn(Object... value) {
        ew.notIn("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlBetween(Object value, Object value1) {
        ew.between("callback_url", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_url", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlLike(String value) {
        ew.like("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackUrlNotLike(String value) {
        ew.notLike("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_url", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesIsNull() {
        ew.isNull("callback_times");
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_times");
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesIsNotNull() {
        ew.isNotNull("callback_times");
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_times");
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesEq(Object value) {
        ew.eq("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesNe(Object value) {
        ew.ne("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesGt(Object value) {
        ew.gt("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesGe(Object value) {
        ew.ge("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesLt(Object value) {
        ew.lt("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesLe(Object value) {
        ew.le("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesIn(Object... value) {
        ew.in("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesNotIn(Object... value) {
        ew.notIn("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesBetween(Object value, Object value1) {
        ew.between("callback_times", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_times", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesNotBetween(Object value, Object value1) {
        ew.notBetween("callback_times", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_times", value, value1);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesLike(String value) {
        ew.like("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition andCallbackTimesNotLike(String value) {
        ew.notLike("callback_times", value);
        return this;
    }

    public SplitInfoUploadLogCondition orCallbackTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_times", value);
        return this;
    }
}