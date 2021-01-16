package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class TransferCondition {
    private PlusEntityWrapper<Transfer> ew;

    public TransferCondition() {
        this.ew = new PlusEntityWrapper(Transfer.class);
    }

    public static TransferCondition builder() {
        return new TransferCondition();
    }

    public PlusEntityWrapper<Transfer> build() {
        return this.ew;
    }

    public TransferCondition or() {
        this.ew.orNew();
        return this;
    }

    public TransferCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(Transfer.class);
    }

    public TransferCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public TransferCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public TransferCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public TransferCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> TransferCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> TransferCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> TransferCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public TransferCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public TransferCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public TransferCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public TransferCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public TransferCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public TransferCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public TransferCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public TransferCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public TransferCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public TransferCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public TransferCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public TransferCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public TransferCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public TransferCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public TransferCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public TransferCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public TransferCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public TransferCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public TransferCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public TransferCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public TransferCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public TransferCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public TransferCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public TransferCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public TransferCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public TransferCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransferCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransferCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public TransferCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public TransferCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public TransferCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public TransferCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public TransferCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public TransferCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransferCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransferCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransferCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransferCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransferCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransferCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public TransferCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransferCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public TransferCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public TransferCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransferCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransferCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransferCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransferCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransferCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransferCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public TransferCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransferCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransferCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public TransferCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public TransferCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public TransferCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public TransferCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransferCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransferCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransferCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransferCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public TransferCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public TransferCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public TransferCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public TransferCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public TransferCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public TransferCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public TransferCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransferCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransferCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransferCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransferCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public TransferCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public TransferCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeIsNull() {
        ew.isNull("payer_industry_code");
        return this;
    }

    public TransferCondition orPayerIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_industry_code");
        return this;
    }

    public TransferCondition andPayerIndustryCodeIsNotNull() {
        ew.isNotNull("payer_industry_code");
        return this;
    }

    public TransferCondition orPayerIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_industry_code");
        return this;
    }

    public TransferCondition andPayerIndustryCodeEq(Object value) {
        ew.eq("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeNe(Object value) {
        ew.ne("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeGt(Object value) {
        ew.gt("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeGe(Object value) {
        ew.ge("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeLt(Object value) {
        ew.lt("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeLe(Object value) {
        ew.le("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeIn(Object... value) {
        ew.in("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeNotIn(Object... value) {
        ew.notIn("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeBetween(Object value, Object value1) {
        ew.between("payer_industry_code", value, value1);
        return this;
    }

    public TransferCondition orPayerIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_industry_code", value, value1);
        return this;
    }

    public TransferCondition andPayerIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("payer_industry_code", value, value1);
        return this;
    }

    public TransferCondition orPayerIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_industry_code", value, value1);
        return this;
    }

    public TransferCondition andPayerIndustryCodeLike(String value) {
        ew.like("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerIndustryCodeNotLike(String value) {
        ew.notLike("payer_industry_code", value);
        return this;
    }

    public TransferCondition orPayerIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_industry_code", value);
        return this;
    }

    public TransferCondition andPayerAccNoIsNull() {
        ew.isNull("payer_acc_no");
        return this;
    }

    public TransferCondition orPayerAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_acc_no");
        return this;
    }

    public TransferCondition andPayerAccNoIsNotNull() {
        ew.isNotNull("payer_acc_no");
        return this;
    }

    public TransferCondition orPayerAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_acc_no");
        return this;
    }

    public TransferCondition andPayerAccNoEq(Object value) {
        ew.eq("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoNe(Object value) {
        ew.ne("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoGt(Object value) {
        ew.gt("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoGe(Object value) {
        ew.ge("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoLt(Object value) {
        ew.lt("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoLe(Object value) {
        ew.le("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoIn(Object... value) {
        ew.in("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoNotIn(Object... value) {
        ew.notIn("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoBetween(Object value, Object value1) {
        ew.between("payer_acc_no", value, value1);
        return this;
    }

    public TransferCondition orPayerAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_acc_no", value, value1);
        return this;
    }

    public TransferCondition andPayerAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("payer_acc_no", value, value1);
        return this;
    }

    public TransferCondition orPayerAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_acc_no", value, value1);
        return this;
    }

    public TransferCondition andPayerAccNoLike(String value) {
        ew.like("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNoNotLike(String value) {
        ew.notLike("payer_acc_no", value);
        return this;
    }

    public TransferCondition orPayerAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_acc_no", value);
        return this;
    }

    public TransferCondition andPayerAccNameIsNull() {
        ew.isNull("payer_acc_name");
        return this;
    }

    public TransferCondition orPayerAccNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_acc_name");
        return this;
    }

    public TransferCondition andPayerAccNameIsNotNull() {
        ew.isNotNull("payer_acc_name");
        return this;
    }

    public TransferCondition orPayerAccNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_acc_name");
        return this;
    }

    public TransferCondition andPayerAccNameEq(Object value) {
        ew.eq("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameNe(Object value) {
        ew.ne("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameGt(Object value) {
        ew.gt("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameGe(Object value) {
        ew.ge("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameLt(Object value) {
        ew.lt("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameLe(Object value) {
        ew.le("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameIn(Object... value) {
        ew.in("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameNotIn(Object... value) {
        ew.notIn("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameBetween(Object value, Object value1) {
        ew.between("payer_acc_name", value, value1);
        return this;
    }

    public TransferCondition orPayerAccNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_acc_name", value, value1);
        return this;
    }

    public TransferCondition andPayerAccNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_acc_name", value, value1);
        return this;
    }

    public TransferCondition orPayerAccNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_acc_name", value, value1);
        return this;
    }

    public TransferCondition andPayerAccNameLike(String value) {
        ew.like("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayerAccNameNotLike(String value) {
        ew.notLike("payer_acc_name", value);
        return this;
    }

    public TransferCondition orPayerAccNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeIsNull() {
        ew.isNull("payee_industry_code");
        return this;
    }

    public TransferCondition orPayeeIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_industry_code");
        return this;
    }

    public TransferCondition andPayeeIndustryCodeIsNotNull() {
        ew.isNotNull("payee_industry_code");
        return this;
    }

    public TransferCondition orPayeeIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_industry_code");
        return this;
    }

    public TransferCondition andPayeeIndustryCodeEq(Object value) {
        ew.eq("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeNe(Object value) {
        ew.ne("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeGt(Object value) {
        ew.gt("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeGe(Object value) {
        ew.ge("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeLt(Object value) {
        ew.lt("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeLe(Object value) {
        ew.le("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeIn(Object... value) {
        ew.in("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeNotIn(Object... value) {
        ew.notIn("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeBetween(Object value, Object value1) {
        ew.between("payee_industry_code", value, value1);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_industry_code", value, value1);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("payee_industry_code", value, value1);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_industry_code", value, value1);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeLike(String value) {
        ew.like("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeIndustryCodeNotLike(String value) {
        ew.notLike("payee_industry_code", value);
        return this;
    }

    public TransferCondition orPayeeIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_industry_code", value);
        return this;
    }

    public TransferCondition andPayeeAccNoIsNull() {
        ew.isNull("payee_acc_no");
        return this;
    }

    public TransferCondition orPayeeAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acc_no");
        return this;
    }

    public TransferCondition andPayeeAccNoIsNotNull() {
        ew.isNotNull("payee_acc_no");
        return this;
    }

    public TransferCondition orPayeeAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acc_no");
        return this;
    }

    public TransferCondition andPayeeAccNoEq(Object value) {
        ew.eq("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoNe(Object value) {
        ew.ne("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoGt(Object value) {
        ew.gt("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoGe(Object value) {
        ew.ge("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoLt(Object value) {
        ew.lt("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoLe(Object value) {
        ew.le("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoIn(Object... value) {
        ew.in("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoNotIn(Object... value) {
        ew.notIn("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoBetween(Object value, Object value1) {
        ew.between("payee_acc_no", value, value1);
        return this;
    }

    public TransferCondition orPayeeAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acc_no", value, value1);
        return this;
    }

    public TransferCondition andPayeeAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acc_no", value, value1);
        return this;
    }

    public TransferCondition orPayeeAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acc_no", value, value1);
        return this;
    }

    public TransferCondition andPayeeAccNoLike(String value) {
        ew.like("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNoNotLike(String value) {
        ew.notLike("payee_acc_no", value);
        return this;
    }

    public TransferCondition orPayeeAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acc_no", value);
        return this;
    }

    public TransferCondition andPayeeAccNameIsNull() {
        ew.isNull("payee_acc_name");
        return this;
    }

    public TransferCondition orPayeeAccNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acc_name");
        return this;
    }

    public TransferCondition andPayeeAccNameIsNotNull() {
        ew.isNotNull("payee_acc_name");
        return this;
    }

    public TransferCondition orPayeeAccNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acc_name");
        return this;
    }

    public TransferCondition andPayeeAccNameEq(Object value) {
        ew.eq("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameNe(Object value) {
        ew.ne("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameGt(Object value) {
        ew.gt("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameGe(Object value) {
        ew.ge("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameLt(Object value) {
        ew.lt("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameLe(Object value) {
        ew.le("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameIn(Object... value) {
        ew.in("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameNotIn(Object... value) {
        ew.notIn("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameBetween(Object value, Object value1) {
        ew.between("payee_acc_name", value, value1);
        return this;
    }

    public TransferCondition orPayeeAccNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acc_name", value, value1);
        return this;
    }

    public TransferCondition andPayeeAccNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acc_name", value, value1);
        return this;
    }

    public TransferCondition orPayeeAccNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acc_name", value, value1);
        return this;
    }

    public TransferCondition andPayeeAccNameLike(String value) {
        ew.like("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeAccNameNotLike(String value) {
        ew.notLike("payee_acc_name", value);
        return this;
    }

    public TransferCondition orPayeeAccNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acc_name", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeIsNull() {
        ew.isNull("payee_bank_code");
        return this;
    }

    public TransferCondition orPayeeBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_bank_code");
        return this;
    }

    public TransferCondition andPayeeBankCodeIsNotNull() {
        ew.isNotNull("payee_bank_code");
        return this;
    }

    public TransferCondition orPayeeBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_bank_code");
        return this;
    }

    public TransferCondition andPayeeBankCodeEq(Object value) {
        ew.eq("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeNe(Object value) {
        ew.ne("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeGt(Object value) {
        ew.gt("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeGe(Object value) {
        ew.ge("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeLt(Object value) {
        ew.lt("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeLe(Object value) {
        ew.le("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeIn(Object... value) {
        ew.in("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeNotIn(Object... value) {
        ew.notIn("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeBetween(Object value, Object value1) {
        ew.between("payee_bank_code", value, value1);
        return this;
    }

    public TransferCondition orPayeeBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_bank_code", value, value1);
        return this;
    }

    public TransferCondition andPayeeBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("payee_bank_code", value, value1);
        return this;
    }

    public TransferCondition orPayeeBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_bank_code", value, value1);
        return this;
    }

    public TransferCondition andPayeeBankCodeLike(String value) {
        ew.like("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayeeBankCodeNotLike(String value) {
        ew.notLike("payee_bank_code", value);
        return this;
    }

    public TransferCondition orPayeeBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_bank_code", value);
        return this;
    }

    public TransferCondition andPayAmtIsNull() {
        ew.isNull("pay_amt");
        return this;
    }

    public TransferCondition orPayAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pay_amt");
        return this;
    }

    public TransferCondition andPayAmtIsNotNull() {
        ew.isNotNull("pay_amt");
        return this;
    }

    public TransferCondition orPayAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pay_amt");
        return this;
    }

    public TransferCondition andPayAmtEq(Object value) {
        ew.eq("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtNe(Object value) {
        ew.ne("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtGt(Object value) {
        ew.gt("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtGe(Object value) {
        ew.ge("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtLt(Object value) {
        ew.lt("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtLe(Object value) {
        ew.le("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtIn(Object... value) {
        ew.in("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtNotIn(Object... value) {
        ew.notIn("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtBetween(Object value, Object value1) {
        ew.between("pay_amt", value, value1);
        return this;
    }

    public TransferCondition orPayAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pay_amt", value, value1);
        return this;
    }

    public TransferCondition andPayAmtNotBetween(Object value, Object value1) {
        ew.notBetween("pay_amt", value, value1);
        return this;
    }

    public TransferCondition orPayAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pay_amt", value, value1);
        return this;
    }

    public TransferCondition andPayAmtLike(String value) {
        ew.like("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pay_amt", value);
        return this;
    }

    public TransferCondition andPayAmtNotLike(String value) {
        ew.notLike("pay_amt", value);
        return this;
    }

    public TransferCondition orPayAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pay_amt", value);
        return this;
    }

    public TransferCondition andCallbackUrlIsNull() {
        ew.isNull("callback_url");
        return this;
    }

    public TransferCondition orCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_url");
        return this;
    }

    public TransferCondition andCallbackUrlIsNotNull() {
        ew.isNotNull("callback_url");
        return this;
    }

    public TransferCondition orCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_url");
        return this;
    }

    public TransferCondition andCallbackUrlEq(Object value) {
        ew.eq("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlNe(Object value) {
        ew.ne("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlGt(Object value) {
        ew.gt("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlGe(Object value) {
        ew.ge("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlLt(Object value) {
        ew.lt("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlLe(Object value) {
        ew.le("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlIn(Object... value) {
        ew.in("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlNotIn(Object... value) {
        ew.notIn("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlBetween(Object value, Object value1) {
        ew.between("callback_url", value, value1);
        return this;
    }

    public TransferCondition orCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_url", value, value1);
        return this;
    }

    public TransferCondition andCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public TransferCondition orCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public TransferCondition andCallbackUrlLike(String value) {
        ew.like("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_url", value);
        return this;
    }

    public TransferCondition andCallbackUrlNotLike(String value) {
        ew.notLike("callback_url", value);
        return this;
    }

    public TransferCondition orCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_url", value);
        return this;
    }

    public TransferCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public TransferCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public TransferCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public TransferCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public TransferCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public TransferCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public TransferCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public TransferCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public TransferCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public TransferCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public TransferCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public TransferCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public TransferCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public TransferCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public TransferCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public TransferCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public TransferCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public TransferCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public TransferCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public TransferCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public TransferCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public TransferCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public TransferCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public TransferCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public TransferCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public TransferCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public TransferCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public TransferCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public TransferCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public TransferCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public TransferCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public TransferCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public TransferCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public TransferCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public TransferCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public TransferCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public TransferCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public TransferCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public TransferCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public TransferCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public TransferCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public TransferCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public TransferCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public TransferCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public TransferCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public TransferCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public TransferCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public TransferCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public TransferCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public TransferCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public TransferCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public TransferCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public TransferCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public TransferCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public TransferCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public TransferCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }
}