package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class AccountEntryDetailCondition {
    private PlusEntityWrapper<AccountEntryDetail> ew;

    public AccountEntryDetailCondition() {
        this.ew = new PlusEntityWrapper(AccountEntryDetail.class);
    }

    public static AccountEntryDetailCondition builder() {
        return new AccountEntryDetailCondition();
    }

    public PlusEntityWrapper<AccountEntryDetail> build() {
        return this.ew;
    }

    public AccountEntryDetailCondition or() {
        this.ew.orNew();
        return this;
    }

    public AccountEntryDetailCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(AccountEntryDetail.class);
    }

    public AccountEntryDetailCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public AccountEntryDetailCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public AccountEntryDetailCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public AccountEntryDetailCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> AccountEntryDetailCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> AccountEntryDetailCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> AccountEntryDetailCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public AccountEntryDetailCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public AccountEntryDetailCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public AccountEntryDetailCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public AccountEntryDetailCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public AccountEntryDetailCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public AccountEntryDetailCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public AccountEntryDetailCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public AccountEntryDetailCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public AccountEntryDetailCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public AccountEntryDetailCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateIsNull() {
        ew.isNull("entry_date");
        return this;
    }

    public AccountEntryDetailCondition orEntryDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("entry_date");
        return this;
    }

    public AccountEntryDetailCondition andEntryDateIsNotNull() {
        ew.isNotNull("entry_date");
        return this;
    }

    public AccountEntryDetailCondition orEntryDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("entry_date");
        return this;
    }

    public AccountEntryDetailCondition andEntryDateEq(Object value) {
        ew.eq("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateNe(Object value) {
        ew.ne("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateGt(Object value) {
        ew.gt("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateGe(Object value) {
        ew.ge("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateLt(Object value) {
        ew.lt("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateLe(Object value) {
        ew.le("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateIn(Object... value) {
        ew.in("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateNotIn(Object... value) {
        ew.notIn("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateBetween(Object value, Object value1) {
        ew.between("entry_date", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("entry_date", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateNotBetween(Object value, Object value1) {
        ew.notBetween("entry_date", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("entry_date", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateLike(String value) {
        ew.like("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andEntryDateNotLike(String value) {
        ew.notLike("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition orEntryDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("entry_date", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdIsNull() {
        ew.isNull("batch_id");
        return this;
    }

    public AccountEntryDetailCondition orBatchIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_id");
        return this;
    }

    public AccountEntryDetailCondition andBatchIdIsNotNull() {
        ew.isNotNull("batch_id");
        return this;
    }

    public AccountEntryDetailCondition orBatchIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_id");
        return this;
    }

    public AccountEntryDetailCondition andBatchIdEq(Object value) {
        ew.eq("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdNe(Object value) {
        ew.ne("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdGt(Object value) {
        ew.gt("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdGe(Object value) {
        ew.ge("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdLt(Object value) {
        ew.lt("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdLe(Object value) {
        ew.le("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdIn(Object... value) {
        ew.in("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdNotIn(Object... value) {
        ew.notIn("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdBetween(Object value, Object value1) {
        ew.between("batch_id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdNotBetween(Object value, Object value1) {
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdLike(String value) {
        ew.like("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andBatchIdNotLike(String value) {
        ew.notLike("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition orBatchIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_id", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountIsNull() {
        ew.isNull("payer_account");
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_account");
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountIsNotNull() {
        ew.isNotNull("payer_account");
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_account");
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountEq(Object value) {
        ew.eq("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountNe(Object value) {
        ew.ne("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountGt(Object value) {
        ew.gt("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountGe(Object value) {
        ew.ge("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountLt(Object value) {
        ew.lt("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountLe(Object value) {
        ew.le("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountIn(Object... value) {
        ew.in("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountNotIn(Object... value) {
        ew.notIn("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountBetween(Object value, Object value1) {
        ew.between("payer_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountLike(String value) {
        ew.like("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andPayerAccountNotLike(String value) {
        ew.notLike("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition orPayerAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_account", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public AccountEntryDetailCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public AccountEntryDetailCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public AccountEntryDetailCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public AccountEntryDetailCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountIsNull() {
        ew.isNull("user_account");
        return this;
    }

    public AccountEntryDetailCondition orUserAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_account");
        return this;
    }

    public AccountEntryDetailCondition andUserAccountIsNotNull() {
        ew.isNotNull("user_account");
        return this;
    }

    public AccountEntryDetailCondition orUserAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_account");
        return this;
    }

    public AccountEntryDetailCondition andUserAccountEq(Object value) {
        ew.eq("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountNe(Object value) {
        ew.ne("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountGt(Object value) {
        ew.gt("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountGe(Object value) {
        ew.ge("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountLt(Object value) {
        ew.lt("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountLe(Object value) {
        ew.le("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountIn(Object... value) {
        ew.in("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountNotIn(Object... value) {
        ew.notIn("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountBetween(Object value, Object value1) {
        ew.between("user_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountNotBetween(Object value, Object value1) {
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountLike(String value) {
        ew.like("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andUserAccountNotLike(String value) {
        ew.notLike("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition orUserAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_account", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public AccountEntryDetailCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public AccountEntryDetailCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public AccountEntryDetailCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public AccountEntryDetailCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public AccountEntryDetailCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public AccountEntryDetailCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public AccountEntryDetailCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public AccountEntryDetailCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public AccountEntryDetailCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public AccountEntryDetailCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public AccountEntryDetailCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeIsNull() {
        ew.isNull("account_type");
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_type");
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeIsNotNull() {
        ew.isNotNull("account_type");
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_type");
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeEq(Object value) {
        ew.eq("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeNe(Object value) {
        ew.ne("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeGt(Object value) {
        ew.gt("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeGe(Object value) {
        ew.ge("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeLt(Object value) {
        ew.lt("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeLe(Object value) {
        ew.le("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeIn(Object... value) {
        ew.in("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeNotIn(Object... value) {
        ew.notIn("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeBetween(Object value, Object value1) {
        ew.between("account_type", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_type", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeNotBetween(Object value, Object value1) {
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeLike(String value) {
        ew.like("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountTypeNotLike(String value) {
        ew.notLike("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_type", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoIsNull() {
        ew.isNull("account_no");
        return this;
    }

    public AccountEntryDetailCondition orAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_no");
        return this;
    }

    public AccountEntryDetailCondition andAccountNoIsNotNull() {
        ew.isNotNull("account_no");
        return this;
    }

    public AccountEntryDetailCondition orAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_no");
        return this;
    }

    public AccountEntryDetailCondition andAccountNoEq(Object value) {
        ew.eq("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoNe(Object value) {
        ew.ne("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoGt(Object value) {
        ew.gt("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoGe(Object value) {
        ew.ge("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoLt(Object value) {
        ew.lt("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoLe(Object value) {
        ew.le("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoIn(Object... value) {
        ew.in("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoNotIn(Object... value) {
        ew.notIn("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoBetween(Object value, Object value1) {
        ew.between("account_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoLike(String value) {
        ew.like("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNoNotLike(String value) {
        ew.notLike("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagIsNull() {
        ew.isNull("card_flag");
        return this;
    }

    public AccountEntryDetailCondition orCardFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("card_flag");
        return this;
    }

    public AccountEntryDetailCondition andCardFlagIsNotNull() {
        ew.isNotNull("card_flag");
        return this;
    }

    public AccountEntryDetailCondition orCardFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("card_flag");
        return this;
    }

    public AccountEntryDetailCondition andCardFlagEq(Object value) {
        ew.eq("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagNe(Object value) {
        ew.ne("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagGt(Object value) {
        ew.gt("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagGe(Object value) {
        ew.ge("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagLt(Object value) {
        ew.lt("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagLe(Object value) {
        ew.le("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagIn(Object... value) {
        ew.in("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagNotIn(Object... value) {
        ew.notIn("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagBetween(Object value, Object value1) {
        ew.between("card_flag", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("card_flag", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagNotBetween(Object value, Object value1) {
        ew.notBetween("card_flag", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("card_flag", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagLike(String value) {
        ew.like("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andCardFlagNotLike(String value) {
        ew.notLike("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition orCardFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("card_flag", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameIsNull() {
        ew.isNull("account_name");
        return this;
    }

    public AccountEntryDetailCondition orAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_name");
        return this;
    }

    public AccountEntryDetailCondition andAccountNameIsNotNull() {
        ew.isNotNull("account_name");
        return this;
    }

    public AccountEntryDetailCondition orAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_name");
        return this;
    }

    public AccountEntryDetailCondition andAccountNameEq(Object value) {
        ew.eq("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameNe(Object value) {
        ew.ne("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameGt(Object value) {
        ew.gt("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameGe(Object value) {
        ew.ge("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameLt(Object value) {
        ew.lt("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameLe(Object value) {
        ew.le("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameIn(Object... value) {
        ew.in("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameNotIn(Object... value) {
        ew.notIn("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameBetween(Object value, Object value1) {
        ew.between("account_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameLike(String value) {
        ew.like("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andAccountNameNotLike(String value) {
        ew.notLike("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition orAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_name", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoIsNull() {
        ew.isNull("cert_no");
        return this;
    }

    public AccountEntryDetailCondition orCertNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cert_no");
        return this;
    }

    public AccountEntryDetailCondition andCertNoIsNotNull() {
        ew.isNotNull("cert_no");
        return this;
    }

    public AccountEntryDetailCondition orCertNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cert_no");
        return this;
    }

    public AccountEntryDetailCondition andCertNoEq(Object value) {
        ew.eq("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoNe(Object value) {
        ew.ne("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoGt(Object value) {
        ew.gt("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoGe(Object value) {
        ew.ge("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoLt(Object value) {
        ew.lt("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoLe(Object value) {
        ew.le("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoIn(Object... value) {
        ew.in("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoNotIn(Object... value) {
        ew.notIn("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoBetween(Object value, Object value1) {
        ew.between("cert_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orCertNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cert_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andCertNoNotBetween(Object value, Object value1) {
        ew.notBetween("cert_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orCertNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cert_no", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andCertNoLike(String value) {
        ew.like("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andCertNoNotLike(String value) {
        ew.notLike("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition orCertNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cert_no", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public AccountEntryDetailCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public AccountEntryDetailCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public AccountEntryDetailCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public AccountEntryDetailCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public AccountEntryDetailCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1IsNull() {
        ew.isNull("extend_1");
        return this;
    }

    public AccountEntryDetailCondition orExtend1IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_1");
        return this;
    }

    public AccountEntryDetailCondition andExtend1IsNotNull() {
        ew.isNotNull("extend_1");
        return this;
    }

    public AccountEntryDetailCondition orExtend1IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_1");
        return this;
    }

    public AccountEntryDetailCondition andExtend1Eq(Object value) {
        ew.eq("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1Ne(Object value) {
        ew.ne("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1Gt(Object value) {
        ew.gt("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1Ge(Object value) {
        ew.ge("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1Lt(Object value) {
        ew.lt("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1Le(Object value) {
        ew.le("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1In(Object... value) {
        ew.in("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1NotIn(Object... value) {
        ew.notIn("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1Between(Object value, Object value1) {
        ew.between("extend_1", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_1", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andExtend1NotBetween(Object value, Object value1) {
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orExtend1NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andExtend1Like(String value) {
        ew.like("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend1NotLike(String value) {
        ew.notLike("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend1NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_1", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2IsNull() {
        ew.isNull("extend_2");
        return this;
    }

    public AccountEntryDetailCondition orExtend2IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_2");
        return this;
    }

    public AccountEntryDetailCondition andExtend2IsNotNull() {
        ew.isNotNull("extend_2");
        return this;
    }

    public AccountEntryDetailCondition orExtend2IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_2");
        return this;
    }

    public AccountEntryDetailCondition andExtend2Eq(Object value) {
        ew.eq("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2Ne(Object value) {
        ew.ne("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2Gt(Object value) {
        ew.gt("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2Ge(Object value) {
        ew.ge("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2Lt(Object value) {
        ew.lt("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2Le(Object value) {
        ew.le("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2In(Object... value) {
        ew.in("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2NotIn(Object... value) {
        ew.notIn("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2Between(Object value, Object value1) {
        ew.between("extend_2", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_2", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andExtend2NotBetween(Object value, Object value1) {
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orExtend2NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andExtend2Like(String value) {
        ew.like("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend2NotLike(String value) {
        ew.notLike("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend2NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_2", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3IsNull() {
        ew.isNull("extend_3");
        return this;
    }

    public AccountEntryDetailCondition orExtend3IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_3");
        return this;
    }

    public AccountEntryDetailCondition andExtend3IsNotNull() {
        ew.isNotNull("extend_3");
        return this;
    }

    public AccountEntryDetailCondition orExtend3IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_3");
        return this;
    }

    public AccountEntryDetailCondition andExtend3Eq(Object value) {
        ew.eq("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3Ne(Object value) {
        ew.ne("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3Gt(Object value) {
        ew.gt("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3Ge(Object value) {
        ew.ge("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3Lt(Object value) {
        ew.lt("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3Le(Object value) {
        ew.le("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3In(Object... value) {
        ew.in("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3NotIn(Object... value) {
        ew.notIn("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3Between(Object value, Object value1) {
        ew.between("extend_3", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_3", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andExtend3NotBetween(Object value, Object value1) {
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orExtend3NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andExtend3Like(String value) {
        ew.like("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andExtend3NotLike(String value) {
        ew.notLike("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition orExtend3NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_3", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusIsNull() {
        ew.isNull("handle_status");
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("handle_status");
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusIsNotNull() {
        ew.isNotNull("handle_status");
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("handle_status");
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusEq(Object value) {
        ew.eq("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusNe(Object value) {
        ew.ne("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusGt(Object value) {
        ew.gt("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusGe(Object value) {
        ew.ge("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusLt(Object value) {
        ew.lt("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusLe(Object value) {
        ew.le("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusIn(Object... value) {
        ew.in("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusNotIn(Object... value) {
        ew.notIn("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusBetween(Object value, Object value1) {
        ew.between("handle_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("handle_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusNotBetween(Object value, Object value1) {
        ew.notBetween("handle_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("handle_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusLike(String value) {
        ew.like("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andHandleStatusNotLike(String value) {
        ew.notLike("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition orHandleStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("handle_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public AccountEntryDetailCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public AccountEntryDetailCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public AccountEntryDetailCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public AccountEntryDetailCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public AccountEntryDetailCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public AccountEntryDetailCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public AccountEntryDetailCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public AccountEntryDetailCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public AccountEntryDetailCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public AccountEntryDetailCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public AccountEntryDetailCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public AccountEntryDetailCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public AccountEntryDetailCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public AccountEntryDetailCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public AccountEntryDetailCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public AccountEntryDetailCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountEntryDetailCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}