package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class FileUploadLogCondition {
    private PlusEntityWrapper<FileUploadLog> ew;

    public FileUploadLogCondition() {
        this.ew = new PlusEntityWrapper(FileUploadLog.class);
    }

    public static FileUploadLogCondition builder() {
        return new FileUploadLogCondition();
    }

    public PlusEntityWrapper<FileUploadLog> build() {
        return this.ew;
    }

    public FileUploadLogCondition or() {
        this.ew.orNew();
        return this;
    }

    public FileUploadLogCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(FileUploadLog.class);
    }

    public FileUploadLogCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public FileUploadLogCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public FileUploadLogCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public FileUploadLogCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> FileUploadLogCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> FileUploadLogCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> FileUploadLogCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public FileUploadLogCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public FileUploadLogCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public FileUploadLogCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public FileUploadLogCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public FileUploadLogCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public FileUploadLogCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public FileUploadLogCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public FileUploadLogCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public FileUploadLogCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public FileUploadLogCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public FileUploadLogCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public FileUploadLogCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public FileUploadLogCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public FileUploadLogCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public FileUploadLogCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public FileUploadLogCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public FileUploadLogCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public FileUploadLogCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public FileUploadLogCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public FileUploadLogCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public FileUploadLogCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public FileUploadLogCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public FileUploadLogCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public FileUploadLogCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public FileUploadLogCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public FileUploadLogCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public FileUploadLogCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public FileUploadLogCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public FileUploadLogCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public FileUploadLogCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public FileUploadLogCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public FileUploadLogCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public FileUploadLogCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public FileUploadLogCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public FileUploadLogCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public FileUploadLogCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public FileUploadLogCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public FileUploadLogCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public FileUploadLogCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public FileUploadLogCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public FileUploadLogCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public FileUploadLogCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public FileUploadLogCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public FileUploadLogCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public FileUploadLogCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public FileUploadLogCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public FileUploadLogCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public FileUploadLogCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public FileUploadLogCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public FileUploadLogCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public FileUploadLogCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public FileUploadLogCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public FileUploadLogCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public FileUploadLogCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public FileUploadLogCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountIsNull() {
        ew.isNull("payer_account");
        return this;
    }

    public FileUploadLogCondition orPayerAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_account");
        return this;
    }

    public FileUploadLogCondition andPayerAccountIsNotNull() {
        ew.isNotNull("payer_account");
        return this;
    }

    public FileUploadLogCondition orPayerAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_account");
        return this;
    }

    public FileUploadLogCondition andPayerAccountEq(Object value) {
        ew.eq("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountNe(Object value) {
        ew.ne("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountGt(Object value) {
        ew.gt("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountGe(Object value) {
        ew.ge("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountLt(Object value) {
        ew.lt("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountLe(Object value) {
        ew.le("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountIn(Object... value) {
        ew.in("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountNotIn(Object... value) {
        ew.notIn("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountBetween(Object value, Object value1) {
        ew.between("payer_account", value, value1);
        return this;
    }

    public FileUploadLogCondition orPayerAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_account", value, value1);
        return this;
    }

    public FileUploadLogCondition andPayerAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public FileUploadLogCondition orPayerAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public FileUploadLogCondition andPayerAccountLike(String value) {
        ew.like("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andPayerAccountNotLike(String value) {
        ew.notLike("payer_account", value);
        return this;
    }

    public FileUploadLogCondition orPayerAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_account", value);
        return this;
    }

    public FileUploadLogCondition andBizDateIsNull() {
        ew.isNull("biz_date");
        return this;
    }

    public FileUploadLogCondition orBizDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("biz_date");
        return this;
    }

    public FileUploadLogCondition andBizDateIsNotNull() {
        ew.isNotNull("biz_date");
        return this;
    }

    public FileUploadLogCondition orBizDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("biz_date");
        return this;
    }

    public FileUploadLogCondition andBizDateEq(Object value) {
        ew.eq("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateNe(Object value) {
        ew.ne("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateGt(Object value) {
        ew.gt("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateGe(Object value) {
        ew.ge("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateLt(Object value) {
        ew.lt("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateLe(Object value) {
        ew.le("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateIn(Object... value) {
        ew.in("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateNotIn(Object... value) {
        ew.notIn("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateBetween(Object value, Object value1) {
        ew.between("biz_date", value, value1);
        return this;
    }

    public FileUploadLogCondition orBizDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("biz_date", value, value1);
        return this;
    }

    public FileUploadLogCondition andBizDateNotBetween(Object value, Object value1) {
        ew.notBetween("biz_date", value, value1);
        return this;
    }

    public FileUploadLogCondition orBizDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("biz_date", value, value1);
        return this;
    }

    public FileUploadLogCondition andBizDateLike(String value) {
        ew.like("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andBizDateNotLike(String value) {
        ew.notLike("biz_date", value);
        return this;
    }

    public FileUploadLogCondition orBizDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("biz_date", value);
        return this;
    }

    public FileUploadLogCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public FileUploadLogCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public FileUploadLogCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public FileUploadLogCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public FileUploadLogCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public FileUploadLogCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public FileUploadLogCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public FileUploadLogCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public FileUploadLogCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public FileUploadLogCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public FileUploadLogCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdIsNull() {
        ew.isNull("batch_id");
        return this;
    }

    public FileUploadLogCondition orBatchIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_id");
        return this;
    }

    public FileUploadLogCondition andBatchIdIsNotNull() {
        ew.isNotNull("batch_id");
        return this;
    }

    public FileUploadLogCondition orBatchIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_id");
        return this;
    }

    public FileUploadLogCondition andBatchIdEq(Object value) {
        ew.eq("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdNe(Object value) {
        ew.ne("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdGt(Object value) {
        ew.gt("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdGe(Object value) {
        ew.ge("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdLt(Object value) {
        ew.lt("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdLe(Object value) {
        ew.le("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdIn(Object... value) {
        ew.in("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdNotIn(Object... value) {
        ew.notIn("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdBetween(Object value, Object value1) {
        ew.between("batch_id", value, value1);
        return this;
    }

    public FileUploadLogCondition orBatchIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_id", value, value1);
        return this;
    }

    public FileUploadLogCondition andBatchIdNotBetween(Object value, Object value1) {
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public FileUploadLogCondition orBatchIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public FileUploadLogCondition andBatchIdLike(String value) {
        ew.like("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andBatchIdNotLike(String value) {
        ew.notLike("batch_id", value);
        return this;
    }

    public FileUploadLogCondition orBatchIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_id", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountIsNull() {
        ew.isNull("total_count");
        return this;
    }

    public FileUploadLogCondition orTotalCountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("total_count");
        return this;
    }

    public FileUploadLogCondition andTotalCountIsNotNull() {
        ew.isNotNull("total_count");
        return this;
    }

    public FileUploadLogCondition orTotalCountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("total_count");
        return this;
    }

    public FileUploadLogCondition andTotalCountEq(Object value) {
        ew.eq("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountNe(Object value) {
        ew.ne("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountGt(Object value) {
        ew.gt("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountGe(Object value) {
        ew.ge("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountLt(Object value) {
        ew.lt("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountLe(Object value) {
        ew.le("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountIn(Object... value) {
        ew.in("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountNotIn(Object... value) {
        ew.notIn("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountBetween(Object value, Object value1) {
        ew.between("total_count", value, value1);
        return this;
    }

    public FileUploadLogCondition orTotalCountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("total_count", value, value1);
        return this;
    }

    public FileUploadLogCondition andTotalCountNotBetween(Object value, Object value1) {
        ew.notBetween("total_count", value, value1);
        return this;
    }

    public FileUploadLogCondition orTotalCountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("total_count", value, value1);
        return this;
    }

    public FileUploadLogCondition andTotalCountLike(String value) {
        ew.like("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalCountNotLike(String value) {
        ew.notLike("total_count", value);
        return this;
    }

    public FileUploadLogCondition orTotalCountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("total_count", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountIsNull() {
        ew.isNull("total_amount");
        return this;
    }

    public FileUploadLogCondition orTotalAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("total_amount");
        return this;
    }

    public FileUploadLogCondition andTotalAmountIsNotNull() {
        ew.isNotNull("total_amount");
        return this;
    }

    public FileUploadLogCondition orTotalAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("total_amount");
        return this;
    }

    public FileUploadLogCondition andTotalAmountEq(Object value) {
        ew.eq("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountNe(Object value) {
        ew.ne("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountGt(Object value) {
        ew.gt("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountGe(Object value) {
        ew.ge("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountLt(Object value) {
        ew.lt("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountLe(Object value) {
        ew.le("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountIn(Object... value) {
        ew.in("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountNotIn(Object... value) {
        ew.notIn("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountBetween(Object value, Object value1) {
        ew.between("total_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition orTotalAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("total_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition andTotalAmountNotBetween(Object value, Object value1) {
        ew.notBetween("total_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition orTotalAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("total_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition andTotalAmountLike(String value) {
        ew.like("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTotalAmountNotLike(String value) {
        ew.notLike("total_amount", value);
        return this;
    }

    public FileUploadLogCondition orTotalAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("total_amount", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public FileUploadLogCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public FileUploadLogCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public FileUploadLogCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public FileUploadLogCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public FileUploadLogCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public FileUploadLogCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public FileUploadLogCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public FileUploadLogCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public FileUploadLogCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public FileUploadLogCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public FileUploadLogCondition andRealCountIsNull() {
        ew.isNull("real_count");
        return this;
    }

    public FileUploadLogCondition orRealCountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_count");
        return this;
    }

    public FileUploadLogCondition andRealCountIsNotNull() {
        ew.isNotNull("real_count");
        return this;
    }

    public FileUploadLogCondition orRealCountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_count");
        return this;
    }

    public FileUploadLogCondition andRealCountEq(Object value) {
        ew.eq("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountNe(Object value) {
        ew.ne("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountGt(Object value) {
        ew.gt("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountGe(Object value) {
        ew.ge("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountLt(Object value) {
        ew.lt("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountLe(Object value) {
        ew.le("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountIn(Object... value) {
        ew.in("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountNotIn(Object... value) {
        ew.notIn("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountBetween(Object value, Object value1) {
        ew.between("real_count", value, value1);
        return this;
    }

    public FileUploadLogCondition orRealCountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_count", value, value1);
        return this;
    }

    public FileUploadLogCondition andRealCountNotBetween(Object value, Object value1) {
        ew.notBetween("real_count", value, value1);
        return this;
    }

    public FileUploadLogCondition orRealCountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_count", value, value1);
        return this;
    }

    public FileUploadLogCondition andRealCountLike(String value) {
        ew.like("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealCountNotLike(String value) {
        ew.notLike("real_count", value);
        return this;
    }

    public FileUploadLogCondition orRealCountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_count", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountIsNull() {
        ew.isNull("real_amount");
        return this;
    }

    public FileUploadLogCondition orRealAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_amount");
        return this;
    }

    public FileUploadLogCondition andRealAmountIsNotNull() {
        ew.isNotNull("real_amount");
        return this;
    }

    public FileUploadLogCondition orRealAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_amount");
        return this;
    }

    public FileUploadLogCondition andRealAmountEq(Object value) {
        ew.eq("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountNe(Object value) {
        ew.ne("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountGt(Object value) {
        ew.gt("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountGe(Object value) {
        ew.ge("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountLt(Object value) {
        ew.lt("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountLe(Object value) {
        ew.le("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountIn(Object... value) {
        ew.in("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountNotIn(Object... value) {
        ew.notIn("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountBetween(Object value, Object value1) {
        ew.between("real_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition orRealAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition andRealAmountNotBetween(Object value, Object value1) {
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition orRealAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public FileUploadLogCondition andRealAmountLike(String value) {
        ew.like("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andRealAmountNotLike(String value) {
        ew.notLike("real_amount", value);
        return this;
    }

    public FileUploadLogCondition orRealAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_amount", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlIsNull() {
        ew.isNull("callback_url");
        return this;
    }

    public FileUploadLogCondition orCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_url");
        return this;
    }

    public FileUploadLogCondition andCallbackUrlIsNotNull() {
        ew.isNotNull("callback_url");
        return this;
    }

    public FileUploadLogCondition orCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_url");
        return this;
    }

    public FileUploadLogCondition andCallbackUrlEq(Object value) {
        ew.eq("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlNe(Object value) {
        ew.ne("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlGt(Object value) {
        ew.gt("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlGe(Object value) {
        ew.ge("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlLt(Object value) {
        ew.lt("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlLe(Object value) {
        ew.le("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlIn(Object... value) {
        ew.in("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlNotIn(Object... value) {
        ew.notIn("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlBetween(Object value, Object value1) {
        ew.between("callback_url", value, value1);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_url", value, value1);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlLike(String value) {
        ew.like("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andCallbackUrlNotLike(String value) {
        ew.notLike("callback_url", value);
        return this;
    }

    public FileUploadLogCondition orCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_url", value);
        return this;
    }

    public FileUploadLogCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public FileUploadLogCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public FileUploadLogCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public FileUploadLogCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public FileUploadLogCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public FileUploadLogCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public FileUploadLogCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public FileUploadLogCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public FileUploadLogCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public FileUploadLogCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public FileUploadLogCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public FileUploadLogCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public FileUploadLogCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesIsNull() {
        ew.isNull("callback_times");
        return this;
    }

    public FileUploadLogCondition orCallbackTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_times");
        return this;
    }

    public FileUploadLogCondition andCallbackTimesIsNotNull() {
        ew.isNotNull("callback_times");
        return this;
    }

    public FileUploadLogCondition orCallbackTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_times");
        return this;
    }

    public FileUploadLogCondition andCallbackTimesEq(Object value) {
        ew.eq("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesNe(Object value) {
        ew.ne("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesGt(Object value) {
        ew.gt("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesGe(Object value) {
        ew.ge("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesLt(Object value) {
        ew.lt("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesLe(Object value) {
        ew.le("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesIn(Object... value) {
        ew.in("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesNotIn(Object... value) {
        ew.notIn("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesBetween(Object value, Object value1) {
        ew.between("callback_times", value, value1);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_times", value, value1);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesNotBetween(Object value, Object value1) {
        ew.notBetween("callback_times", value, value1);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_times", value, value1);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesLike(String value) {
        ew.like("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andCallbackTimesNotLike(String value) {
        ew.notLike("callback_times", value);
        return this;
    }

    public FileUploadLogCondition orCallbackTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_times", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public FileUploadLogCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public FileUploadLogCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public FileUploadLogCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public FileUploadLogCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public FileUploadLogCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public FileUploadLogCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public FileUploadLogCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public FileUploadLogCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public FileUploadLogCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public FileUploadLogCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public FileUploadLogCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public FileUploadLogCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public FileUploadLogCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public FileUploadLogCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public FileUploadLogCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public FileUploadLogCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public FileUploadLogCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public FileUploadLogCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public FileUploadLogCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public FileUploadLogCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public FileUploadLogCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public FileUploadLogCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public FileUploadLogCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public FileUploadLogCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public FileUploadLogCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public FileUploadLogCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public FileUploadLogCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public FileUploadLogCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public FileUploadLogCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public FileUploadLogCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public FileUploadLogCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public FileUploadLogCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public FileUploadLogCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public FileUploadLogCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public FileUploadLogCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public FileUploadLogCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public FileUploadLogCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public FileUploadLogCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public FileUploadLogCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public FileUploadLogCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public FileUploadLogCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public FileUploadLogCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FileUploadLogCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public FileUploadLogCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public FileUploadLogCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public FileUploadLogCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public FileUploadLogCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public FileUploadLogCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public FileUploadLogCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public FileUploadLogCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FileUploadLogCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public FileUploadLogCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FileUploadLogCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public FileUploadLogCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public FileUploadLogCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public FileUploadLogCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public FileUploadLogCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public FileUploadLogCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public FileUploadLogCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public FileUploadLogCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public FileUploadLogCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FileUploadLogCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public FileUploadLogCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public FileUploadLogCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}