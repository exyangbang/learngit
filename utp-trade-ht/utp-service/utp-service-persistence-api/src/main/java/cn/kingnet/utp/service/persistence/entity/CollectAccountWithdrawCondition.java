package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class CollectAccountWithdrawCondition {
    private PlusEntityWrapper<CollectAccountWithdraw> ew;

    public CollectAccountWithdrawCondition() {
        this.ew = new PlusEntityWrapper(CollectAccountWithdraw.class);
    }

    public static CollectAccountWithdrawCondition builder() {
        return new CollectAccountWithdrawCondition();
    }

    public PlusEntityWrapper<CollectAccountWithdraw> build() {
        return this.ew;
    }

    public CollectAccountWithdrawCondition or() {
        this.ew.orNew();
        return this;
    }

    public CollectAccountWithdrawCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(CollectAccountWithdraw.class);
    }

    public CollectAccountWithdrawCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public CollectAccountWithdrawCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public CollectAccountWithdrawCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public CollectAccountWithdrawCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> CollectAccountWithdrawCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> CollectAccountWithdrawCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> CollectAccountWithdrawCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public CollectAccountWithdrawCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public CollectAccountWithdrawCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public CollectAccountWithdrawCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public CollectAccountWithdrawCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public CollectAccountWithdrawCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public CollectAccountWithdrawCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public CollectAccountWithdrawCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public CollectAccountWithdrawCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameIsNull() {
        ew.isNull("industry_name");
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_name");
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameIsNotNull() {
        ew.isNotNull("industry_name");
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_name");
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameEq(Object value) {
        ew.eq("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameNe(Object value) {
        ew.ne("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameGt(Object value) {
        ew.gt("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameGe(Object value) {
        ew.ge("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameLt(Object value) {
        ew.lt("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameLe(Object value) {
        ew.le("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameIn(Object... value) {
        ew.in("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameNotIn(Object... value) {
        ew.notIn("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameBetween(Object value, Object value1) {
        ew.between("industry_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameNotBetween(Object value, Object value1) {
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameLike(String value) {
        ew.like("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andIndustryNameNotLike(String value) {
        ew.notLike("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orIndustryNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public CollectAccountWithdrawCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public CollectAccountWithdrawCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public CollectAccountWithdrawCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public CollectAccountWithdrawCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public CollectAccountWithdrawCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public CollectAccountWithdrawCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public CollectAccountWithdrawCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public CollectAccountWithdrawCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoIsNull() {
        ew.isNull("recive_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("recive_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoIsNotNull() {
        ew.isNotNull("recive_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("recive_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoEq(Object value) {
        ew.eq("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoNe(Object value) {
        ew.ne("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoGt(Object value) {
        ew.gt("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoGe(Object value) {
        ew.ge("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoLt(Object value) {
        ew.lt("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoLe(Object value) {
        ew.le("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoIn(Object... value) {
        ew.in("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoNotIn(Object... value) {
        ew.notIn("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoBetween(Object value, Object value1) {
        ew.between("recive_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("recive_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("recive_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("recive_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoLike(String value) {
        ew.like("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNoNotLike(String value) {
        ew.notLike("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("recive_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameIsNull() {
        ew.isNull("recive_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("recive_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameIsNotNull() {
        ew.isNotNull("recive_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("recive_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameEq(Object value) {
        ew.eq("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameNe(Object value) {
        ew.ne("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameGt(Object value) {
        ew.gt("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameGe(Object value) {
        ew.ge("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameLt(Object value) {
        ew.lt("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameLe(Object value) {
        ew.le("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameIn(Object... value) {
        ew.in("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameNotIn(Object... value) {
        ew.notIn("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameBetween(Object value, Object value1) {
        ew.between("recive_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("recive_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("recive_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("recive_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameLike(String value) {
        ew.like("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveAccountNameNotLike(String value) {
        ew.notLike("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("recive_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusIsNull() {
        ew.isNull("audit_status");
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("audit_status");
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusIsNotNull() {
        ew.isNotNull("audit_status");
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("audit_status");
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusEq(Object value) {
        ew.eq("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusNe(Object value) {
        ew.ne("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusGt(Object value) {
        ew.gt("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusGe(Object value) {
        ew.ge("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusLt(Object value) {
        ew.lt("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusLe(Object value) {
        ew.le("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusIn(Object... value) {
        ew.in("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusNotIn(Object... value) {
        ew.notIn("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusBetween(Object value, Object value1) {
        ew.between("audit_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("audit_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusNotBetween(Object value, Object value1) {
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusLike(String value) {
        ew.like("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andAuditStatusNotLike(String value) {
        ew.notLike("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orAuditStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("audit_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public CollectAccountWithdrawCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public CollectAccountWithdrawCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public CollectAccountWithdrawCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public CollectAccountWithdrawCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateIsNull() {
        ew.isNull("req_date");
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_date");
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateIsNotNull() {
        ew.isNotNull("req_date");
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_date");
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateEq(Object value) {
        ew.eq("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateNe(Object value) {
        ew.ne("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateGt(Object value) {
        ew.gt("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateGe(Object value) {
        ew.ge("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateLt(Object value) {
        ew.lt("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateLe(Object value) {
        ew.le("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateIn(Object... value) {
        ew.in("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateNotIn(Object... value) {
        ew.notIn("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateBetween(Object value, Object value1) {
        ew.between("req_date", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_date", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateNotBetween(Object value, Object value1) {
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateLike(String value) {
        ew.like("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqDateNotLike(String value) {
        ew.notLike("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_date", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeIsNull() {
        ew.isNull("req_time");
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_time");
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeIsNotNull() {
        ew.isNotNull("req_time");
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_time");
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeEq(Object value) {
        ew.eq("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeNe(Object value) {
        ew.ne("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeGt(Object value) {
        ew.gt("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeGe(Object value) {
        ew.ge("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeLt(Object value) {
        ew.lt("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeLe(Object value) {
        ew.le("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeIn(Object... value) {
        ew.in("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeNotIn(Object... value) {
        ew.notIn("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeBetween(Object value, Object value1) {
        ew.between("req_time", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_time", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeNotBetween(Object value, Object value1) {
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeLike(String value) {
        ew.like("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReqTimeNotLike(String value) {
        ew.notLike("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReqTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_time", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeIsNull() {
        ew.isNull("recive_op_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("recive_op_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeIsNotNull() {
        ew.isNotNull("recive_op_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("recive_op_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeEq(Object value) {
        ew.eq("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeNe(Object value) {
        ew.ne("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeGt(Object value) {
        ew.gt("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeGe(Object value) {
        ew.ge("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeLt(Object value) {
        ew.lt("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeLe(Object value) {
        ew.le("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeIn(Object... value) {
        ew.in("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeNotIn(Object... value) {
        ew.notIn("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeBetween(Object value, Object value1) {
        ew.between("recive_op_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("recive_op_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("recive_op_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("recive_op_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeLike(String value) {
        ew.like("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankCodeNotLike(String value) {
        ew.notLike("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("recive_op_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameIsNull() {
        ew.isNull("recive_op_bank_name");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("recive_op_bank_name");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameIsNotNull() {
        ew.isNotNull("recive_op_bank_name");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("recive_op_bank_name");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameEq(Object value) {
        ew.eq("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameNe(Object value) {
        ew.ne("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameGt(Object value) {
        ew.gt("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameGe(Object value) {
        ew.ge("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameLt(Object value) {
        ew.lt("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameLe(Object value) {
        ew.le("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameIn(Object... value) {
        ew.in("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameNotIn(Object... value) {
        ew.notIn("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameBetween(Object value, Object value1) {
        ew.between("recive_op_bank_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("recive_op_bank_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("recive_op_bank_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("recive_op_bank_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameLike(String value) {
        ew.like("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveOpBankNameNotLike(String value) {
        ew.notLike("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveOpBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("recive_op_bank_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeIsNull() {
        ew.isNull("recive_cl_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("recive_cl_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeIsNotNull() {
        ew.isNotNull("recive_cl_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("recive_cl_bank_code");
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeEq(Object value) {
        ew.eq("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeNe(Object value) {
        ew.ne("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeGt(Object value) {
        ew.gt("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeGe(Object value) {
        ew.ge("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeLt(Object value) {
        ew.lt("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeLe(Object value) {
        ew.le("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeIn(Object... value) {
        ew.in("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeNotIn(Object... value) {
        ew.notIn("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeBetween(Object value, Object value1) {
        ew.between("recive_cl_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("recive_cl_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("recive_cl_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("recive_cl_bank_code", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeLike(String value) {
        ew.like("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andReciveClBankCodeNotLike(String value) {
        ew.notLike("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition orReciveClBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("recive_cl_bank_code", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoIsNull() {
        ew.isNull("fund_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fund_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoIsNotNull() {
        ew.isNotNull("fund_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fund_account_no");
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoEq(Object value) {
        ew.eq("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoNe(Object value) {
        ew.ne("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoGt(Object value) {
        ew.gt("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoGe(Object value) {
        ew.ge("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoLt(Object value) {
        ew.lt("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoLe(Object value) {
        ew.le("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoIn(Object... value) {
        ew.in("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoNotIn(Object... value) {
        ew.notIn("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoBetween(Object value, Object value1) {
        ew.between("fund_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fund_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("fund_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fund_account_no", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoLike(String value) {
        ew.like("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNoNotLike(String value) {
        ew.notLike("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fund_account_no", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameIsNull() {
        ew.isNull("fund_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fund_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameIsNotNull() {
        ew.isNotNull("fund_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fund_account_name");
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameEq(Object value) {
        ew.eq("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameNe(Object value) {
        ew.ne("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameGt(Object value) {
        ew.gt("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameGe(Object value) {
        ew.ge("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameLt(Object value) {
        ew.lt("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameLe(Object value) {
        ew.le("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameIn(Object... value) {
        ew.in("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameNotIn(Object... value) {
        ew.notIn("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameBetween(Object value, Object value1) {
        ew.between("fund_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fund_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("fund_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fund_account_name", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameLike(String value) {
        ew.like("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andFundAccountNameNotLike(String value) {
        ew.notLike("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition orFundAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fund_account_name", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public CollectAccountWithdrawCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }
}