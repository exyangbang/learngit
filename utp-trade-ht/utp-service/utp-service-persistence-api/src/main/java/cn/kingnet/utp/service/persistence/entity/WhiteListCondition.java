package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class WhiteListCondition {
    private PlusEntityWrapper<WhiteList> ew;

    public WhiteListCondition() {
        this.ew = new PlusEntityWrapper(WhiteList.class);
    }

    public static WhiteListCondition builder() {
        return new WhiteListCondition();
    }

    public PlusEntityWrapper<WhiteList> build() {
        return this.ew;
    }

    public WhiteListCondition or() {
        this.ew.orNew();
        return this;
    }

    public WhiteListCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(WhiteList.class);
    }

    public WhiteListCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public WhiteListCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public WhiteListCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public WhiteListCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> WhiteListCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> WhiteListCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> WhiteListCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public WhiteListCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public WhiteListCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public WhiteListCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public WhiteListCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public WhiteListCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public WhiteListCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public WhiteListCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public WhiteListCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public WhiteListCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public WhiteListCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public WhiteListCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public WhiteListCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public WhiteListCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public WhiteListCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public WhiteListCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public WhiteListCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public WhiteListCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public WhiteListCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public WhiteListCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public WhiteListCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public WhiteListCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public WhiteListCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public WhiteListCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public WhiteListCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public WhiteListCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public WhiteListCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public WhiteListCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public WhiteListCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public WhiteListCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public WhiteListCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public WhiteListCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public WhiteListCondition andMerNameIsNull() {
        ew.isNull("mer_name");
        return this;
    }

    public WhiteListCondition orMerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_name");
        return this;
    }

    public WhiteListCondition andMerNameIsNotNull() {
        ew.isNotNull("mer_name");
        return this;
    }

    public WhiteListCondition orMerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_name");
        return this;
    }

    public WhiteListCondition andMerNameEq(Object value) {
        ew.eq("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameNe(Object value) {
        ew.ne("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameGt(Object value) {
        ew.gt("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameGe(Object value) {
        ew.ge("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameLt(Object value) {
        ew.lt("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameLe(Object value) {
        ew.le("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameIn(Object... value) {
        ew.in("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameNotIn(Object... value) {
        ew.notIn("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameBetween(Object value, Object value1) {
        ew.between("mer_name", value, value1);
        return this;
    }

    public WhiteListCondition orMerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_name", value, value1);
        return this;
    }

    public WhiteListCondition andMerNameNotBetween(Object value, Object value1) {
        ew.notBetween("mer_name", value, value1);
        return this;
    }

    public WhiteListCondition orMerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_name", value, value1);
        return this;
    }

    public WhiteListCondition andMerNameLike(String value) {
        ew.like("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerNameNotLike(String value) {
        ew.notLike("mer_name", value);
        return this;
    }

    public WhiteListCondition orMerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_name", value);
        return this;
    }

    public WhiteListCondition andMerAbbIsNull() {
        ew.isNull("mer_abb");
        return this;
    }

    public WhiteListCondition orMerAbbIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_abb");
        return this;
    }

    public WhiteListCondition andMerAbbIsNotNull() {
        ew.isNotNull("mer_abb");
        return this;
    }

    public WhiteListCondition orMerAbbIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_abb");
        return this;
    }

    public WhiteListCondition andMerAbbEq(Object value) {
        ew.eq("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbNe(Object value) {
        ew.ne("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbGt(Object value) {
        ew.gt("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbGe(Object value) {
        ew.ge("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbLt(Object value) {
        ew.lt("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbLe(Object value) {
        ew.le("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbIn(Object... value) {
        ew.in("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbNotIn(Object... value) {
        ew.notIn("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbBetween(Object value, Object value1) {
        ew.between("mer_abb", value, value1);
        return this;
    }

    public WhiteListCondition orMerAbbBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_abb", value, value1);
        return this;
    }

    public WhiteListCondition andMerAbbNotBetween(Object value, Object value1) {
        ew.notBetween("mer_abb", value, value1);
        return this;
    }

    public WhiteListCondition orMerAbbNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_abb", value, value1);
        return this;
    }

    public WhiteListCondition andMerAbbLike(String value) {
        ew.like("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_abb", value);
        return this;
    }

    public WhiteListCondition andMerAbbNotLike(String value) {
        ew.notLike("mer_abb", value);
        return this;
    }

    public WhiteListCondition orMerAbbNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_abb", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public WhiteListCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public WhiteListCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public WhiteListCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public WhiteListCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public WhiteListCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public WhiteListCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public WhiteListCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public WhiteListCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public WhiteListCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public WhiteListCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public WhiteListCondition andAccountNameIsNull() {
        ew.isNull("account_name");
        return this;
    }

    public WhiteListCondition orAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_name");
        return this;
    }

    public WhiteListCondition andAccountNameIsNotNull() {
        ew.isNotNull("account_name");
        return this;
    }

    public WhiteListCondition orAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_name");
        return this;
    }

    public WhiteListCondition andAccountNameEq(Object value) {
        ew.eq("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameNe(Object value) {
        ew.ne("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameGt(Object value) {
        ew.gt("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameGe(Object value) {
        ew.ge("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameLt(Object value) {
        ew.lt("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameLe(Object value) {
        ew.le("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameIn(Object... value) {
        ew.in("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameNotIn(Object... value) {
        ew.notIn("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameBetween(Object value, Object value1) {
        ew.between("account_name", value, value1);
        return this;
    }

    public WhiteListCondition orAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_name", value, value1);
        return this;
    }

    public WhiteListCondition andAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public WhiteListCondition orAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public WhiteListCondition andAccountNameLike(String value) {
        ew.like("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_name", value);
        return this;
    }

    public WhiteListCondition andAccountNameNotLike(String value) {
        ew.notLike("account_name", value);
        return this;
    }

    public WhiteListCondition orAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_name", value);
        return this;
    }

    public WhiteListCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public WhiteListCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public WhiteListCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public WhiteListCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public WhiteListCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public WhiteListCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public WhiteListCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public WhiteListCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public WhiteListCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public WhiteListCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public WhiteListCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public WhiteListCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public WhiteListCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public WhiteListCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public WhiteListCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public WhiteListCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public WhiteListCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public WhiteListCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public WhiteListCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public WhiteListCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public WhiteListCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public WhiteListCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public WhiteListCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public WhiteListCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public WhiteListCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public WhiteListCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public WhiteListCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public WhiteListCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public WhiteListCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public WhiteListCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public WhiteListCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public WhiteListCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public WhiteListCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public WhiteListCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public WhiteListCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public WhiteListCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public WhiteListCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public WhiteListCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public WhiteListCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public WhiteListCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public WhiteListCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public WhiteListCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}