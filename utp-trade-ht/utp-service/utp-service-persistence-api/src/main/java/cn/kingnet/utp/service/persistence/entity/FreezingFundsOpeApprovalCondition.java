package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class FreezingFundsOpeApprovalCondition {
    private PlusEntityWrapper<FreezingFundsOpeApproval> ew;

    public FreezingFundsOpeApprovalCondition() {
        this.ew = new PlusEntityWrapper(FreezingFundsOpeApproval.class);
    }

    public static FreezingFundsOpeApprovalCondition builder() {
        return new FreezingFundsOpeApprovalCondition();
    }

    public PlusEntityWrapper<FreezingFundsOpeApproval> build() {
        return this.ew;
    }

    public FreezingFundsOpeApprovalCondition or() {
        this.ew.orNew();
        return this;
    }

    public FreezingFundsOpeApprovalCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(FreezingFundsOpeApproval.class);
    }

    public FreezingFundsOpeApprovalCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public FreezingFundsOpeApprovalCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> FreezingFundsOpeApprovalCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> FreezingFundsOpeApprovalCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> FreezingFundsOpeApprovalCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public FreezingFundsOpeApprovalCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public FreezingFundsOpeApprovalCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public FreezingFundsOpeApprovalCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeIsNull() {
        ew.isNull("obj_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("obj_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeIsNotNull() {
        ew.isNotNull("obj_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("obj_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeEq(Object value) {
        ew.eq("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeNe(Object value) {
        ew.ne("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeGt(Object value) {
        ew.gt("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeGe(Object value) {
        ew.ge("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeLt(Object value) {
        ew.lt("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeLe(Object value) {
        ew.le("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeIn(Object... value) {
        ew.in("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeNotIn(Object... value) {
        ew.notIn("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeBetween(Object value, Object value1) {
        ew.between("obj_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("obj_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeNotBetween(Object value, Object value1) {
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeLike(String value) {
        ew.like("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjTypeNotLike(String value) {
        ew.notLike("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("obj_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeIsNull() {
        ew.isNull("bus_lic_code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bus_lic_code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeIsNotNull() {
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeEq(Object value) {
        ew.eq("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeNe(Object value) {
        ew.ne("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeGt(Object value) {
        ew.gt("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeGe(Object value) {
        ew.ge("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeLt(Object value) {
        ew.lt("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeLe(Object value) {
        ew.le("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeIn(Object... value) {
        ew.in("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeNotIn(Object... value) {
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeBetween(Object value, Object value1) {
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeLike(String value) {
        ew.like("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andBusLicCodeNotLike(String value) {
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orBusLicCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameIsNull() {
        ew.isNull("obj_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("obj_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameIsNotNull() {
        ew.isNotNull("obj_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("obj_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameEq(Object value) {
        ew.eq("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameNe(Object value) {
        ew.ne("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameGt(Object value) {
        ew.gt("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameGe(Object value) {
        ew.ge("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameLt(Object value) {
        ew.lt("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameLe(Object value) {
        ew.le("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameIn(Object... value) {
        ew.in("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameNotIn(Object... value) {
        ew.notIn("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameBetween(Object value, Object value1) {
        ew.between("obj_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("obj_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameNotBetween(Object value, Object value1) {
        ew.notBetween("obj_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("obj_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameLike(String value) {
        ew.like("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andObjNameNotLike(String value) {
        ew.notLike("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orObjNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("obj_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeIsNull() {
        ew.isNull("code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeIsNotNull() {
        ew.isNotNull("code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("code");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeEq(Object value) {
        ew.eq("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeNe(Object value) {
        ew.ne("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeGt(Object value) {
        ew.gt("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeGe(Object value) {
        ew.ge("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeLt(Object value) {
        ew.lt("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeLe(Object value) {
        ew.le("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeIn(Object... value) {
        ew.in("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeNotIn(Object... value) {
        ew.notIn("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeBetween(Object value, Object value1) {
        ew.between("code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeNotBetween(Object value, Object value1) {
        ew.notBetween("code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("code", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeLike(String value) {
        ew.like("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andCodeNotLike(String value) {
        ew.notLike("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("code", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameIsNull() {
        ew.isNull("ind_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ind_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameIsNotNull() {
        ew.isNotNull("ind_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ind_name");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameEq(Object value) {
        ew.eq("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameNe(Object value) {
        ew.ne("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameGt(Object value) {
        ew.gt("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameGe(Object value) {
        ew.ge("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameLt(Object value) {
        ew.lt("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameLe(Object value) {
        ew.le("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameIn(Object... value) {
        ew.in("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameNotIn(Object... value) {
        ew.notIn("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameBetween(Object value, Object value1) {
        ew.between("ind_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ind_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameNotBetween(Object value, Object value1) {
        ew.notBetween("ind_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ind_name", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameLike(String value) {
        ew.like("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andIndNameNotLike(String value) {
        ew.notLike("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orIndNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ind_name", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeIsNull() {
        ew.isNull("operation_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("operation_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeIsNotNull() {
        ew.isNotNull("operation_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("operation_type");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeEq(Object value) {
        ew.eq("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeNe(Object value) {
        ew.ne("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeGt(Object value) {
        ew.gt("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeGe(Object value) {
        ew.ge("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeLt(Object value) {
        ew.lt("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeLe(Object value) {
        ew.le("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeIn(Object... value) {
        ew.in("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeNotIn(Object... value) {
        ew.notIn("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeBetween(Object value, Object value1) {
        ew.between("operation_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("operation_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeNotBetween(Object value, Object value1) {
        ew.notBetween("operation_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("operation_type", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeLike(String value) {
        ew.like("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andOperationTypeNotLike(String value) {
        ew.notLike("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orOperationTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("operation_type", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountIsNull() {
        ew.isNull("frozen_amount");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("frozen_amount");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountIsNotNull() {
        ew.isNotNull("frozen_amount");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("frozen_amount");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountEq(Object value) {
        ew.eq("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountNe(Object value) {
        ew.ne("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountGt(Object value) {
        ew.gt("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountGe(Object value) {
        ew.ge("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountLt(Object value) {
        ew.lt("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountLe(Object value) {
        ew.le("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountIn(Object... value) {
        ew.in("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountNotIn(Object... value) {
        ew.notIn("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountBetween(Object value, Object value1) {
        ew.between("frozen_amount", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("frozen_amount", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountNotBetween(Object value, Object value1) {
        ew.notBetween("frozen_amount", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("frozen_amount", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountLike(String value) {
        ew.like("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFrozenAmountNotLike(String value) {
        ew.notLike("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFrozenAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("frozen_amount", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkIsNull() {
        ew.isNull("audit_remark");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("audit_remark");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkIsNotNull() {
        ew.isNotNull("audit_remark");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("audit_remark");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkEq(Object value) {
        ew.eq("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkNe(Object value) {
        ew.ne("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkGt(Object value) {
        ew.gt("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkGe(Object value) {
        ew.ge("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkLt(Object value) {
        ew.lt("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkLe(Object value) {
        ew.le("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkIn(Object... value) {
        ew.in("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkNotIn(Object... value) {
        ew.notIn("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkBetween(Object value, Object value1) {
        ew.between("audit_remark", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("audit_remark", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("audit_remark", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("audit_remark", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkLike(String value) {
        ew.like("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditRemarkNotLike(String value) {
        ew.notLike("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("audit_remark", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdIsNull() {
        ew.isNull("clinet_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("clinet_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdIsNotNull() {
        ew.isNotNull("clinet_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("clinet_trans_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdEq(Object value) {
        ew.eq("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdNe(Object value) {
        ew.ne("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdGt(Object value) {
        ew.gt("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdGe(Object value) {
        ew.ge("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdLt(Object value) {
        ew.lt("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdLe(Object value) {
        ew.le("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdIn(Object... value) {
        ew.in("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdNotIn(Object... value) {
        ew.notIn("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdBetween(Object value, Object value1) {
        ew.between("clinet_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("clinet_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("clinet_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("clinet_trans_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdLike(String value) {
        ew.like("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andClinetTransIdNotLike(String value) {
        ew.notLike("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orClinetTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("clinet_trans_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrIsNull() {
        ew.isNull("add_usr");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("add_usr");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrIsNotNull() {
        ew.isNotNull("add_usr");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("add_usr");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrEq(Object value) {
        ew.eq("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrNe(Object value) {
        ew.ne("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrGt(Object value) {
        ew.gt("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrGe(Object value) {
        ew.ge("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrLt(Object value) {
        ew.lt("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrLe(Object value) {
        ew.le("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrIn(Object... value) {
        ew.in("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrNotIn(Object... value) {
        ew.notIn("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrBetween(Object value, Object value1) {
        ew.between("add_usr", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("add_usr", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrNotBetween(Object value, Object value1) {
        ew.notBetween("add_usr", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("add_usr", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrLike(String value) {
        ew.like("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAddUsrNotLike(String value) {
        ew.notLike("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAddUsrNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("add_usr", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusIsNull() {
        ew.isNull("audit_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("audit_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusIsNotNull() {
        ew.isNotNull("audit_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("audit_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusEq(Object value) {
        ew.eq("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusNe(Object value) {
        ew.ne("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusGt(Object value) {
        ew.gt("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusGe(Object value) {
        ew.ge("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusLt(Object value) {
        ew.lt("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusLe(Object value) {
        ew.le("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusIn(Object... value) {
        ew.in("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusNotIn(Object... value) {
        ew.notIn("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusBetween(Object value, Object value1) {
        ew.between("audit_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("audit_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusNotBetween(Object value, Object value1) {
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusLike(String value) {
        ew.like("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andAuditStatusNotLike(String value) {
        ew.notLike("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orAuditStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("audit_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgIsNull() {
        ew.isNull("resp_msg");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_msg");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgIsNotNull() {
        ew.isNotNull("resp_msg");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_msg");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgEq(Object value) {
        ew.eq("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgNe(Object value) {
        ew.ne("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgGt(Object value) {
        ew.gt("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgGe(Object value) {
        ew.ge("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgLt(Object value) {
        ew.lt("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgLe(Object value) {
        ew.le("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgIn(Object... value) {
        ew.in("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgNotIn(Object... value) {
        ew.notIn("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgBetween(Object value, Object value1) {
        ew.between("resp_msg", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_msg", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgNotBetween(Object value, Object value1) {
        ew.notBetween("resp_msg", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_msg", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgLike(String value) {
        ew.like("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andRespMsgNotLike(String value) {
        ew.notLike("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orRespMsgNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_msg", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdIsNull() {
        ew.isNull("freeze_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("freeze_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdIsNotNull() {
        ew.isNotNull("freeze_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("freeze_id");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdEq(Object value) {
        ew.eq("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdNe(Object value) {
        ew.ne("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdGt(Object value) {
        ew.gt("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdGe(Object value) {
        ew.ge("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdLt(Object value) {
        ew.lt("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdLe(Object value) {
        ew.le("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdIn(Object... value) {
        ew.in("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdNotIn(Object... value) {
        ew.notIn("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdBetween(Object value, Object value1) {
        ew.between("freeze_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("freeze_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdNotBetween(Object value, Object value1) {
        ew.notBetween("freeze_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("freeze_id", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdLike(String value) {
        ew.like("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andFreezeIdNotLike(String value) {
        ew.notLike("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orFreezeIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("freeze_id", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusIsNull() {
        ew.isNull("unfreeze_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("unfreeze_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusIsNotNull() {
        ew.isNotNull("unfreeze_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("unfreeze_status");
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusEq(Object value) {
        ew.eq("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusNe(Object value) {
        ew.ne("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusGt(Object value) {
        ew.gt("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusGe(Object value) {
        ew.ge("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusLt(Object value) {
        ew.lt("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusLe(Object value) {
        ew.le("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusIn(Object... value) {
        ew.in("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusNotIn(Object... value) {
        ew.notIn("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusBetween(Object value, Object value1) {
        ew.between("unfreeze_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("unfreeze_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusNotBetween(Object value, Object value1) {
        ew.notBetween("unfreeze_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("unfreeze_status", value, value1);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusLike(String value) {
        ew.like("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition andUnfreezeStatusNotLike(String value) {
        ew.notLike("unfreeze_status", value);
        return this;
    }

    public FreezingFundsOpeApprovalCondition orUnfreezeStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("unfreeze_status", value);
        return this;
    }
}