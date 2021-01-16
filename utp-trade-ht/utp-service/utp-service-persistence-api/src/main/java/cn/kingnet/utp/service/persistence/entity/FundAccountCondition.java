package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class FundAccountCondition {
    private PlusEntityWrapper<FundAccount> ew;

    public FundAccountCondition() {
        this.ew = new PlusEntityWrapper(FundAccount.class);
    }

    public static FundAccountCondition builder() {
        return new FundAccountCondition();
    }

    public PlusEntityWrapper<FundAccount> build() {
        return this.ew;
    }

    public FundAccountCondition or() {
        this.ew.orNew();
        return this;
    }

    public FundAccountCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(FundAccount.class);
    }

    public FundAccountCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public FundAccountCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public FundAccountCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public FundAccountCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> FundAccountCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> FundAccountCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> FundAccountCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public FundAccountCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public FundAccountCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public FundAccountCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public FundAccountCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public FundAccountCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public FundAccountCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public FundAccountCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public FundAccountCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public FundAccountCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public FundAccountCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public FundAccountCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public FundAccountCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public FundAccountCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public FundAccountCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public FundAccountCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public FundAccountCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public FundAccountCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public FundAccountCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public FundAccountCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public FundAccountCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public FundAccountCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public FundAccountCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public FundAccountCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public FundAccountCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public FundAccountCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public FundAccountCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public FundAccountCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public FundAccountCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public FundAccountCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public FundAccountCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public FundAccountCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public FundAccountCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public FundAccountCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public FundAccountCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public FundAccountCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public FundAccountCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public FundAccountCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public FundAccountCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FundAccountCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FundAccountCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public FundAccountCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public FundAccountCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public FundAccountCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public FundAccountCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public FundAccountCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public FundAccountCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FundAccountCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FundAccountCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FundAccountCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FundAccountCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public FundAccountCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public FundAccountCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public FundAccountCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public FundAccountCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public FundAccountCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public FundAccountCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public FundAccountCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public FundAccountCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public FundAccountCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FundAccountCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FundAccountCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public FundAccountCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public FundAccountCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public FundAccountCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public FundAccountCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FundAccountCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FundAccountCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FundAccountCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FundAccountCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FundAccountCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FundAccountCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FundAccountCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FundAccountCondition andAccountNumIsNull() {
        ew.isNull("account_num");
        return this;
    }

    public FundAccountCondition orAccountNumIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_num");
        return this;
    }

    public FundAccountCondition andAccountNumIsNotNull() {
        ew.isNotNull("account_num");
        return this;
    }

    public FundAccountCondition orAccountNumIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_num");
        return this;
    }

    public FundAccountCondition andAccountNumEq(Object value) {
        ew.eq("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumNe(Object value) {
        ew.ne("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumGt(Object value) {
        ew.gt("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumGe(Object value) {
        ew.ge("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumLt(Object value) {
        ew.lt("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumLe(Object value) {
        ew.le("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumIn(Object... value) {
        ew.in("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumNotIn(Object... value) {
        ew.notIn("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumBetween(Object value, Object value1) {
        ew.between("account_num", value, value1);
        return this;
    }

    public FundAccountCondition orAccountNumBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_num", value, value1);
        return this;
    }

    public FundAccountCondition andAccountNumNotBetween(Object value, Object value1) {
        ew.notBetween("account_num", value, value1);
        return this;
    }

    public FundAccountCondition orAccountNumNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_num", value, value1);
        return this;
    }

    public FundAccountCondition andAccountNumLike(String value) {
        ew.like("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_num", value);
        return this;
    }

    public FundAccountCondition andAccountNumNotLike(String value) {
        ew.notLike("account_num", value);
        return this;
    }

    public FundAccountCondition orAccountNumNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_num", value);
        return this;
    }

    public FundAccountCondition andBankCodeIsNull() {
        ew.isNull("bank_code");
        return this;
    }

    public FundAccountCondition orBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_code");
        return this;
    }

    public FundAccountCondition andBankCodeIsNotNull() {
        ew.isNotNull("bank_code");
        return this;
    }

    public FundAccountCondition orBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_code");
        return this;
    }

    public FundAccountCondition andBankCodeEq(Object value) {
        ew.eq("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeNe(Object value) {
        ew.ne("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeGt(Object value) {
        ew.gt("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeGe(Object value) {
        ew.ge("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeLt(Object value) {
        ew.lt("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeLe(Object value) {
        ew.le("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeIn(Object... value) {
        ew.in("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeNotIn(Object... value) {
        ew.notIn("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeBetween(Object value, Object value1) {
        ew.between("bank_code", value, value1);
        return this;
    }

    public FundAccountCondition orBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_code", value, value1);
        return this;
    }

    public FundAccountCondition andBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public FundAccountCondition orBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public FundAccountCondition andBankCodeLike(String value) {
        ew.like("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_code", value);
        return this;
    }

    public FundAccountCondition andBankCodeNotLike(String value) {
        ew.notLike("bank_code", value);
        return this;
    }

    public FundAccountCondition orBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_code", value);
        return this;
    }

    public FundAccountCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public FundAccountCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public FundAccountCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public FundAccountCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public FundAccountCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public FundAccountCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public FundAccountCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public FundAccountCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public FundAccountCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public FundAccountCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public FundAccountCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public FundAccountCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public FundAccountCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public FundAccountCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public FundAccountCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public FundAccountCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public FundAccountCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public FundAccountCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public FundAccountCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public FundAccountCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public FundAccountCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public FundAccountCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public FundAccountCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public FundAccountCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public FundAccountCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public FundAccountCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public FundAccountCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public FundAccountCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoIsNull() {
        ew.isNull("bank_account_no");
        return this;
    }

    public FundAccountCondition orBankAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_account_no");
        return this;
    }

    public FundAccountCondition andBankAccountNoIsNotNull() {
        ew.isNotNull("bank_account_no");
        return this;
    }

    public FundAccountCondition orBankAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_account_no");
        return this;
    }

    public FundAccountCondition andBankAccountNoEq(Object value) {
        ew.eq("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoNe(Object value) {
        ew.ne("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoGt(Object value) {
        ew.gt("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoGe(Object value) {
        ew.ge("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoLt(Object value) {
        ew.lt("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoLe(Object value) {
        ew.le("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoIn(Object... value) {
        ew.in("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoNotIn(Object... value) {
        ew.notIn("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoBetween(Object value, Object value1) {
        ew.between("bank_account_no", value, value1);
        return this;
    }

    public FundAccountCondition orBankAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_account_no", value, value1);
        return this;
    }

    public FundAccountCondition andBankAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("bank_account_no", value, value1);
        return this;
    }

    public FundAccountCondition orBankAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_account_no", value, value1);
        return this;
    }

    public FundAccountCondition andBankAccountNoLike(String value) {
        ew.like("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNoNotLike(String value) {
        ew.notLike("bank_account_no", value);
        return this;
    }

    public FundAccountCondition orBankAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_account_no", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameIsNull() {
        ew.isNull("bank_account_name");
        return this;
    }

    public FundAccountCondition orBankAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_account_name");
        return this;
    }

    public FundAccountCondition andBankAccountNameIsNotNull() {
        ew.isNotNull("bank_account_name");
        return this;
    }

    public FundAccountCondition orBankAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_account_name");
        return this;
    }

    public FundAccountCondition andBankAccountNameEq(Object value) {
        ew.eq("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameNe(Object value) {
        ew.ne("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameGt(Object value) {
        ew.gt("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameGe(Object value) {
        ew.ge("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameLt(Object value) {
        ew.lt("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameLe(Object value) {
        ew.le("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameIn(Object... value) {
        ew.in("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameNotIn(Object... value) {
        ew.notIn("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameBetween(Object value, Object value1) {
        ew.between("bank_account_name", value, value1);
        return this;
    }

    public FundAccountCondition orBankAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_account_name", value, value1);
        return this;
    }

    public FundAccountCondition andBankAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("bank_account_name", value, value1);
        return this;
    }

    public FundAccountCondition orBankAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_account_name", value, value1);
        return this;
    }

    public FundAccountCondition andBankAccountNameLike(String value) {
        ew.like("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andBankAccountNameNotLike(String value) {
        ew.notLike("bank_account_name", value);
        return this;
    }

    public FundAccountCondition orBankAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_account_name", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeIsNull() {
        ew.isNull("synchronization_time");
        return this;
    }

    public FundAccountCondition orSynchronizationTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("synchronization_time");
        return this;
    }

    public FundAccountCondition andSynchronizationTimeIsNotNull() {
        ew.isNotNull("synchronization_time");
        return this;
    }

    public FundAccountCondition orSynchronizationTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("synchronization_time");
        return this;
    }

    public FundAccountCondition andSynchronizationTimeEq(Object value) {
        ew.eq("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeNe(Object value) {
        ew.ne("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeGt(Object value) {
        ew.gt("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeGe(Object value) {
        ew.ge("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeLt(Object value) {
        ew.lt("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeLe(Object value) {
        ew.le("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeIn(Object... value) {
        ew.in("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeNotIn(Object... value) {
        ew.notIn("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeBetween(Object value, Object value1) {
        ew.between("synchronization_time", value, value1);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("synchronization_time", value, value1);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeNotBetween(Object value, Object value1) {
        ew.notBetween("synchronization_time", value, value1);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("synchronization_time", value, value1);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeLike(String value) {
        ew.like("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andSynchronizationTimeNotLike(String value) {
        ew.notLike("synchronization_time", value);
        return this;
    }

    public FundAccountCondition orSynchronizationTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("synchronization_time", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceIsNull() {
        ew.isNull("current_balance");
        return this;
    }

    public FundAccountCondition orCurrentBalanceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("current_balance");
        return this;
    }

    public FundAccountCondition andCurrentBalanceIsNotNull() {
        ew.isNotNull("current_balance");
        return this;
    }

    public FundAccountCondition orCurrentBalanceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("current_balance");
        return this;
    }

    public FundAccountCondition andCurrentBalanceEq(Object value) {
        ew.eq("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceNe(Object value) {
        ew.ne("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceGt(Object value) {
        ew.gt("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceGe(Object value) {
        ew.ge("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceLt(Object value) {
        ew.lt("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceLe(Object value) {
        ew.le("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceIn(Object... value) {
        ew.in("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceNotIn(Object... value) {
        ew.notIn("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceBetween(Object value, Object value1) {
        ew.between("current_balance", value, value1);
        return this;
    }

    public FundAccountCondition orCurrentBalanceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("current_balance", value, value1);
        return this;
    }

    public FundAccountCondition andCurrentBalanceNotBetween(Object value, Object value1) {
        ew.notBetween("current_balance", value, value1);
        return this;
    }

    public FundAccountCondition orCurrentBalanceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("current_balance", value, value1);
        return this;
    }

    public FundAccountCondition andCurrentBalanceLike(String value) {
        ew.like("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("current_balance", value);
        return this;
    }

    public FundAccountCondition andCurrentBalanceNotLike(String value) {
        ew.notLike("current_balance", value);
        return this;
    }

    public FundAccountCondition orCurrentBalanceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("current_balance", value);
        return this;
    }

    public FundAccountCondition andAccountTypeIsNull() {
        ew.isNull("account_type");
        return this;
    }

    public FundAccountCondition orAccountTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_type");
        return this;
    }

    public FundAccountCondition andAccountTypeIsNotNull() {
        ew.isNotNull("account_type");
        return this;
    }

    public FundAccountCondition orAccountTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_type");
        return this;
    }

    public FundAccountCondition andAccountTypeEq(Object value) {
        ew.eq("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeNe(Object value) {
        ew.ne("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeGt(Object value) {
        ew.gt("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeGe(Object value) {
        ew.ge("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeLt(Object value) {
        ew.lt("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeLe(Object value) {
        ew.le("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeIn(Object... value) {
        ew.in("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeNotIn(Object... value) {
        ew.notIn("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeBetween(Object value, Object value1) {
        ew.between("account_type", value, value1);
        return this;
    }

    public FundAccountCondition orAccountTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_type", value, value1);
        return this;
    }

    public FundAccountCondition andAccountTypeNotBetween(Object value, Object value1) {
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public FundAccountCondition orAccountTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public FundAccountCondition andAccountTypeLike(String value) {
        ew.like("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_type", value);
        return this;
    }

    public FundAccountCondition andAccountTypeNotLike(String value) {
        ew.notLike("account_type", value);
        return this;
    }

    public FundAccountCondition orAccountTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeIsNull() {
        ew.isNull("use_type");
        return this;
    }

    public FundAccountCondition orUseTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("use_type");
        return this;
    }

    public FundAccountCondition andUseTypeIsNotNull() {
        ew.isNotNull("use_type");
        return this;
    }

    public FundAccountCondition orUseTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("use_type");
        return this;
    }

    public FundAccountCondition andUseTypeEq(Object value) {
        ew.eq("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeNe(Object value) {
        ew.ne("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeGt(Object value) {
        ew.gt("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeGe(Object value) {
        ew.ge("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeLt(Object value) {
        ew.lt("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeLe(Object value) {
        ew.le("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeIn(Object... value) {
        ew.in("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeNotIn(Object... value) {
        ew.notIn("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeBetween(Object value, Object value1) {
        ew.between("use_type", value, value1);
        return this;
    }

    public FundAccountCondition orUseTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("use_type", value, value1);
        return this;
    }

    public FundAccountCondition andUseTypeNotBetween(Object value, Object value1) {
        ew.notBetween("use_type", value, value1);
        return this;
    }

    public FundAccountCondition orUseTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("use_type", value, value1);
        return this;
    }

    public FundAccountCondition andUseTypeLike(String value) {
        ew.like("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("use_type", value);
        return this;
    }

    public FundAccountCondition andUseTypeNotLike(String value) {
        ew.notLike("use_type", value);
        return this;
    }

    public FundAccountCondition orUseTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("use_type", value);
        return this;
    }

    public FundAccountCondition andShareFlagIsNull() {
        ew.isNull("share_flag");
        return this;
    }

    public FundAccountCondition orShareFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("share_flag");
        return this;
    }

    public FundAccountCondition andShareFlagIsNotNull() {
        ew.isNotNull("share_flag");
        return this;
    }

    public FundAccountCondition orShareFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("share_flag");
        return this;
    }

    public FundAccountCondition andShareFlagEq(Object value) {
        ew.eq("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagNe(Object value) {
        ew.ne("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagGt(Object value) {
        ew.gt("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagGe(Object value) {
        ew.ge("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagLt(Object value) {
        ew.lt("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagLe(Object value) {
        ew.le("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagIn(Object... value) {
        ew.in("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagNotIn(Object... value) {
        ew.notIn("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagBetween(Object value, Object value1) {
        ew.between("share_flag", value, value1);
        return this;
    }

    public FundAccountCondition orShareFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("share_flag", value, value1);
        return this;
    }

    public FundAccountCondition andShareFlagNotBetween(Object value, Object value1) {
        ew.notBetween("share_flag", value, value1);
        return this;
    }

    public FundAccountCondition orShareFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("share_flag", value, value1);
        return this;
    }

    public FundAccountCondition andShareFlagLike(String value) {
        ew.like("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("share_flag", value);
        return this;
    }

    public FundAccountCondition andShareFlagNotLike(String value) {
        ew.notLike("share_flag", value);
        return this;
    }

    public FundAccountCondition orShareFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("share_flag", value);
        return this;
    }
}