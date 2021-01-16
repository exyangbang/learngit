package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class UploadSplitPayFlowCondition {
    private PlusEntityWrapper<UploadSplitPayFlow> ew;

    public UploadSplitPayFlowCondition() {
        this.ew = new PlusEntityWrapper(UploadSplitPayFlow.class);
    }

    public static UploadSplitPayFlowCondition builder() {
        return new UploadSplitPayFlowCondition();
    }

    public PlusEntityWrapper<UploadSplitPayFlow> build() {
        return this.ew;
    }

    public UploadSplitPayFlowCondition or() {
        this.ew.orNew();
        return this;
    }

    public UploadSplitPayFlowCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(UploadSplitPayFlow.class);
    }

    public UploadSplitPayFlowCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public UploadSplitPayFlowCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public UploadSplitPayFlowCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public UploadSplitPayFlowCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> UploadSplitPayFlowCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> UploadSplitPayFlowCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> UploadSplitPayFlowCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public UploadSplitPayFlowCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public UploadSplitPayFlowCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public UploadSplitPayFlowCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public UploadSplitPayFlowCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public UploadSplitPayFlowCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public UploadSplitPayFlowCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public UploadSplitPayFlowCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public UploadSplitPayFlowCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateIsNull() {
        ew.isNull("settle_date");
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_date");
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateIsNotNull() {
        ew.isNotNull("settle_date");
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_date");
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateEq(Object value) {
        ew.eq("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateNe(Object value) {
        ew.ne("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateGt(Object value) {
        ew.gt("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateGe(Object value) {
        ew.ge("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateLt(Object value) {
        ew.lt("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateLe(Object value) {
        ew.le("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateIn(Object... value) {
        ew.in("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateNotIn(Object... value) {
        ew.notIn("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateBetween(Object value, Object value1) {
        ew.between("settle_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateLike(String value) {
        ew.like("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleDateNotLike(String value) {
        ew.notLike("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public UploadSplitPayFlowCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public UploadSplitPayFlowCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public UploadSplitPayFlowCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public UploadSplitPayFlowCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateIsNull() {
        ew.isNull("split_date");
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_date");
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateIsNotNull() {
        ew.isNotNull("split_date");
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_date");
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateEq(Object value) {
        ew.eq("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateNe(Object value) {
        ew.ne("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateGt(Object value) {
        ew.gt("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateGe(Object value) {
        ew.ge("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateLt(Object value) {
        ew.lt("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateLe(Object value) {
        ew.le("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateIn(Object... value) {
        ew.in("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateNotIn(Object... value) {
        ew.notIn("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateBetween(Object value, Object value1) {
        ew.between("split_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateNotBetween(Object value, Object value1) {
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateLike(String value) {
        ew.like("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSplitDateNotLike(String value) {
        ew.notLike("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSplitDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1IsNull() {
        ew.isNull("extend_1");
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_1");
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1IsNotNull() {
        ew.isNotNull("extend_1");
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_1");
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Eq(Object value) {
        ew.eq("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Ne(Object value) {
        ew.ne("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Gt(Object value) {
        ew.gt("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Ge(Object value) {
        ew.ge("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Lt(Object value) {
        ew.lt("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Le(Object value) {
        ew.le("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1In(Object... value) {
        ew.in("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1NotIn(Object... value) {
        ew.notIn("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Between(Object value, Object value1) {
        ew.between("extend_1", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_1", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1NotBetween(Object value, Object value1) {
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_1", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1Like(String value) {
        ew.like("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend1NotLike(String value) {
        ew.notLike("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend1NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_1", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2IsNull() {
        ew.isNull("extend_2");
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_2");
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2IsNotNull() {
        ew.isNotNull("extend_2");
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_2");
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Eq(Object value) {
        ew.eq("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Ne(Object value) {
        ew.ne("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Gt(Object value) {
        ew.gt("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Ge(Object value) {
        ew.ge("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Lt(Object value) {
        ew.lt("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Le(Object value) {
        ew.le("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2In(Object... value) {
        ew.in("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2NotIn(Object... value) {
        ew.notIn("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Between(Object value, Object value1) {
        ew.between("extend_2", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_2", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2NotBetween(Object value, Object value1) {
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2Like(String value) {
        ew.like("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend2NotLike(String value) {
        ew.notLike("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend2NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_2", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3IsNull() {
        ew.isNull("extend_3");
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_3");
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3IsNotNull() {
        ew.isNotNull("extend_3");
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_3");
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Eq(Object value) {
        ew.eq("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Ne(Object value) {
        ew.ne("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Gt(Object value) {
        ew.gt("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Ge(Object value) {
        ew.ge("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Lt(Object value) {
        ew.lt("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Le(Object value) {
        ew.le("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3In(Object... value) {
        ew.in("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3NotIn(Object... value) {
        ew.notIn("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Between(Object value, Object value1) {
        ew.between("extend_3", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_3", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3NotBetween(Object value, Object value1) {
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3Like(String value) {
        ew.like("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andExtend3NotLike(String value) {
        ew.notLike("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition orExtend3NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_3", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdIsNull() {
        ew.isNull("batch_id");
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_id");
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdIsNotNull() {
        ew.isNotNull("batch_id");
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_id");
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdEq(Object value) {
        ew.eq("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdNe(Object value) {
        ew.ne("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdGt(Object value) {
        ew.gt("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdGe(Object value) {
        ew.ge("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdLt(Object value) {
        ew.lt("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdLe(Object value) {
        ew.le("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdIn(Object... value) {
        ew.in("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdNotIn(Object... value) {
        ew.notIn("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdBetween(Object value, Object value1) {
        ew.between("batch_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdNotBetween(Object value, Object value1) {
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdLike(String value) {
        ew.like("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andBatchIdNotLike(String value) {
        ew.notLike("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orBatchIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesIsNull() {
        ew.isNull("query_times");
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("query_times");
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesIsNotNull() {
        ew.isNotNull("query_times");
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("query_times");
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesEq(Object value) {
        ew.eq("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesNe(Object value) {
        ew.ne("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesGt(Object value) {
        ew.gt("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesGe(Object value) {
        ew.ge("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesLt(Object value) {
        ew.lt("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesLe(Object value) {
        ew.le("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesIn(Object... value) {
        ew.in("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesNotIn(Object... value) {
        ew.notIn("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesBetween(Object value, Object value1) {
        ew.between("query_times", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("query_times", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesNotBetween(Object value, Object value1) {
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesLike(String value) {
        ew.like("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andQueryTimesNotLike(String value) {
        ew.notLike("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition orQueryTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("query_times", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountIsNull() {
        ew.isNull("user_account");
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_account");
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountIsNotNull() {
        ew.isNotNull("user_account");
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_account");
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountEq(Object value) {
        ew.eq("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountNe(Object value) {
        ew.ne("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountGt(Object value) {
        ew.gt("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountGe(Object value) {
        ew.ge("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountLt(Object value) {
        ew.lt("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountLe(Object value) {
        ew.le("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountIn(Object... value) {
        ew.in("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountNotIn(Object... value) {
        ew.notIn("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountBetween(Object value, Object value1) {
        ew.between("user_account", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_account", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountNotBetween(Object value, Object value1) {
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountLike(String value) {
        ew.like("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUserAccountNotLike(String value) {
        ew.notLike("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUserAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_account", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeIsNull() {
        ew.isNull("settle_mode");
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_mode");
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeIsNotNull() {
        ew.isNotNull("settle_mode");
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_mode");
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeEq(Object value) {
        ew.eq("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeNe(Object value) {
        ew.ne("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeGt(Object value) {
        ew.gt("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeGe(Object value) {
        ew.ge("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeLt(Object value) {
        ew.lt("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeLe(Object value) {
        ew.le("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeIn(Object... value) {
        ew.in("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeNotIn(Object... value) {
        ew.notIn("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeBetween(Object value, Object value1) {
        ew.between("settle_mode", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_mode", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeNotBetween(Object value, Object value1) {
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeLike(String value) {
        ew.like("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andSettleModeNotLike(String value) {
        ew.notLike("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition orSettleModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_mode", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusIsNull() {
        ew.isNull("upload_status");
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("upload_status");
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusIsNotNull() {
        ew.isNotNull("upload_status");
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("upload_status");
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusEq(Object value) {
        ew.eq("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusNe(Object value) {
        ew.ne("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusGt(Object value) {
        ew.gt("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusGe(Object value) {
        ew.ge("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusLt(Object value) {
        ew.lt("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusLe(Object value) {
        ew.le("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusIn(Object... value) {
        ew.in("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusNotIn(Object... value) {
        ew.notIn("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusBetween(Object value, Object value1) {
        ew.between("upload_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("upload_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusNotBetween(Object value, Object value1) {
        ew.notBetween("upload_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("upload_status", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusLike(String value) {
        ew.like("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadStatusNotLike(String value) {
        ew.notLike("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("upload_status", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescIsNull() {
        ew.isNull("upload_desc");
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("upload_desc");
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescIsNotNull() {
        ew.isNotNull("upload_desc");
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("upload_desc");
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescEq(Object value) {
        ew.eq("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescNe(Object value) {
        ew.ne("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescGt(Object value) {
        ew.gt("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescGe(Object value) {
        ew.ge("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescLt(Object value) {
        ew.lt("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescLe(Object value) {
        ew.le("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescIn(Object... value) {
        ew.in("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescNotIn(Object... value) {
        ew.notIn("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescBetween(Object value, Object value1) {
        ew.between("upload_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("upload_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescNotBetween(Object value, Object value1) {
        ew.notBetween("upload_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("upload_desc", value, value1);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescLike(String value) {
        ew.like("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition andUploadDescNotLike(String value) {
        ew.notLike("upload_desc", value);
        return this;
    }

    public UploadSplitPayFlowCondition orUploadDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("upload_desc", value);
        return this;
    }
}