package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ChannelIndustryCondition {
    private PlusEntityWrapper<ChannelIndustry> ew;

    public ChannelIndustryCondition() {
        this.ew = new PlusEntityWrapper(ChannelIndustry.class);
    }

    public static ChannelIndustryCondition builder() {
        return new ChannelIndustryCondition();
    }

    public PlusEntityWrapper<ChannelIndustry> build() {
        return this.ew;
    }

    public ChannelIndustryCondition or() {
        this.ew.orNew();
        return this;
    }

    public ChannelIndustryCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ChannelIndustry.class);
    }

    public ChannelIndustryCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ChannelIndustryCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ChannelIndustryCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ChannelIndustryCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ChannelIndustryCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ChannelIndustryCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ChannelIndustryCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ChannelIndustryCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ChannelIndustryCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ChannelIndustryCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ChannelIndustryCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ChannelIndustryCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ChannelIndustryCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ChannelIndustryCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ChannelIndustryCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ChannelIndustryCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ChannelIndustryCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ChannelIndustryCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ChannelIndustryCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelIndustryCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelIndustryCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelIndustryCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelIndustryCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelIndustryCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelIndustryCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelIndustryCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ChannelIndustryCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ChannelIndustryCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelIndustryCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelIndustryCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public ChannelIndustryCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public ChannelIndustryCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public ChannelIndustryCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public ChannelIndustryCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoIsNull() {
        ew.isNull("product_no");
        return this;
    }

    public ChannelIndustryCondition orProductNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_no");
        return this;
    }

    public ChannelIndustryCondition andProductNoIsNotNull() {
        ew.isNotNull("product_no");
        return this;
    }

    public ChannelIndustryCondition orProductNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_no");
        return this;
    }

    public ChannelIndustryCondition andProductNoEq(Object value) {
        ew.eq("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoNe(Object value) {
        ew.ne("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoGt(Object value) {
        ew.gt("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoGe(Object value) {
        ew.ge("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoLt(Object value) {
        ew.lt("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoLe(Object value) {
        ew.le("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoIn(Object... value) {
        ew.in("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoNotIn(Object... value) {
        ew.notIn("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoBetween(Object value, Object value1) {
        ew.between("product_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition orProductNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition andProductNoNotBetween(Object value, Object value1) {
        ew.notBetween("product_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition orProductNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition andProductNoLike(String value) {
        ew.like("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andProductNoNotLike(String value) {
        ew.notLike("product_no", value);
        return this;
    }

    public ChannelIndustryCondition orProductNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_no", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdIsNull() {
        ew.isNull("ind_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ind_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdIsNotNull() {
        ew.isNotNull("ind_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ind_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdEq(Object value) {
        ew.eq("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdNe(Object value) {
        ew.ne("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdGt(Object value) {
        ew.gt("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdGe(Object value) {
        ew.ge("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdLt(Object value) {
        ew.lt("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdLe(Object value) {
        ew.le("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdIn(Object... value) {
        ew.in("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdNotIn(Object... value) {
        ew.notIn("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("ind_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ind_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("ind_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ind_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdLike(String value) {
        ew.like("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andIndFeeTemplateIdNotLike(String value) {
        ew.notLike("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orIndFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ind_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdIsNull() {
        ew.isNull("chn_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("chn_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdIsNotNull() {
        ew.isNotNull("chn_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("chn_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdEq(Object value) {
        ew.eq("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdNe(Object value) {
        ew.ne("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdGt(Object value) {
        ew.gt("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdGe(Object value) {
        ew.ge("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdLt(Object value) {
        ew.lt("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdLe(Object value) {
        ew.le("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdIn(Object... value) {
        ew.in("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdNotIn(Object... value) {
        ew.notIn("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdLike(String value) {
        ew.like("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChnFeeTemplateIdNotLike(String value) {
        ew.notLike("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orChnFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("chn_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementIsNull() {
        ew.isNull("roof_placement");
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("roof_placement");
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementIsNotNull() {
        ew.isNotNull("roof_placement");
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("roof_placement");
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementEq(Object value) {
        ew.eq("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementNe(Object value) {
        ew.ne("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementGt(Object value) {
        ew.gt("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementGe(Object value) {
        ew.ge("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementLt(Object value) {
        ew.lt("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementLe(Object value) {
        ew.le("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementIn(Object... value) {
        ew.in("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementNotIn(Object... value) {
        ew.notIn("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementBetween(Object value, Object value1) {
        ew.between("roof_placement", value, value1);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("roof_placement", value, value1);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementNotBetween(Object value, Object value1) {
        ew.notBetween("roof_placement", value, value1);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("roof_placement", value, value1);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementLike(String value) {
        ew.like("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andRoofPlacementNotLike(String value) {
        ew.notLike("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition orRoofPlacementNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("roof_placement", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoIsNull() {
        ew.isNull("channel_mer_no");
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_no");
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoIsNotNull() {
        ew.isNotNull("channel_mer_no");
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_no");
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoEq(Object value) {
        ew.eq("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoNe(Object value) {
        ew.ne("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoGt(Object value) {
        ew.gt("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoGe(Object value) {
        ew.ge("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoLt(Object value) {
        ew.lt("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoLe(Object value) {
        ew.le("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoIn(Object... value) {
        ew.in("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoNotIn(Object... value) {
        ew.notIn("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoBetween(Object value, Object value1) {
        ew.between("channel_mer_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_no", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoLike(String value) {
        ew.like("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNoNotLike(String value) {
        ew.notLike("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_no", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public ChannelIndustryCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public ChannelIndustryCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public ChannelIndustryCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public ChannelIndustryCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdIsNull() {
        ew.isNull("public_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("public_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdIsNotNull() {
        ew.isNotNull("public_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("public_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdEq(Object value) {
        ew.eq("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdNe(Object value) {
        ew.ne("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdGt(Object value) {
        ew.gt("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdGe(Object value) {
        ew.ge("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdLt(Object value) {
        ew.lt("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdLe(Object value) {
        ew.le("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdIn(Object... value) {
        ew.in("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdNotIn(Object... value) {
        ew.notIn("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("public_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("public_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("public_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("public_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdLike(String value) {
        ew.like("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPublicFeeTemplateIdNotLike(String value) {
        ew.notLike("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPublicFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("public_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdIsNull() {
        ew.isNull("private_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("private_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdIsNotNull() {
        ew.isNotNull("private_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("private_fee_template_id");
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdEq(Object value) {
        ew.eq("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdNe(Object value) {
        ew.ne("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdGt(Object value) {
        ew.gt("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdGe(Object value) {
        ew.ge("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdLt(Object value) {
        ew.lt("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdLe(Object value) {
        ew.le("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdIn(Object... value) {
        ew.in("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdNotIn(Object... value) {
        ew.notIn("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("private_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("private_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("private_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("private_fee_template_id", value, value1);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdLike(String value) {
        ew.like("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andPrivateFeeTemplateIdNotLike(String value) {
        ew.notLike("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition orPrivateFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("private_fee_template_id", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameIsNull() {
        ew.isNull("channel_mer_name");
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_name");
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameIsNotNull() {
        ew.isNotNull("channel_mer_name");
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_name");
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameEq(Object value) {
        ew.eq("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameNe(Object value) {
        ew.ne("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameGt(Object value) {
        ew.gt("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameGe(Object value) {
        ew.ge("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameLt(Object value) {
        ew.lt("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameLe(Object value) {
        ew.le("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameIn(Object... value) {
        ew.in("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameNotIn(Object... value) {
        ew.notIn("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameBetween(Object value, Object value1) {
        ew.between("channel_mer_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameLike(String value) {
        ew.like("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerNameNotLike(String value) {
        ew.notLike("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameIsNull() {
        ew.isNull("channel_mer_short_name");
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_short_name");
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameIsNotNull() {
        ew.isNotNull("channel_mer_short_name");
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_short_name");
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameEq(Object value) {
        ew.eq("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameNe(Object value) {
        ew.ne("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameGt(Object value) {
        ew.gt("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameGe(Object value) {
        ew.ge("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameLt(Object value) {
        ew.lt("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameLe(Object value) {
        ew.le("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameIn(Object... value) {
        ew.in("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameNotIn(Object... value) {
        ew.notIn("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameBetween(Object value, Object value1) {
        ew.between("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameLike(String value) {
        ew.like("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerShortNameNotLike(String value) {
        ew.notLike("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerShortNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_short_name", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryIsNull() {
        ew.isNull("channel_mer_category");
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_category");
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryIsNotNull() {
        ew.isNotNull("channel_mer_category");
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_category");
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryEq(Object value) {
        ew.eq("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryNe(Object value) {
        ew.ne("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryGt(Object value) {
        ew.gt("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryGe(Object value) {
        ew.ge("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryLt(Object value) {
        ew.lt("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryLe(Object value) {
        ew.le("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryIn(Object... value) {
        ew.in("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryNotIn(Object... value) {
        ew.notIn("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryBetween(Object value, Object value1) {
        ew.between("channel_mer_category", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_category", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_category", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_category", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryLike(String value) {
        ew.like("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelMerCategoryNotLike(String value) {
        ew.notLike("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition orChannelMerCategoryNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_category", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceIsNull() {
        ew.isNull("channel_capital_source");
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_capital_source");
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceIsNotNull() {
        ew.isNotNull("channel_capital_source");
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_capital_source");
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceEq(Object value) {
        ew.eq("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceNe(Object value) {
        ew.ne("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceGt(Object value) {
        ew.gt("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceGe(Object value) {
        ew.ge("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceLt(Object value) {
        ew.lt("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceLe(Object value) {
        ew.le("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceIn(Object... value) {
        ew.in("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceNotIn(Object... value) {
        ew.notIn("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceBetween(Object value, Object value1) {
        ew.between("channel_capital_source", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_capital_source", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceNotBetween(Object value, Object value1) {
        ew.notBetween("channel_capital_source", value, value1);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_capital_source", value, value1);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceLike(String value) {
        ew.like("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition andChannelCapitalSourceNotLike(String value) {
        ew.notLike("channel_capital_source", value);
        return this;
    }

    public ChannelIndustryCondition orChannelCapitalSourceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_capital_source", value);
        return this;
    }
}