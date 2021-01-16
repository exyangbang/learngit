package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class AccountInfoCondition {
    private PlusEntityWrapper<AccountInfo> ew;

    public AccountInfoCondition() {
        this.ew = new PlusEntityWrapper(AccountInfo.class);
    }

    public static AccountInfoCondition builder() {
        return new AccountInfoCondition();
    }

    public PlusEntityWrapper<AccountInfo> build() {
        return this.ew;
    }

    public AccountInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public AccountInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(AccountInfo.class);
    }

    public AccountInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public AccountInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public AccountInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public AccountInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> AccountInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> AccountInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> AccountInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public AccountInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public AccountInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public AccountInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public AccountInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public AccountInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public AccountInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public AccountInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public AccountInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public AccountInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public AccountInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public AccountInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public AccountInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public AccountInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public AccountInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public AccountInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public AccountInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public AccountInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public AccountInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public AccountInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public AccountInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public AccountInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public AccountInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public AccountInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public AccountInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public AccountInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public AccountInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public AccountInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public AccountInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public AccountInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public AccountInfoCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public AccountInfoCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public AccountInfoCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public AccountInfoCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public AccountInfoCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public AccountInfoCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public AccountInfoCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public AccountInfoCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public AccountInfoCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public AccountInfoCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public AccountInfoCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public AccountInfoCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public AccountInfoCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public AccountInfoCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public AccountInfoCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public AccountInfoCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public AccountInfoCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public AccountInfoCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public AccountInfoCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public AccountInfoCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public AccountInfoCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public AccountInfoCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public AccountInfoCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountInfoCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountInfoCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public AccountInfoCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public AccountInfoCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public AccountInfoCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public AccountInfoCondition andObjTypeIsNull() {
        ew.isNull("obj_type");
        return this;
    }

    public AccountInfoCondition orObjTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("obj_type");
        return this;
    }

    public AccountInfoCondition andObjTypeIsNotNull() {
        ew.isNotNull("obj_type");
        return this;
    }

    public AccountInfoCondition orObjTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("obj_type");
        return this;
    }

    public AccountInfoCondition andObjTypeEq(Object value) {
        ew.eq("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeNe(Object value) {
        ew.ne("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeGt(Object value) {
        ew.gt("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeGe(Object value) {
        ew.ge("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeLt(Object value) {
        ew.lt("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeLe(Object value) {
        ew.le("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeIn(Object... value) {
        ew.in("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeNotIn(Object... value) {
        ew.notIn("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeBetween(Object value, Object value1) {
        ew.between("obj_type", value, value1);
        return this;
    }

    public AccountInfoCondition orObjTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("obj_type", value, value1);
        return this;
    }

    public AccountInfoCondition andObjTypeNotBetween(Object value, Object value1) {
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public AccountInfoCondition orObjTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public AccountInfoCondition andObjTypeLike(String value) {
        ew.like("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("obj_type", value);
        return this;
    }

    public AccountInfoCondition andObjTypeNotLike(String value) {
        ew.notLike("obj_type", value);
        return this;
    }

    public AccountInfoCondition orObjTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("obj_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeIsNull() {
        ew.isNull("user_type");
        return this;
    }

    public AccountInfoCondition orUserTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_type");
        return this;
    }

    public AccountInfoCondition andUserTypeIsNotNull() {
        ew.isNotNull("user_type");
        return this;
    }

    public AccountInfoCondition orUserTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_type");
        return this;
    }

    public AccountInfoCondition andUserTypeEq(Object value) {
        ew.eq("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeNe(Object value) {
        ew.ne("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeGt(Object value) {
        ew.gt("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeGe(Object value) {
        ew.ge("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeLt(Object value) {
        ew.lt("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeLe(Object value) {
        ew.le("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeIn(Object... value) {
        ew.in("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeNotIn(Object... value) {
        ew.notIn("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeBetween(Object value, Object value1) {
        ew.between("user_type", value, value1);
        return this;
    }

    public AccountInfoCondition orUserTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_type", value, value1);
        return this;
    }

    public AccountInfoCondition andUserTypeNotBetween(Object value, Object value1) {
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public AccountInfoCondition orUserTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public AccountInfoCondition andUserTypeLike(String value) {
        ew.like("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_type", value);
        return this;
    }

    public AccountInfoCondition andUserTypeNotLike(String value) {
        ew.notLike("user_type", value);
        return this;
    }

    public AccountInfoCondition orUserTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_type", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeIsNull() {
        ew.isNull("business_scope");
        return this;
    }

    public AccountInfoCondition orBusinessScopeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("business_scope");
        return this;
    }

    public AccountInfoCondition andBusinessScopeIsNotNull() {
        ew.isNotNull("business_scope");
        return this;
    }

    public AccountInfoCondition orBusinessScopeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("business_scope");
        return this;
    }

    public AccountInfoCondition andBusinessScopeEq(Object value) {
        ew.eq("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeNe(Object value) {
        ew.ne("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeGt(Object value) {
        ew.gt("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeGe(Object value) {
        ew.ge("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeLt(Object value) {
        ew.lt("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeLe(Object value) {
        ew.le("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeIn(Object... value) {
        ew.in("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeNotIn(Object... value) {
        ew.notIn("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeBetween(Object value, Object value1) {
        ew.between("business_scope", value, value1);
        return this;
    }

    public AccountInfoCondition orBusinessScopeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("business_scope", value, value1);
        return this;
    }

    public AccountInfoCondition andBusinessScopeNotBetween(Object value, Object value1) {
        ew.notBetween("business_scope", value, value1);
        return this;
    }

    public AccountInfoCondition orBusinessScopeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("business_scope", value, value1);
        return this;
    }

    public AccountInfoCondition andBusinessScopeLike(String value) {
        ew.like("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("business_scope", value);
        return this;
    }

    public AccountInfoCondition andBusinessScopeNotLike(String value) {
        ew.notLike("business_scope", value);
        return this;
    }

    public AccountInfoCondition orBusinessScopeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("business_scope", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundIsNull() {
        ew.isNull("register_fund");
        return this;
    }

    public AccountInfoCondition orRegisterFundIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("register_fund");
        return this;
    }

    public AccountInfoCondition andRegisterFundIsNotNull() {
        ew.isNotNull("register_fund");
        return this;
    }

    public AccountInfoCondition orRegisterFundIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("register_fund");
        return this;
    }

    public AccountInfoCondition andRegisterFundEq(Object value) {
        ew.eq("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundNe(Object value) {
        ew.ne("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundGt(Object value) {
        ew.gt("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundGe(Object value) {
        ew.ge("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundLt(Object value) {
        ew.lt("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundLe(Object value) {
        ew.le("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundIn(Object... value) {
        ew.in("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundNotIn(Object... value) {
        ew.notIn("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundBetween(Object value, Object value1) {
        ew.between("register_fund", value, value1);
        return this;
    }

    public AccountInfoCondition orRegisterFundBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("register_fund", value, value1);
        return this;
    }

    public AccountInfoCondition andRegisterFundNotBetween(Object value, Object value1) {
        ew.notBetween("register_fund", value, value1);
        return this;
    }

    public AccountInfoCondition orRegisterFundNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("register_fund", value, value1);
        return this;
    }

    public AccountInfoCondition andRegisterFundLike(String value) {
        ew.like("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("register_fund", value);
        return this;
    }

    public AccountInfoCondition andRegisterFundNotLike(String value) {
        ew.notLike("register_fund", value);
        return this;
    }

    public AccountInfoCondition orRegisterFundNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("register_fund", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateIsNull() {
        ew.isNull("business_indate");
        return this;
    }

    public AccountInfoCondition orBusinessIndateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("business_indate");
        return this;
    }

    public AccountInfoCondition andBusinessIndateIsNotNull() {
        ew.isNotNull("business_indate");
        return this;
    }

    public AccountInfoCondition orBusinessIndateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("business_indate");
        return this;
    }

    public AccountInfoCondition andBusinessIndateEq(Object value) {
        ew.eq("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateNe(Object value) {
        ew.ne("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateGt(Object value) {
        ew.gt("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateGe(Object value) {
        ew.ge("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateLt(Object value) {
        ew.lt("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateLe(Object value) {
        ew.le("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateIn(Object... value) {
        ew.in("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateNotIn(Object... value) {
        ew.notIn("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateBetween(Object value, Object value1) {
        ew.between("business_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orBusinessIndateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("business_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andBusinessIndateNotBetween(Object value, Object value1) {
        ew.notBetween("business_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orBusinessIndateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("business_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andBusinessIndateLike(String value) {
        ew.like("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("business_indate", value);
        return this;
    }

    public AccountInfoCondition andBusinessIndateNotLike(String value) {
        ew.notLike("business_indate", value);
        return this;
    }

    public AccountInfoCondition orBusinessIndateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("business_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateIsNull() {
        ew.isNull("legal_indate");
        return this;
    }

    public AccountInfoCondition orLegalIndateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("legal_indate");
        return this;
    }

    public AccountInfoCondition andLegalIndateIsNotNull() {
        ew.isNotNull("legal_indate");
        return this;
    }

    public AccountInfoCondition orLegalIndateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("legal_indate");
        return this;
    }

    public AccountInfoCondition andLegalIndateEq(Object value) {
        ew.eq("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateNe(Object value) {
        ew.ne("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateGt(Object value) {
        ew.gt("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateGe(Object value) {
        ew.ge("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateLt(Object value) {
        ew.lt("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateLe(Object value) {
        ew.le("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateIn(Object... value) {
        ew.in("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateNotIn(Object... value) {
        ew.notIn("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateBetween(Object value, Object value1) {
        ew.between("legal_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orLegalIndateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("legal_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andLegalIndateNotBetween(Object value, Object value1) {
        ew.notBetween("legal_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orLegalIndateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("legal_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andLegalIndateLike(String value) {
        ew.like("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andLegalIndateNotLike(String value) {
        ew.notLike("legal_indate", value);
        return this;
    }

    public AccountInfoCondition orLegalIndateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("legal_indate", value);
        return this;
    }

    public AccountInfoCondition andControlNameIsNull() {
        ew.isNull("control_name");
        return this;
    }

    public AccountInfoCondition orControlNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("control_name");
        return this;
    }

    public AccountInfoCondition andControlNameIsNotNull() {
        ew.isNotNull("control_name");
        return this;
    }

    public AccountInfoCondition orControlNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("control_name");
        return this;
    }

    public AccountInfoCondition andControlNameEq(Object value) {
        ew.eq("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameNe(Object value) {
        ew.ne("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameGt(Object value) {
        ew.gt("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameGe(Object value) {
        ew.ge("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameLt(Object value) {
        ew.lt("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameLe(Object value) {
        ew.le("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameIn(Object... value) {
        ew.in("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameNotIn(Object... value) {
        ew.notIn("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameBetween(Object value, Object value1) {
        ew.between("control_name", value, value1);
        return this;
    }

    public AccountInfoCondition orControlNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("control_name", value, value1);
        return this;
    }

    public AccountInfoCondition andControlNameNotBetween(Object value, Object value1) {
        ew.notBetween("control_name", value, value1);
        return this;
    }

    public AccountInfoCondition orControlNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("control_name", value, value1);
        return this;
    }

    public AccountInfoCondition andControlNameLike(String value) {
        ew.like("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlNameNotLike(String value) {
        ew.notLike("control_name", value);
        return this;
    }

    public AccountInfoCondition orControlNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("control_name", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeIsNull() {
        ew.isNull("control_cerfile_type");
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("control_cerfile_type");
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeIsNotNull() {
        ew.isNotNull("control_cerfile_type");
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("control_cerfile_type");
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeEq(Object value) {
        ew.eq("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeNe(Object value) {
        ew.ne("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeGt(Object value) {
        ew.gt("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeGe(Object value) {
        ew.ge("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeLt(Object value) {
        ew.lt("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeLe(Object value) {
        ew.le("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeIn(Object... value) {
        ew.in("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeNotIn(Object... value) {
        ew.notIn("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeBetween(Object value, Object value1) {
        ew.between("control_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("control_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("control_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("control_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeLike(String value) {
        ew.like("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileTypeNotLike(String value) {
        ew.notLike("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("control_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoIsNull() {
        ew.isNull("control_cerfile_no");
        return this;
    }

    public AccountInfoCondition orControlCerfileNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("control_cerfile_no");
        return this;
    }

    public AccountInfoCondition andControlCerfileNoIsNotNull() {
        ew.isNotNull("control_cerfile_no");
        return this;
    }

    public AccountInfoCondition orControlCerfileNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("control_cerfile_no");
        return this;
    }

    public AccountInfoCondition andControlCerfileNoEq(Object value) {
        ew.eq("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoNe(Object value) {
        ew.ne("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoGt(Object value) {
        ew.gt("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoGe(Object value) {
        ew.ge("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoLt(Object value) {
        ew.lt("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoLe(Object value) {
        ew.le("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoIn(Object... value) {
        ew.in("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoNotIn(Object... value) {
        ew.notIn("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoBetween(Object value, Object value1) {
        ew.between("control_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("control_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoNotBetween(Object value, Object value1) {
        ew.notBetween("control_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("control_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoLike(String value) {
        ew.like("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlCerfileNoNotLike(String value) {
        ew.notLike("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orControlCerfileNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("control_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andControlIndateIsNull() {
        ew.isNull("control_indate");
        return this;
    }

    public AccountInfoCondition orControlIndateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("control_indate");
        return this;
    }

    public AccountInfoCondition andControlIndateIsNotNull() {
        ew.isNotNull("control_indate");
        return this;
    }

    public AccountInfoCondition orControlIndateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("control_indate");
        return this;
    }

    public AccountInfoCondition andControlIndateEq(Object value) {
        ew.eq("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateNe(Object value) {
        ew.ne("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateGt(Object value) {
        ew.gt("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateGe(Object value) {
        ew.ge("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateLt(Object value) {
        ew.lt("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateLe(Object value) {
        ew.le("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateIn(Object... value) {
        ew.in("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateNotIn(Object... value) {
        ew.notIn("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateBetween(Object value, Object value1) {
        ew.between("control_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orControlIndateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("control_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andControlIndateNotBetween(Object value, Object value1) {
        ew.notBetween("control_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orControlIndateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("control_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andControlIndateLike(String value) {
        ew.like("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("control_indate", value);
        return this;
    }

    public AccountInfoCondition andControlIndateNotLike(String value) {
        ew.notLike("control_indate", value);
        return this;
    }

    public AccountInfoCondition orControlIndateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("control_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeNameIsNull() {
        ew.isNull("charge_name");
        return this;
    }

    public AccountInfoCondition orChargeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("charge_name");
        return this;
    }

    public AccountInfoCondition andChargeNameIsNotNull() {
        ew.isNotNull("charge_name");
        return this;
    }

    public AccountInfoCondition orChargeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("charge_name");
        return this;
    }

    public AccountInfoCondition andChargeNameEq(Object value) {
        ew.eq("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameNe(Object value) {
        ew.ne("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameGt(Object value) {
        ew.gt("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameGe(Object value) {
        ew.ge("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameLt(Object value) {
        ew.lt("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameLe(Object value) {
        ew.le("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameIn(Object... value) {
        ew.in("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameNotIn(Object... value) {
        ew.notIn("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameBetween(Object value, Object value1) {
        ew.between("charge_name", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("charge_name", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeNameNotBetween(Object value, Object value1) {
        ew.notBetween("charge_name", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("charge_name", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeNameLike(String value) {
        ew.like("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeNameNotLike(String value) {
        ew.notLike("charge_name", value);
        return this;
    }

    public AccountInfoCondition orChargeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("charge_name", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeIsNull() {
        ew.isNull("charge_cerfile_type");
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("charge_cerfile_type");
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeIsNotNull() {
        ew.isNotNull("charge_cerfile_type");
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("charge_cerfile_type");
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeEq(Object value) {
        ew.eq("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeNe(Object value) {
        ew.ne("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeGt(Object value) {
        ew.gt("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeGe(Object value) {
        ew.ge("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeLt(Object value) {
        ew.lt("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeLe(Object value) {
        ew.le("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeIn(Object... value) {
        ew.in("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeNotIn(Object... value) {
        ew.notIn("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeBetween(Object value, Object value1) {
        ew.between("charge_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("charge_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("charge_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("charge_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeLike(String value) {
        ew.like("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileTypeNotLike(String value) {
        ew.notLike("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("charge_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoIsNull() {
        ew.isNull("charge_cerfile_no");
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("charge_cerfile_no");
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoIsNotNull() {
        ew.isNotNull("charge_cerfile_no");
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("charge_cerfile_no");
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoEq(Object value) {
        ew.eq("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoNe(Object value) {
        ew.ne("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoGt(Object value) {
        ew.gt("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoGe(Object value) {
        ew.ge("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoLt(Object value) {
        ew.lt("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoLe(Object value) {
        ew.le("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoIn(Object... value) {
        ew.in("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoNotIn(Object... value) {
        ew.notIn("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoBetween(Object value, Object value1) {
        ew.between("charge_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("charge_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoNotBetween(Object value, Object value1) {
        ew.notBetween("charge_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("charge_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoLike(String value) {
        ew.like("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeCerfileNoNotLike(String value) {
        ew.notLike("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orChargeCerfileNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("charge_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateIsNull() {
        ew.isNull("charge_indate");
        return this;
    }

    public AccountInfoCondition orChargeIndateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("charge_indate");
        return this;
    }

    public AccountInfoCondition andChargeIndateIsNotNull() {
        ew.isNotNull("charge_indate");
        return this;
    }

    public AccountInfoCondition orChargeIndateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("charge_indate");
        return this;
    }

    public AccountInfoCondition andChargeIndateEq(Object value) {
        ew.eq("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateNe(Object value) {
        ew.ne("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateGt(Object value) {
        ew.gt("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateGe(Object value) {
        ew.ge("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateLt(Object value) {
        ew.lt("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateLe(Object value) {
        ew.le("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateIn(Object... value) {
        ew.in("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateNotIn(Object... value) {
        ew.notIn("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateBetween(Object value, Object value1) {
        ew.between("charge_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeIndateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("charge_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeIndateNotBetween(Object value, Object value1) {
        ew.notBetween("charge_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orChargeIndateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("charge_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andChargeIndateLike(String value) {
        ew.like("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andChargeIndateNotLike(String value) {
        ew.notLike("charge_indate", value);
        return this;
    }

    public AccountInfoCondition orChargeIndateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("charge_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameIsNull() {
        ew.isNull("auth_bus_name");
        return this;
    }

    public AccountInfoCondition orAuthBusNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_bus_name");
        return this;
    }

    public AccountInfoCondition andAuthBusNameIsNotNull() {
        ew.isNotNull("auth_bus_name");
        return this;
    }

    public AccountInfoCondition orAuthBusNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_bus_name");
        return this;
    }

    public AccountInfoCondition andAuthBusNameEq(Object value) {
        ew.eq("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameNe(Object value) {
        ew.ne("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameGt(Object value) {
        ew.gt("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameGe(Object value) {
        ew.ge("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameLt(Object value) {
        ew.lt("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameLe(Object value) {
        ew.le("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameIn(Object... value) {
        ew.in("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameNotIn(Object... value) {
        ew.notIn("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameBetween(Object value, Object value1) {
        ew.between("auth_bus_name", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_bus_name", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusNameNotBetween(Object value, Object value1) {
        ew.notBetween("auth_bus_name", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_bus_name", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusNameLike(String value) {
        ew.like("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNameNotLike(String value) {
        ew.notLike("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_bus_name", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeIsNull() {
        ew.isNull("auth_bus_type");
        return this;
    }

    public AccountInfoCondition orAuthBusTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_bus_type");
        return this;
    }

    public AccountInfoCondition andAuthBusTypeIsNotNull() {
        ew.isNotNull("auth_bus_type");
        return this;
    }

    public AccountInfoCondition orAuthBusTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_bus_type");
        return this;
    }

    public AccountInfoCondition andAuthBusTypeEq(Object value) {
        ew.eq("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeNe(Object value) {
        ew.ne("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeGt(Object value) {
        ew.gt("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeGe(Object value) {
        ew.ge("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeLt(Object value) {
        ew.lt("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeLe(Object value) {
        ew.le("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeIn(Object... value) {
        ew.in("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeNotIn(Object... value) {
        ew.notIn("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeBetween(Object value, Object value1) {
        ew.between("auth_bus_type", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_bus_type", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeNotBetween(Object value, Object value1) {
        ew.notBetween("auth_bus_type", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_bus_type", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeLike(String value) {
        ew.like("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusTypeNotLike(String value) {
        ew.notLike("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition orAuthBusTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_bus_type", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoIsNull() {
        ew.isNull("auth_bus_no");
        return this;
    }

    public AccountInfoCondition orAuthBusNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_bus_no");
        return this;
    }

    public AccountInfoCondition andAuthBusNoIsNotNull() {
        ew.isNotNull("auth_bus_no");
        return this;
    }

    public AccountInfoCondition orAuthBusNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_bus_no");
        return this;
    }

    public AccountInfoCondition andAuthBusNoEq(Object value) {
        ew.eq("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoNe(Object value) {
        ew.ne("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoGt(Object value) {
        ew.gt("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoGe(Object value) {
        ew.ge("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoLt(Object value) {
        ew.lt("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoLe(Object value) {
        ew.le("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoIn(Object... value) {
        ew.in("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoNotIn(Object... value) {
        ew.notIn("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoBetween(Object value, Object value1) {
        ew.between("auth_bus_no", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_bus_no", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusNoNotBetween(Object value, Object value1) {
        ew.notBetween("auth_bus_no", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_bus_no", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusNoLike(String value) {
        ew.like("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusNoNotLike(String value) {
        ew.notLike("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition orAuthBusNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_bus_no", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateIsNull() {
        ew.isNull("auth_bus_indate");
        return this;
    }

    public AccountInfoCondition orAuthBusIndateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_bus_indate");
        return this;
    }

    public AccountInfoCondition andAuthBusIndateIsNotNull() {
        ew.isNotNull("auth_bus_indate");
        return this;
    }

    public AccountInfoCondition orAuthBusIndateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_bus_indate");
        return this;
    }

    public AccountInfoCondition andAuthBusIndateEq(Object value) {
        ew.eq("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateNe(Object value) {
        ew.ne("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateGt(Object value) {
        ew.gt("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateGe(Object value) {
        ew.ge("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateLt(Object value) {
        ew.lt("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateLe(Object value) {
        ew.le("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateIn(Object... value) {
        ew.in("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateNotIn(Object... value) {
        ew.notIn("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateBetween(Object value, Object value1) {
        ew.between("auth_bus_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_bus_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateNotBetween(Object value, Object value1) {
        ew.notBetween("auth_bus_indate", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_bus_indate", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateLike(String value) {
        ew.like("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andAuthBusIndateNotLike(String value) {
        ew.notLike("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition orAuthBusIndateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_bus_indate", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerIsNull() {
        ew.isNull("customer_manager");
        return this;
    }

    public AccountInfoCondition orCustomerManagerIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("customer_manager");
        return this;
    }

    public AccountInfoCondition andCustomerManagerIsNotNull() {
        ew.isNotNull("customer_manager");
        return this;
    }

    public AccountInfoCondition orCustomerManagerIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("customer_manager");
        return this;
    }

    public AccountInfoCondition andCustomerManagerEq(Object value) {
        ew.eq("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerNe(Object value) {
        ew.ne("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerGt(Object value) {
        ew.gt("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerGe(Object value) {
        ew.ge("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerLt(Object value) {
        ew.lt("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerLe(Object value) {
        ew.le("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerIn(Object... value) {
        ew.in("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerNotIn(Object... value) {
        ew.notIn("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerBetween(Object value, Object value1) {
        ew.between("customer_manager", value, value1);
        return this;
    }

    public AccountInfoCondition orCustomerManagerBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("customer_manager", value, value1);
        return this;
    }

    public AccountInfoCondition andCustomerManagerNotBetween(Object value, Object value1) {
        ew.notBetween("customer_manager", value, value1);
        return this;
    }

    public AccountInfoCondition orCustomerManagerNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("customer_manager", value, value1);
        return this;
    }

    public AccountInfoCondition andCustomerManagerLike(String value) {
        ew.like("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerNotLike(String value) {
        ew.notLike("customer_manager", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("customer_manager", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneIsNull() {
        ew.isNull("customer_manager_phone");
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("customer_manager_phone");
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneIsNotNull() {
        ew.isNotNull("customer_manager_phone");
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("customer_manager_phone");
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneEq(Object value) {
        ew.eq("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneNe(Object value) {
        ew.ne("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneGt(Object value) {
        ew.gt("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneGe(Object value) {
        ew.ge("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneLt(Object value) {
        ew.lt("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneLe(Object value) {
        ew.le("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneIn(Object... value) {
        ew.in("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneNotIn(Object... value) {
        ew.notIn("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneBetween(Object value, Object value1) {
        ew.between("customer_manager_phone", value, value1);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("customer_manager_phone", value, value1);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneNotBetween(Object value, Object value1) {
        ew.notBetween("customer_manager_phone", value, value1);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("customer_manager_phone", value, value1);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneLike(String value) {
        ew.like("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andCustomerManagerPhoneNotLike(String value) {
        ew.notLike("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition orCustomerManagerPhoneNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("customer_manager_phone", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeIsNull() {
        ew.isNull("enterprise_type");
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("enterprise_type");
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeIsNotNull() {
        ew.isNotNull("enterprise_type");
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("enterprise_type");
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeEq(Object value) {
        ew.eq("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeNe(Object value) {
        ew.ne("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeGt(Object value) {
        ew.gt("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeGe(Object value) {
        ew.ge("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeLt(Object value) {
        ew.lt("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeLe(Object value) {
        ew.le("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeIn(Object... value) {
        ew.in("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeNotIn(Object... value) {
        ew.notIn("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeBetween(Object value, Object value1) {
        ew.between("enterprise_type", value, value1);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("enterprise_type", value, value1);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeNotBetween(Object value, Object value1) {
        ew.notBetween("enterprise_type", value, value1);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("enterprise_type", value, value1);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeLike(String value) {
        ew.like("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseTypeNotLike(String value) {
        ew.notLike("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("enterprise_type", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleIsNull() {
        ew.isNull("enterprise_sale");
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("enterprise_sale");
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleIsNotNull() {
        ew.isNotNull("enterprise_sale");
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("enterprise_sale");
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleEq(Object value) {
        ew.eq("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleNe(Object value) {
        ew.ne("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleGt(Object value) {
        ew.gt("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleGe(Object value) {
        ew.ge("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleLt(Object value) {
        ew.lt("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleLe(Object value) {
        ew.le("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleIn(Object... value) {
        ew.in("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleNotIn(Object... value) {
        ew.notIn("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleBetween(Object value, Object value1) {
        ew.between("enterprise_sale", value, value1);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("enterprise_sale", value, value1);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleNotBetween(Object value, Object value1) {
        ew.notBetween("enterprise_sale", value, value1);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("enterprise_sale", value, value1);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleLike(String value) {
        ew.like("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseSaleNotLike(String value) {
        ew.notLike("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseSaleNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("enterprise_sale", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureIsNull() {
        ew.isNull("enterprise_eco_nature");
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("enterprise_eco_nature");
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureIsNotNull() {
        ew.isNotNull("enterprise_eco_nature");
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("enterprise_eco_nature");
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureEq(Object value) {
        ew.eq("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureNe(Object value) {
        ew.ne("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureGt(Object value) {
        ew.gt("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureGe(Object value) {
        ew.ge("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureLt(Object value) {
        ew.lt("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureLe(Object value) {
        ew.le("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureIn(Object... value) {
        ew.in("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureNotIn(Object... value) {
        ew.notIn("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureBetween(Object value, Object value1) {
        ew.between("enterprise_eco_nature", value, value1);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("enterprise_eco_nature", value, value1);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureNotBetween(Object value, Object value1) {
        ew.notBetween("enterprise_eco_nature", value, value1);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("enterprise_eco_nature", value, value1);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureLike(String value) {
        ew.like("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andEnterpriseEcoNatureNotLike(String value) {
        ew.notLike("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition orEnterpriseEcoNatureNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("enterprise_eco_nature", value);
        return this;
    }

    public AccountInfoCondition andListingTypeIsNull() {
        ew.isNull("listing_type");
        return this;
    }

    public AccountInfoCondition orListingTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("listing_type");
        return this;
    }

    public AccountInfoCondition andListingTypeIsNotNull() {
        ew.isNotNull("listing_type");
        return this;
    }

    public AccountInfoCondition orListingTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("listing_type");
        return this;
    }

    public AccountInfoCondition andListingTypeEq(Object value) {
        ew.eq("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeNe(Object value) {
        ew.ne("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeGt(Object value) {
        ew.gt("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeGe(Object value) {
        ew.ge("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeLt(Object value) {
        ew.lt("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeLe(Object value) {
        ew.le("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeIn(Object... value) {
        ew.in("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeNotIn(Object... value) {
        ew.notIn("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeBetween(Object value, Object value1) {
        ew.between("listing_type", value, value1);
        return this;
    }

    public AccountInfoCondition orListingTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("listing_type", value, value1);
        return this;
    }

    public AccountInfoCondition andListingTypeNotBetween(Object value, Object value1) {
        ew.notBetween("listing_type", value, value1);
        return this;
    }

    public AccountInfoCondition orListingTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("listing_type", value, value1);
        return this;
    }

    public AccountInfoCondition andListingTypeLike(String value) {
        ew.like("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("listing_type", value);
        return this;
    }

    public AccountInfoCondition andListingTypeNotLike(String value) {
        ew.notLike("listing_type", value);
        return this;
    }

    public AccountInfoCondition orListingTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("listing_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeIsNull() {
        ew.isNull("resident_type");
        return this;
    }

    public AccountInfoCondition orResidentTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resident_type");
        return this;
    }

    public AccountInfoCondition andResidentTypeIsNotNull() {
        ew.isNotNull("resident_type");
        return this;
    }

    public AccountInfoCondition orResidentTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resident_type");
        return this;
    }

    public AccountInfoCondition andResidentTypeEq(Object value) {
        ew.eq("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeNe(Object value) {
        ew.ne("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeGt(Object value) {
        ew.gt("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeGe(Object value) {
        ew.ge("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeLt(Object value) {
        ew.lt("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeLe(Object value) {
        ew.le("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeIn(Object... value) {
        ew.in("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeNotIn(Object... value) {
        ew.notIn("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeBetween(Object value, Object value1) {
        ew.between("resident_type", value, value1);
        return this;
    }

    public AccountInfoCondition orResidentTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resident_type", value, value1);
        return this;
    }

    public AccountInfoCondition andResidentTypeNotBetween(Object value, Object value1) {
        ew.notBetween("resident_type", value, value1);
        return this;
    }

    public AccountInfoCondition orResidentTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resident_type", value, value1);
        return this;
    }

    public AccountInfoCondition andResidentTypeLike(String value) {
        ew.like("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resident_type", value);
        return this;
    }

    public AccountInfoCondition andResidentTypeNotLike(String value) {
        ew.notLike("resident_type", value);
        return this;
    }

    public AccountInfoCondition orResidentTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resident_type", value);
        return this;
    }

    public AccountInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public AccountInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public AccountInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public AccountInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public AccountInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public AccountInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public AccountInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public AccountInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public AccountInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public AccountInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public AccountInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public AccountInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountInfoCondition andContactAddressIsNull() {
        ew.isNull("contact_address");
        return this;
    }

    public AccountInfoCondition orContactAddressIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("contact_address");
        return this;
    }

    public AccountInfoCondition andContactAddressIsNotNull() {
        ew.isNotNull("contact_address");
        return this;
    }

    public AccountInfoCondition orContactAddressIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("contact_address");
        return this;
    }

    public AccountInfoCondition andContactAddressEq(Object value) {
        ew.eq("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressNe(Object value) {
        ew.ne("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressGt(Object value) {
        ew.gt("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressGe(Object value) {
        ew.ge("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressLt(Object value) {
        ew.lt("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressLe(Object value) {
        ew.le("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressIn(Object... value) {
        ew.in("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressNotIn(Object... value) {
        ew.notIn("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressBetween(Object value, Object value1) {
        ew.between("contact_address", value, value1);
        return this;
    }

    public AccountInfoCondition orContactAddressBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("contact_address", value, value1);
        return this;
    }

    public AccountInfoCondition andContactAddressNotBetween(Object value, Object value1) {
        ew.notBetween("contact_address", value, value1);
        return this;
    }

    public AccountInfoCondition orContactAddressNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("contact_address", value, value1);
        return this;
    }

    public AccountInfoCondition andContactAddressLike(String value) {
        ew.like("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("contact_address", value);
        return this;
    }

    public AccountInfoCondition andContactAddressNotLike(String value) {
        ew.notLike("contact_address", value);
        return this;
    }

    public AccountInfoCondition orContactAddressNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("contact_address", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateIsNull() {
        ew.isNull("business_start_date");
        return this;
    }

    public AccountInfoCondition orBusinessStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("business_start_date");
        return this;
    }

    public AccountInfoCondition andBusinessStartDateIsNotNull() {
        ew.isNotNull("business_start_date");
        return this;
    }

    public AccountInfoCondition orBusinessStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("business_start_date");
        return this;
    }

    public AccountInfoCondition andBusinessStartDateEq(Object value) {
        ew.eq("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateNe(Object value) {
        ew.ne("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateGt(Object value) {
        ew.gt("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateGe(Object value) {
        ew.ge("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateLt(Object value) {
        ew.lt("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateLe(Object value) {
        ew.le("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateIn(Object... value) {
        ew.in("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateNotIn(Object... value) {
        ew.notIn("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateBetween(Object value, Object value1) {
        ew.between("business_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("business_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("business_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("business_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateLike(String value) {
        ew.like("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andBusinessStartDateNotLike(String value) {
        ew.notLike("business_start_date", value);
        return this;
    }

    public AccountInfoCondition orBusinessStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("business_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateIsNull() {
        ew.isNull("legal_start_date");
        return this;
    }

    public AccountInfoCondition orLegalStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("legal_start_date");
        return this;
    }

    public AccountInfoCondition andLegalStartDateIsNotNull() {
        ew.isNotNull("legal_start_date");
        return this;
    }

    public AccountInfoCondition orLegalStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("legal_start_date");
        return this;
    }

    public AccountInfoCondition andLegalStartDateEq(Object value) {
        ew.eq("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateNe(Object value) {
        ew.ne("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateGt(Object value) {
        ew.gt("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateGe(Object value) {
        ew.ge("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateLt(Object value) {
        ew.lt("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateLe(Object value) {
        ew.le("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateIn(Object... value) {
        ew.in("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateNotIn(Object... value) {
        ew.notIn("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateBetween(Object value, Object value1) {
        ew.between("legal_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orLegalStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("legal_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andLegalStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("legal_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orLegalStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("legal_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andLegalStartDateLike(String value) {
        ew.like("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andLegalStartDateNotLike(String value) {
        ew.notLike("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition orLegalStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("legal_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateIsNull() {
        ew.isNull("control_start_date");
        return this;
    }

    public AccountInfoCondition orControlStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("control_start_date");
        return this;
    }

    public AccountInfoCondition andControlStartDateIsNotNull() {
        ew.isNotNull("control_start_date");
        return this;
    }

    public AccountInfoCondition orControlStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("control_start_date");
        return this;
    }

    public AccountInfoCondition andControlStartDateEq(Object value) {
        ew.eq("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateNe(Object value) {
        ew.ne("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateGt(Object value) {
        ew.gt("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateGe(Object value) {
        ew.ge("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateLt(Object value) {
        ew.lt("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateLe(Object value) {
        ew.le("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateIn(Object... value) {
        ew.in("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateNotIn(Object... value) {
        ew.notIn("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateBetween(Object value, Object value1) {
        ew.between("control_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orControlStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("control_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andControlStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("control_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orControlStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("control_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andControlStartDateLike(String value) {
        ew.like("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andControlStartDateNotLike(String value) {
        ew.notLike("control_start_date", value);
        return this;
    }

    public AccountInfoCondition orControlStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("control_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateIsNull() {
        ew.isNull("auth_bus_start_date");
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_bus_start_date");
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateIsNotNull() {
        ew.isNotNull("auth_bus_start_date");
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_bus_start_date");
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateEq(Object value) {
        ew.eq("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateNe(Object value) {
        ew.ne("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateGt(Object value) {
        ew.gt("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateGe(Object value) {
        ew.ge("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateLt(Object value) {
        ew.lt("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateLe(Object value) {
        ew.le("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateIn(Object... value) {
        ew.in("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateNotIn(Object... value) {
        ew.notIn("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateBetween(Object value, Object value1) {
        ew.between("auth_bus_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_bus_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("auth_bus_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_bus_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateLike(String value) {
        ew.like("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andAuthBusStartDateNotLike(String value) {
        ew.notLike("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition orAuthBusStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_bus_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameIsNull() {
        ew.isNull("ownerone_name");
        return this;
    }

    public AccountInfoCondition orOwneroneNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerone_name");
        return this;
    }

    public AccountInfoCondition andOwneroneNameIsNotNull() {
        ew.isNotNull("ownerone_name");
        return this;
    }

    public AccountInfoCondition orOwneroneNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerone_name");
        return this;
    }

    public AccountInfoCondition andOwneroneNameEq(Object value) {
        ew.eq("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameNe(Object value) {
        ew.ne("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameGt(Object value) {
        ew.gt("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameGe(Object value) {
        ew.ge("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameLt(Object value) {
        ew.lt("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameLe(Object value) {
        ew.le("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameIn(Object... value) {
        ew.in("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameNotIn(Object... value) {
        ew.notIn("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameBetween(Object value, Object value1) {
        ew.between("ownerone_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerone_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneNameNotBetween(Object value, Object value1) {
        ew.notBetween("ownerone_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerone_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneNameLike(String value) {
        ew.like("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneNameNotLike(String value) {
        ew.notLike("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition orOwneroneNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerone_name", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeIsNull() {
        ew.isNull("ownerone_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerone_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeIsNotNull() {
        ew.isNotNull("ownerone_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerone_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeEq(Object value) {
        ew.eq("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeNe(Object value) {
        ew.ne("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeGt(Object value) {
        ew.gt("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeGe(Object value) {
        ew.ge("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeLt(Object value) {
        ew.lt("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeLe(Object value) {
        ew.le("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeIn(Object... value) {
        ew.in("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeNotIn(Object... value) {
        ew.notIn("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeBetween(Object value, Object value1) {
        ew.between("ownerone_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerone_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("ownerone_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerone_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeLike(String value) {
        ew.like("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileTypeNotLike(String value) {
        ew.notLike("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerone_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoIsNull() {
        ew.isNull("ownerone_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerone_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoIsNotNull() {
        ew.isNotNull("ownerone_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerone_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoEq(Object value) {
        ew.eq("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoNe(Object value) {
        ew.ne("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoGt(Object value) {
        ew.gt("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoGe(Object value) {
        ew.ge("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoLt(Object value) {
        ew.lt("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoLe(Object value) {
        ew.le("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoIn(Object... value) {
        ew.in("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoNotIn(Object... value) {
        ew.notIn("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoBetween(Object value, Object value1) {
        ew.between("ownerone_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerone_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoNotBetween(Object value, Object value1) {
        ew.notBetween("ownerone_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerone_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoLike(String value) {
        ew.like("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneCerfileNoNotLike(String value) {
        ew.notLike("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwneroneCerfileNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerone_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateIsNull() {
        ew.isNull("ownerone_start_date");
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerone_start_date");
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateIsNotNull() {
        ew.isNotNull("ownerone_start_date");
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerone_start_date");
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateEq(Object value) {
        ew.eq("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateNe(Object value) {
        ew.ne("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateGt(Object value) {
        ew.gt("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateGe(Object value) {
        ew.ge("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateLt(Object value) {
        ew.lt("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateLe(Object value) {
        ew.le("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateIn(Object... value) {
        ew.in("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateNotIn(Object... value) {
        ew.notIn("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateBetween(Object value, Object value1) {
        ew.between("ownerone_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerone_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownerone_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerone_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateLike(String value) {
        ew.like("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneStartDateNotLike(String value) {
        ew.notLike("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerone_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateIsNull() {
        ew.isNull("ownerone_in_date");
        return this;
    }

    public AccountInfoCondition orOwneroneInDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerone_in_date");
        return this;
    }

    public AccountInfoCondition andOwneroneInDateIsNotNull() {
        ew.isNotNull("ownerone_in_date");
        return this;
    }

    public AccountInfoCondition orOwneroneInDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerone_in_date");
        return this;
    }

    public AccountInfoCondition andOwneroneInDateEq(Object value) {
        ew.eq("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateNe(Object value) {
        ew.ne("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateGt(Object value) {
        ew.gt("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateGe(Object value) {
        ew.ge("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateLt(Object value) {
        ew.lt("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateLe(Object value) {
        ew.le("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateIn(Object... value) {
        ew.in("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateNotIn(Object... value) {
        ew.notIn("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateBetween(Object value, Object value1) {
        ew.between("ownerone_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerone_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownerone_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerone_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateLike(String value) {
        ew.like("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwneroneInDateNotLike(String value) {
        ew.notLike("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwneroneInDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerone_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameIsNull() {
        ew.isNull("ownertwo_name");
        return this;
    }

    public AccountInfoCondition orOwnertwoNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownertwo_name");
        return this;
    }

    public AccountInfoCondition andOwnertwoNameIsNotNull() {
        ew.isNotNull("ownertwo_name");
        return this;
    }

    public AccountInfoCondition orOwnertwoNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownertwo_name");
        return this;
    }

    public AccountInfoCondition andOwnertwoNameEq(Object value) {
        ew.eq("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameNe(Object value) {
        ew.ne("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameGt(Object value) {
        ew.gt("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameGe(Object value) {
        ew.ge("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameLt(Object value) {
        ew.lt("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameLe(Object value) {
        ew.le("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameIn(Object... value) {
        ew.in("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameNotIn(Object... value) {
        ew.notIn("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameBetween(Object value, Object value1) {
        ew.between("ownertwo_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownertwo_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameNotBetween(Object value, Object value1) {
        ew.notBetween("ownertwo_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownertwo_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameLike(String value) {
        ew.like("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoNameNotLike(String value) {
        ew.notLike("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownertwo_name", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeIsNull() {
        ew.isNull("ownertwo_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownertwo_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeIsNotNull() {
        ew.isNotNull("ownertwo_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownertwo_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeEq(Object value) {
        ew.eq("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeNe(Object value) {
        ew.ne("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeGt(Object value) {
        ew.gt("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeGe(Object value) {
        ew.ge("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeLt(Object value) {
        ew.lt("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeLe(Object value) {
        ew.le("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeIn(Object... value) {
        ew.in("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeNotIn(Object... value) {
        ew.notIn("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeBetween(Object value, Object value1) {
        ew.between("ownertwo_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownertwo_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("ownertwo_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownertwo_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeLike(String value) {
        ew.like("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileTypeNotLike(String value) {
        ew.notLike("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownertwo_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoIsNull() {
        ew.isNull("ownertwo_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownertwo_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoIsNotNull() {
        ew.isNotNull("ownertwo_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownertwo_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoEq(Object value) {
        ew.eq("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoNe(Object value) {
        ew.ne("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoGt(Object value) {
        ew.gt("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoGe(Object value) {
        ew.ge("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoLt(Object value) {
        ew.lt("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoLe(Object value) {
        ew.le("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoIn(Object... value) {
        ew.in("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoNotIn(Object... value) {
        ew.notIn("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoBetween(Object value, Object value1) {
        ew.between("ownertwo_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownertwo_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoNotBetween(Object value, Object value1) {
        ew.notBetween("ownertwo_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownertwo_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoLike(String value) {
        ew.like("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoCerfileNoNotLike(String value) {
        ew.notLike("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoCerfileNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownertwo_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateIsNull() {
        ew.isNull("ownertwo_start_date");
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownertwo_start_date");
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateIsNotNull() {
        ew.isNotNull("ownertwo_start_date");
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownertwo_start_date");
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateEq(Object value) {
        ew.eq("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateNe(Object value) {
        ew.ne("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateGt(Object value) {
        ew.gt("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateGe(Object value) {
        ew.ge("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateLt(Object value) {
        ew.lt("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateLe(Object value) {
        ew.le("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateIn(Object... value) {
        ew.in("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateNotIn(Object... value) {
        ew.notIn("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateBetween(Object value, Object value1) {
        ew.between("ownertwo_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownertwo_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownertwo_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownertwo_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateLike(String value) {
        ew.like("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoStartDateNotLike(String value) {
        ew.notLike("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownertwo_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateIsNull() {
        ew.isNull("ownertwo_in_date");
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownertwo_in_date");
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateIsNotNull() {
        ew.isNotNull("ownertwo_in_date");
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownertwo_in_date");
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateEq(Object value) {
        ew.eq("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateNe(Object value) {
        ew.ne("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateGt(Object value) {
        ew.gt("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateGe(Object value) {
        ew.ge("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateLt(Object value) {
        ew.lt("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateLe(Object value) {
        ew.le("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateIn(Object... value) {
        ew.in("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateNotIn(Object... value) {
        ew.notIn("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateBetween(Object value, Object value1) {
        ew.between("ownertwo_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownertwo_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownertwo_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownertwo_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateLike(String value) {
        ew.like("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnertwoInDateNotLike(String value) {
        ew.notLike("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnertwoInDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownertwo_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameIsNull() {
        ew.isNull("ownerthree_name");
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerthree_name");
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameIsNotNull() {
        ew.isNotNull("ownerthree_name");
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerthree_name");
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameEq(Object value) {
        ew.eq("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameNe(Object value) {
        ew.ne("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameGt(Object value) {
        ew.gt("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameGe(Object value) {
        ew.ge("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameLt(Object value) {
        ew.lt("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameLe(Object value) {
        ew.le("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameIn(Object... value) {
        ew.in("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameNotIn(Object... value) {
        ew.notIn("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameBetween(Object value, Object value1) {
        ew.between("ownerthree_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerthree_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameNotBetween(Object value, Object value1) {
        ew.notBetween("ownerthree_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerthree_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameLike(String value) {
        ew.like("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeNameNotLike(String value) {
        ew.notLike("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerthree_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeIsNull() {
        ew.isNull("ownerthree_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerthree_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeIsNotNull() {
        ew.isNotNull("ownerthree_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerthree_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeEq(Object value) {
        ew.eq("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeNe(Object value) {
        ew.ne("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeGt(Object value) {
        ew.gt("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeGe(Object value) {
        ew.ge("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeLt(Object value) {
        ew.lt("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeLe(Object value) {
        ew.le("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeIn(Object... value) {
        ew.in("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeNotIn(Object... value) {
        ew.notIn("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeBetween(Object value, Object value1) {
        ew.between("ownerthree_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerthree_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("ownerthree_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerthree_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeLike(String value) {
        ew.like("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileTypeNotLike(String value) {
        ew.notLike("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerthree_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoIsNull() {
        ew.isNull("ownerthree_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerthree_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoIsNotNull() {
        ew.isNotNull("ownerthree_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerthree_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoEq(Object value) {
        ew.eq("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoNe(Object value) {
        ew.ne("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoGt(Object value) {
        ew.gt("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoGe(Object value) {
        ew.ge("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoLt(Object value) {
        ew.lt("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoLe(Object value) {
        ew.le("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoIn(Object... value) {
        ew.in("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoNotIn(Object... value) {
        ew.notIn("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoBetween(Object value, Object value1) {
        ew.between("ownerthree_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerthree_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoNotBetween(Object value, Object value1) {
        ew.notBetween("ownerthree_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerthree_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoLike(String value) {
        ew.like("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeCerfileNoNotLike(String value) {
        ew.notLike("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeCerfileNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerthree_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateIsNull() {
        ew.isNull("ownerthree_start_date");
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerthree_start_date");
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateIsNotNull() {
        ew.isNotNull("ownerthree_start_date");
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerthree_start_date");
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateEq(Object value) {
        ew.eq("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateNe(Object value) {
        ew.ne("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateGt(Object value) {
        ew.gt("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateGe(Object value) {
        ew.ge("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateLt(Object value) {
        ew.lt("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateLe(Object value) {
        ew.le("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateIn(Object... value) {
        ew.in("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateNotIn(Object... value) {
        ew.notIn("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateBetween(Object value, Object value1) {
        ew.between("ownerthree_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerthree_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownerthree_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerthree_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateLike(String value) {
        ew.like("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeStartDateNotLike(String value) {
        ew.notLike("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerthree_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateIsNull() {
        ew.isNull("ownerthree_in_date");
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerthree_in_date");
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateIsNotNull() {
        ew.isNotNull("ownerthree_in_date");
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerthree_in_date");
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateEq(Object value) {
        ew.eq("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateNe(Object value) {
        ew.ne("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateGt(Object value) {
        ew.gt("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateGe(Object value) {
        ew.ge("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateLt(Object value) {
        ew.lt("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateLe(Object value) {
        ew.le("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateIn(Object... value) {
        ew.in("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateNotIn(Object... value) {
        ew.notIn("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateBetween(Object value, Object value1) {
        ew.between("ownerthree_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerthree_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownerthree_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerthree_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateLike(String value) {
        ew.like("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerthreeInDateNotLike(String value) {
        ew.notLike("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerthreeInDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerthree_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameIsNull() {
        ew.isNull("ownerfour_name");
        return this;
    }

    public AccountInfoCondition orOwnerfourNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerfour_name");
        return this;
    }

    public AccountInfoCondition andOwnerfourNameIsNotNull() {
        ew.isNotNull("ownerfour_name");
        return this;
    }

    public AccountInfoCondition orOwnerfourNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerfour_name");
        return this;
    }

    public AccountInfoCondition andOwnerfourNameEq(Object value) {
        ew.eq("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameNe(Object value) {
        ew.ne("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameGt(Object value) {
        ew.gt("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameGe(Object value) {
        ew.ge("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameLt(Object value) {
        ew.lt("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameLe(Object value) {
        ew.le("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameIn(Object... value) {
        ew.in("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameNotIn(Object... value) {
        ew.notIn("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameBetween(Object value, Object value1) {
        ew.between("ownerfour_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerfour_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameNotBetween(Object value, Object value1) {
        ew.notBetween("ownerfour_name", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerfour_name", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameLike(String value) {
        ew.like("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourNameNotLike(String value) {
        ew.notLike("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerfour_name", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeIsNull() {
        ew.isNull("ownerfour_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerfour_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeIsNotNull() {
        ew.isNotNull("ownerfour_cerfile_type");
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerfour_cerfile_type");
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeEq(Object value) {
        ew.eq("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeNe(Object value) {
        ew.ne("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeGt(Object value) {
        ew.gt("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeGe(Object value) {
        ew.ge("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeLt(Object value) {
        ew.lt("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeLe(Object value) {
        ew.le("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeIn(Object... value) {
        ew.in("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeNotIn(Object... value) {
        ew.notIn("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeBetween(Object value, Object value1) {
        ew.between("ownerfour_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerfour_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("ownerfour_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerfour_cerfile_type", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeLike(String value) {
        ew.like("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileTypeNotLike(String value) {
        ew.notLike("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerfour_cerfile_type", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoIsNull() {
        ew.isNull("ownerfour_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerfour_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoIsNotNull() {
        ew.isNotNull("ownerfour_cerfile_no");
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerfour_cerfile_no");
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoEq(Object value) {
        ew.eq("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoNe(Object value) {
        ew.ne("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoGt(Object value) {
        ew.gt("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoGe(Object value) {
        ew.ge("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoLt(Object value) {
        ew.lt("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoLe(Object value) {
        ew.le("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoIn(Object... value) {
        ew.in("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoNotIn(Object... value) {
        ew.notIn("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoBetween(Object value, Object value1) {
        ew.between("ownerfour_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerfour_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoNotBetween(Object value, Object value1) {
        ew.notBetween("ownerfour_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerfour_cerfile_no", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoLike(String value) {
        ew.like("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourCerfileNoNotLike(String value) {
        ew.notLike("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourCerfileNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerfour_cerfile_no", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateIsNull() {
        ew.isNull("ownerfour_start_date");
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerfour_start_date");
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateIsNotNull() {
        ew.isNotNull("ownerfour_start_date");
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerfour_start_date");
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateEq(Object value) {
        ew.eq("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateNe(Object value) {
        ew.ne("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateGt(Object value) {
        ew.gt("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateGe(Object value) {
        ew.ge("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateLt(Object value) {
        ew.lt("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateLe(Object value) {
        ew.le("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateIn(Object... value) {
        ew.in("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateNotIn(Object... value) {
        ew.notIn("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateBetween(Object value, Object value1) {
        ew.between("ownerfour_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerfour_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownerfour_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerfour_start_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateLike(String value) {
        ew.like("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourStartDateNotLike(String value) {
        ew.notLike("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourStartDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerfour_start_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateIsNull() {
        ew.isNull("ownerfour_in_date");
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ownerfour_in_date");
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateIsNotNull() {
        ew.isNotNull("ownerfour_in_date");
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ownerfour_in_date");
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateEq(Object value) {
        ew.eq("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateNe(Object value) {
        ew.ne("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateGt(Object value) {
        ew.gt("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateGe(Object value) {
        ew.ge("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateLt(Object value) {
        ew.lt("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateLe(Object value) {
        ew.le("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateIn(Object... value) {
        ew.in("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateNotIn(Object... value) {
        ew.notIn("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateBetween(Object value, Object value1) {
        ew.between("ownerfour_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ownerfour_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateNotBetween(Object value, Object value1) {
        ew.notBetween("ownerfour_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ownerfour_in_date", value, value1);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateLike(String value) {
        ew.like("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andOwnerfourInDateNotLike(String value) {
        ew.notLike("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition orOwnerfourInDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ownerfour_in_date", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceIsNull() {
        ew.isNull("contact_province");
        return this;
    }

    public AccountInfoCondition orContactProvinceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("contact_province");
        return this;
    }

    public AccountInfoCondition andContactProvinceIsNotNull() {
        ew.isNotNull("contact_province");
        return this;
    }

    public AccountInfoCondition orContactProvinceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("contact_province");
        return this;
    }

    public AccountInfoCondition andContactProvinceEq(Object value) {
        ew.eq("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceNe(Object value) {
        ew.ne("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceGt(Object value) {
        ew.gt("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceGe(Object value) {
        ew.ge("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceLt(Object value) {
        ew.lt("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceLe(Object value) {
        ew.le("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceIn(Object... value) {
        ew.in("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceNotIn(Object... value) {
        ew.notIn("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceBetween(Object value, Object value1) {
        ew.between("contact_province", value, value1);
        return this;
    }

    public AccountInfoCondition orContactProvinceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("contact_province", value, value1);
        return this;
    }

    public AccountInfoCondition andContactProvinceNotBetween(Object value, Object value1) {
        ew.notBetween("contact_province", value, value1);
        return this;
    }

    public AccountInfoCondition orContactProvinceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("contact_province", value, value1);
        return this;
    }

    public AccountInfoCondition andContactProvinceLike(String value) {
        ew.like("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactProvinceNotLike(String value) {
        ew.notLike("contact_province", value);
        return this;
    }

    public AccountInfoCondition orContactProvinceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("contact_province", value);
        return this;
    }

    public AccountInfoCondition andContactCityIsNull() {
        ew.isNull("contact_city");
        return this;
    }

    public AccountInfoCondition orContactCityIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("contact_city");
        return this;
    }

    public AccountInfoCondition andContactCityIsNotNull() {
        ew.isNotNull("contact_city");
        return this;
    }

    public AccountInfoCondition orContactCityIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("contact_city");
        return this;
    }

    public AccountInfoCondition andContactCityEq(Object value) {
        ew.eq("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityNe(Object value) {
        ew.ne("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityGt(Object value) {
        ew.gt("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityGe(Object value) {
        ew.ge("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityLt(Object value) {
        ew.lt("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityLe(Object value) {
        ew.le("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityIn(Object... value) {
        ew.in("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityNotIn(Object... value) {
        ew.notIn("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityBetween(Object value, Object value1) {
        ew.between("contact_city", value, value1);
        return this;
    }

    public AccountInfoCondition orContactCityBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("contact_city", value, value1);
        return this;
    }

    public AccountInfoCondition andContactCityNotBetween(Object value, Object value1) {
        ew.notBetween("contact_city", value, value1);
        return this;
    }

    public AccountInfoCondition orContactCityNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("contact_city", value, value1);
        return this;
    }

    public AccountInfoCondition andContactCityLike(String value) {
        ew.like("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactCityNotLike(String value) {
        ew.notLike("contact_city", value);
        return this;
    }

    public AccountInfoCondition orContactCityNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("contact_city", value);
        return this;
    }

    public AccountInfoCondition andContactAreaIsNull() {
        ew.isNull("contact_area");
        return this;
    }

    public AccountInfoCondition orContactAreaIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("contact_area");
        return this;
    }

    public AccountInfoCondition andContactAreaIsNotNull() {
        ew.isNotNull("contact_area");
        return this;
    }

    public AccountInfoCondition orContactAreaIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("contact_area");
        return this;
    }

    public AccountInfoCondition andContactAreaEq(Object value) {
        ew.eq("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaNe(Object value) {
        ew.ne("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaGt(Object value) {
        ew.gt("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaGe(Object value) {
        ew.ge("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaLt(Object value) {
        ew.lt("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaLe(Object value) {
        ew.le("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaIn(Object... value) {
        ew.in("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaNotIn(Object... value) {
        ew.notIn("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaBetween(Object value, Object value1) {
        ew.between("contact_area", value, value1);
        return this;
    }

    public AccountInfoCondition orContactAreaBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("contact_area", value, value1);
        return this;
    }

    public AccountInfoCondition andContactAreaNotBetween(Object value, Object value1) {
        ew.notBetween("contact_area", value, value1);
        return this;
    }

    public AccountInfoCondition orContactAreaNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("contact_area", value, value1);
        return this;
    }

    public AccountInfoCondition andContactAreaLike(String value) {
        ew.like("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("contact_area", value);
        return this;
    }

    public AccountInfoCondition andContactAreaNotLike(String value) {
        ew.notLike("contact_area", value);
        return this;
    }

    public AccountInfoCondition orContactAreaNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("contact_area", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceIsNull() {
        ew.isNull("reg_province");
        return this;
    }

    public AccountInfoCondition orRegProvinceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reg_province");
        return this;
    }

    public AccountInfoCondition andRegProvinceIsNotNull() {
        ew.isNotNull("reg_province");
        return this;
    }

    public AccountInfoCondition orRegProvinceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reg_province");
        return this;
    }

    public AccountInfoCondition andRegProvinceEq(Object value) {
        ew.eq("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceNe(Object value) {
        ew.ne("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceGt(Object value) {
        ew.gt("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceGe(Object value) {
        ew.ge("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceLt(Object value) {
        ew.lt("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceLe(Object value) {
        ew.le("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceIn(Object... value) {
        ew.in("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceNotIn(Object... value) {
        ew.notIn("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceBetween(Object value, Object value1) {
        ew.between("reg_province", value, value1);
        return this;
    }

    public AccountInfoCondition orRegProvinceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reg_province", value, value1);
        return this;
    }

    public AccountInfoCondition andRegProvinceNotBetween(Object value, Object value1) {
        ew.notBetween("reg_province", value, value1);
        return this;
    }

    public AccountInfoCondition orRegProvinceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reg_province", value, value1);
        return this;
    }

    public AccountInfoCondition andRegProvinceLike(String value) {
        ew.like("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegProvinceNotLike(String value) {
        ew.notLike("reg_province", value);
        return this;
    }

    public AccountInfoCondition orRegProvinceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reg_province", value);
        return this;
    }

    public AccountInfoCondition andRegCityIsNull() {
        ew.isNull("reg_city");
        return this;
    }

    public AccountInfoCondition orRegCityIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reg_city");
        return this;
    }

    public AccountInfoCondition andRegCityIsNotNull() {
        ew.isNotNull("reg_city");
        return this;
    }

    public AccountInfoCondition orRegCityIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reg_city");
        return this;
    }

    public AccountInfoCondition andRegCityEq(Object value) {
        ew.eq("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityNe(Object value) {
        ew.ne("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityGt(Object value) {
        ew.gt("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityGe(Object value) {
        ew.ge("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityLt(Object value) {
        ew.lt("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityLe(Object value) {
        ew.le("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityIn(Object... value) {
        ew.in("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityNotIn(Object... value) {
        ew.notIn("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityBetween(Object value, Object value1) {
        ew.between("reg_city", value, value1);
        return this;
    }

    public AccountInfoCondition orRegCityBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reg_city", value, value1);
        return this;
    }

    public AccountInfoCondition andRegCityNotBetween(Object value, Object value1) {
        ew.notBetween("reg_city", value, value1);
        return this;
    }

    public AccountInfoCondition orRegCityNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reg_city", value, value1);
        return this;
    }

    public AccountInfoCondition andRegCityLike(String value) {
        ew.like("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegCityNotLike(String value) {
        ew.notLike("reg_city", value);
        return this;
    }

    public AccountInfoCondition orRegCityNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reg_city", value);
        return this;
    }

    public AccountInfoCondition andRegAreaIsNull() {
        ew.isNull("reg_area");
        return this;
    }

    public AccountInfoCondition orRegAreaIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reg_area");
        return this;
    }

    public AccountInfoCondition andRegAreaIsNotNull() {
        ew.isNotNull("reg_area");
        return this;
    }

    public AccountInfoCondition orRegAreaIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reg_area");
        return this;
    }

    public AccountInfoCondition andRegAreaEq(Object value) {
        ew.eq("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaNe(Object value) {
        ew.ne("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaGt(Object value) {
        ew.gt("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaGe(Object value) {
        ew.ge("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaLt(Object value) {
        ew.lt("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaLe(Object value) {
        ew.le("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaIn(Object... value) {
        ew.in("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaNotIn(Object... value) {
        ew.notIn("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaBetween(Object value, Object value1) {
        ew.between("reg_area", value, value1);
        return this;
    }

    public AccountInfoCondition orRegAreaBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reg_area", value, value1);
        return this;
    }

    public AccountInfoCondition andRegAreaNotBetween(Object value, Object value1) {
        ew.notBetween("reg_area", value, value1);
        return this;
    }

    public AccountInfoCondition orRegAreaNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reg_area", value, value1);
        return this;
    }

    public AccountInfoCondition andRegAreaLike(String value) {
        ew.like("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reg_area", value);
        return this;
    }

    public AccountInfoCondition andRegAreaNotLike(String value) {
        ew.notLike("reg_area", value);
        return this;
    }

    public AccountInfoCondition orRegAreaNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reg_area", value);
        return this;
    }
}