package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ChannelMerchantCondition {
    private PlusEntityWrapper<ChannelMerchant> ew;

    public ChannelMerchantCondition() {
        this.ew = new PlusEntityWrapper(ChannelMerchant.class);
    }

    public static ChannelMerchantCondition builder() {
        return new ChannelMerchantCondition();
    }

    public PlusEntityWrapper<ChannelMerchant> build() {
        return this.ew;
    }

    public ChannelMerchantCondition or() {
        this.ew.orNew();
        return this;
    }

    public ChannelMerchantCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ChannelMerchant.class);
    }

    public ChannelMerchantCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ChannelMerchantCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ChannelMerchantCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ChannelMerchantCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ChannelMerchantCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ChannelMerchantCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ChannelMerchantCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ChannelMerchantCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ChannelMerchantCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ChannelMerchantCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ChannelMerchantCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ChannelMerchantCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ChannelMerchantCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ChannelMerchantCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ChannelMerchantCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ChannelMerchantCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ChannelMerchantCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelMerchantCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelMerchantCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ChannelMerchantCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ChannelMerchantCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ChannelMerchantCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ChannelMerchantCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelMerchantCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelMerchantCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelMerchantCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelMerchantCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelMerchantCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelMerchantCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelMerchantCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ChannelMerchantCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ChannelMerchantCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelMerchantCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelMerchantCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public ChannelMerchantCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public ChannelMerchantCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public ChannelMerchantCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public ChannelMerchantCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoIsNull() {
        ew.isNull("product_no");
        return this;
    }

    public ChannelMerchantCondition orProductNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_no");
        return this;
    }

    public ChannelMerchantCondition andProductNoIsNotNull() {
        ew.isNotNull("product_no");
        return this;
    }

    public ChannelMerchantCondition orProductNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_no");
        return this;
    }

    public ChannelMerchantCondition andProductNoEq(Object value) {
        ew.eq("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoNe(Object value) {
        ew.ne("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoGt(Object value) {
        ew.gt("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoGe(Object value) {
        ew.ge("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoLt(Object value) {
        ew.lt("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoLe(Object value) {
        ew.le("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoIn(Object... value) {
        ew.in("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoNotIn(Object... value) {
        ew.notIn("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoBetween(Object value, Object value1) {
        ew.between("product_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition orProductNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition andProductNoNotBetween(Object value, Object value1) {
        ew.notBetween("product_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition orProductNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition andProductNoLike(String value) {
        ew.like("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andProductNoNotLike(String value) {
        ew.notLike("product_no", value);
        return this;
    }

    public ChannelMerchantCondition orProductNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public ChannelMerchantCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public ChannelMerchantCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public ChannelMerchantCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public ChannelMerchantCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public ChannelMerchantCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdIsNull() {
        ew.isNull("mer_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdIsNotNull() {
        ew.isNotNull("mer_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdEq(Object value) {
        ew.eq("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdNe(Object value) {
        ew.ne("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdGt(Object value) {
        ew.gt("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdGe(Object value) {
        ew.ge("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdLt(Object value) {
        ew.lt("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdLe(Object value) {
        ew.le("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdIn(Object... value) {
        ew.in("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdNotIn(Object... value) {
        ew.notIn("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("mer_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("mer_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdLike(String value) {
        ew.like("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andMerFeeTemplateIdNotLike(String value) {
        ew.notLike("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orMerFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdIsNull() {
        ew.isNull("chn_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("chn_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdIsNotNull() {
        ew.isNotNull("chn_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("chn_fee_template_id");
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdEq(Object value) {
        ew.eq("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdNe(Object value) {
        ew.ne("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdGt(Object value) {
        ew.gt("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdGe(Object value) {
        ew.ge("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdLt(Object value) {
        ew.lt("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdLe(Object value) {
        ew.le("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdIn(Object... value) {
        ew.in("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdNotIn(Object... value) {
        ew.notIn("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdLike(String value) {
        ew.like("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition andChnFeeTemplateIdNotLike(String value) {
        ew.notLike("chn_fee_template_id", value);
        return this;
    }

    public ChannelMerchantCondition orChnFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("chn_fee_template_id", value);
        return this;
    }
}