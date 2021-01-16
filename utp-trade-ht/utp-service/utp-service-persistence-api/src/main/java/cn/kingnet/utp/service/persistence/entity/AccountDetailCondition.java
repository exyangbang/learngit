package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class AccountDetailCondition {
    private PlusEntityWrapper<AccountDetail> ew;

    public AccountDetailCondition() {
        this.ew = new PlusEntityWrapper(AccountDetail.class);
    }

    public static AccountDetailCondition builder() {
        return new AccountDetailCondition();
    }

    public PlusEntityWrapper<AccountDetail> build() {
        return this.ew;
    }

    public AccountDetailCondition or() {
        this.ew.orNew();
        return this;
    }

    public AccountDetailCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(AccountDetail.class);
    }

    public AccountDetailCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public AccountDetailCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public AccountDetailCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public AccountDetailCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> AccountDetailCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> AccountDetailCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> AccountDetailCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public AccountDetailCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public AccountDetailCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public AccountDetailCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public AccountDetailCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public AccountDetailCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public AccountDetailCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public AccountDetailCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public AccountDetailCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public AccountDetailCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public AccountDetailCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public AccountDetailCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public AccountDetailCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public AccountDetailCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public AccountDetailCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public AccountDetailCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public AccountDetailCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public AccountDetailCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public AccountDetailCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public AccountDetailCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public AccountDetailCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public AccountDetailCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public AccountDetailCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public AccountDetailCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public AccountDetailCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public AccountDetailCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public AccountDetailCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountDetailCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountDetailCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public AccountDetailCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public AccountDetailCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public AccountDetailCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public AccountDetailCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public AccountDetailCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public AccountDetailCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public AccountDetailCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public AccountDetailCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public AccountDetailCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public AccountDetailCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public AccountDetailCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public AccountDetailCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public AccountDetailCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public AccountDetailCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public AccountDetailCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public AccountDetailCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public AccountDetailCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public AccountDetailCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public AccountDetailCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public AccountDetailCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public AccountDetailCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public AccountDetailCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public AccountDetailCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public AccountDetailCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public AccountDetailCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public AccountDetailCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountDetailCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountDetailCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public AccountDetailCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public AccountDetailCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public AccountDetailCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeIsNull() {
        ew.isNull("operate_type");
        return this;
    }

    public AccountDetailCondition orOperateTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("operate_type");
        return this;
    }

    public AccountDetailCondition andOperateTypeIsNotNull() {
        ew.isNotNull("operate_type");
        return this;
    }

    public AccountDetailCondition orOperateTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("operate_type");
        return this;
    }

    public AccountDetailCondition andOperateTypeEq(Object value) {
        ew.eq("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeNe(Object value) {
        ew.ne("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeGt(Object value) {
        ew.gt("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeGe(Object value) {
        ew.ge("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeLt(Object value) {
        ew.lt("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeLe(Object value) {
        ew.le("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeIn(Object... value) {
        ew.in("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeNotIn(Object... value) {
        ew.notIn("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeBetween(Object value, Object value1) {
        ew.between("operate_type", value, value1);
        return this;
    }

    public AccountDetailCondition orOperateTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("operate_type", value, value1);
        return this;
    }

    public AccountDetailCondition andOperateTypeNotBetween(Object value, Object value1) {
        ew.notBetween("operate_type", value, value1);
        return this;
    }

    public AccountDetailCondition orOperateTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("operate_type", value, value1);
        return this;
    }

    public AccountDetailCondition andOperateTypeLike(String value) {
        ew.like("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateTypeNotLike(String value) {
        ew.notLike("operate_type", value);
        return this;
    }

    public AccountDetailCondition orOperateTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("operate_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeIsNull() {
        ew.isNull("operate_sub_type");
        return this;
    }

    public AccountDetailCondition orOperateSubTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("operate_sub_type");
        return this;
    }

    public AccountDetailCondition andOperateSubTypeIsNotNull() {
        ew.isNotNull("operate_sub_type");
        return this;
    }

    public AccountDetailCondition orOperateSubTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("operate_sub_type");
        return this;
    }

    public AccountDetailCondition andOperateSubTypeEq(Object value) {
        ew.eq("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeNe(Object value) {
        ew.ne("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeGt(Object value) {
        ew.gt("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeGe(Object value) {
        ew.ge("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeLt(Object value) {
        ew.lt("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeLe(Object value) {
        ew.le("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeIn(Object... value) {
        ew.in("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeNotIn(Object... value) {
        ew.notIn("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeBetween(Object value, Object value1) {
        ew.between("operate_sub_type", value, value1);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("operate_sub_type", value, value1);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeNotBetween(Object value, Object value1) {
        ew.notBetween("operate_sub_type", value, value1);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("operate_sub_type", value, value1);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeLike(String value) {
        ew.like("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andOperateSubTypeNotLike(String value) {
        ew.notLike("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition orOperateSubTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("operate_sub_type", value);
        return this;
    }

    public AccountDetailCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public AccountDetailCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public AccountDetailCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public AccountDetailCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public AccountDetailCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public AccountDetailCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public AccountDetailCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public AccountDetailCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public AccountDetailCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public AccountDetailCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public AccountDetailCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceIsNull() {
        ew.isNull("before_balance");
        return this;
    }

    public AccountDetailCondition orBeforeBalanceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("before_balance");
        return this;
    }

    public AccountDetailCondition andBeforeBalanceIsNotNull() {
        ew.isNotNull("before_balance");
        return this;
    }

    public AccountDetailCondition orBeforeBalanceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("before_balance");
        return this;
    }

    public AccountDetailCondition andBeforeBalanceEq(Object value) {
        ew.eq("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceNe(Object value) {
        ew.ne("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceGt(Object value) {
        ew.gt("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceGe(Object value) {
        ew.ge("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceLt(Object value) {
        ew.lt("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceLe(Object value) {
        ew.le("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceIn(Object... value) {
        ew.in("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceNotIn(Object... value) {
        ew.notIn("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceBetween(Object value, Object value1) {
        ew.between("before_balance", value, value1);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("before_balance", value, value1);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceNotBetween(Object value, Object value1) {
        ew.notBetween("before_balance", value, value1);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("before_balance", value, value1);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceLike(String value) {
        ew.like("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("before_balance", value);
        return this;
    }

    public AccountDetailCondition andBeforeBalanceNotLike(String value) {
        ew.notLike("before_balance", value);
        return this;
    }

    public AccountDetailCondition orBeforeBalanceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("before_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceIsNull() {
        ew.isNull("after_balance");
        return this;
    }

    public AccountDetailCondition orAfterBalanceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("after_balance");
        return this;
    }

    public AccountDetailCondition andAfterBalanceIsNotNull() {
        ew.isNotNull("after_balance");
        return this;
    }

    public AccountDetailCondition orAfterBalanceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("after_balance");
        return this;
    }

    public AccountDetailCondition andAfterBalanceEq(Object value) {
        ew.eq("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceNe(Object value) {
        ew.ne("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceGt(Object value) {
        ew.gt("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceGe(Object value) {
        ew.ge("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceLt(Object value) {
        ew.lt("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceLe(Object value) {
        ew.le("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceIn(Object... value) {
        ew.in("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceNotIn(Object... value) {
        ew.notIn("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceBetween(Object value, Object value1) {
        ew.between("after_balance", value, value1);
        return this;
    }

    public AccountDetailCondition orAfterBalanceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("after_balance", value, value1);
        return this;
    }

    public AccountDetailCondition andAfterBalanceNotBetween(Object value, Object value1) {
        ew.notBetween("after_balance", value, value1);
        return this;
    }

    public AccountDetailCondition orAfterBalanceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("after_balance", value, value1);
        return this;
    }

    public AccountDetailCondition andAfterBalanceLike(String value) {
        ew.like("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("after_balance", value);
        return this;
    }

    public AccountDetailCondition andAfterBalanceNotLike(String value) {
        ew.notLike("after_balance", value);
        return this;
    }

    public AccountDetailCondition orAfterBalanceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("after_balance", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeIsNull() {
        ew.isNull("record_time");
        return this;
    }

    public AccountDetailCondition orRecordTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("record_time");
        return this;
    }

    public AccountDetailCondition andRecordTimeIsNotNull() {
        ew.isNotNull("record_time");
        return this;
    }

    public AccountDetailCondition orRecordTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("record_time");
        return this;
    }

    public AccountDetailCondition andRecordTimeEq(Object value) {
        ew.eq("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeNe(Object value) {
        ew.ne("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeGt(Object value) {
        ew.gt("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeGe(Object value) {
        ew.ge("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeLt(Object value) {
        ew.lt("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeLe(Object value) {
        ew.le("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeIn(Object... value) {
        ew.in("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeNotIn(Object... value) {
        ew.notIn("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeBetween(Object value, Object value1) {
        ew.between("record_time", value, value1);
        return this;
    }

    public AccountDetailCondition orRecordTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("record_time", value, value1);
        return this;
    }

    public AccountDetailCondition andRecordTimeNotBetween(Object value, Object value1) {
        ew.notBetween("record_time", value, value1);
        return this;
    }

    public AccountDetailCondition orRecordTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("record_time", value, value1);
        return this;
    }

    public AccountDetailCondition andRecordTimeLike(String value) {
        ew.like("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("record_time", value);
        return this;
    }

    public AccountDetailCondition andRecordTimeNotLike(String value) {
        ew.notLike("record_time", value);
        return this;
    }

    public AccountDetailCondition orRecordTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("record_time", value);
        return this;
    }

    public AccountDetailCondition andSeqNoIsNull() {
        ew.isNull("seq_no");
        return this;
    }

    public AccountDetailCondition orSeqNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("seq_no");
        return this;
    }

    public AccountDetailCondition andSeqNoIsNotNull() {
        ew.isNotNull("seq_no");
        return this;
    }

    public AccountDetailCondition orSeqNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("seq_no");
        return this;
    }

    public AccountDetailCondition andSeqNoEq(Object value) {
        ew.eq("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoNe(Object value) {
        ew.ne("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoGt(Object value) {
        ew.gt("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoGe(Object value) {
        ew.ge("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoLt(Object value) {
        ew.lt("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoLe(Object value) {
        ew.le("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoIn(Object... value) {
        ew.in("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoNotIn(Object... value) {
        ew.notIn("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoBetween(Object value, Object value1) {
        ew.between("seq_no", value, value1);
        return this;
    }

    public AccountDetailCondition orSeqNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("seq_no", value, value1);
        return this;
    }

    public AccountDetailCondition andSeqNoNotBetween(Object value, Object value1) {
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public AccountDetailCondition orSeqNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public AccountDetailCondition andSeqNoLike(String value) {
        ew.like("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("seq_no", value);
        return this;
    }

    public AccountDetailCondition andSeqNoNotLike(String value) {
        ew.notLike("seq_no", value);
        return this;
    }

    public AccountDetailCondition orSeqNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("seq_no", value);
        return this;
    }

    public AccountDetailCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public AccountDetailCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public AccountDetailCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public AccountDetailCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public AccountDetailCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public AccountDetailCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public AccountDetailCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountDetailCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountDetailCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public AccountDetailCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public AccountDetailCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoIsNull() {
        ew.isNull("peer_acc_no");
        return this;
    }

    public AccountDetailCondition orPeerAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("peer_acc_no");
        return this;
    }

    public AccountDetailCondition andPeerAccNoIsNotNull() {
        ew.isNotNull("peer_acc_no");
        return this;
    }

    public AccountDetailCondition orPeerAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("peer_acc_no");
        return this;
    }

    public AccountDetailCondition andPeerAccNoEq(Object value) {
        ew.eq("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoNe(Object value) {
        ew.ne("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoGt(Object value) {
        ew.gt("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoGe(Object value) {
        ew.ge("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoLt(Object value) {
        ew.lt("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoLe(Object value) {
        ew.le("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoIn(Object... value) {
        ew.in("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoNotIn(Object... value) {
        ew.notIn("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoBetween(Object value, Object value1) {
        ew.between("peer_acc_no", value, value1);
        return this;
    }

    public AccountDetailCondition orPeerAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("peer_acc_no", value, value1);
        return this;
    }

    public AccountDetailCondition andPeerAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("peer_acc_no", value, value1);
        return this;
    }

    public AccountDetailCondition orPeerAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("peer_acc_no", value, value1);
        return this;
    }

    public AccountDetailCondition andPeerAccNoLike(String value) {
        ew.like("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNoNotLike(String value) {
        ew.notLike("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("peer_acc_no", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public AccountDetailCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public AccountDetailCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public AccountDetailCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public AccountDetailCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public AccountDetailCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public AccountDetailCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public AccountDetailCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public AccountDetailCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdIsNull() {
        ew.isNull("outside_order_id");
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("outside_order_id");
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdIsNotNull() {
        ew.isNotNull("outside_order_id");
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("outside_order_id");
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdEq(Object value) {
        ew.eq("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdNe(Object value) {
        ew.ne("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdGt(Object value) {
        ew.gt("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdGe(Object value) {
        ew.ge("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdLt(Object value) {
        ew.lt("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdLe(Object value) {
        ew.le("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdIn(Object... value) {
        ew.in("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdNotIn(Object... value) {
        ew.notIn("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdBetween(Object value, Object value1) {
        ew.between("outside_order_id", value, value1);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("outside_order_id", value, value1);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("outside_order_id", value, value1);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("outside_order_id", value, value1);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdLike(String value) {
        ew.like("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andOutsideOrderIdNotLike(String value) {
        ew.notLike("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition orOutsideOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("outside_order_id", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameIsNull() {
        ew.isNull("peer_acc_name");
        return this;
    }

    public AccountDetailCondition orPeerAccNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("peer_acc_name");
        return this;
    }

    public AccountDetailCondition andPeerAccNameIsNotNull() {
        ew.isNotNull("peer_acc_name");
        return this;
    }

    public AccountDetailCondition orPeerAccNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("peer_acc_name");
        return this;
    }

    public AccountDetailCondition andPeerAccNameEq(Object value) {
        ew.eq("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameNe(Object value) {
        ew.ne("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameGt(Object value) {
        ew.gt("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameGe(Object value) {
        ew.ge("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameLt(Object value) {
        ew.lt("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameLe(Object value) {
        ew.le("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameIn(Object... value) {
        ew.in("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameNotIn(Object... value) {
        ew.notIn("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameBetween(Object value, Object value1) {
        ew.between("peer_acc_name", value, value1);
        return this;
    }

    public AccountDetailCondition orPeerAccNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("peer_acc_name", value, value1);
        return this;
    }

    public AccountDetailCondition andPeerAccNameNotBetween(Object value, Object value1) {
        ew.notBetween("peer_acc_name", value, value1);
        return this;
    }

    public AccountDetailCondition orPeerAccNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("peer_acc_name", value, value1);
        return this;
    }

    public AccountDetailCondition andPeerAccNameLike(String value) {
        ew.like("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition andPeerAccNameNotLike(String value) {
        ew.notLike("peer_acc_name", value);
        return this;
    }

    public AccountDetailCondition orPeerAccNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("peer_acc_name", value);
        return this;
    }
}