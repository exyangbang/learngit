package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class JobTaskCondition {
    private PlusEntityWrapper<JobTask> ew;

    public JobTaskCondition() {
        this.ew = new PlusEntityWrapper(JobTask.class);
    }

    public static JobTaskCondition builder() {
        return new JobTaskCondition();
    }

    public PlusEntityWrapper<JobTask> build() {
        return this.ew;
    }

    public JobTaskCondition or() {
        this.ew.orNew();
        return this;
    }

    public JobTaskCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(JobTask.class);
    }

    public JobTaskCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public JobTaskCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public JobTaskCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public JobTaskCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> JobTaskCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> JobTaskCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> JobTaskCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public JobTaskCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public JobTaskCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public JobTaskCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public JobTaskCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public JobTaskCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public JobTaskCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public JobTaskCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public JobTaskCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public JobTaskCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public JobTaskCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public JobTaskCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public JobTaskCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public JobTaskCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public JobTaskCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public JobTaskCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public JobTaskCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public JobTaskCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public JobTaskCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public JobTaskCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public JobTaskCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public JobTaskCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public JobTaskCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public JobTaskCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public JobTaskCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public JobTaskCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public JobTaskCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public JobTaskCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public JobTaskCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public JobTaskCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public JobTaskCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public JobTaskCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public JobTaskCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public JobTaskCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public JobTaskCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public JobTaskCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public JobTaskCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public JobTaskCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public JobTaskCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public JobTaskCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public JobTaskCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public JobTaskCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public JobTaskCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public JobTaskCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public JobTaskCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public JobTaskCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public JobTaskCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public JobTaskCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public JobTaskCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public JobTaskCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public JobTaskCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public JobTaskCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public JobTaskCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public JobTaskCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public JobTaskCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public JobTaskCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public JobTaskCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public JobTaskCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public JobTaskCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public JobTaskCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public JobTaskCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public JobTaskCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public JobTaskCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public JobTaskCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public JobTaskCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public JobTaskCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public JobTaskCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public JobTaskCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public JobTaskCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public JobTaskCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public JobTaskCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public JobTaskCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public JobTaskCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionIsNull() {
        ew.isNull("catch_exception");
        return this;
    }

    public JobTaskCondition orCatchExceptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("catch_exception");
        return this;
    }

    public JobTaskCondition andCatchExceptionIsNotNull() {
        ew.isNotNull("catch_exception");
        return this;
    }

    public JobTaskCondition orCatchExceptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("catch_exception");
        return this;
    }

    public JobTaskCondition andCatchExceptionEq(Object value) {
        ew.eq("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionNe(Object value) {
        ew.ne("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionGt(Object value) {
        ew.gt("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionGe(Object value) {
        ew.ge("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionLt(Object value) {
        ew.lt("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionLe(Object value) {
        ew.le("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionIn(Object... value) {
        ew.in("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionNotIn(Object... value) {
        ew.notIn("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionBetween(Object value, Object value1) {
        ew.between("catch_exception", value, value1);
        return this;
    }

    public JobTaskCondition orCatchExceptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("catch_exception", value, value1);
        return this;
    }

    public JobTaskCondition andCatchExceptionNotBetween(Object value, Object value1) {
        ew.notBetween("catch_exception", value, value1);
        return this;
    }

    public JobTaskCondition orCatchExceptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("catch_exception", value, value1);
        return this;
    }

    public JobTaskCondition andCatchExceptionLike(String value) {
        ew.like("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("catch_exception", value);
        return this;
    }

    public JobTaskCondition andCatchExceptionNotLike(String value) {
        ew.notLike("catch_exception", value);
        return this;
    }

    public JobTaskCondition orCatchExceptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("catch_exception", value);
        return this;
    }

    public JobTaskCondition andDescriptionIsNull() {
        ew.isNull("description");
        return this;
    }

    public JobTaskCondition orDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("description");
        return this;
    }

    public JobTaskCondition andDescriptionIsNotNull() {
        ew.isNotNull("description");
        return this;
    }

    public JobTaskCondition orDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("description");
        return this;
    }

    public JobTaskCondition andDescriptionEq(Object value) {
        ew.eq("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionNe(Object value) {
        ew.ne("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionGt(Object value) {
        ew.gt("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionGe(Object value) {
        ew.ge("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionLt(Object value) {
        ew.lt("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionLe(Object value) {
        ew.le("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionIn(Object... value) {
        ew.in("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionNotIn(Object... value) {
        ew.notIn("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionBetween(Object value, Object value1) {
        ew.between("description", value, value1);
        return this;
    }

    public JobTaskCondition orDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("description", value, value1);
        return this;
    }

    public JobTaskCondition andDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("description", value, value1);
        return this;
    }

    public JobTaskCondition orDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("description", value, value1);
        return this;
    }

    public JobTaskCondition andDescriptionLike(String value) {
        ew.like("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("description", value);
        return this;
    }

    public JobTaskCondition andDescriptionNotLike(String value) {
        ew.notLike("description", value);
        return this;
    }

    public JobTaskCondition orDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("description", value);
        return this;
    }

    public JobTaskCondition andJobDateIsNull() {
        ew.isNull("job_date");
        return this;
    }

    public JobTaskCondition orJobDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("job_date");
        return this;
    }

    public JobTaskCondition andJobDateIsNotNull() {
        ew.isNotNull("job_date");
        return this;
    }

    public JobTaskCondition orJobDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("job_date");
        return this;
    }

    public JobTaskCondition andJobDateEq(Object value) {
        ew.eq("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateNe(Object value) {
        ew.ne("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateGt(Object value) {
        ew.gt("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateGe(Object value) {
        ew.ge("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateLt(Object value) {
        ew.lt("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateLe(Object value) {
        ew.le("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateIn(Object... value) {
        ew.in("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateNotIn(Object... value) {
        ew.notIn("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateBetween(Object value, Object value1) {
        ew.between("job_date", value, value1);
        return this;
    }

    public JobTaskCondition orJobDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("job_date", value, value1);
        return this;
    }

    public JobTaskCondition andJobDateNotBetween(Object value, Object value1) {
        ew.notBetween("job_date", value, value1);
        return this;
    }

    public JobTaskCondition orJobDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("job_date", value, value1);
        return this;
    }

    public JobTaskCondition andJobDateLike(String value) {
        ew.like("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("job_date", value);
        return this;
    }

    public JobTaskCondition andJobDateNotLike(String value) {
        ew.notLike("job_date", value);
        return this;
    }

    public JobTaskCondition orJobDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("job_date", value);
        return this;
    }

    public JobTaskCondition andJobIdIsNull() {
        ew.isNull("job_id");
        return this;
    }

    public JobTaskCondition orJobIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("job_id");
        return this;
    }

    public JobTaskCondition andJobIdIsNotNull() {
        ew.isNotNull("job_id");
        return this;
    }

    public JobTaskCondition orJobIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("job_id");
        return this;
    }

    public JobTaskCondition andJobIdEq(Object value) {
        ew.eq("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdNe(Object value) {
        ew.ne("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdGt(Object value) {
        ew.gt("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdGe(Object value) {
        ew.ge("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdLt(Object value) {
        ew.lt("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdLe(Object value) {
        ew.le("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdIn(Object... value) {
        ew.in("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdNotIn(Object... value) {
        ew.notIn("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdBetween(Object value, Object value1) {
        ew.between("job_id", value, value1);
        return this;
    }

    public JobTaskCondition orJobIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("job_id", value, value1);
        return this;
    }

    public JobTaskCondition andJobIdNotBetween(Object value, Object value1) {
        ew.notBetween("job_id", value, value1);
        return this;
    }

    public JobTaskCondition orJobIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("job_id", value, value1);
        return this;
    }

    public JobTaskCondition andJobIdLike(String value) {
        ew.like("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("job_id", value);
        return this;
    }

    public JobTaskCondition andJobIdNotLike(String value) {
        ew.notLike("job_id", value);
        return this;
    }

    public JobTaskCondition orJobIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("job_id", value);
        return this;
    }

    public JobTaskCondition andJobNameIsNull() {
        ew.isNull("job_name");
        return this;
    }

    public JobTaskCondition orJobNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("job_name");
        return this;
    }

    public JobTaskCondition andJobNameIsNotNull() {
        ew.isNotNull("job_name");
        return this;
    }

    public JobTaskCondition orJobNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("job_name");
        return this;
    }

    public JobTaskCondition andJobNameEq(Object value) {
        ew.eq("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameNe(Object value) {
        ew.ne("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameGt(Object value) {
        ew.gt("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameGe(Object value) {
        ew.ge("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameLt(Object value) {
        ew.lt("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameLe(Object value) {
        ew.le("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameIn(Object... value) {
        ew.in("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameNotIn(Object... value) {
        ew.notIn("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameBetween(Object value, Object value1) {
        ew.between("job_name", value, value1);
        return this;
    }

    public JobTaskCondition orJobNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("job_name", value, value1);
        return this;
    }

    public JobTaskCondition andJobNameNotBetween(Object value, Object value1) {
        ew.notBetween("job_name", value, value1);
        return this;
    }

    public JobTaskCondition orJobNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("job_name", value, value1);
        return this;
    }

    public JobTaskCondition andJobNameLike(String value) {
        ew.like("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("job_name", value);
        return this;
    }

    public JobTaskCondition andJobNameNotLike(String value) {
        ew.notLike("job_name", value);
        return this;
    }

    public JobTaskCondition orJobNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("job_name", value);
        return this;
    }

    public JobTaskCondition andJobPriorityIsNull() {
        ew.isNull("job_priority");
        return this;
    }

    public JobTaskCondition orJobPriorityIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("job_priority");
        return this;
    }

    public JobTaskCondition andJobPriorityIsNotNull() {
        ew.isNotNull("job_priority");
        return this;
    }

    public JobTaskCondition orJobPriorityIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("job_priority");
        return this;
    }

    public JobTaskCondition andJobPriorityEq(Object value) {
        ew.eq("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityNe(Object value) {
        ew.ne("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityGt(Object value) {
        ew.gt("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityGe(Object value) {
        ew.ge("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityLt(Object value) {
        ew.lt("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityLe(Object value) {
        ew.le("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityIn(Object... value) {
        ew.in("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityNotIn(Object... value) {
        ew.notIn("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityBetween(Object value, Object value1) {
        ew.between("job_priority", value, value1);
        return this;
    }

    public JobTaskCondition orJobPriorityBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("job_priority", value, value1);
        return this;
    }

    public JobTaskCondition andJobPriorityNotBetween(Object value, Object value1) {
        ew.notBetween("job_priority", value, value1);
        return this;
    }

    public JobTaskCondition orJobPriorityNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("job_priority", value, value1);
        return this;
    }

    public JobTaskCondition andJobPriorityLike(String value) {
        ew.like("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobPriorityNotLike(String value) {
        ew.notLike("job_priority", value);
        return this;
    }

    public JobTaskCondition orJobPriorityNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("job_priority", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateIsNull() {
        ew.isNull("jobtask_state");
        return this;
    }

    public JobTaskCondition orJobtaskStateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("jobtask_state");
        return this;
    }

    public JobTaskCondition andJobtaskStateIsNotNull() {
        ew.isNotNull("jobtask_state");
        return this;
    }

    public JobTaskCondition orJobtaskStateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("jobtask_state");
        return this;
    }

    public JobTaskCondition andJobtaskStateEq(Object value) {
        ew.eq("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateNe(Object value) {
        ew.ne("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateGt(Object value) {
        ew.gt("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateGe(Object value) {
        ew.ge("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateLt(Object value) {
        ew.lt("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateLe(Object value) {
        ew.le("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateIn(Object... value) {
        ew.in("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateNotIn(Object... value) {
        ew.notIn("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateBetween(Object value, Object value1) {
        ew.between("jobtask_state", value, value1);
        return this;
    }

    public JobTaskCondition orJobtaskStateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("jobtask_state", value, value1);
        return this;
    }

    public JobTaskCondition andJobtaskStateNotBetween(Object value, Object value1) {
        ew.notBetween("jobtask_state", value, value1);
        return this;
    }

    public JobTaskCondition orJobtaskStateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("jobtask_state", value, value1);
        return this;
    }

    public JobTaskCondition andJobtaskStateLike(String value) {
        ew.like("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andJobtaskStateNotLike(String value) {
        ew.notLike("jobtask_state", value);
        return this;
    }

    public JobTaskCondition orJobtaskStateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("jobtask_state", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeIsNull() {
        ew.isNull("last_run_endtime");
        return this;
    }

    public JobTaskCondition orLastRunEndtimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("last_run_endtime");
        return this;
    }

    public JobTaskCondition andLastRunEndtimeIsNotNull() {
        ew.isNotNull("last_run_endtime");
        return this;
    }

    public JobTaskCondition orLastRunEndtimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("last_run_endtime");
        return this;
    }

    public JobTaskCondition andLastRunEndtimeEq(Object value) {
        ew.eq("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeNe(Object value) {
        ew.ne("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeGt(Object value) {
        ew.gt("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeGe(Object value) {
        ew.ge("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeLt(Object value) {
        ew.lt("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeLe(Object value) {
        ew.le("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeIn(Object... value) {
        ew.in("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeNotIn(Object... value) {
        ew.notIn("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeBetween(Object value, Object value1) {
        ew.between("last_run_endtime", value, value1);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("last_run_endtime", value, value1);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeNotBetween(Object value, Object value1) {
        ew.notBetween("last_run_endtime", value, value1);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("last_run_endtime", value, value1);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeLike(String value) {
        ew.like("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunEndtimeNotLike(String value) {
        ew.notLike("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition orLastRunEndtimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("last_run_endtime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeIsNull() {
        ew.isNull("last_run_starttime");
        return this;
    }

    public JobTaskCondition orLastRunStarttimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("last_run_starttime");
        return this;
    }

    public JobTaskCondition andLastRunStarttimeIsNotNull() {
        ew.isNotNull("last_run_starttime");
        return this;
    }

    public JobTaskCondition orLastRunStarttimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("last_run_starttime");
        return this;
    }

    public JobTaskCondition andLastRunStarttimeEq(Object value) {
        ew.eq("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeNe(Object value) {
        ew.ne("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeGt(Object value) {
        ew.gt("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeGe(Object value) {
        ew.ge("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeLt(Object value) {
        ew.lt("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeLe(Object value) {
        ew.le("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeIn(Object... value) {
        ew.in("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeNotIn(Object... value) {
        ew.notIn("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeBetween(Object value, Object value1) {
        ew.between("last_run_starttime", value, value1);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("last_run_starttime", value, value1);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeNotBetween(Object value, Object value1) {
        ew.notBetween("last_run_starttime", value, value1);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("last_run_starttime", value, value1);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeLike(String value) {
        ew.like("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andLastRunStarttimeNotLike(String value) {
        ew.notLike("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition orLastRunStarttimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("last_run_starttime", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeIsNull() {
        ew.isNull("next_rerun_time");
        return this;
    }

    public JobTaskCondition orNextRerunTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("next_rerun_time");
        return this;
    }

    public JobTaskCondition andNextRerunTimeIsNotNull() {
        ew.isNotNull("next_rerun_time");
        return this;
    }

    public JobTaskCondition orNextRerunTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("next_rerun_time");
        return this;
    }

    public JobTaskCondition andNextRerunTimeEq(Object value) {
        ew.eq("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeNe(Object value) {
        ew.ne("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeGt(Object value) {
        ew.gt("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeGe(Object value) {
        ew.ge("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeLt(Object value) {
        ew.lt("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeLe(Object value) {
        ew.le("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeIn(Object... value) {
        ew.in("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeNotIn(Object... value) {
        ew.notIn("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeBetween(Object value, Object value1) {
        ew.between("next_rerun_time", value, value1);
        return this;
    }

    public JobTaskCondition orNextRerunTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("next_rerun_time", value, value1);
        return this;
    }

    public JobTaskCondition andNextRerunTimeNotBetween(Object value, Object value1) {
        ew.notBetween("next_rerun_time", value, value1);
        return this;
    }

    public JobTaskCondition orNextRerunTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("next_rerun_time", value, value1);
        return this;
    }

    public JobTaskCondition andNextRerunTimeLike(String value) {
        ew.like("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andNextRerunTimeNotLike(String value) {
        ew.notLike("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition orNextRerunTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("next_rerun_time", value);
        return this;
    }

    public JobTaskCondition andRetryTimesIsNull() {
        ew.isNull("retry_times");
        return this;
    }

    public JobTaskCondition orRetryTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("retry_times");
        return this;
    }

    public JobTaskCondition andRetryTimesIsNotNull() {
        ew.isNotNull("retry_times");
        return this;
    }

    public JobTaskCondition orRetryTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("retry_times");
        return this;
    }

    public JobTaskCondition andRetryTimesEq(Object value) {
        ew.eq("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesNe(Object value) {
        ew.ne("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesGt(Object value) {
        ew.gt("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesGe(Object value) {
        ew.ge("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesLt(Object value) {
        ew.lt("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesLe(Object value) {
        ew.le("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesIn(Object... value) {
        ew.in("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesNotIn(Object... value) {
        ew.notIn("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesBetween(Object value, Object value1) {
        ew.between("retry_times", value, value1);
        return this;
    }

    public JobTaskCondition orRetryTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("retry_times", value, value1);
        return this;
    }

    public JobTaskCondition andRetryTimesNotBetween(Object value, Object value1) {
        ew.notBetween("retry_times", value, value1);
        return this;
    }

    public JobTaskCondition orRetryTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("retry_times", value, value1);
        return this;
    }

    public JobTaskCondition andRetryTimesLike(String value) {
        ew.like("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("retry_times", value);
        return this;
    }

    public JobTaskCondition andRetryTimesNotLike(String value) {
        ew.notLike("retry_times", value);
        return this;
    }

    public JobTaskCondition orRetryTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("retry_times", value);
        return this;
    }

    public JobTaskCondition andTaskArgsIsNull() {
        ew.isNull("task_args");
        return this;
    }

    public JobTaskCondition orTaskArgsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("task_args");
        return this;
    }

    public JobTaskCondition andTaskArgsIsNotNull() {
        ew.isNotNull("task_args");
        return this;
    }

    public JobTaskCondition orTaskArgsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("task_args");
        return this;
    }

    public JobTaskCondition andTaskArgsEq(Object value) {
        ew.eq("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsNe(Object value) {
        ew.ne("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsGt(Object value) {
        ew.gt("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsGe(Object value) {
        ew.ge("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsLt(Object value) {
        ew.lt("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsLe(Object value) {
        ew.le("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsIn(Object... value) {
        ew.in("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsNotIn(Object... value) {
        ew.notIn("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsBetween(Object value, Object value1) {
        ew.between("task_args", value, value1);
        return this;
    }

    public JobTaskCondition orTaskArgsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("task_args", value, value1);
        return this;
    }

    public JobTaskCondition andTaskArgsNotBetween(Object value, Object value1) {
        ew.notBetween("task_args", value, value1);
        return this;
    }

    public JobTaskCondition orTaskArgsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("task_args", value, value1);
        return this;
    }

    public JobTaskCondition andTaskArgsLike(String value) {
        ew.like("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskArgsNotLike(String value) {
        ew.notLike("task_args", value);
        return this;
    }

    public JobTaskCondition orTaskArgsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("task_args", value);
        return this;
    }

    public JobTaskCondition andTaskIdIsNull() {
        ew.isNull("task_id");
        return this;
    }

    public JobTaskCondition orTaskIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("task_id");
        return this;
    }

    public JobTaskCondition andTaskIdIsNotNull() {
        ew.isNotNull("task_id");
        return this;
    }

    public JobTaskCondition orTaskIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("task_id");
        return this;
    }

    public JobTaskCondition andTaskIdEq(Object value) {
        ew.eq("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdNe(Object value) {
        ew.ne("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdGt(Object value) {
        ew.gt("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdGe(Object value) {
        ew.ge("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdLt(Object value) {
        ew.lt("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdLe(Object value) {
        ew.le("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdIn(Object... value) {
        ew.in("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdNotIn(Object... value) {
        ew.notIn("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdBetween(Object value, Object value1) {
        ew.between("task_id", value, value1);
        return this;
    }

    public JobTaskCondition orTaskIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("task_id", value, value1);
        return this;
    }

    public JobTaskCondition andTaskIdNotBetween(Object value, Object value1) {
        ew.notBetween("task_id", value, value1);
        return this;
    }

    public JobTaskCondition orTaskIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("task_id", value, value1);
        return this;
    }

    public JobTaskCondition andTaskIdLike(String value) {
        ew.like("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("task_id", value);
        return this;
    }

    public JobTaskCondition andTaskIdNotLike(String value) {
        ew.notLike("task_id", value);
        return this;
    }

    public JobTaskCondition orTaskIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("task_id", value);
        return this;
    }
}