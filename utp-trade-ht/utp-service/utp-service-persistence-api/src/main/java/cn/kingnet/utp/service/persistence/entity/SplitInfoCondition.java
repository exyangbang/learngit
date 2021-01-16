package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class SplitInfoCondition {
    private PlusEntityWrapper<SplitInfo> ew;

    public SplitInfoCondition() {
        this.ew = new PlusEntityWrapper(SplitInfo.class);
    }

    public static SplitInfoCondition builder() {
        return new SplitInfoCondition();
    }

    public PlusEntityWrapper<SplitInfo> build() {
        return this.ew;
    }

    public SplitInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public SplitInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(SplitInfo.class);
    }

    public SplitInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public SplitInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public SplitInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public SplitInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> SplitInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> SplitInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> SplitInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public SplitInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public SplitInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public SplitInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public SplitInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public SplitInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public SplitInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public SplitInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public SplitInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public SplitInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public SplitInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public SplitInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public SplitInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public SplitInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public SplitInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public SplitInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public SplitInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public SplitInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public SplitInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public SplitInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public SplitInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public SplitInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public SplitInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public SplitInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public SplitInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public SplitInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public SplitInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public SplitInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public SplitInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public SplitInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public SplitInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public SplitInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public SplitInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public SplitInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public SplitInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public SplitInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public SplitInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public SplitInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public SplitInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SplitInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SplitInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public SplitInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public SplitInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public SplitInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public SplitInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public SplitInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public SplitInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SplitInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SplitInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SplitInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SplitInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public SplitInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public SplitInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public SplitInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public SplitInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public SplitInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public SplitInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public SplitInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SplitInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SplitInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public SplitInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public SplitInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public SplitInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public SplitInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SplitInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SplitInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SplitInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SplitInfoCondition andSettleDateIsNull() {
        ew.isNull("settle_date");
        return this;
    }

    public SplitInfoCondition orSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_date");
        return this;
    }

    public SplitInfoCondition andSettleDateIsNotNull() {
        ew.isNotNull("settle_date");
        return this;
    }

    public SplitInfoCondition orSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_date");
        return this;
    }

    public SplitInfoCondition andSettleDateEq(Object value) {
        ew.eq("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateNe(Object value) {
        ew.ne("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateGt(Object value) {
        ew.gt("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateGe(Object value) {
        ew.ge("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateLt(Object value) {
        ew.lt("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateLe(Object value) {
        ew.le("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateIn(Object... value) {
        ew.in("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateNotIn(Object... value) {
        ew.notIn("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateBetween(Object value, Object value1) {
        ew.between("settle_date", value, value1);
        return this;
    }

    public SplitInfoCondition orSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_date", value, value1);
        return this;
    }

    public SplitInfoCondition andSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public SplitInfoCondition orSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public SplitInfoCondition andSettleDateLike(String value) {
        ew.like("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_date", value);
        return this;
    }

    public SplitInfoCondition andSettleDateNotLike(String value) {
        ew.notLike("settle_date", value);
        return this;
    }

    public SplitInfoCondition orSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_date", value);
        return this;
    }

    public SplitInfoCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public SplitInfoCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public SplitInfoCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public SplitInfoCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public SplitInfoCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public SplitInfoCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public SplitInfoCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public SplitInfoCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public SplitInfoCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public SplitInfoCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public SplitInfoCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public SplitInfoCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public SplitInfoCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public SplitInfoCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public SplitInfoCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public SplitInfoCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public SplitInfoCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public SplitInfoCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public SplitInfoCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public SplitInfoCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public SplitInfoCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public SplitInfoCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public SplitInfoCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public SplitInfoCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public SplitInfoCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public SplitInfoCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public SplitInfoCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public SplitInfoCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public SplitInfoCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public SplitInfoCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public SplitInfoCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public SplitInfoCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public SplitInfoCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public SplitInfoCondition andSplitDateIsNull() {
        ew.isNull("split_date");
        return this;
    }

    public SplitInfoCondition orSplitDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_date");
        return this;
    }

    public SplitInfoCondition andSplitDateIsNotNull() {
        ew.isNotNull("split_date");
        return this;
    }

    public SplitInfoCondition orSplitDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_date");
        return this;
    }

    public SplitInfoCondition andSplitDateEq(Object value) {
        ew.eq("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateNe(Object value) {
        ew.ne("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateGt(Object value) {
        ew.gt("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateGe(Object value) {
        ew.ge("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateLt(Object value) {
        ew.lt("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateLe(Object value) {
        ew.le("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateIn(Object... value) {
        ew.in("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateNotIn(Object... value) {
        ew.notIn("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateBetween(Object value, Object value1) {
        ew.between("split_date", value, value1);
        return this;
    }

    public SplitInfoCondition orSplitDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_date", value, value1);
        return this;
    }

    public SplitInfoCondition andSplitDateNotBetween(Object value, Object value1) {
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public SplitInfoCondition orSplitDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public SplitInfoCondition andSplitDateLike(String value) {
        ew.like("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_date", value);
        return this;
    }

    public SplitInfoCondition andSplitDateNotLike(String value) {
        ew.notLike("split_date", value);
        return this;
    }

    public SplitInfoCondition orSplitDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_date", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeIsNull() {
        ew.isNull("account_type");
        return this;
    }

    public SplitInfoCondition orAccountTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_type");
        return this;
    }

    public SplitInfoCondition andAccountTypeIsNotNull() {
        ew.isNotNull("account_type");
        return this;
    }

    public SplitInfoCondition orAccountTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_type");
        return this;
    }

    public SplitInfoCondition andAccountTypeEq(Object value) {
        ew.eq("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeNe(Object value) {
        ew.ne("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeGt(Object value) {
        ew.gt("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeGe(Object value) {
        ew.ge("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeLt(Object value) {
        ew.lt("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeLe(Object value) {
        ew.le("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeIn(Object... value) {
        ew.in("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeNotIn(Object... value) {
        ew.notIn("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeBetween(Object value, Object value1) {
        ew.between("account_type", value, value1);
        return this;
    }

    public SplitInfoCondition orAccountTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_type", value, value1);
        return this;
    }

    public SplitInfoCondition andAccountTypeNotBetween(Object value, Object value1) {
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public SplitInfoCondition orAccountTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public SplitInfoCondition andAccountTypeLike(String value) {
        ew.like("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountTypeNotLike(String value) {
        ew.notLike("account_type", value);
        return this;
    }

    public SplitInfoCondition orAccountTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_type", value);
        return this;
    }

    public SplitInfoCondition andAccountNoIsNull() {
        ew.isNull("account_no");
        return this;
    }

    public SplitInfoCondition orAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_no");
        return this;
    }

    public SplitInfoCondition andAccountNoIsNotNull() {
        ew.isNotNull("account_no");
        return this;
    }

    public SplitInfoCondition orAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_no");
        return this;
    }

    public SplitInfoCondition andAccountNoEq(Object value) {
        ew.eq("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoNe(Object value) {
        ew.ne("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoGt(Object value) {
        ew.gt("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoGe(Object value) {
        ew.ge("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoLt(Object value) {
        ew.lt("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoLe(Object value) {
        ew.le("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoIn(Object... value) {
        ew.in("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoNotIn(Object... value) {
        ew.notIn("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoBetween(Object value, Object value1) {
        ew.between("account_no", value, value1);
        return this;
    }

    public SplitInfoCondition orAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_no", value, value1);
        return this;
    }

    public SplitInfoCondition andAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public SplitInfoCondition orAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public SplitInfoCondition andAccountNoLike(String value) {
        ew.like("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNoNotLike(String value) {
        ew.notLike("account_no", value);
        return this;
    }

    public SplitInfoCondition orAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_no", value);
        return this;
    }

    public SplitInfoCondition andAccountNameIsNull() {
        ew.isNull("account_name");
        return this;
    }

    public SplitInfoCondition orAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_name");
        return this;
    }

    public SplitInfoCondition andAccountNameIsNotNull() {
        ew.isNotNull("account_name");
        return this;
    }

    public SplitInfoCondition orAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_name");
        return this;
    }

    public SplitInfoCondition andAccountNameEq(Object value) {
        ew.eq("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameNe(Object value) {
        ew.ne("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameGt(Object value) {
        ew.gt("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameGe(Object value) {
        ew.ge("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameLt(Object value) {
        ew.lt("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameLe(Object value) {
        ew.le("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameIn(Object... value) {
        ew.in("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameNotIn(Object... value) {
        ew.notIn("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameBetween(Object value, Object value1) {
        ew.between("account_name", value, value1);
        return this;
    }

    public SplitInfoCondition orAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_name", value, value1);
        return this;
    }

    public SplitInfoCondition andAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public SplitInfoCondition orAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public SplitInfoCondition andAccountNameLike(String value) {
        ew.like("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_name", value);
        return this;
    }

    public SplitInfoCondition andAccountNameNotLike(String value) {
        ew.notLike("account_name", value);
        return this;
    }

    public SplitInfoCondition orAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_name", value);
        return this;
    }

    public SplitInfoCondition andBankCodeIsNull() {
        ew.isNull("bank_code");
        return this;
    }

    public SplitInfoCondition orBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_code");
        return this;
    }

    public SplitInfoCondition andBankCodeIsNotNull() {
        ew.isNotNull("bank_code");
        return this;
    }

    public SplitInfoCondition orBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_code");
        return this;
    }

    public SplitInfoCondition andBankCodeEq(Object value) {
        ew.eq("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeNe(Object value) {
        ew.ne("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeGt(Object value) {
        ew.gt("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeGe(Object value) {
        ew.ge("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeLt(Object value) {
        ew.lt("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeLe(Object value) {
        ew.le("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeIn(Object... value) {
        ew.in("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeNotIn(Object... value) {
        ew.notIn("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeBetween(Object value, Object value1) {
        ew.between("bank_code", value, value1);
        return this;
    }

    public SplitInfoCondition orBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_code", value, value1);
        return this;
    }

    public SplitInfoCondition andBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public SplitInfoCondition orBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public SplitInfoCondition andBankCodeLike(String value) {
        ew.like("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_code", value);
        return this;
    }

    public SplitInfoCondition andBankCodeNotLike(String value) {
        ew.notLike("bank_code", value);
        return this;
    }

    public SplitInfoCondition orBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_code", value);
        return this;
    }

    public SplitInfoCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public SplitInfoCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public SplitInfoCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public SplitInfoCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public SplitInfoCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public SplitInfoCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public SplitInfoCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SplitInfoCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SplitInfoCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public SplitInfoCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public SplitInfoCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public SplitInfoCondition andExtend1IsNull() {
        ew.isNull("extend_1");
        return this;
    }

    public SplitInfoCondition orExtend1IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_1");
        return this;
    }

    public SplitInfoCondition andExtend1IsNotNull() {
        ew.isNotNull("extend_1");
        return this;
    }

    public SplitInfoCondition orExtend1IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_1");
        return this;
    }

    public SplitInfoCondition andExtend1Eq(Object value) {
        ew.eq("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1Ne(Object value) {
        ew.ne("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1Gt(Object value) {
        ew.gt("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1Ge(Object value) {
        ew.ge("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1Lt(Object value) {
        ew.lt("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1Le(Object value) {
        ew.le("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1In(Object... value) {
        ew.in("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1NotIn(Object... value) {
        ew.notIn("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1Between(Object value, Object value1) {
        ew.between("extend_1", value, value1);
        return this;
    }

    public SplitInfoCondition orExtend1Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_1", value, value1);
        return this;
    }

    public SplitInfoCondition andExtend1NotBetween(Object value, Object value1) {
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public SplitInfoCondition orExtend1NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public SplitInfoCondition andExtend1Like(String value) {
        ew.like("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend1NotLike(String value) {
        ew.notLike("extend_1", value);
        return this;
    }

    public SplitInfoCondition orExtend1NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_1", value);
        return this;
    }

    public SplitInfoCondition andExtend2IsNull() {
        ew.isNull("extend_2");
        return this;
    }

    public SplitInfoCondition orExtend2IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_2");
        return this;
    }

    public SplitInfoCondition andExtend2IsNotNull() {
        ew.isNotNull("extend_2");
        return this;
    }

    public SplitInfoCondition orExtend2IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_2");
        return this;
    }

    public SplitInfoCondition andExtend2Eq(Object value) {
        ew.eq("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2Ne(Object value) {
        ew.ne("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2Gt(Object value) {
        ew.gt("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2Ge(Object value) {
        ew.ge("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2Lt(Object value) {
        ew.lt("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2Le(Object value) {
        ew.le("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2In(Object... value) {
        ew.in("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2NotIn(Object... value) {
        ew.notIn("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2Between(Object value, Object value1) {
        ew.between("extend_2", value, value1);
        return this;
    }

    public SplitInfoCondition orExtend2Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_2", value, value1);
        return this;
    }

    public SplitInfoCondition andExtend2NotBetween(Object value, Object value1) {
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public SplitInfoCondition orExtend2NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public SplitInfoCondition andExtend2Like(String value) {
        ew.like("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend2NotLike(String value) {
        ew.notLike("extend_2", value);
        return this;
    }

    public SplitInfoCondition orExtend2NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_2", value);
        return this;
    }

    public SplitInfoCondition andExtend3IsNull() {
        ew.isNull("extend_3");
        return this;
    }

    public SplitInfoCondition orExtend3IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_3");
        return this;
    }

    public SplitInfoCondition andExtend3IsNotNull() {
        ew.isNotNull("extend_3");
        return this;
    }

    public SplitInfoCondition orExtend3IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_3");
        return this;
    }

    public SplitInfoCondition andExtend3Eq(Object value) {
        ew.eq("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3Ne(Object value) {
        ew.ne("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3Gt(Object value) {
        ew.gt("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3Ge(Object value) {
        ew.ge("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3Lt(Object value) {
        ew.lt("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3Le(Object value) {
        ew.le("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3In(Object... value) {
        ew.in("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3NotIn(Object... value) {
        ew.notIn("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3Between(Object value, Object value1) {
        ew.between("extend_3", value, value1);
        return this;
    }

    public SplitInfoCondition orExtend3Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_3", value, value1);
        return this;
    }

    public SplitInfoCondition andExtend3NotBetween(Object value, Object value1) {
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public SplitInfoCondition orExtend3NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public SplitInfoCondition andExtend3Like(String value) {
        ew.like("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_3", value);
        return this;
    }

    public SplitInfoCondition andExtend3NotLike(String value) {
        ew.notLike("extend_3", value);
        return this;
    }

    public SplitInfoCondition orExtend3NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_3", value);
        return this;
    }

    public SplitInfoCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public SplitInfoCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public SplitInfoCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public SplitInfoCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public SplitInfoCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public SplitInfoCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public SplitInfoCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public SplitInfoCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public SplitInfoCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public SplitInfoCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public SplitInfoCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public SplitInfoCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public SplitInfoCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public SplitInfoCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public SplitInfoCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public SplitInfoCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public SplitInfoCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public SplitInfoCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public SplitInfoCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public SplitInfoCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public SplitInfoCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public SplitInfoCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public SplitInfoCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public SplitInfoCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public SplitInfoCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public SplitInfoCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public SplitInfoCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public SplitInfoCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeIsNull() {
        ew.isNull("provider_code");
        return this;
    }

    public SplitInfoCondition orProviderCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("provider_code");
        return this;
    }

    public SplitInfoCondition andProviderCodeIsNotNull() {
        ew.isNotNull("provider_code");
        return this;
    }

    public SplitInfoCondition orProviderCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("provider_code");
        return this;
    }

    public SplitInfoCondition andProviderCodeEq(Object value) {
        ew.eq("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeNe(Object value) {
        ew.ne("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeGt(Object value) {
        ew.gt("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeGe(Object value) {
        ew.ge("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeLt(Object value) {
        ew.lt("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeLe(Object value) {
        ew.le("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeIn(Object... value) {
        ew.in("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeNotIn(Object... value) {
        ew.notIn("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeBetween(Object value, Object value1) {
        ew.between("provider_code", value, value1);
        return this;
    }

    public SplitInfoCondition orProviderCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("provider_code", value, value1);
        return this;
    }

    public SplitInfoCondition andProviderCodeNotBetween(Object value, Object value1) {
        ew.notBetween("provider_code", value, value1);
        return this;
    }

    public SplitInfoCondition orProviderCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("provider_code", value, value1);
        return this;
    }

    public SplitInfoCondition andProviderCodeLike(String value) {
        ew.like("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("provider_code", value);
        return this;
    }

    public SplitInfoCondition andProviderCodeNotLike(String value) {
        ew.notLike("provider_code", value);
        return this;
    }

    public SplitInfoCondition orProviderCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("provider_code", value);
        return this;
    }

    public SplitInfoCondition andBatchIdIsNull() {
        ew.isNull("batch_id");
        return this;
    }

    public SplitInfoCondition orBatchIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_id");
        return this;
    }

    public SplitInfoCondition andBatchIdIsNotNull() {
        ew.isNotNull("batch_id");
        return this;
    }

    public SplitInfoCondition orBatchIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_id");
        return this;
    }

    public SplitInfoCondition andBatchIdEq(Object value) {
        ew.eq("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdNe(Object value) {
        ew.ne("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdGt(Object value) {
        ew.gt("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdGe(Object value) {
        ew.ge("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdLt(Object value) {
        ew.lt("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdLe(Object value) {
        ew.le("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdIn(Object... value) {
        ew.in("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdNotIn(Object... value) {
        ew.notIn("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdBetween(Object value, Object value1) {
        ew.between("batch_id", value, value1);
        return this;
    }

    public SplitInfoCondition orBatchIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_id", value, value1);
        return this;
    }

    public SplitInfoCondition andBatchIdNotBetween(Object value, Object value1) {
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public SplitInfoCondition orBatchIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public SplitInfoCondition andBatchIdLike(String value) {
        ew.like("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_id", value);
        return this;
    }

    public SplitInfoCondition andBatchIdNotLike(String value) {
        ew.notLike("batch_id", value);
        return this;
    }

    public SplitInfoCondition orBatchIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_id", value);
        return this;
    }

    public SplitInfoCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public SplitInfoCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public SplitInfoCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public SplitInfoCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public SplitInfoCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public SplitInfoCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public SplitInfoCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SplitInfoCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SplitInfoCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public SplitInfoCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public SplitInfoCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public SplitInfoCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public SplitInfoCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public SplitInfoCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public SplitInfoCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public SplitInfoCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public SplitInfoCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public SplitInfoCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public SplitInfoCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public SplitInfoCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public SplitInfoCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public SplitInfoCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public SplitInfoCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public SplitInfoCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public SplitInfoCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public SplitInfoCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public SplitInfoCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SplitInfoCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SplitInfoCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public SplitInfoCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public SplitInfoCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesIsNull() {
        ew.isNull("query_times");
        return this;
    }

    public SplitInfoCondition orQueryTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("query_times");
        return this;
    }

    public SplitInfoCondition andQueryTimesIsNotNull() {
        ew.isNotNull("query_times");
        return this;
    }

    public SplitInfoCondition orQueryTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("query_times");
        return this;
    }

    public SplitInfoCondition andQueryTimesEq(Object value) {
        ew.eq("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesNe(Object value) {
        ew.ne("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesGt(Object value) {
        ew.gt("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesGe(Object value) {
        ew.ge("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesLt(Object value) {
        ew.lt("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesLe(Object value) {
        ew.le("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesIn(Object... value) {
        ew.in("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesNotIn(Object... value) {
        ew.notIn("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesBetween(Object value, Object value1) {
        ew.between("query_times", value, value1);
        return this;
    }

    public SplitInfoCondition orQueryTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("query_times", value, value1);
        return this;
    }

    public SplitInfoCondition andQueryTimesNotBetween(Object value, Object value1) {
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public SplitInfoCondition orQueryTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public SplitInfoCondition andQueryTimesLike(String value) {
        ew.like("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("query_times", value);
        return this;
    }

    public SplitInfoCondition andQueryTimesNotLike(String value) {
        ew.notLike("query_times", value);
        return this;
    }

    public SplitInfoCondition orQueryTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("query_times", value);
        return this;
    }

    public SplitInfoCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public SplitInfoCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public SplitInfoCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public SplitInfoCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public SplitInfoCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public SplitInfoCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public SplitInfoCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public SplitInfoCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public SplitInfoCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public SplitInfoCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public SplitInfoCondition andSubjectIsNull() {
        ew.isNull("subject");
        return this;
    }

    public SplitInfoCondition orSubjectIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("subject");
        return this;
    }

    public SplitInfoCondition andSubjectIsNotNull() {
        ew.isNotNull("subject");
        return this;
    }

    public SplitInfoCondition orSubjectIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("subject");
        return this;
    }

    public SplitInfoCondition andSubjectEq(Object value) {
        ew.eq("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectNe(Object value) {
        ew.ne("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectGt(Object value) {
        ew.gt("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectGe(Object value) {
        ew.ge("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectLt(Object value) {
        ew.lt("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectLe(Object value) {
        ew.le("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectIn(Object... value) {
        ew.in("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectNotIn(Object... value) {
        ew.notIn("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectBetween(Object value, Object value1) {
        ew.between("subject", value, value1);
        return this;
    }

    public SplitInfoCondition orSubjectBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("subject", value, value1);
        return this;
    }

    public SplitInfoCondition andSubjectNotBetween(Object value, Object value1) {
        ew.notBetween("subject", value, value1);
        return this;
    }

    public SplitInfoCondition orSubjectNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("subject", value, value1);
        return this;
    }

    public SplitInfoCondition andSubjectLike(String value) {
        ew.like("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("subject", value);
        return this;
    }

    public SplitInfoCondition andSubjectNotLike(String value) {
        ew.notLike("subject", value);
        return this;
    }

    public SplitInfoCondition orSubjectNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("subject", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public SplitInfoCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public SplitInfoCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public SplitInfoCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public SplitInfoCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public SplitInfoCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public SplitInfoCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public SplitInfoCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public SplitInfoCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public SplitInfoCondition andUserAccountIsNull() {
        ew.isNull("user_account");
        return this;
    }

    public SplitInfoCondition orUserAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_account");
        return this;
    }

    public SplitInfoCondition andUserAccountIsNotNull() {
        ew.isNotNull("user_account");
        return this;
    }

    public SplitInfoCondition orUserAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_account");
        return this;
    }

    public SplitInfoCondition andUserAccountEq(Object value) {
        ew.eq("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountNe(Object value) {
        ew.ne("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountGt(Object value) {
        ew.gt("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountGe(Object value) {
        ew.ge("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountLt(Object value) {
        ew.lt("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountLe(Object value) {
        ew.le("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountIn(Object... value) {
        ew.in("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountNotIn(Object... value) {
        ew.notIn("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountBetween(Object value, Object value1) {
        ew.between("user_account", value, value1);
        return this;
    }

    public SplitInfoCondition orUserAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_account", value, value1);
        return this;
    }

    public SplitInfoCondition andUserAccountNotBetween(Object value, Object value1) {
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public SplitInfoCondition orUserAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public SplitInfoCondition andUserAccountLike(String value) {
        ew.like("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_account", value);
        return this;
    }

    public SplitInfoCondition andUserAccountNotLike(String value) {
        ew.notLike("user_account", value);
        return this;
    }

    public SplitInfoCondition orUserAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_account", value);
        return this;
    }

    public SplitInfoCondition andSettleModeIsNull() {
        ew.isNull("settle_mode");
        return this;
    }

    public SplitInfoCondition orSettleModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_mode");
        return this;
    }

    public SplitInfoCondition andSettleModeIsNotNull() {
        ew.isNotNull("settle_mode");
        return this;
    }

    public SplitInfoCondition orSettleModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_mode");
        return this;
    }

    public SplitInfoCondition andSettleModeEq(Object value) {
        ew.eq("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeNe(Object value) {
        ew.ne("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeGt(Object value) {
        ew.gt("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeGe(Object value) {
        ew.ge("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeLt(Object value) {
        ew.lt("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeLe(Object value) {
        ew.le("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeIn(Object... value) {
        ew.in("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeNotIn(Object... value) {
        ew.notIn("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeBetween(Object value, Object value1) {
        ew.between("settle_mode", value, value1);
        return this;
    }

    public SplitInfoCondition orSettleModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_mode", value, value1);
        return this;
    }

    public SplitInfoCondition andSettleModeNotBetween(Object value, Object value1) {
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public SplitInfoCondition orSettleModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public SplitInfoCondition andSettleModeLike(String value) {
        ew.like("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andSettleModeNotLike(String value) {
        ew.notLike("settle_mode", value);
        return this;
    }

    public SplitInfoCondition orSettleModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_mode", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public SplitInfoCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public SplitInfoCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public SplitInfoCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public SplitInfoCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public SplitInfoCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public SplitInfoCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SplitInfoCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SplitInfoCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public SplitInfoCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public SplitInfoCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }
}