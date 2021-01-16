package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class UploadSubAccountSettleSplitLogCondition {
    private PlusEntityWrapper<UploadSubAccountSettleSplitLog> ew;

    public UploadSubAccountSettleSplitLogCondition() {
        this.ew = new PlusEntityWrapper(UploadSubAccountSettleSplitLog.class);
    }

    public static UploadSubAccountSettleSplitLogCondition builder() {
        return new UploadSubAccountSettleSplitLogCondition();
    }

    public PlusEntityWrapper<UploadSubAccountSettleSplitLog> build() {
        return this.ew;
    }

    public UploadSubAccountSettleSplitLogCondition or() {
        this.ew.orNew();
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(UploadSubAccountSettleSplitLog.class);
    }

    public UploadSubAccountSettleSplitLogCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> UploadSubAccountSettleSplitLogCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> UploadSubAccountSettleSplitLogCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> UploadSubAccountSettleSplitLogCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateIsNull() {
        ew.isNull("req_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateIsNotNull() {
        ew.isNotNull("req_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateEq(Object value) {
        ew.eq("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateNe(Object value) {
        ew.ne("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateGt(Object value) {
        ew.gt("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateGe(Object value) {
        ew.ge("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateLt(Object value) {
        ew.lt("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateLe(Object value) {
        ew.le("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateIn(Object... value) {
        ew.in("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateNotIn(Object... value) {
        ew.notIn("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateBetween(Object value, Object value1) {
        ew.between("req_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateNotBetween(Object value, Object value1) {
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateLike(String value) {
        ew.like("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqDateNotLike(String value) {
        ew.notLike("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeIsNull() {
        ew.isNull("req_time");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_time");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeIsNotNull() {
        ew.isNotNull("req_time");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_time");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeEq(Object value) {
        ew.eq("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeNe(Object value) {
        ew.ne("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeGt(Object value) {
        ew.gt("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeGe(Object value) {
        ew.ge("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeLt(Object value) {
        ew.lt("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeLe(Object value) {
        ew.le("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeIn(Object... value) {
        ew.in("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeNotIn(Object... value) {
        ew.notIn("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeBetween(Object value, Object value1) {
        ew.between("req_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeNotBetween(Object value, Object value1) {
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeLike(String value) {
        ew.like("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andReqTimeNotLike(String value) {
        ew.notLike("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orReqTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateIsNull() {
        ew.isNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateIsNotNull() {
        ew.isNotNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateEq(Object value) {
        ew.eq("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateNe(Object value) {
        ew.ne("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateGt(Object value) {
        ew.gt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateGe(Object value) {
        ew.ge("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateLt(Object value) {
        ew.lt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateLe(Object value) {
        ew.le("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateIn(Object... value) {
        ew.in("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateNotIn(Object... value) {
        ew.notIn("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateBetween(Object value, Object value1) {
        ew.between("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateLike(String value) {
        ew.like("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andSettleDateNotLike(String value) {
        ew.notLike("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountIsNull() {
        ew.isNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountIsNotNull() {
        ew.isNotNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountEq(Object value) {
        ew.eq("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountNe(Object value) {
        ew.ne("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountGt(Object value) {
        ew.gt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountGe(Object value) {
        ew.ge("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountLt(Object value) {
        ew.lt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountLe(Object value) {
        ew.le("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountIn(Object... value) {
        ew.in("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountNotIn(Object... value) {
        ew.notIn("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountBetween(Object value, Object value1) {
        ew.between("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountNotBetween(Object value, Object value1) {
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountLike(String value) {
        ew.like("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserAccountNotLike(String value) {
        ew.notLike("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoIsNull() {
        ew.isNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoIsNotNull() {
        ew.isNotNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoEq(Object value) {
        ew.eq("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoNe(Object value) {
        ew.ne("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoGt(Object value) {
        ew.gt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoGe(Object value) {
        ew.ge("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoLt(Object value) {
        ew.lt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoLe(Object value) {
        ew.le("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoIn(Object... value) {
        ew.in("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoNotIn(Object... value) {
        ew.notIn("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoBetween(Object value, Object value1) {
        ew.between("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoLike(String value) {
        ew.like("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andBatchNoNotLike(String value) {
        ew.notLike("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlIsNull() {
        ew.isNull("callback_url");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_url");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlIsNotNull() {
        ew.isNotNull("callback_url");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_url");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlEq(Object value) {
        ew.eq("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlNe(Object value) {
        ew.ne("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlGt(Object value) {
        ew.gt("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlGe(Object value) {
        ew.ge("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlLt(Object value) {
        ew.lt("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlLe(Object value) {
        ew.le("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlIn(Object... value) {
        ew.in("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlNotIn(Object... value) {
        ew.notIn("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlBetween(Object value, Object value1) {
        ew.between("callback_url", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_url", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlLike(String value) {
        ew.like("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackUrlNotLike(String value) {
        ew.notLike("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_url", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesIsNull() {
        ew.isNull("callback_times");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_times");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesIsNotNull() {
        ew.isNotNull("callback_times");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_times");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesEq(Object value) {
        ew.eq("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesNe(Object value) {
        ew.ne("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesGt(Object value) {
        ew.gt("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesGe(Object value) {
        ew.ge("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesLt(Object value) {
        ew.lt("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesLe(Object value) {
        ew.le("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesIn(Object... value) {
        ew.in("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesNotIn(Object... value) {
        ew.notIn("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesBetween(Object value, Object value1) {
        ew.between("callback_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesNotBetween(Object value, Object value1) {
        ew.notBetween("callback_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesLike(String value) {
        ew.like("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackTimesNotLike(String value) {
        ew.notLike("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusIsNull() {
        ew.isNull("callback_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusIsNotNull() {
        ew.isNotNull("callback_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_status");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusEq(Object value) {
        ew.eq("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusNe(Object value) {
        ew.ne("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusGt(Object value) {
        ew.gt("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusGe(Object value) {
        ew.ge("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusLt(Object value) {
        ew.lt("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusLe(Object value) {
        ew.le("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusIn(Object... value) {
        ew.in("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusNotIn(Object... value) {
        ew.notIn("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusBetween(Object value, Object value1) {
        ew.between("callback_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusNotBetween(Object value, Object value1) {
        ew.notBetween("callback_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusLike(String value) {
        ew.like("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andCallbackStatusNotLike(String value) {
        ew.notLike("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orCallbackStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitLogCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}