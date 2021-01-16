package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class TransCallbackLogCondition {
    private PlusEntityWrapper<TransCallbackLog> ew;

    public TransCallbackLogCondition() {
        this.ew = new PlusEntityWrapper(TransCallbackLog.class);
    }

    public static TransCallbackLogCondition builder() {
        return new TransCallbackLogCondition();
    }

    public PlusEntityWrapper<TransCallbackLog> build() {
        return this.ew;
    }

    public TransCallbackLogCondition or() {
        this.ew.orNew();
        return this;
    }

    public TransCallbackLogCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(TransCallbackLog.class);
    }

    public TransCallbackLogCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public TransCallbackLogCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public TransCallbackLogCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public TransCallbackLogCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> TransCallbackLogCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> TransCallbackLogCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> TransCallbackLogCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public TransCallbackLogCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public TransCallbackLogCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public TransCallbackLogCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public TransCallbackLogCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public TransCallbackLogCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public TransCallbackLogCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public TransCallbackLogCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public TransCallbackLogCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public TransCallbackLogCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public TransCallbackLogCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransCallbackLogCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransCallbackLogCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public TransCallbackLogCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public TransCallbackLogCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public TransCallbackLogCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public TransCallbackLogCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransCallbackLogCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransCallbackLogCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public TransCallbackLogCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public TransCallbackLogCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public TransCallbackLogCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public TransCallbackLogCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransCallbackLogCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public TransCallbackLogCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public TransCallbackLogCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public TransCallbackLogCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public TransCallbackLogCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public TransCallbackLogCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespIsNull() {
        ew.isNull("callback_resp");
        return this;
    }

    public TransCallbackLogCondition orCallbackRespIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("callback_resp");
        return this;
    }

    public TransCallbackLogCondition andCallbackRespIsNotNull() {
        ew.isNotNull("callback_resp");
        return this;
    }

    public TransCallbackLogCondition orCallbackRespIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("callback_resp");
        return this;
    }

    public TransCallbackLogCondition andCallbackRespEq(Object value) {
        ew.eq("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespNe(Object value) {
        ew.ne("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespGt(Object value) {
        ew.gt("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespGe(Object value) {
        ew.ge("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespLt(Object value) {
        ew.lt("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespLe(Object value) {
        ew.le("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespIn(Object... value) {
        ew.in("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespNotIn(Object... value) {
        ew.notIn("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespBetween(Object value, Object value1) {
        ew.between("callback_resp", value, value1);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("callback_resp", value, value1);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespNotBetween(Object value, Object value1) {
        ew.notBetween("callback_resp", value, value1);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("callback_resp", value, value1);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespLike(String value) {
        ew.like("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition andCallbackRespNotLike(String value) {
        ew.notLike("callback_resp", value);
        return this;
    }

    public TransCallbackLogCondition orCallbackRespNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("callback_resp", value);
        return this;
    }
}