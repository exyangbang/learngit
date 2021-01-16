package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class IndustrySyncLogCondition {
    private PlusEntityWrapper<IndustrySyncLog> ew;

    public IndustrySyncLogCondition() {
        this.ew = new PlusEntityWrapper(IndustrySyncLog.class);
    }

    public static IndustrySyncLogCondition builder() {
        return new IndustrySyncLogCondition();
    }

    public PlusEntityWrapper<IndustrySyncLog> build() {
        return this.ew;
    }

    public IndustrySyncLogCondition or() {
        this.ew.orNew();
        return this;
    }

    public IndustrySyncLogCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(IndustrySyncLog.class);
    }

    public IndustrySyncLogCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public IndustrySyncLogCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public IndustrySyncLogCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public IndustrySyncLogCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> IndustrySyncLogCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> IndustrySyncLogCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> IndustrySyncLogCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public IndustrySyncLogCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public IndustrySyncLogCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public IndustrySyncLogCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public IndustrySyncLogCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public IndustrySyncLogCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public IndustrySyncLogCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public IndustrySyncLogCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public IndustrySyncLogCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public IndustrySyncLogCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoIsNull() {
        ew.isNull("fund_account_no");
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fund_account_no");
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoIsNotNull() {
        ew.isNotNull("fund_account_no");
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fund_account_no");
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoEq(Object value) {
        ew.eq("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoNe(Object value) {
        ew.ne("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoGt(Object value) {
        ew.gt("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoGe(Object value) {
        ew.ge("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoLt(Object value) {
        ew.lt("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoLe(Object value) {
        ew.le("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoIn(Object... value) {
        ew.in("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoNotIn(Object... value) {
        ew.notIn("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoBetween(Object value, Object value1) {
        ew.between("fund_account_no", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fund_account_no", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("fund_account_no", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fund_account_no", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoLike(String value) {
        ew.like("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andFundAccountNoNotLike(String value) {
        ew.notLike("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition orFundAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fund_account_no", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateIsNull() {
        ew.isNull("last_date");
        return this;
    }

    public IndustrySyncLogCondition orLastDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("last_date");
        return this;
    }

    public IndustrySyncLogCondition andLastDateIsNotNull() {
        ew.isNotNull("last_date");
        return this;
    }

    public IndustrySyncLogCondition orLastDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("last_date");
        return this;
    }

    public IndustrySyncLogCondition andLastDateEq(Object value) {
        ew.eq("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateNe(Object value) {
        ew.ne("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateGt(Object value) {
        ew.gt("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateGe(Object value) {
        ew.ge("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateLt(Object value) {
        ew.lt("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateLe(Object value) {
        ew.le("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateIn(Object... value) {
        ew.in("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateNotIn(Object... value) {
        ew.notIn("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateBetween(Object value, Object value1) {
        ew.between("last_date", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orLastDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("last_date", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andLastDateNotBetween(Object value, Object value1) {
        ew.notBetween("last_date", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orLastDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("last_date", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andLastDateLike(String value) {
        ew.like("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastDateNotLike(String value) {
        ew.notLike("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition orLastDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("last_date", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeIsNull() {
        ew.isNull("last_time");
        return this;
    }

    public IndustrySyncLogCondition orLastTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("last_time");
        return this;
    }

    public IndustrySyncLogCondition andLastTimeIsNotNull() {
        ew.isNotNull("last_time");
        return this;
    }

    public IndustrySyncLogCondition orLastTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("last_time");
        return this;
    }

    public IndustrySyncLogCondition andLastTimeEq(Object value) {
        ew.eq("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeNe(Object value) {
        ew.ne("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeGt(Object value) {
        ew.gt("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeGe(Object value) {
        ew.ge("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeLt(Object value) {
        ew.lt("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeLe(Object value) {
        ew.le("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeIn(Object... value) {
        ew.in("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeNotIn(Object... value) {
        ew.notIn("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeBetween(Object value, Object value1) {
        ew.between("last_time", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("last_time", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeNotBetween(Object value, Object value1) {
        ew.notBetween("last_time", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("last_time", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeLike(String value) {
        ew.like("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andLastTimeNotLike(String value) {
        ew.notLike("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition orLastTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("last_time", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public IndustrySyncLogCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public IndustrySyncLogCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public IndustrySyncLogCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public IndustrySyncLogCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public IndustrySyncLogCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public IndustrySyncLogCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public IndustrySyncLogCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public IndustrySyncLogCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public IndustrySyncLogCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public IndustrySyncLogCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }
}