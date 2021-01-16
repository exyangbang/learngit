package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class IndustryAccountInfoCondition {
    private PlusEntityWrapper<IndustryAccountInfo> ew;

    public IndustryAccountInfoCondition() {
        this.ew = new PlusEntityWrapper(IndustryAccountInfo.class);
    }

    public static IndustryAccountInfoCondition builder() {
        return new IndustryAccountInfoCondition();
    }

    public PlusEntityWrapper<IndustryAccountInfo> build() {
        return this.ew;
    }

    public IndustryAccountInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public IndustryAccountInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(IndustryAccountInfo.class);
    }

    public IndustryAccountInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public IndustryAccountInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public IndustryAccountInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public IndustryAccountInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> IndustryAccountInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> IndustryAccountInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> IndustryAccountInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public IndustryAccountInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public IndustryAccountInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public IndustryAccountInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public IndustryAccountInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public IndustryAccountInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public IndustryAccountInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public IndustryAccountInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public IndustryAccountInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public IndustryAccountInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoIsNull() {
        ew.isNull("account_no");
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_no");
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoIsNotNull() {
        ew.isNotNull("account_no");
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_no");
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoEq(Object value) {
        ew.eq("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoNe(Object value) {
        ew.ne("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoGt(Object value) {
        ew.gt("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoGe(Object value) {
        ew.ge("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoLt(Object value) {
        ew.lt("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoLe(Object value) {
        ew.le("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoIn(Object... value) {
        ew.in("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoNotIn(Object... value) {
        ew.notIn("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoBetween(Object value, Object value1) {
        ew.between("account_no", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_no", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoLike(String value) {
        ew.like("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNoNotLike(String value) {
        ew.notLike("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_no", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameIsNull() {
        ew.isNull("account_name");
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_name");
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameIsNotNull() {
        ew.isNotNull("account_name");
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_name");
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameEq(Object value) {
        ew.eq("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameNe(Object value) {
        ew.ne("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameGt(Object value) {
        ew.gt("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameGe(Object value) {
        ew.ge("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameLt(Object value) {
        ew.lt("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameLe(Object value) {
        ew.le("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameIn(Object... value) {
        ew.in("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameNotIn(Object... value) {
        ew.notIn("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameBetween(Object value, Object value1) {
        ew.between("account_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameLike(String value) {
        ew.like("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andAccountNameNotLike(String value) {
        ew.notLike("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeIsNull() {
        ew.isNull("bank_code");
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_code");
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeIsNotNull() {
        ew.isNotNull("bank_code");
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_code");
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeEq(Object value) {
        ew.eq("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeNe(Object value) {
        ew.ne("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeGt(Object value) {
        ew.gt("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeGe(Object value) {
        ew.ge("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeLt(Object value) {
        ew.lt("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeLe(Object value) {
        ew.le("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeIn(Object... value) {
        ew.in("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeNotIn(Object... value) {
        ew.notIn("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeBetween(Object value, Object value1) {
        ew.between("bank_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeLike(String value) {
        ew.like("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankCodeNotLike(String value) {
        ew.notLike("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_code", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameIsNull() {
        ew.isNull("bank_name");
        return this;
    }

    public IndustryAccountInfoCondition orBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_name");
        return this;
    }

    public IndustryAccountInfoCondition andBankNameIsNotNull() {
        ew.isNotNull("bank_name");
        return this;
    }

    public IndustryAccountInfoCondition orBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_name");
        return this;
    }

    public IndustryAccountInfoCondition andBankNameEq(Object value) {
        ew.eq("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameNe(Object value) {
        ew.ne("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameGt(Object value) {
        ew.gt("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameGe(Object value) {
        ew.ge("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameLt(Object value) {
        ew.lt("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameLe(Object value) {
        ew.le("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameIn(Object... value) {
        ew.in("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameNotIn(Object... value) {
        ew.notIn("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameBetween(Object value, Object value1) {
        ew.between("bank_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameLike(String value) {
        ew.like("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andBankNameNotLike(String value) {
        ew.notLike("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition orBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_name", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeIsNull() {
        ew.isNull("industry_type");
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_type");
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeIsNotNull() {
        ew.isNotNull("industry_type");
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_type");
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeEq(Object value) {
        ew.eq("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeNe(Object value) {
        ew.ne("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeGt(Object value) {
        ew.gt("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeGe(Object value) {
        ew.ge("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeLt(Object value) {
        ew.lt("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeLe(Object value) {
        ew.le("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeIn(Object... value) {
        ew.in("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeNotIn(Object... value) {
        ew.notIn("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeBetween(Object value, Object value1) {
        ew.between("industry_type", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_type", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_type", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_type", value, value1);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeLike(String value) {
        ew.like("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition andIndustryTypeNotLike(String value) {
        ew.notLike("industry_type", value);
        return this;
    }

    public IndustryAccountInfoCondition orIndustryTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_type", value);
        return this;
    }
}