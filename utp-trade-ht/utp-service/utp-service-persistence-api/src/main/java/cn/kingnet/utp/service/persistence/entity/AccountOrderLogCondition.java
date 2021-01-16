package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class AccountOrderLogCondition {
    private PlusEntityWrapper<AccountOrderLog> ew;

    public AccountOrderLogCondition() {
        this.ew = new PlusEntityWrapper(AccountOrderLog.class);
    }

    public static AccountOrderLogCondition builder() {
        return new AccountOrderLogCondition();
    }

    public PlusEntityWrapper<AccountOrderLog> build() {
        return this.ew;
    }

    public AccountOrderLogCondition or() {
        this.ew.orNew();
        return this;
    }

    public AccountOrderLogCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(AccountOrderLog.class);
    }

    public AccountOrderLogCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public AccountOrderLogCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public AccountOrderLogCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public AccountOrderLogCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> AccountOrderLogCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> AccountOrderLogCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> AccountOrderLogCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public AccountOrderLogCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public AccountOrderLogCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public AccountOrderLogCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public AccountOrderLogCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public AccountOrderLogCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public AccountOrderLogCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public AccountOrderLogCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public AccountOrderLogCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public AccountOrderLogCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public AccountOrderLogCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public AccountOrderLogCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public AccountOrderLogCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public AccountOrderLogCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public AccountOrderLogCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public AccountOrderLogCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public AccountOrderLogCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public AccountOrderLogCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public AccountOrderLogCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public AccountOrderLogCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public AccountOrderLogCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public AccountOrderLogCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public AccountOrderLogCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public AccountOrderLogCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public AccountOrderLogCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public AccountOrderLogCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public AccountOrderLogCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public AccountOrderLogCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public AccountOrderLogCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public AccountOrderLogCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public AccountOrderLogCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public AccountOrderLogCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public AccountOrderLogCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public AccountOrderLogCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountOrderLogCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountOrderLogCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameIsNull() {
        ew.isNull("account_name");
        return this;
    }

    public AccountOrderLogCondition orAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_name");
        return this;
    }

    public AccountOrderLogCondition andAccountNameIsNotNull() {
        ew.isNotNull("account_name");
        return this;
    }

    public AccountOrderLogCondition orAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_name");
        return this;
    }

    public AccountOrderLogCondition andAccountNameEq(Object value) {
        ew.eq("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameNe(Object value) {
        ew.ne("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameGt(Object value) {
        ew.gt("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameGe(Object value) {
        ew.ge("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameLt(Object value) {
        ew.lt("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameLe(Object value) {
        ew.le("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameIn(Object... value) {
        ew.in("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameNotIn(Object... value) {
        ew.notIn("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameBetween(Object value, Object value1) {
        ew.between("account_name", value, value1);
        return this;
    }

    public AccountOrderLogCondition orAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_name", value, value1);
        return this;
    }

    public AccountOrderLogCondition andAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public AccountOrderLogCondition orAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public AccountOrderLogCondition andAccountNameLike(String value) {
        ew.like("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAccountNameNotLike(String value) {
        ew.notLike("account_name", value);
        return this;
    }

    public AccountOrderLogCondition orAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_name", value);
        return this;
    }

    public AccountOrderLogCondition andAmtIsNull() {
        ew.isNull("amt");
        return this;
    }

    public AccountOrderLogCondition orAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amt");
        return this;
    }

    public AccountOrderLogCondition andAmtIsNotNull() {
        ew.isNotNull("amt");
        return this;
    }

    public AccountOrderLogCondition orAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amt");
        return this;
    }

    public AccountOrderLogCondition andAmtEq(Object value) {
        ew.eq("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtNe(Object value) {
        ew.ne("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtGt(Object value) {
        ew.gt("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtGe(Object value) {
        ew.ge("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtLt(Object value) {
        ew.lt("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtLe(Object value) {
        ew.le("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtIn(Object... value) {
        ew.in("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtNotIn(Object... value) {
        ew.notIn("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtBetween(Object value, Object value1) {
        ew.between("amt", value, value1);
        return this;
    }

    public AccountOrderLogCondition orAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amt", value, value1);
        return this;
    }

    public AccountOrderLogCondition andAmtNotBetween(Object value, Object value1) {
        ew.notBetween("amt", value, value1);
        return this;
    }

    public AccountOrderLogCondition orAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amt", value, value1);
        return this;
    }

    public AccountOrderLogCondition andAmtLike(String value) {
        ew.like("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amt", value);
        return this;
    }

    public AccountOrderLogCondition andAmtNotLike(String value) {
        ew.notLike("amt", value);
        return this;
    }

    public AccountOrderLogCondition orAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amt", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdIsNull() {
        ew.isNull("order_id");
        return this;
    }

    public AccountOrderLogCondition orOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_id");
        return this;
    }

    public AccountOrderLogCondition andOrderIdIsNotNull() {
        ew.isNotNull("order_id");
        return this;
    }

    public AccountOrderLogCondition orOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_id");
        return this;
    }

    public AccountOrderLogCondition andOrderIdEq(Object value) {
        ew.eq("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdNe(Object value) {
        ew.ne("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdGt(Object value) {
        ew.gt("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdGe(Object value) {
        ew.ge("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdLt(Object value) {
        ew.lt("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdLe(Object value) {
        ew.le("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdIn(Object... value) {
        ew.in("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdNotIn(Object... value) {
        ew.notIn("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdBetween(Object value, Object value1) {
        ew.between("order_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition orOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public AccountOrderLogCondition andOrderIdLike(String value) {
        ew.like("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andOrderIdNotLike(String value) {
        ew.notLike("order_id", value);
        return this;
    }

    public AccountOrderLogCondition orOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_id", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlIsNull() {
        ew.isNull("callback_url");
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_url");
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlIsNotNull() {
        ew.isNotNull("callback_url");
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_url");
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlEq(Object value) {
        ew.eq("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlNe(Object value) {
        ew.ne("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlGt(Object value) {
        ew.gt("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlGe(Object value) {
        ew.ge("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlLt(Object value) {
        ew.lt("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlLe(Object value) {
        ew.le("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlIn(Object... value) {
        ew.in("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlNotIn(Object... value) {
        ew.notIn("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlBetween(Object value, Object value1) {
        ew.between("callback_url", value, value1);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_url", value, value1);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_url", value, value1);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlLike(String value) {
        ew.like("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andCallbackUrlNotLike(String value) {
        ew.notLike("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition orCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_url", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public AccountOrderLogCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public AccountOrderLogCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public AccountOrderLogCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public AccountOrderLogCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public AccountOrderLogCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public AccountOrderLogCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public AccountOrderLogCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public AccountOrderLogCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescIsNull() {
        ew.isNull("resp_desc");
        return this;
    }

    public AccountOrderLogCondition orRespDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_desc");
        return this;
    }

    public AccountOrderLogCondition andRespDescIsNotNull() {
        ew.isNotNull("resp_desc");
        return this;
    }

    public AccountOrderLogCondition orRespDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_desc");
        return this;
    }

    public AccountOrderLogCondition andRespDescEq(Object value) {
        ew.eq("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescNe(Object value) {
        ew.ne("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescGt(Object value) {
        ew.gt("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescGe(Object value) {
        ew.ge("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescLt(Object value) {
        ew.lt("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescLe(Object value) {
        ew.le("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescIn(Object... value) {
        ew.in("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescNotIn(Object... value) {
        ew.notIn("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescBetween(Object value, Object value1) {
        ew.between("resp_desc", value, value1);
        return this;
    }

    public AccountOrderLogCondition orRespDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_desc", value, value1);
        return this;
    }

    public AccountOrderLogCondition andRespDescNotBetween(Object value, Object value1) {
        ew.notBetween("resp_desc", value, value1);
        return this;
    }

    public AccountOrderLogCondition orRespDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_desc", value, value1);
        return this;
    }

    public AccountOrderLogCondition andRespDescLike(String value) {
        ew.like("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRespDescNotLike(String value) {
        ew.notLike("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition orRespDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_desc", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public AccountOrderLogCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public AccountOrderLogCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public AccountOrderLogCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public AccountOrderLogCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public AccountOrderLogCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public AccountOrderLogCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountOrderLogCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public AccountOrderLogCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public AccountOrderLogCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public AccountOrderLogCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public AccountOrderLogCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public AccountOrderLogCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public AccountOrderLogCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public AccountOrderLogCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public AccountOrderLogCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public AccountOrderLogCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public AccountOrderLogCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountOrderLogCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountOrderLogCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public AccountOrderLogCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public AccountOrderLogCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountOrderLogCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountOrderLogCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountOrderLogCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}