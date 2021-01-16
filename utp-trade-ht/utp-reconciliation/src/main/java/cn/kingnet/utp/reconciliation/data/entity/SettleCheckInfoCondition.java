package cn.kingnet.utp.reconciliation.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class SettleCheckInfoCondition {
    private PlusEntityWrapper<SettleCheckInfo> ew;

    public SettleCheckInfoCondition() {
        this.ew = new PlusEntityWrapper(SettleCheckInfo.class);
    }

    public static SettleCheckInfoCondition builder() {
        return new SettleCheckInfoCondition();
    }

    public PlusEntityWrapper<SettleCheckInfo> build() {
        return this.ew;
    }

    public SettleCheckInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public SettleCheckInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(SettleCheckInfo.class);
    }

    public SettleCheckInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public SettleCheckInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public SettleCheckInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public SettleCheckInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> SettleCheckInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> SettleCheckInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> SettleCheckInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public SettleCheckInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public SettleCheckInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public SettleCheckInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public SettleCheckInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public SettleCheckInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public SettleCheckInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public SettleCheckInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public SettleCheckInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public SettleCheckInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public SettleCheckInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeIsNull() {
        ew.isNull("error_type");
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("error_type");
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeIsNotNull() {
        ew.isNotNull("error_type");
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("error_type");
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeEq(Object value) {
        ew.eq("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeNe(Object value) {
        ew.ne("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeGt(Object value) {
        ew.gt("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeGe(Object value) {
        ew.ge("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeLt(Object value) {
        ew.lt("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeLe(Object value) {
        ew.le("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeIn(Object... value) {
        ew.in("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeNotIn(Object... value) {
        ew.notIn("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeBetween(Object value, Object value1) {
        ew.between("error_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("error_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeNotBetween(Object value, Object value1) {
        ew.notBetween("error_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("error_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeLike(String value) {
        ew.like("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorTypeNotLike(String value) {
        ew.notLike("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("error_type", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescIsNull() {
        ew.isNull("error_desc");
        return this;
    }

    public SettleCheckInfoCondition orErrorDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("error_desc");
        return this;
    }

    public SettleCheckInfoCondition andErrorDescIsNotNull() {
        ew.isNotNull("error_desc");
        return this;
    }

    public SettleCheckInfoCondition orErrorDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("error_desc");
        return this;
    }

    public SettleCheckInfoCondition andErrorDescEq(Object value) {
        ew.eq("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescNe(Object value) {
        ew.ne("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescGt(Object value) {
        ew.gt("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescGe(Object value) {
        ew.ge("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescLt(Object value) {
        ew.lt("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescLe(Object value) {
        ew.le("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescIn(Object... value) {
        ew.in("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescNotIn(Object... value) {
        ew.notIn("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescBetween(Object value, Object value1) {
        ew.between("error_desc", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("error_desc", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescNotBetween(Object value, Object value1) {
        ew.notBetween("error_desc", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("error_desc", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescLike(String value) {
        ew.like("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andErrorDescNotLike(String value) {
        ew.notLike("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition orErrorDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("error_desc", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public SettleCheckInfoCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public SettleCheckInfoCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public SettleCheckInfoCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public SettleCheckInfoCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public SettleCheckInfoCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public SettleCheckInfoCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public SettleCheckInfoCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public SettleCheckInfoCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public SettleCheckInfoCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public SettleCheckInfoCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public SettleCheckInfoCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagIsNull() {
        ew.isNull("account_handle_flag");
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_handle_flag");
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagIsNotNull() {
        ew.isNotNull("account_handle_flag");
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_handle_flag");
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagEq(Object value) {
        ew.eq("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagNe(Object value) {
        ew.ne("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagGt(Object value) {
        ew.gt("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagGe(Object value) {
        ew.ge("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagLt(Object value) {
        ew.lt("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagLe(Object value) {
        ew.le("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagIn(Object... value) {
        ew.in("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagNotIn(Object... value) {
        ew.notIn("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagBetween(Object value, Object value1) {
        ew.between("account_handle_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_handle_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagNotBetween(Object value, Object value1) {
        ew.notBetween("account_handle_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_handle_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagLike(String value) {
        ew.like("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andAccountHandleFlagNotLike(String value) {
        ew.notLike("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orAccountHandleFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_handle_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeIsNull() {
        ew.isNull("reconcile_time");
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_time");
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeIsNotNull() {
        ew.isNotNull("reconcile_time");
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_time");
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeEq(Object value) {
        ew.eq("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeNe(Object value) {
        ew.ne("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeGt(Object value) {
        ew.gt("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeGe(Object value) {
        ew.ge("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeLt(Object value) {
        ew.lt("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeLe(Object value) {
        ew.le("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeIn(Object... value) {
        ew.in("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeNotIn(Object... value) {
        ew.notIn("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeBetween(Object value, Object value1) {
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeLike(String value) {
        ew.like("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileTimeNotLike(String value) {
        ew.notLike("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_time", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusIsNull() {
        ew.isNull("before_trans_status");
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("before_trans_status");
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusIsNotNull() {
        ew.isNotNull("before_trans_status");
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("before_trans_status");
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusEq(Object value) {
        ew.eq("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusNe(Object value) {
        ew.ne("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusGt(Object value) {
        ew.gt("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusGe(Object value) {
        ew.ge("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusLt(Object value) {
        ew.lt("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusLe(Object value) {
        ew.le("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusIn(Object... value) {
        ew.in("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusNotIn(Object... value) {
        ew.notIn("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusBetween(Object value, Object value1) {
        ew.between("before_trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("before_trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("before_trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("before_trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusLike(String value) {
        ew.like("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andBeforeTransStatusNotLike(String value) {
        ew.notLike("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orBeforeTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("before_trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public SettleCheckInfoCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public SettleCheckInfoCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public SettleCheckInfoCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public SettleCheckInfoCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountIsNull() {
        ew.isNull("trans_amount");
        return this;
    }

    public SettleCheckInfoCondition orTransAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_amount");
        return this;
    }

    public SettleCheckInfoCondition andTransAmountIsNotNull() {
        ew.isNotNull("trans_amount");
        return this;
    }

    public SettleCheckInfoCondition orTransAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_amount");
        return this;
    }

    public SettleCheckInfoCondition andTransAmountEq(Object value) {
        ew.eq("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountNe(Object value) {
        ew.ne("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountGt(Object value) {
        ew.gt("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountGe(Object value) {
        ew.ge("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountLt(Object value) {
        ew.lt("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountLe(Object value) {
        ew.le("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountIn(Object... value) {
        ew.in("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountNotIn(Object... value) {
        ew.notIn("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountBetween(Object value, Object value1) {
        ew.between("trans_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountNotBetween(Object value, Object value1) {
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountLike(String value) {
        ew.like("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andTransAmountNotLike(String value) {
        ew.notLike("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orTransAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeIsNull() {
        ew.isNull("mer_fee");
        return this;
    }

    public SettleCheckInfoCondition orMerFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_fee");
        return this;
    }

    public SettleCheckInfoCondition andMerFeeIsNotNull() {
        ew.isNotNull("mer_fee");
        return this;
    }

    public SettleCheckInfoCondition orMerFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_fee");
        return this;
    }

    public SettleCheckInfoCondition andMerFeeEq(Object value) {
        ew.eq("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeNe(Object value) {
        ew.ne("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeGt(Object value) {
        ew.gt("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeGe(Object value) {
        ew.ge("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeLt(Object value) {
        ew.lt("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeLe(Object value) {
        ew.le("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeIn(Object... value) {
        ew.in("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeNotIn(Object... value) {
        ew.notIn("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeBetween(Object value, Object value1) {
        ew.between("mer_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeLike(String value) {
        ew.like("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andMerFeeNotLike(String value) {
        ew.notLike("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orMerFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeIsNull() {
        ew.isNull("channel_fee");
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_fee");
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeIsNotNull() {
        ew.isNotNull("channel_fee");
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_fee");
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeEq(Object value) {
        ew.eq("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeNe(Object value) {
        ew.ne("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeGt(Object value) {
        ew.gt("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeGe(Object value) {
        ew.ge("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeLt(Object value) {
        ew.lt("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeLe(Object value) {
        ew.le("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeIn(Object... value) {
        ew.in("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeNotIn(Object... value) {
        ew.notIn("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeBetween(Object value, Object value1) {
        ew.between("channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeLike(String value) {
        ew.like("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelFeeNotLike(String value) {
        ew.notLike("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountIsNull() {
        ew.isNull("real_amount");
        return this;
    }

    public SettleCheckInfoCondition orRealAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_amount");
        return this;
    }

    public SettleCheckInfoCondition andRealAmountIsNotNull() {
        ew.isNotNull("real_amount");
        return this;
    }

    public SettleCheckInfoCondition orRealAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_amount");
        return this;
    }

    public SettleCheckInfoCondition andRealAmountEq(Object value) {
        ew.eq("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountNe(Object value) {
        ew.ne("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountGt(Object value) {
        ew.gt("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountGe(Object value) {
        ew.ge("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountLt(Object value) {
        ew.lt("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountLe(Object value) {
        ew.le("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountIn(Object... value) {
        ew.in("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountNotIn(Object... value) {
        ew.notIn("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountBetween(Object value, Object value1) {
        ew.between("real_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountNotBetween(Object value, Object value1) {
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountLike(String value) {
        ew.like("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andRealAmountNotLike(String value) {
        ew.notLike("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition orRealAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_amount", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public SettleCheckInfoCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public SettleCheckInfoCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public SettleCheckInfoCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public SettleCheckInfoCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public SettleCheckInfoCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public SettleCheckInfoCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public SettleCheckInfoCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public SettleCheckInfoCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public SettleCheckInfoCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public SettleCheckInfoCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public SettleCheckInfoCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public SettleCheckInfoCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public SettleCheckInfoCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public SettleCheckInfoCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public SettleCheckInfoCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public SettleCheckInfoCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public SettleCheckInfoCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public SettleCheckInfoCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public SettleCheckInfoCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public SettleCheckInfoCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeIsNull() {
        ew.isNull("channel_resp_code");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_code");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeIsNotNull() {
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeEq(Object value) {
        ew.eq("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeNe(Object value) {
        ew.ne("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeGt(Object value) {
        ew.gt("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeGe(Object value) {
        ew.ge("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeLt(Object value) {
        ew.lt("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeLe(Object value) {
        ew.le("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeIn(Object... value) {
        ew.in("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeNotIn(Object... value) {
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeBetween(Object value, Object value1) {
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeLike(String value) {
        ew.like("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespCodeNotLike(String value) {
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdIsNull() {
        ew.isNull("channel_resp_id");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_id");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdIsNotNull() {
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdEq(Object value) {
        ew.eq("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdNe(Object value) {
        ew.ne("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdGt(Object value) {
        ew.gt("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdGe(Object value) {
        ew.ge("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdLt(Object value) {
        ew.lt("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdLe(Object value) {
        ew.le("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdIn(Object... value) {
        ew.in("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdNotIn(Object... value) {
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdBetween(Object value, Object value1) {
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdLike(String value) {
        ew.like("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespIdNotLike(String value) {
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgIsNull() {
        ew.isNull("channel_resp_msg");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_msg");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgIsNotNull() {
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgEq(Object value) {
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgNe(Object value) {
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgGt(Object value) {
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgGe(Object value) {
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgLt(Object value) {
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgLe(Object value) {
        ew.le("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgIn(Object... value) {
        ew.in("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgNotIn(Object... value) {
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgBetween(Object value, Object value1) {
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgLike(String value) {
        ew.like("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespMsgNotLike(String value) {
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespMsgNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeIsNull() {
        ew.isNull("channel_resp_time");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_time");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeIsNotNull() {
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeEq(Object value) {
        ew.eq("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeNe(Object value) {
        ew.ne("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeGt(Object value) {
        ew.gt("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeGe(Object value) {
        ew.ge("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeLt(Object value) {
        ew.lt("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeLe(Object value) {
        ew.le("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeIn(Object... value) {
        ew.in("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeNotIn(Object... value) {
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeBetween(Object value, Object value1) {
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeLike(String value) {
        ew.like("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelRespTimeNotLike(String value) {
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelRespTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeIsNull() {
        ew.isNull("client_trans_time");
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_time");
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeIsNotNull() {
        ew.isNotNull("client_trans_time");
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_time");
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeEq(Object value) {
        ew.eq("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeNe(Object value) {
        ew.ne("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeGt(Object value) {
        ew.gt("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeGe(Object value) {
        ew.ge("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeLt(Object value) {
        ew.lt("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeLe(Object value) {
        ew.le("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeIn(Object... value) {
        ew.in("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeNotIn(Object... value) {
        ew.notIn("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeBetween(Object value, Object value1) {
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeLike(String value) {
        ew.like("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andClientTransTimeNotLike(String value) {
        ew.notLike("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition orClientTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_time", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public SettleCheckInfoCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public SettleCheckInfoCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public SettleCheckInfoCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public SettleCheckInfoCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoIsNull() {
        ew.isNull("server_batch_no");
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_batch_no");
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoIsNotNull() {
        ew.isNotNull("server_batch_no");
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_batch_no");
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoEq(Object value) {
        ew.eq("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoNe(Object value) {
        ew.ne("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoGt(Object value) {
        ew.gt("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoGe(Object value) {
        ew.ge("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoLt(Object value) {
        ew.lt("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoLe(Object value) {
        ew.le("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoIn(Object... value) {
        ew.in("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoNotIn(Object... value) {
        ew.notIn("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoBetween(Object value, Object value1) {
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoLike(String value) {
        ew.like("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerBatchNoNotLike(String value) {
        ew.notLike("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition orServerBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_batch_no", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdIsNull() {
        ew.isNull("server_link_id");
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_link_id");
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdIsNotNull() {
        ew.isNotNull("server_link_id");
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_link_id");
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdEq(Object value) {
        ew.eq("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdNe(Object value) {
        ew.ne("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdGt(Object value) {
        ew.gt("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdGe(Object value) {
        ew.ge("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdLt(Object value) {
        ew.lt("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdLe(Object value) {
        ew.le("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdIn(Object... value) {
        ew.in("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdNotIn(Object... value) {
        ew.notIn("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdBetween(Object value, Object value1) {
        ew.between("server_link_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_link_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdLike(String value) {
        ew.like("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andServerLinkIdNotLike(String value) {
        ew.notLike("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition orServerLinkIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_link_id", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeIsNull() {
        ew.isNull("resp_code");
        return this;
    }

    public SettleCheckInfoCondition orRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_code");
        return this;
    }

    public SettleCheckInfoCondition andRespCodeIsNotNull() {
        ew.isNotNull("resp_code");
        return this;
    }

    public SettleCheckInfoCondition orRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_code");
        return this;
    }

    public SettleCheckInfoCondition andRespCodeEq(Object value) {
        ew.eq("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeNe(Object value) {
        ew.ne("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeGt(Object value) {
        ew.gt("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeGe(Object value) {
        ew.ge("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeLt(Object value) {
        ew.lt("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeLe(Object value) {
        ew.le("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeIn(Object... value) {
        ew.in("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeNotIn(Object... value) {
        ew.notIn("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeBetween(Object value, Object value1) {
        ew.between("resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeLike(String value) {
        ew.like("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRespCodeNotLike(String value) {
        ew.notLike("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition orRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_code", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusIsNull() {
        ew.isNull("revoke_status");
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("revoke_status");
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusIsNotNull() {
        ew.isNotNull("revoke_status");
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("revoke_status");
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusEq(Object value) {
        ew.eq("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusNe(Object value) {
        ew.ne("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusGt(Object value) {
        ew.gt("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusGe(Object value) {
        ew.ge("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusLt(Object value) {
        ew.lt("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusLe(Object value) {
        ew.le("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusIn(Object... value) {
        ew.in("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusNotIn(Object... value) {
        ew.notIn("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusBetween(Object value, Object value1) {
        ew.between("revoke_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("revoke_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusNotBetween(Object value, Object value1) {
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusLike(String value) {
        ew.like("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRevokeStatusNotLike(String value) {
        ew.notLike("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRevokeStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("revoke_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusIsNull() {
        ew.isNull("refund_status");
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("refund_status");
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusIsNotNull() {
        ew.isNotNull("refund_status");
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("refund_status");
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusEq(Object value) {
        ew.eq("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusNe(Object value) {
        ew.ne("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusGt(Object value) {
        ew.gt("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusGe(Object value) {
        ew.ge("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusLt(Object value) {
        ew.lt("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusLe(Object value) {
        ew.le("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusIn(Object... value) {
        ew.in("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusNotIn(Object... value) {
        ew.notIn("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusBetween(Object value, Object value1) {
        ew.between("refund_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("refund_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusNotBetween(Object value, Object value1) {
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusLike(String value) {
        ew.like("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andRefundStatusNotLike(String value) {
        ew.notLike("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition orRefundStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("refund_status", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeIsNull() {
        ew.isNull("user_code");
        return this;
    }

    public SettleCheckInfoCondition orUserCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_code");
        return this;
    }

    public SettleCheckInfoCondition andUserCodeIsNotNull() {
        ew.isNotNull("user_code");
        return this;
    }

    public SettleCheckInfoCondition orUserCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_code");
        return this;
    }

    public SettleCheckInfoCondition andUserCodeEq(Object value) {
        ew.eq("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeNe(Object value) {
        ew.ne("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeGt(Object value) {
        ew.gt("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeGe(Object value) {
        ew.ge("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeLt(Object value) {
        ew.lt("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeLe(Object value) {
        ew.le("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeIn(Object... value) {
        ew.in("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeNotIn(Object... value) {
        ew.notIn("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeBetween(Object value, Object value1) {
        ew.between("user_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeNotBetween(Object value, Object value1) {
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeLike(String value) {
        ew.like("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCodeNotLike(String value) {
        ew.notLike("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_code", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoIsNull() {
        ew.isNull("batch_sub_no");
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_sub_no");
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoIsNotNull() {
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoEq(Object value) {
        ew.eq("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoNe(Object value) {
        ew.ne("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoGt(Object value) {
        ew.gt("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoGe(Object value) {
        ew.ge("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoLt(Object value) {
        ew.lt("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoLe(Object value) {
        ew.le("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoIn(Object... value) {
        ew.in("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoNotIn(Object... value) {
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoBetween(Object value, Object value1) {
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoLike(String value) {
        ew.like("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andBatchSubNoNotLike(String value) {
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition orBatchSubNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagIsNull() {
        ew.isNull("pc_flag");
        return this;
    }

    public SettleCheckInfoCondition orPcFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pc_flag");
        return this;
    }

    public SettleCheckInfoCondition andPcFlagIsNotNull() {
        ew.isNotNull("pc_flag");
        return this;
    }

    public SettleCheckInfoCondition orPcFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pc_flag");
        return this;
    }

    public SettleCheckInfoCondition andPcFlagEq(Object value) {
        ew.eq("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagNe(Object value) {
        ew.ne("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagGt(Object value) {
        ew.gt("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagGe(Object value) {
        ew.ge("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagLt(Object value) {
        ew.lt("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagLe(Object value) {
        ew.le("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagIn(Object... value) {
        ew.in("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagNotIn(Object... value) {
        ew.notIn("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagBetween(Object value, Object value1) {
        ew.between("pc_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pc_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagNotBetween(Object value, Object value1) {
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagLike(String value) {
        ew.like("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andPcFlagNotLike(String value) {
        ew.notLike("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orPcFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pc_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeIsNull() {
        ew.isNull("user_type");
        return this;
    }

    public SettleCheckInfoCondition orUserTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_type");
        return this;
    }

    public SettleCheckInfoCondition andUserTypeIsNotNull() {
        ew.isNotNull("user_type");
        return this;
    }

    public SettleCheckInfoCondition orUserTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_type");
        return this;
    }

    public SettleCheckInfoCondition andUserTypeEq(Object value) {
        ew.eq("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeNe(Object value) {
        ew.ne("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeGt(Object value) {
        ew.gt("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeGe(Object value) {
        ew.ge("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeLt(Object value) {
        ew.lt("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeLe(Object value) {
        ew.le("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeIn(Object... value) {
        ew.in("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeNotIn(Object... value) {
        ew.notIn("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeBetween(Object value, Object value1) {
        ew.between("user_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeNotBetween(Object value, Object value1) {
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeLike(String value) {
        ew.like("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andUserTypeNotLike(String value) {
        ew.notLike("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition orUserTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_type", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoIsNull() {
        ew.isNull("payee_acct_no");
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acct_no");
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoIsNotNull() {
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoEq(Object value) {
        ew.eq("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoNe(Object value) {
        ew.ne("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoGt(Object value) {
        ew.gt("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoGe(Object value) {
        ew.ge("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoLt(Object value) {
        ew.lt("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoLe(Object value) {
        ew.le("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoIn(Object... value) {
        ew.in("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoNotIn(Object... value) {
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoBetween(Object value, Object value1) {
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoLike(String value) {
        ew.like("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAcctNoNotLike(String value) {
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameIsNull() {
        ew.isNull("payee_name");
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_name");
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameIsNotNull() {
        ew.isNotNull("payee_name");
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_name");
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameEq(Object value) {
        ew.eq("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameNe(Object value) {
        ew.ne("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameGt(Object value) {
        ew.gt("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameGe(Object value) {
        ew.ge("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameLt(Object value) {
        ew.lt("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameLe(Object value) {
        ew.le("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameIn(Object... value) {
        ew.in("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameNotIn(Object... value) {
        ew.notIn("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameBetween(Object value, Object value1) {
        ew.between("payee_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameLike(String value) {
        ew.like("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeNameNotLike(String value) {
        ew.notLike("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoIsNull() {
        ew.isNull("payer_acct_no");
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_acct_no");
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoIsNotNull() {
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoEq(Object value) {
        ew.eq("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoNe(Object value) {
        ew.ne("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoGt(Object value) {
        ew.gt("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoGe(Object value) {
        ew.ge("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoLt(Object value) {
        ew.lt("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoLe(Object value) {
        ew.le("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoIn(Object... value) {
        ew.in("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoNotIn(Object... value) {
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoBetween(Object value, Object value1) {
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoLike(String value) {
        ew.like("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAcctNoNotLike(String value) {
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameIsNull() {
        ew.isNull("payer_name");
        return this;
    }

    public SettleCheckInfoCondition orPayerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_name");
        return this;
    }

    public SettleCheckInfoCondition andPayerNameIsNotNull() {
        ew.isNotNull("payer_name");
        return this;
    }

    public SettleCheckInfoCondition orPayerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_name");
        return this;
    }

    public SettleCheckInfoCondition andPayerNameEq(Object value) {
        ew.eq("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameNe(Object value) {
        ew.ne("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameGt(Object value) {
        ew.gt("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameGe(Object value) {
        ew.ge("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameLt(Object value) {
        ew.lt("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameLe(Object value) {
        ew.le("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameIn(Object... value) {
        ew.in("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameNotIn(Object... value) {
        ew.notIn("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameBetween(Object value, Object value1) {
        ew.between("payer_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameLike(String value) {
        ew.like("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerNameNotLike(String value) {
        ew.notLike("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_name", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoIsNull() {
        ew.isNull("acc_no");
        return this;
    }

    public SettleCheckInfoCondition orAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_no");
        return this;
    }

    public SettleCheckInfoCondition andAccNoIsNotNull() {
        ew.isNotNull("acc_no");
        return this;
    }

    public SettleCheckInfoCondition orAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_no");
        return this;
    }

    public SettleCheckInfoCondition andAccNoEq(Object value) {
        ew.eq("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoNe(Object value) {
        ew.ne("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoGt(Object value) {
        ew.gt("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoGe(Object value) {
        ew.ge("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoLt(Object value) {
        ew.lt("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoLe(Object value) {
        ew.le("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoIn(Object... value) {
        ew.in("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoNotIn(Object... value) {
        ew.notIn("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoBetween(Object value, Object value1) {
        ew.between("acc_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andAccNoLike(String value) {
        ew.like("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andAccNoNotLike(String value) {
        ew.notLike("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition orAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_no", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public SettleCheckInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public SettleCheckInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public SettleCheckInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public SettleCheckInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeIsNull() {
        ew.isNull("mer_settle_type");
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_settle_type");
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeIsNotNull() {
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeEq(Object value) {
        ew.eq("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeNe(Object value) {
        ew.ne("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeGt(Object value) {
        ew.gt("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeGe(Object value) {
        ew.ge("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeLt(Object value) {
        ew.lt("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeLe(Object value) {
        ew.le("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeIn(Object... value) {
        ew.in("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeNotIn(Object... value) {
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeBetween(Object value, Object value1) {
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeLike(String value) {
        ew.like("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerSettleTypeNotLike(String value) {
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orMerSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeIsNull() {
        ew.isNull("mer_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeIsNotNull() {
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeEq(Object value) {
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeNe(Object value) {
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeGt(Object value) {
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeGe(Object value) {
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeLt(Object value) {
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeLe(Object value) {
        ew.le("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeIn(Object... value) {
        ew.in("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeNotIn(Object... value) {
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeBetween(Object value, Object value1) {
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeLike(String value) {
        ew.like("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andMerChargeModeNotLike(String value) {
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orMerChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeIsNull() {
        ew.isNull("channel_settle_type");
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_type");
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeIsNotNull() {
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeEq(Object value) {
        ew.eq("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeNe(Object value) {
        ew.ne("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeGt(Object value) {
        ew.gt("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeGe(Object value) {
        ew.ge("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeLt(Object value) {
        ew.lt("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeLe(Object value) {
        ew.le("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeIn(Object... value) {
        ew.in("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeNotIn(Object... value) {
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeBetween(Object value, Object value1) {
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeLike(String value) {
        ew.like("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleTypeNotLike(String value) {
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeIsNull() {
        ew.isNull("channel_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeIsNotNull() {
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeEq(Object value) {
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeNe(Object value) {
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeGt(Object value) {
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeGe(Object value) {
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeLt(Object value) {
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeLe(Object value) {
        ew.le("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeIn(Object... value) {
        ew.in("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeNotIn(Object... value) {
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeBetween(Object value, Object value1) {
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeLike(String value) {
        ew.like("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelChargeModeNotLike(String value) {
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateIsNull() {
        ew.isNull("channel_settle_date");
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_date");
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateIsNotNull() {
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateEq(Object value) {
        ew.eq("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateNe(Object value) {
        ew.ne("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateGt(Object value) {
        ew.gt("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateGe(Object value) {
        ew.ge("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateLt(Object value) {
        ew.lt("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateLe(Object value) {
        ew.le("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateIn(Object... value) {
        ew.in("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateNotIn(Object... value) {
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateBetween(Object value, Object value1) {
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateLike(String value) {
        ew.like("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andChannelSettleDateNotLike(String value) {
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition orChannelSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeIsNull() {
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeIsNotNull() {
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeEq(Object value) {
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeNe(Object value) {
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeGt(Object value) {
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeGe(Object value) {
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeLt(Object value) {
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeLe(Object value) {
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeIn(Object... value) {
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeNotIn(Object... value) {
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeBetween(Object value, Object value1) {
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeLike(String value) {
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andOrginChannelFeeNotLike(String value) {
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition orOrginChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountIsNull() {
        ew.isNull("payer_account");
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_account");
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountIsNotNull() {
        ew.isNotNull("payer_account");
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_account");
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountEq(Object value) {
        ew.eq("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountNe(Object value) {
        ew.ne("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountGt(Object value) {
        ew.gt("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountGe(Object value) {
        ew.ge("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountLt(Object value) {
        ew.lt("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountLe(Object value) {
        ew.le("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountIn(Object... value) {
        ew.in("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountNotIn(Object... value) {
        ew.notIn("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountBetween(Object value, Object value1) {
        ew.between("payer_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountLike(String value) {
        ew.like("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerAccountNotLike(String value) {
        ew.notLike("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountIsNull() {
        ew.isNull("payee_account");
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_account");
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountIsNotNull() {
        ew.isNotNull("payee_account");
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_account");
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountEq(Object value) {
        ew.eq("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountNe(Object value) {
        ew.ne("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountGt(Object value) {
        ew.gt("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountGe(Object value) {
        ew.ge("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountLt(Object value) {
        ew.lt("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountLe(Object value) {
        ew.le("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountIn(Object... value) {
        ew.in("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountNotIn(Object... value) {
        ew.notIn("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountBetween(Object value, Object value1) {
        ew.between("payee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountLike(String value) {
        ew.like("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeAccountNotLike(String value) {
        ew.notLike("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountIsNull() {
        ew.isNull("fee_account");
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account");
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountIsNotNull() {
        ew.isNotNull("fee_account");
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account");
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountEq(Object value) {
        ew.eq("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNe(Object value) {
        ew.ne("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountGt(Object value) {
        ew.gt("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountGe(Object value) {
        ew.ge("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountLt(Object value) {
        ew.lt("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountLe(Object value) {
        ew.le("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountIn(Object... value) {
        ew.in("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNotIn(Object... value) {
        ew.notIn("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountBetween(Object value, Object value1) {
        ew.between("fee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountLike(String value) {
        ew.like("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNotLike(String value) {
        ew.notLike("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountIsNull() {
        ew.isNull("income_account");
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account");
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountIsNotNull() {
        ew.isNotNull("income_account");
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account");
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountEq(Object value) {
        ew.eq("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNe(Object value) {
        ew.ne("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountGt(Object value) {
        ew.gt("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountGe(Object value) {
        ew.ge("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountLt(Object value) {
        ew.lt("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountLe(Object value) {
        ew.le("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountIn(Object... value) {
        ew.in("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNotIn(Object... value) {
        ew.notIn("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountBetween(Object value, Object value1) {
        ew.between("income_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountLike(String value) {
        ew.like("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNotLike(String value) {
        ew.notLike("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileIsNull() {
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileIsNotNull() {
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileEq(Object value) {
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileNe(Object value) {
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileGt(Object value) {
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileGe(Object value) {
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileLt(Object value) {
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileLe(Object value) {
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileIn(Object... value) {
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileNotIn(Object... value) {
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileBetween(Object value, Object value1) {
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileNotBetween(Object value, Object value1) {
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileLike(String value) {
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andNeedChannelReconcileNotLike(String value) {
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition orNeedChannelReconcileNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoIsNull() {
        ew.isNull("show_payer_account_no");
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_no");
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoIsNotNull() {
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoEq(Object value) {
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoNe(Object value) {
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoGt(Object value) {
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoGe(Object value) {
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoLt(Object value) {
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoLe(Object value) {
        ew.le("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoIn(Object... value) {
        ew.in("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoNotIn(Object... value) {
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoBetween(Object value, Object value1) {
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoLike(String value) {
        ew.like("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNoNotLike(String value) {
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameIsNull() {
        ew.isNull("show_payer_account_name");
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_name");
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameIsNotNull() {
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameEq(Object value) {
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameNe(Object value) {
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameGt(Object value) {
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameGe(Object value) {
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameLt(Object value) {
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameLe(Object value) {
        ew.le("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameIn(Object... value) {
        ew.in("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameNotIn(Object... value) {
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameBetween(Object value, Object value1) {
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameLike(String value) {
        ew.like("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayerAccountNameNotLike(String value) {
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayerAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoIsNull() {
        ew.isNull("show_payee_account_no");
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_no");
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoIsNotNull() {
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoEq(Object value) {
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoNe(Object value) {
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoGt(Object value) {
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoGe(Object value) {
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoLt(Object value) {
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoLe(Object value) {
        ew.le("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoIn(Object... value) {
        ew.in("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoNotIn(Object... value) {
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoBetween(Object value, Object value1) {
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoLike(String value) {
        ew.like("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNoNotLike(String value) {
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameIsNull() {
        ew.isNull("show_payee_account_name");
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_name");
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameIsNotNull() {
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameEq(Object value) {
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameNe(Object value) {
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameGt(Object value) {
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameGe(Object value) {
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameLt(Object value) {
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameLe(Object value) {
        ew.le("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameIn(Object... value) {
        ew.in("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameNotIn(Object... value) {
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameBetween(Object value, Object value1) {
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameLike(String value) {
        ew.like("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andShowPayeeAccountNameNotLike(String value) {
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orShowPayeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdIsNull() {
        ew.isNull("order_id");
        return this;
    }

    public SettleCheckInfoCondition orOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_id");
        return this;
    }

    public SettleCheckInfoCondition andOrderIdIsNotNull() {
        ew.isNotNull("order_id");
        return this;
    }

    public SettleCheckInfoCondition orOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_id");
        return this;
    }

    public SettleCheckInfoCondition andOrderIdEq(Object value) {
        ew.eq("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdNe(Object value) {
        ew.ne("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdGt(Object value) {
        ew.gt("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdGe(Object value) {
        ew.ge("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdLt(Object value) {
        ew.lt("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdLe(Object value) {
        ew.le("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdIn(Object... value) {
        ew.in("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdNotIn(Object... value) {
        ew.notIn("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdBetween(Object value, Object value1) {
        ew.between("order_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdLike(String value) {
        ew.like("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andOrderIdNotLike(String value) {
        ew.notLike("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition orOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_id", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagIsNull() {
        ew.isNull("elc_make_flag");
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("elc_make_flag");
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagIsNotNull() {
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagEq(Object value) {
        ew.eq("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagNe(Object value) {
        ew.ne("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagGt(Object value) {
        ew.gt("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagGe(Object value) {
        ew.ge("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagLt(Object value) {
        ew.lt("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagLe(Object value) {
        ew.le("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagIn(Object... value) {
        ew.in("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagNotIn(Object... value) {
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagBetween(Object value, Object value1) {
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagNotBetween(Object value, Object value1) {
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagLike(String value) {
        ew.like("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andElcMakeFlagNotLike(String value) {
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition orElcMakeFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameIsNull() {
        ew.isNull("fee_account_name");
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account_name");
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameIsNotNull() {
        ew.isNotNull("fee_account_name");
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account_name");
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameEq(Object value) {
        ew.eq("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameNe(Object value) {
        ew.ne("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameGt(Object value) {
        ew.gt("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameGe(Object value) {
        ew.ge("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameLt(Object value) {
        ew.lt("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameLe(Object value) {
        ew.le("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameIn(Object... value) {
        ew.in("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameNotIn(Object... value) {
        ew.notIn("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameBetween(Object value, Object value1) {
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameLike(String value) {
        ew.like("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andFeeAccountNameNotLike(String value) {
        ew.notLike("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orFeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameIsNull() {
        ew.isNull("income_account_name");
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account_name");
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameIsNotNull() {
        ew.isNotNull("income_account_name");
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account_name");
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameEq(Object value) {
        ew.eq("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameNe(Object value) {
        ew.ne("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameGt(Object value) {
        ew.gt("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameGe(Object value) {
        ew.ge("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameLt(Object value) {
        ew.lt("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameLe(Object value) {
        ew.le("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameIn(Object... value) {
        ew.in("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameNotIn(Object... value) {
        ew.notIn("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameBetween(Object value, Object value1) {
        ew.between("income_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameLike(String value) {
        ew.like("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andIncomeAccountNameNotLike(String value) {
        ew.notLike("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition orIncomeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameIsNull() {
        ew.isNull("payer_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameIsNotNull() {
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameEq(Object value) {
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameNe(Object value) {
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameGt(Object value) {
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameGe(Object value) {
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameLt(Object value) {
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameLe(Object value) {
        ew.le("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameIn(Object... value) {
        ew.in("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameNotIn(Object... value) {
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameBetween(Object value, Object value1) {
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameLike(String value) {
        ew.like("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayerOpbkNameNotLike(String value) {
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayerOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameIsNull() {
        ew.isNull("payee_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameIsNotNull() {
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameEq(Object value) {
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameNe(Object value) {
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameGt(Object value) {
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameGe(Object value) {
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameLt(Object value) {
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameLe(Object value) {
        ew.le("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameIn(Object... value) {
        ew.in("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameNotIn(Object... value) {
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameBetween(Object value, Object value1) {
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameLike(String value) {
        ew.like("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andPayeeOpbkNameNotLike(String value) {
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition orPayeeOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionIsNull() {
        ew.isNull("summary_description");
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("summary_description");
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionIsNotNull() {
        ew.isNotNull("summary_description");
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("summary_description");
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionEq(Object value) {
        ew.eq("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionNe(Object value) {
        ew.ne("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionGt(Object value) {
        ew.gt("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionGe(Object value) {
        ew.ge("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionLt(Object value) {
        ew.lt("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionLe(Object value) {
        ew.le("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionIn(Object... value) {
        ew.in("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionNotIn(Object... value) {
        ew.notIn("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionBetween(Object value, Object value1) {
        ew.between("summary_description", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("summary_description", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionLike(String value) {
        ew.like("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andSummaryDescriptionNotLike(String value) {
        ew.notLike("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition orSummaryDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("summary_description", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusIsNull() {
        ew.isNull("audit_status");
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("audit_status");
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusIsNotNull() {
        ew.isNotNull("audit_status");
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("audit_status");
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusEq(Object value) {
        ew.eq("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusNe(Object value) {
        ew.ne("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusGt(Object value) {
        ew.gt("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusGe(Object value) {
        ew.ge("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusLt(Object value) {
        ew.lt("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusLe(Object value) {
        ew.le("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusIn(Object... value) {
        ew.in("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusNotIn(Object... value) {
        ew.notIn("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusBetween(Object value, Object value1) {
        ew.between("audit_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("audit_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusNotBetween(Object value, Object value1) {
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("audit_status", value, value1);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusLike(String value) {
        ew.like("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition andAuditStatusNotLike(String value) {
        ew.notLike("audit_status", value);
        return this;
    }

    public SettleCheckInfoCondition orAuditStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("audit_status", value);
        return this;
    }
}