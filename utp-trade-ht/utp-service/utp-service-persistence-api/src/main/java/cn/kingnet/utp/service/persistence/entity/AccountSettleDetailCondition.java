package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class AccountSettleDetailCondition {
    private PlusEntityWrapper<AccountSettleDetail> ew;

    public AccountSettleDetailCondition() {
        this.ew = new PlusEntityWrapper(AccountSettleDetail.class);
    }

    public static AccountSettleDetailCondition builder() {
        return new AccountSettleDetailCondition();
    }

    public PlusEntityWrapper<AccountSettleDetail> build() {
        return this.ew;
    }

    public AccountSettleDetailCondition or() {
        this.ew.orNew();
        return this;
    }

    public AccountSettleDetailCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(AccountSettleDetail.class);
    }

    public AccountSettleDetailCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public AccountSettleDetailCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public AccountSettleDetailCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public AccountSettleDetailCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> AccountSettleDetailCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> AccountSettleDetailCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> AccountSettleDetailCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public AccountSettleDetailCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public AccountSettleDetailCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public AccountSettleDetailCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public AccountSettleDetailCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public AccountSettleDetailCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public AccountSettleDetailCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public AccountSettleDetailCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public AccountSettleDetailCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public AccountSettleDetailCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public AccountSettleDetailCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateIsNull() {
        ew.isNull("settle_date");
        return this;
    }

    public AccountSettleDetailCondition orSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_date");
        return this;
    }

    public AccountSettleDetailCondition andSettleDateIsNotNull() {
        ew.isNotNull("settle_date");
        return this;
    }

    public AccountSettleDetailCondition orSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_date");
        return this;
    }

    public AccountSettleDetailCondition andSettleDateEq(Object value) {
        ew.eq("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateNe(Object value) {
        ew.ne("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateGt(Object value) {
        ew.gt("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateGe(Object value) {
        ew.ge("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateLt(Object value) {
        ew.lt("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateLe(Object value) {
        ew.le("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateIn(Object... value) {
        ew.in("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateNotIn(Object... value) {
        ew.notIn("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateBetween(Object value, Object value1) {
        ew.between("settle_date", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_date", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateLike(String value) {
        ew.like("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andSettleDateNotLike(String value) {
        ew.notLike("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition orSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_date", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdIsNull() {
        ew.isNull("batch_id");
        return this;
    }

    public AccountSettleDetailCondition orBatchIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_id");
        return this;
    }

    public AccountSettleDetailCondition andBatchIdIsNotNull() {
        ew.isNotNull("batch_id");
        return this;
    }

    public AccountSettleDetailCondition orBatchIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_id");
        return this;
    }

    public AccountSettleDetailCondition andBatchIdEq(Object value) {
        ew.eq("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdNe(Object value) {
        ew.ne("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdGt(Object value) {
        ew.gt("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdGe(Object value) {
        ew.ge("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdLt(Object value) {
        ew.lt("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdLe(Object value) {
        ew.le("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdIn(Object... value) {
        ew.in("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdNotIn(Object... value) {
        ew.notIn("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdBetween(Object value, Object value1) {
        ew.between("batch_id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdNotBetween(Object value, Object value1) {
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdLike(String value) {
        ew.like("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andBatchIdNotLike(String value) {
        ew.notLike("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition orBatchIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_id", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountIsNull() {
        ew.isNull("payer_account");
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_account");
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountIsNotNull() {
        ew.isNotNull("payer_account");
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_account");
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountEq(Object value) {
        ew.eq("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountNe(Object value) {
        ew.ne("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountGt(Object value) {
        ew.gt("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountGe(Object value) {
        ew.ge("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountLt(Object value) {
        ew.lt("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountLe(Object value) {
        ew.le("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountIn(Object... value) {
        ew.in("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountNotIn(Object... value) {
        ew.notIn("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountBetween(Object value, Object value1) {
        ew.between("payer_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountLike(String value) {
        ew.like("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andPayerAccountNotLike(String value) {
        ew.notLike("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition orPayerAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_account", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public AccountSettleDetailCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public AccountSettleDetailCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public AccountSettleDetailCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public AccountSettleDetailCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountIsNull() {
        ew.isNull("user_account");
        return this;
    }

    public AccountSettleDetailCondition orUserAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_account");
        return this;
    }

    public AccountSettleDetailCondition andUserAccountIsNotNull() {
        ew.isNotNull("user_account");
        return this;
    }

    public AccountSettleDetailCondition orUserAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_account");
        return this;
    }

    public AccountSettleDetailCondition andUserAccountEq(Object value) {
        ew.eq("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountNe(Object value) {
        ew.ne("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountGt(Object value) {
        ew.gt("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountGe(Object value) {
        ew.ge("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountLt(Object value) {
        ew.lt("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountLe(Object value) {
        ew.le("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountIn(Object... value) {
        ew.in("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountNotIn(Object... value) {
        ew.notIn("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountBetween(Object value, Object value1) {
        ew.between("user_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountNotBetween(Object value, Object value1) {
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountLike(String value) {
        ew.like("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andUserAccountNotLike(String value) {
        ew.notLike("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition orUserAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_account", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public AccountSettleDetailCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public AccountSettleDetailCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public AccountSettleDetailCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public AccountSettleDetailCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public AccountSettleDetailCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public AccountSettleDetailCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public AccountSettleDetailCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public AccountSettleDetailCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public AccountSettleDetailCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public AccountSettleDetailCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public AccountSettleDetailCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoIsNull() {
        ew.isNull("account_no");
        return this;
    }

    public AccountSettleDetailCondition orAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_no");
        return this;
    }

    public AccountSettleDetailCondition andAccountNoIsNotNull() {
        ew.isNotNull("account_no");
        return this;
    }

    public AccountSettleDetailCondition orAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_no");
        return this;
    }

    public AccountSettleDetailCondition andAccountNoEq(Object value) {
        ew.eq("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoNe(Object value) {
        ew.ne("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoGt(Object value) {
        ew.gt("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoGe(Object value) {
        ew.ge("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoLt(Object value) {
        ew.lt("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoLe(Object value) {
        ew.le("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoIn(Object... value) {
        ew.in("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoNotIn(Object... value) {
        ew.notIn("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoBetween(Object value, Object value1) {
        ew.between("account_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoLike(String value) {
        ew.like("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andAccountNoNotLike(String value) {
        ew.notLike("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition orAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoIsNull() {
        ew.isNull("show_payer_acct_no");
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_acct_no");
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoIsNotNull() {
        ew.isNotNull("show_payer_acct_no");
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_acct_no");
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoEq(Object value) {
        ew.eq("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoNe(Object value) {
        ew.ne("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoGt(Object value) {
        ew.gt("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoGe(Object value) {
        ew.ge("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoLt(Object value) {
        ew.lt("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoLe(Object value) {
        ew.le("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoIn(Object... value) {
        ew.in("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoNotIn(Object... value) {
        ew.notIn("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoBetween(Object value, Object value1) {
        ew.between("show_payer_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoLike(String value) {
        ew.like("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerAcctNoNotLike(String value) {
        ew.notLike("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameIsNull() {
        ew.isNull("show_payer_name");
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_name");
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameIsNotNull() {
        ew.isNotNull("show_payer_name");
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_name");
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameEq(Object value) {
        ew.eq("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameNe(Object value) {
        ew.ne("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameGt(Object value) {
        ew.gt("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameGe(Object value) {
        ew.ge("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameLt(Object value) {
        ew.lt("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameLe(Object value) {
        ew.le("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameIn(Object... value) {
        ew.in("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameNotIn(Object... value) {
        ew.notIn("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameBetween(Object value, Object value1) {
        ew.between("show_payer_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameLike(String value) {
        ew.like("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andShowPayerNameNotLike(String value) {
        ew.notLike("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition orShowPayerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoIsNull() {
        ew.isNull("payee_acct_no");
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acct_no");
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoIsNotNull() {
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoEq(Object value) {
        ew.eq("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoNe(Object value) {
        ew.ne("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoGt(Object value) {
        ew.gt("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoGe(Object value) {
        ew.ge("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoLt(Object value) {
        ew.lt("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoLe(Object value) {
        ew.le("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoIn(Object... value) {
        ew.in("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoNotIn(Object... value) {
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoBetween(Object value, Object value1) {
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoLike(String value) {
        ew.like("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeAcctNoNotLike(String value) {
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameIsNull() {
        ew.isNull("payee_name");
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_name");
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameIsNotNull() {
        ew.isNotNull("payee_name");
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_name");
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameEq(Object value) {
        ew.eq("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameNe(Object value) {
        ew.ne("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameGt(Object value) {
        ew.gt("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameGe(Object value) {
        ew.ge("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameLt(Object value) {
        ew.lt("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameLe(Object value) {
        ew.le("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameIn(Object... value) {
        ew.in("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameNotIn(Object... value) {
        ew.notIn("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameBetween(Object value, Object value1) {
        ew.between("payee_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameLike(String value) {
        ew.like("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeNameNotLike(String value) {
        ew.notLike("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_name", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkIsNull() {
        ew.isNull("payee_opbk");
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_opbk");
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkIsNotNull() {
        ew.isNotNull("payee_opbk");
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_opbk");
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkEq(Object value) {
        ew.eq("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkNe(Object value) {
        ew.ne("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkGt(Object value) {
        ew.gt("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkGe(Object value) {
        ew.ge("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkLt(Object value) {
        ew.lt("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkLe(Object value) {
        ew.le("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkIn(Object... value) {
        ew.in("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkNotIn(Object... value) {
        ew.notIn("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkBetween(Object value, Object value1) {
        ew.between("payee_opbk", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_opbk", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkNotBetween(Object value, Object value1) {
        ew.notBetween("payee_opbk", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_opbk", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkLike(String value) {
        ew.like("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andPayeeOpbkNotLike(String value) {
        ew.notLike("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition orPayeeOpbkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_opbk", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public AccountSettleDetailCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public AccountSettleDetailCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public AccountSettleDetailCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public AccountSettleDetailCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public AccountSettleDetailCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1IsNull() {
        ew.isNull("extend_1");
        return this;
    }

    public AccountSettleDetailCondition orExtend1IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_1");
        return this;
    }

    public AccountSettleDetailCondition andExtend1IsNotNull() {
        ew.isNotNull("extend_1");
        return this;
    }

    public AccountSettleDetailCondition orExtend1IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_1");
        return this;
    }

    public AccountSettleDetailCondition andExtend1Eq(Object value) {
        ew.eq("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1Ne(Object value) {
        ew.ne("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1Gt(Object value) {
        ew.gt("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1Ge(Object value) {
        ew.ge("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1Lt(Object value) {
        ew.lt("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1Le(Object value) {
        ew.le("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1In(Object... value) {
        ew.in("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1NotIn(Object... value) {
        ew.notIn("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1Between(Object value, Object value1) {
        ew.between("extend_1", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_1", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andExtend1NotBetween(Object value, Object value1) {
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orExtend1NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andExtend1Like(String value) {
        ew.like("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend1NotLike(String value) {
        ew.notLike("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend1NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_1", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2IsNull() {
        ew.isNull("extend_2");
        return this;
    }

    public AccountSettleDetailCondition orExtend2IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_2");
        return this;
    }

    public AccountSettleDetailCondition andExtend2IsNotNull() {
        ew.isNotNull("extend_2");
        return this;
    }

    public AccountSettleDetailCondition orExtend2IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_2");
        return this;
    }

    public AccountSettleDetailCondition andExtend2Eq(Object value) {
        ew.eq("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2Ne(Object value) {
        ew.ne("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2Gt(Object value) {
        ew.gt("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2Ge(Object value) {
        ew.ge("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2Lt(Object value) {
        ew.lt("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2Le(Object value) {
        ew.le("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2In(Object... value) {
        ew.in("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2NotIn(Object... value) {
        ew.notIn("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2Between(Object value, Object value1) {
        ew.between("extend_2", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_2", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andExtend2NotBetween(Object value, Object value1) {
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orExtend2NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andExtend2Like(String value) {
        ew.like("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend2NotLike(String value) {
        ew.notLike("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend2NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_2", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3IsNull() {
        ew.isNull("extend_3");
        return this;
    }

    public AccountSettleDetailCondition orExtend3IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_3");
        return this;
    }

    public AccountSettleDetailCondition andExtend3IsNotNull() {
        ew.isNotNull("extend_3");
        return this;
    }

    public AccountSettleDetailCondition orExtend3IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_3");
        return this;
    }

    public AccountSettleDetailCondition andExtend3Eq(Object value) {
        ew.eq("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3Ne(Object value) {
        ew.ne("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3Gt(Object value) {
        ew.gt("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3Ge(Object value) {
        ew.ge("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3Lt(Object value) {
        ew.lt("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3Le(Object value) {
        ew.le("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3In(Object... value) {
        ew.in("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3NotIn(Object... value) {
        ew.notIn("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3Between(Object value, Object value1) {
        ew.between("extend_3", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_3", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andExtend3NotBetween(Object value, Object value1) {
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orExtend3NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andExtend3Like(String value) {
        ew.like("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andExtend3NotLike(String value) {
        ew.notLike("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition orExtend3NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_3", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusIsNull() {
        ew.isNull("handle_status");
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("handle_status");
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusIsNotNull() {
        ew.isNotNull("handle_status");
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("handle_status");
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusEq(Object value) {
        ew.eq("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusNe(Object value) {
        ew.ne("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusGt(Object value) {
        ew.gt("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusGe(Object value) {
        ew.ge("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusLt(Object value) {
        ew.lt("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusLe(Object value) {
        ew.le("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusIn(Object... value) {
        ew.in("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusNotIn(Object... value) {
        ew.notIn("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusBetween(Object value, Object value1) {
        ew.between("handle_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("handle_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusNotBetween(Object value, Object value1) {
        ew.notBetween("handle_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("handle_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusLike(String value) {
        ew.like("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andHandleStatusNotLike(String value) {
        ew.notLike("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition orHandleStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("handle_status", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagIsNull() {
        ew.isNull("provision_flag");
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("provision_flag");
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagIsNotNull() {
        ew.isNotNull("provision_flag");
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("provision_flag");
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagEq(Object value) {
        ew.eq("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagNe(Object value) {
        ew.ne("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagGt(Object value) {
        ew.gt("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagGe(Object value) {
        ew.ge("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagLt(Object value) {
        ew.lt("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagLe(Object value) {
        ew.le("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagIn(Object... value) {
        ew.in("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagNotIn(Object... value) {
        ew.notIn("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagBetween(Object value, Object value1) {
        ew.between("provision_flag", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("provision_flag", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagNotBetween(Object value, Object value1) {
        ew.notBetween("provision_flag", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("provision_flag", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagLike(String value) {
        ew.like("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andProvisionFlagNotLike(String value) {
        ew.notLike("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition orProvisionFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("provision_flag", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public AccountSettleDetailCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public AccountSettleDetailCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public AccountSettleDetailCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public AccountSettleDetailCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public AccountSettleDetailCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public AccountSettleDetailCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public AccountSettleDetailCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public AccountSettleDetailCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public AccountSettleDetailCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public AccountSettleDetailCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public AccountSettleDetailCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public AccountSettleDetailCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public AccountSettleDetailCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public AccountSettleDetailCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public AccountSettleDetailCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public AccountSettleDetailCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountSettleDetailCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}