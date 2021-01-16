package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class FeeIncomeAccountMonthStatCondition {
    private PlusEntityWrapper<FeeIncomeAccountMonthStat> ew;

    public FeeIncomeAccountMonthStatCondition() {
        this.ew = new PlusEntityWrapper(FeeIncomeAccountMonthStat.class);
    }

    public static FeeIncomeAccountMonthStatCondition builder() {
        return new FeeIncomeAccountMonthStatCondition();
    }

    public PlusEntityWrapper<FeeIncomeAccountMonthStat> build() {
        return this.ew;
    }

    public FeeIncomeAccountMonthStatCondition or() {
        this.ew.orNew();
        return this;
    }

    public FeeIncomeAccountMonthStatCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(FeeIncomeAccountMonthStat.class);
    }

    public FeeIncomeAccountMonthStatCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> FeeIncomeAccountMonthStatCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> FeeIncomeAccountMonthStatCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> FeeIncomeAccountMonthStatCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthIsNull() {
        ew.isNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthIsNotNull() {
        ew.isNotNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthEq(Object value) {
        ew.eq("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthNe(Object value) {
        ew.ne("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthGt(Object value) {
        ew.gt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthGe(Object value) {
        ew.ge("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthLt(Object value) {
        ew.lt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthLe(Object value) {
        ew.le("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthIn(Object... value) {
        ew.in("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthNotIn(Object... value) {
        ew.notIn("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthBetween(Object value, Object value1) {
        ew.between("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthNotBetween(Object value, Object value1) {
        ew.notBetween("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthLike(String value) {
        ew.like("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andStatMonthNotLike(String value) {
        ew.notLike("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orStatMonthNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameIsNull() {
        ew.isNull("name");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("name");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameIsNotNull() {
        ew.isNotNull("name");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("name");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameEq(Object value) {
        ew.eq("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameNe(Object value) {
        ew.ne("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameGt(Object value) {
        ew.gt("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameGe(Object value) {
        ew.ge("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameLt(Object value) {
        ew.lt("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameLe(Object value) {
        ew.le("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameIn(Object... value) {
        ew.in("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameNotIn(Object... value) {
        ew.notIn("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameBetween(Object value, Object value1) {
        ew.between("name", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("name", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameNotBetween(Object value, Object value1) {
        ew.notBetween("name", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("name", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameLike(String value) {
        ew.like("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andNameNotLike(String value) {
        ew.notLike("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("name", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusIsNull() {
        ew.isNull("collection_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("collection_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusIsNotNull() {
        ew.isNotNull("collection_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("collection_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusEq(Object value) {
        ew.eq("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusNe(Object value) {
        ew.ne("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusGt(Object value) {
        ew.gt("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusGe(Object value) {
        ew.ge("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusLt(Object value) {
        ew.lt("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusLe(Object value) {
        ew.le("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusIn(Object... value) {
        ew.in("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusNotIn(Object... value) {
        ew.notIn("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusBetween(Object value, Object value1) {
        ew.between("collection_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("collection_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusNotBetween(Object value, Object value1) {
        ew.notBetween("collection_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("collection_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusLike(String value) {
        ew.like("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andCollectionStatusNotLike(String value) {
        ew.notLike("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orCollectionStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("collection_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountIsNull() {
        ew.isNull("income_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountIsNotNull() {
        ew.isNotNull("income_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountEq(Object value) {
        ew.eq("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountNe(Object value) {
        ew.ne("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountGt(Object value) {
        ew.gt("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountGe(Object value) {
        ew.ge("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountLt(Object value) {
        ew.lt("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountLe(Object value) {
        ew.le("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountIn(Object... value) {
        ew.in("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountNotIn(Object... value) {
        ew.notIn("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountBetween(Object value, Object value1) {
        ew.between("income_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountNotBetween(Object value, Object value1) {
        ew.notBetween("income_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountLike(String value) {
        ew.like("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andIncomeAmountNotLike(String value) {
        ew.notLike("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orIncomeAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountIsNull() {
        ew.isNull("outcome_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("outcome_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountIsNotNull() {
        ew.isNotNull("outcome_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("outcome_amount");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountEq(Object value) {
        ew.eq("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountNe(Object value) {
        ew.ne("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountGt(Object value) {
        ew.gt("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountGe(Object value) {
        ew.ge("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountLt(Object value) {
        ew.lt("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountLe(Object value) {
        ew.le("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountIn(Object... value) {
        ew.in("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountNotIn(Object... value) {
        ew.notIn("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountBetween(Object value, Object value1) {
        ew.between("outcome_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("outcome_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountNotBetween(Object value, Object value1) {
        ew.notBetween("outcome_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("outcome_amount", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountLike(String value) {
        ew.like("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andOutcomeAmountNotLike(String value) {
        ew.notLike("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orOutcomeAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("outcome_amount", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthStatCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }
}