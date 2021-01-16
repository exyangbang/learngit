package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class SubPayPayeeWhiteListCondition {
    private PlusEntityWrapper<SubPayPayeeWhiteList> ew;

    public SubPayPayeeWhiteListCondition() {
        this.ew = new PlusEntityWrapper(SubPayPayeeWhiteList.class);
    }

    public static SubPayPayeeWhiteListCondition builder() {
        return new SubPayPayeeWhiteListCondition();
    }

    public PlusEntityWrapper<SubPayPayeeWhiteList> build() {
        return this.ew;
    }

    public SubPayPayeeWhiteListCondition or() {
        this.ew.orNew();
        return this;
    }

    public SubPayPayeeWhiteListCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(SubPayPayeeWhiteList.class);
    }

    public SubPayPayeeWhiteListCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public SubPayPayeeWhiteListCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public SubPayPayeeWhiteListCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public SubPayPayeeWhiteListCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> SubPayPayeeWhiteListCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> SubPayPayeeWhiteListCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> SubPayPayeeWhiteListCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public SubPayPayeeWhiteListCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public SubPayPayeeWhiteListCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public SubPayPayeeWhiteListCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountIsNull() {
        ew.isNull("payee_account");
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_account");
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountIsNotNull() {
        ew.isNotNull("payee_account");
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_account");
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountEq(Object value) {
        ew.eq("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountNe(Object value) {
        ew.ne("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountGt(Object value) {
        ew.gt("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountGe(Object value) {
        ew.ge("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountLt(Object value) {
        ew.lt("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountLe(Object value) {
        ew.le("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountIn(Object... value) {
        ew.in("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountNotIn(Object... value) {
        ew.notIn("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountBetween(Object value, Object value1) {
        ew.between("payee_account", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_account", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountLike(String value) {
        ew.like("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeAccountNotLike(String value) {
        ew.notLike("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_account", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameIsNull() {
        ew.isNull("payee_name");
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_name");
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameIsNotNull() {
        ew.isNotNull("payee_name");
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_name");
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameEq(Object value) {
        ew.eq("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameNe(Object value) {
        ew.ne("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameGt(Object value) {
        ew.gt("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameGe(Object value) {
        ew.ge("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameLt(Object value) {
        ew.lt("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameLe(Object value) {
        ew.le("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameIn(Object... value) {
        ew.in("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameNotIn(Object... value) {
        ew.notIn("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameBetween(Object value, Object value1) {
        ew.between("payee_name", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_name", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameLike(String value) {
        ew.like("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andPayeeNameNotLike(String value) {
        ew.notLike("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orPayeeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_name", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdIsNull() {
        ew.isNull("industry_id");
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_id");
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdIsNotNull() {
        ew.isNotNull("industry_id");
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_id");
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdEq(Object value) {
        ew.eq("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdNe(Object value) {
        ew.ne("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdGt(Object value) {
        ew.gt("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdGe(Object value) {
        ew.ge("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdLt(Object value) {
        ew.lt("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdLe(Object value) {
        ew.le("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdIn(Object... value) {
        ew.in("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdNotIn(Object... value) {
        ew.notIn("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdBetween(Object value, Object value1) {
        ew.between("industry_id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdNotBetween(Object value, Object value1) {
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_id", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdLike(String value) {
        ew.like("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andIndustryIdNotLike(String value) {
        ew.notLike("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orIndustryIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_id", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SubPayPayeeWhiteListCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}