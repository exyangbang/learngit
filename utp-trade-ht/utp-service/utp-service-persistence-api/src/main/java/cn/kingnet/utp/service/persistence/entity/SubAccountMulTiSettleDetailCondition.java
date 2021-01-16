package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class SubAccountMulTiSettleDetailCondition {
    private PlusEntityWrapper<SubAccountMulTiSettleDetail> ew;

    public SubAccountMulTiSettleDetailCondition() {
        this.ew = new PlusEntityWrapper(SubAccountMulTiSettleDetail.class);
    }

    public static SubAccountMulTiSettleDetailCondition builder() {
        return new SubAccountMulTiSettleDetailCondition();
    }

    public PlusEntityWrapper<SubAccountMulTiSettleDetail> build() {
        return this.ew;
    }

    public SubAccountMulTiSettleDetailCondition or() {
        this.ew.orNew();
        return this;
    }

    public SubAccountMulTiSettleDetailCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(SubAccountMulTiSettleDetail.class);
    }

    public SubAccountMulTiSettleDetailCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> SubAccountMulTiSettleDetailCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> SubAccountMulTiSettleDetailCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> SubAccountMulTiSettleDetailCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateIsNull() {
        ew.isNull("req_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateIsNotNull() {
        ew.isNotNull("req_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateEq(Object value) {
        ew.eq("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateNe(Object value) {
        ew.ne("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateGt(Object value) {
        ew.gt("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateGe(Object value) {
        ew.ge("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateLt(Object value) {
        ew.lt("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateLe(Object value) {
        ew.le("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateIn(Object... value) {
        ew.in("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateNotIn(Object... value) {
        ew.notIn("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateBetween(Object value, Object value1) {
        ew.between("req_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateNotBetween(Object value, Object value1) {
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateLike(String value) {
        ew.like("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqDateNotLike(String value) {
        ew.notLike("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeIsNull() {
        ew.isNull("req_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeIsNotNull() {
        ew.isNotNull("req_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeEq(Object value) {
        ew.eq("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeNe(Object value) {
        ew.ne("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeGt(Object value) {
        ew.gt("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeGe(Object value) {
        ew.ge("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeLt(Object value) {
        ew.lt("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeLe(Object value) {
        ew.le("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeIn(Object... value) {
        ew.in("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeNotIn(Object... value) {
        ew.notIn("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeBetween(Object value, Object value1) {
        ew.between("req_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeNotBetween(Object value, Object value1) {
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeLike(String value) {
        ew.like("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReqTimeNotLike(String value) {
        ew.notLike("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReqTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountIsNull() {
        ew.isNull("user_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountIsNotNull() {
        ew.isNotNull("user_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountEq(Object value) {
        ew.eq("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountNe(Object value) {
        ew.ne("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountGt(Object value) {
        ew.gt("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountGe(Object value) {
        ew.ge("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountLt(Object value) {
        ew.lt("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountLe(Object value) {
        ew.le("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountIn(Object... value) {
        ew.in("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountNotIn(Object... value) {
        ew.notIn("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountBetween(Object value, Object value1) {
        ew.between("user_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountNotBetween(Object value, Object value1) {
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountLike(String value) {
        ew.like("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserAccountNotLike(String value) {
        ew.notLike("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeIsNull() {
        ew.isNull("type");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("type");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeIsNotNull() {
        ew.isNotNull("type");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("type");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeEq(Object value) {
        ew.eq("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeNe(Object value) {
        ew.ne("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeGt(Object value) {
        ew.gt("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeGe(Object value) {
        ew.ge("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeLt(Object value) {
        ew.lt("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeLe(Object value) {
        ew.le("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeIn(Object... value) {
        ew.in("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeNotIn(Object... value) {
        ew.notIn("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeBetween(Object value, Object value1) {
        ew.between("type", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("type", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeNotBetween(Object value, Object value1) {
        ew.notBetween("type", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("type", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeLike(String value) {
        ew.like("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTypeNotLike(String value) {
        ew.notLike("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("type", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoIsNull() {
        ew.isNull("batch_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoIsNotNull() {
        ew.isNotNull("batch_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoEq(Object value) {
        ew.eq("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoNe(Object value) {
        ew.ne("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoGt(Object value) {
        ew.gt("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoGe(Object value) {
        ew.ge("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoLt(Object value) {
        ew.lt("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoLe(Object value) {
        ew.le("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoIn(Object... value) {
        ew.in("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoNotIn(Object... value) {
        ew.notIn("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoBetween(Object value, Object value1) {
        ew.between("batch_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoLike(String value) {
        ew.like("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andBatchNoNotLike(String value) {
        ew.notLike("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoIsNull() {
        ew.isNull("seq_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("seq_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoIsNotNull() {
        ew.isNotNull("seq_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("seq_no");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoEq(Object value) {
        ew.eq("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoNe(Object value) {
        ew.ne("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoGt(Object value) {
        ew.gt("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoGe(Object value) {
        ew.ge("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoLt(Object value) {
        ew.lt("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoLe(Object value) {
        ew.le("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoIn(Object... value) {
        ew.in("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoNotIn(Object... value) {
        ew.notIn("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoBetween(Object value, Object value1) {
        ew.between("seq_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("seq_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoNotBetween(Object value, Object value1) {
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoLike(String value) {
        ew.like("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSeqNoNotLike(String value) {
        ew.notLike("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSeqNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("seq_no", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateIsNull() {
        ew.isNull("settle_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateIsNotNull() {
        ew.isNotNull("settle_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateEq(Object value) {
        ew.eq("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateNe(Object value) {
        ew.ne("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateGt(Object value) {
        ew.gt("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateGe(Object value) {
        ew.ge("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateLt(Object value) {
        ew.lt("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateLe(Object value) {
        ew.le("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateIn(Object... value) {
        ew.in("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateNotIn(Object... value) {
        ew.notIn("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateBetween(Object value, Object value1) {
        ew.between("settle_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateLike(String value) {
        ew.like("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleDateNotLike(String value) {
        ew.notLike("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountIsNull() {
        ew.isNull("payer_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountIsNotNull() {
        ew.isNotNull("payer_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountEq(Object value) {
        ew.eq("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountNe(Object value) {
        ew.ne("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountGt(Object value) {
        ew.gt("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountGe(Object value) {
        ew.ge("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountLt(Object value) {
        ew.lt("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountLe(Object value) {
        ew.le("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountIn(Object... value) {
        ew.in("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountNotIn(Object... value) {
        ew.notIn("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountBetween(Object value, Object value1) {
        ew.between("payer_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountLike(String value) {
        ew.like("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayerSubAccountNotLike(String value) {
        ew.notLike("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayerSubAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountIsNull() {
        ew.isNull("payee_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountIsNotNull() {
        ew.isNotNull("payee_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_sub_account");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountEq(Object value) {
        ew.eq("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountNe(Object value) {
        ew.ne("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountGt(Object value) {
        ew.gt("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountGe(Object value) {
        ew.ge("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountLt(Object value) {
        ew.lt("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountLe(Object value) {
        ew.le("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountIn(Object... value) {
        ew.in("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountNotIn(Object... value) {
        ew.notIn("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountBetween(Object value, Object value1) {
        ew.between("payee_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payee_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_sub_account", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountLike(String value) {
        ew.like("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPayeeSubAccountNotLike(String value) {
        ew.notLike("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPayeeSubAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_sub_account", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeIsNull() {
        ew.isNull("settle_mode");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_mode");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeIsNotNull() {
        ew.isNotNull("settle_mode");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_mode");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeEq(Object value) {
        ew.eq("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeNe(Object value) {
        ew.ne("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeGt(Object value) {
        ew.gt("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeGe(Object value) {
        ew.ge("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeLt(Object value) {
        ew.lt("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeLe(Object value) {
        ew.le("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeIn(Object... value) {
        ew.in("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeNotIn(Object... value) {
        ew.notIn("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeBetween(Object value, Object value1) {
        ew.between("settle_mode", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_mode", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeNotBetween(Object value, Object value1) {
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeLike(String value) {
        ew.like("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSettleModeNotLike(String value) {
        ew.notLike("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSettleModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_mode", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateIsNull() {
        ew.isNull("split_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateIsNotNull() {
        ew.isNotNull("split_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateEq(Object value) {
        ew.eq("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateNe(Object value) {
        ew.ne("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateGt(Object value) {
        ew.gt("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateGe(Object value) {
        ew.ge("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateLt(Object value) {
        ew.lt("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateLe(Object value) {
        ew.le("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateIn(Object... value) {
        ew.in("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateNotIn(Object... value) {
        ew.notIn("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateBetween(Object value, Object value1) {
        ew.between("split_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateNotBetween(Object value, Object value1) {
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateLike(String value) {
        ew.like("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSplitDateNotLike(String value) {
        ew.notLike("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSplitDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2IsNull() {
        ew.isNull("extend_2");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_2");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2IsNotNull() {
        ew.isNotNull("extend_2");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_2");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Eq(Object value) {
        ew.eq("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Ne(Object value) {
        ew.ne("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Gt(Object value) {
        ew.gt("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Ge(Object value) {
        ew.ge("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Lt(Object value) {
        ew.lt("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Le(Object value) {
        ew.le("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2In(Object... value) {
        ew.in("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2NotIn(Object... value) {
        ew.notIn("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Between(Object value, Object value1) {
        ew.between("extend_2", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_2", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2NotBetween(Object value, Object value1) {
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2Like(String value) {
        ew.like("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend2NotLike(String value) {
        ew.notLike("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend2NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_2", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3IsNull() {
        ew.isNull("extend_3");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_3");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3IsNotNull() {
        ew.isNotNull("extend_3");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_3");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Eq(Object value) {
        ew.eq("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Ne(Object value) {
        ew.ne("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Gt(Object value) {
        ew.gt("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Ge(Object value) {
        ew.ge("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Lt(Object value) {
        ew.lt("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Le(Object value) {
        ew.le("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3In(Object... value) {
        ew.in("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3NotIn(Object... value) {
        ew.notIn("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Between(Object value, Object value1) {
        ew.between("extend_3", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_3", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3NotBetween(Object value, Object value1) {
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3Like(String value) {
        ew.like("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andExtend3NotLike(String value) {
        ew.notLike("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orExtend3NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_3", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesIsNull() {
        ew.isNull("query_times");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("query_times");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesIsNotNull() {
        ew.isNotNull("query_times");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("query_times");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesEq(Object value) {
        ew.eq("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesNe(Object value) {
        ew.ne("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesGt(Object value) {
        ew.gt("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesGe(Object value) {
        ew.ge("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesLt(Object value) {
        ew.lt("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesLe(Object value) {
        ew.le("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesIn(Object... value) {
        ew.in("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesNotIn(Object... value) {
        ew.notIn("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesBetween(Object value, Object value1) {
        ew.between("query_times", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("query_times", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesNotBetween(Object value, Object value1) {
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesLike(String value) {
        ew.like("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andQueryTimesNotLike(String value) {
        ew.notLike("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orQueryTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("query_times", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectIsNull() {
        ew.isNull("subject");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("subject");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectIsNotNull() {
        ew.isNotNull("subject");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("subject");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectEq(Object value) {
        ew.eq("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectNe(Object value) {
        ew.ne("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectGt(Object value) {
        ew.gt("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectGe(Object value) {
        ew.ge("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectLt(Object value) {
        ew.lt("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectLe(Object value) {
        ew.le("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectIn(Object... value) {
        ew.in("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectNotIn(Object... value) {
        ew.notIn("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectBetween(Object value, Object value1) {
        ew.between("subject", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("subject", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectNotBetween(Object value, Object value1) {
        ew.notBetween("subject", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("subject", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectLike(String value) {
        ew.like("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andSubjectNotLike(String value) {
        ew.notLike("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orSubjectNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("subject", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsIsNull() {
        ew.isNull("trans_order_ids");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_order_ids");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsIsNotNull() {
        ew.isNotNull("trans_order_ids");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_order_ids");
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsEq(Object value) {
        ew.eq("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsNe(Object value) {
        ew.ne("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsGt(Object value) {
        ew.gt("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsGe(Object value) {
        ew.ge("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsLt(Object value) {
        ew.lt("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsLe(Object value) {
        ew.le("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsIn(Object... value) {
        ew.in("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsNotIn(Object... value) {
        ew.notIn("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsBetween(Object value, Object value1) {
        ew.between("trans_order_ids", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_order_ids", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsNotBetween(Object value, Object value1) {
        ew.notBetween("trans_order_ids", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_order_ids", value, value1);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsLike(String value) {
        ew.like("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition andTransOrderIdsNotLike(String value) {
        ew.notLike("trans_order_ids", value);
        return this;
    }

    public SubAccountMulTiSettleDetailCondition orTransOrderIdsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_order_ids", value);
        return this;
    }
}