package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class UploadSubAccountIncomeFlowCondition {
    private PlusEntityWrapper<UploadSubAccountIncomeFlow> ew;

    public UploadSubAccountIncomeFlowCondition() {
        this.ew = new PlusEntityWrapper(UploadSubAccountIncomeFlow.class);
    }

    public static UploadSubAccountIncomeFlowCondition builder() {
        return new UploadSubAccountIncomeFlowCondition();
    }

    public PlusEntityWrapper<UploadSubAccountIncomeFlow> build() {
        return this.ew;
    }

    public UploadSubAccountIncomeFlowCondition or() {
        this.ew.orNew();
        return this;
    }

    public UploadSubAccountIncomeFlowCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(UploadSubAccountIncomeFlow.class);
    }

    public UploadSubAccountIncomeFlowCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> UploadSubAccountIncomeFlowCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> UploadSubAccountIncomeFlowCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> UploadSubAccountIncomeFlowCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountIsNull() {
        ew.isNull("sub_account");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sub_account");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountIsNotNull() {
        ew.isNotNull("sub_account");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sub_account");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountEq(Object value) {
        ew.eq("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountNe(Object value) {
        ew.ne("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountGt(Object value) {
        ew.gt("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountGe(Object value) {
        ew.ge("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountLt(Object value) {
        ew.lt("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountLe(Object value) {
        ew.le("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountIn(Object... value) {
        ew.in("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountNotIn(Object... value) {
        ew.notIn("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountBetween(Object value, Object value1) {
        ew.between("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountNotBetween(Object value, Object value1) {
        ew.notBetween("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountLike(String value) {
        ew.like("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSubAccountNotLike(String value) {
        ew.notLike("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSubAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sub_account", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoIsNull() {
        ew.isNull("batch_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoIsNotNull() {
        ew.isNotNull("batch_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoEq(Object value) {
        ew.eq("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoNe(Object value) {
        ew.ne("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoGt(Object value) {
        ew.gt("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoGe(Object value) {
        ew.ge("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoLt(Object value) {
        ew.lt("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoLe(Object value) {
        ew.le("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoIn(Object... value) {
        ew.in("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoNotIn(Object... value) {
        ew.notIn("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoBetween(Object value, Object value1) {
        ew.between("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoLike(String value) {
        ew.like("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andBatchNoNotLike(String value) {
        ew.notLike("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoIsNull() {
        ew.isNull("seq_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("seq_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoIsNotNull() {
        ew.isNotNull("seq_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("seq_no");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoEq(Object value) {
        ew.eq("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoNe(Object value) {
        ew.ne("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoGt(Object value) {
        ew.gt("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoGe(Object value) {
        ew.ge("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoLt(Object value) {
        ew.lt("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoLe(Object value) {
        ew.le("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoIn(Object... value) {
        ew.in("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoNotIn(Object... value) {
        ew.notIn("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoBetween(Object value, Object value1) {
        ew.between("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoNotBetween(Object value, Object value1) {
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoLike(String value) {
        ew.like("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andSeqNoNotLike(String value) {
        ew.notLike("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orSeqNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("seq_no", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdIsNull() {
        ew.isNull("income_flow_id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_flow_id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdIsNotNull() {
        ew.isNotNull("income_flow_id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_flow_id");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdEq(Object value) {
        ew.eq("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdNe(Object value) {
        ew.ne("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdGt(Object value) {
        ew.gt("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdGe(Object value) {
        ew.ge("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdLt(Object value) {
        ew.lt("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdLe(Object value) {
        ew.le("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdIn(Object... value) {
        ew.in("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdNotIn(Object... value) {
        ew.notIn("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdBetween(Object value, Object value1) {
        ew.between("income_flow_id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_flow_id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdNotBetween(Object value, Object value1) {
        ew.notBetween("income_flow_id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_flow_id", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdLike(String value) {
        ew.like("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeFlowIdNotLike(String value) {
        ew.notLike("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeFlowIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_flow_id", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountIsNull() {
        ew.isNull("income_amount");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_amount");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountIsNotNull() {
        ew.isNotNull("income_amount");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_amount");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountEq(Object value) {
        ew.eq("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountNe(Object value) {
        ew.ne("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountGt(Object value) {
        ew.gt("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountGe(Object value) {
        ew.ge("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountLt(Object value) {
        ew.lt("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountLe(Object value) {
        ew.le("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountIn(Object... value) {
        ew.in("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountNotIn(Object... value) {
        ew.notIn("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountBetween(Object value, Object value1) {
        ew.between("income_amount", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_amount", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountNotBetween(Object value, Object value1) {
        ew.notBetween("income_amount", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_amount", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountLike(String value) {
        ew.like("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andIncomeAmountNotLike(String value) {
        ew.notLike("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orIncomeAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_amount", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsIsNull() {
        ew.isNull("pay_flow_ids");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pay_flow_ids");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsIsNotNull() {
        ew.isNotNull("pay_flow_ids");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pay_flow_ids");
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsEq(Object value) {
        ew.eq("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsNe(Object value) {
        ew.ne("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsGt(Object value) {
        ew.gt("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsGe(Object value) {
        ew.ge("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsLt(Object value) {
        ew.lt("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsLe(Object value) {
        ew.le("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsIn(Object... value) {
        ew.in("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsNotIn(Object... value) {
        ew.notIn("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsBetween(Object value, Object value1) {
        ew.between("pay_flow_ids", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pay_flow_ids", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsNotBetween(Object value, Object value1) {
        ew.notBetween("pay_flow_ids", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pay_flow_ids", value, value1);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsLike(String value) {
        ew.like("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition andPayFlowIdsNotLike(String value) {
        ew.notLike("pay_flow_ids", value);
        return this;
    }

    public UploadSubAccountIncomeFlowCondition orPayFlowIdsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pay_flow_ids", value);
        return this;
    }
}