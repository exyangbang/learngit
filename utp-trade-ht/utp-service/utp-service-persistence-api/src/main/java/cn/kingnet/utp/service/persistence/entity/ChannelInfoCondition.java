package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ChannelInfoCondition {
    private PlusEntityWrapper<ChannelInfo> ew;

    public ChannelInfoCondition() {
        this.ew = new PlusEntityWrapper(ChannelInfo.class);
    }

    public static ChannelInfoCondition builder() {
        return new ChannelInfoCondition();
    }

    public PlusEntityWrapper<ChannelInfo> build() {
        return this.ew;
    }

    public ChannelInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public ChannelInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ChannelInfo.class);
    }

    public ChannelInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ChannelInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ChannelInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ChannelInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ChannelInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ChannelInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ChannelInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ChannelInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ChannelInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ChannelInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ChannelInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ChannelInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ChannelInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ChannelInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ChannelInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ChannelInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ChannelInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ChannelInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ChannelInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ChannelInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ChannelInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ChannelInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ChannelInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ChannelInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ChannelInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ChannelInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ChannelInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ChannelInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ChannelInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ChannelInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ChannelInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ChannelInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ChannelInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ChannelInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ChannelInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ChannelInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ChannelInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ChannelInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ChannelInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ChannelInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ChannelInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public ChannelInfoCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public ChannelInfoCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public ChannelInfoCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public ChannelInfoCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public ChannelInfoCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public ChannelInfoCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public ChannelInfoCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public ChannelInfoCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public ChannelInfoCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public ChannelInfoCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public ChannelInfoCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public ChannelInfoCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public ChannelInfoCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public ChannelInfoCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public ChannelInfoCondition andProductNoIsNull() {
        ew.isNull("product_no");
        return this;
    }

    public ChannelInfoCondition orProductNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_no");
        return this;
    }

    public ChannelInfoCondition andProductNoIsNotNull() {
        ew.isNotNull("product_no");
        return this;
    }

    public ChannelInfoCondition orProductNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_no");
        return this;
    }

    public ChannelInfoCondition andProductNoEq(Object value) {
        ew.eq("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoNe(Object value) {
        ew.ne("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoGt(Object value) {
        ew.gt("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoGe(Object value) {
        ew.ge("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoLt(Object value) {
        ew.lt("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoLe(Object value) {
        ew.le("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoIn(Object... value) {
        ew.in("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoNotIn(Object... value) {
        ew.notIn("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoBetween(Object value, Object value1) {
        ew.between("product_no", value, value1);
        return this;
    }

    public ChannelInfoCondition orProductNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_no", value, value1);
        return this;
    }

    public ChannelInfoCondition andProductNoNotBetween(Object value, Object value1) {
        ew.notBetween("product_no", value, value1);
        return this;
    }

    public ChannelInfoCondition orProductNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_no", value, value1);
        return this;
    }

    public ChannelInfoCondition andProductNoLike(String value) {
        ew.like("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_no", value);
        return this;
    }

    public ChannelInfoCondition andProductNoNotLike(String value) {
        ew.notLike("product_no", value);
        return this;
    }

    public ChannelInfoCondition orProductNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_no", value);
        return this;
    }

    public ChannelInfoCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public ChannelInfoCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public ChannelInfoCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public ChannelInfoCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public ChannelInfoCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public ChannelInfoCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public ChannelInfoCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public ChannelInfoCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public ChannelInfoCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public ChannelInfoCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public ChannelInfoCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeIsNull() {
        ew.isNull("join_type");
        return this;
    }

    public ChannelInfoCondition orJoinTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("join_type");
        return this;
    }

    public ChannelInfoCondition andJoinTypeIsNotNull() {
        ew.isNotNull("join_type");
        return this;
    }

    public ChannelInfoCondition orJoinTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("join_type");
        return this;
    }

    public ChannelInfoCondition andJoinTypeEq(Object value) {
        ew.eq("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeNe(Object value) {
        ew.ne("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeGt(Object value) {
        ew.gt("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeGe(Object value) {
        ew.ge("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeLt(Object value) {
        ew.lt("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeLe(Object value) {
        ew.le("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeIn(Object... value) {
        ew.in("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeNotIn(Object... value) {
        ew.notIn("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeBetween(Object value, Object value1) {
        ew.between("join_type", value, value1);
        return this;
    }

    public ChannelInfoCondition orJoinTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("join_type", value, value1);
        return this;
    }

    public ChannelInfoCondition andJoinTypeNotBetween(Object value, Object value1) {
        ew.notBetween("join_type", value, value1);
        return this;
    }

    public ChannelInfoCondition orJoinTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("join_type", value, value1);
        return this;
    }

    public ChannelInfoCondition andJoinTypeLike(String value) {
        ew.like("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("join_type", value);
        return this;
    }

    public ChannelInfoCondition andJoinTypeNotLike(String value) {
        ew.notLike("join_type", value);
        return this;
    }

    public ChannelInfoCondition orJoinTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("join_type", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlIsNull() {
        ew.isNull("front_url");
        return this;
    }

    public ChannelInfoCondition orFrontUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("front_url");
        return this;
    }

    public ChannelInfoCondition andFrontUrlIsNotNull() {
        ew.isNotNull("front_url");
        return this;
    }

    public ChannelInfoCondition orFrontUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("front_url");
        return this;
    }

    public ChannelInfoCondition andFrontUrlEq(Object value) {
        ew.eq("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlNe(Object value) {
        ew.ne("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlGt(Object value) {
        ew.gt("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlGe(Object value) {
        ew.ge("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlLt(Object value) {
        ew.lt("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlLe(Object value) {
        ew.le("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlIn(Object... value) {
        ew.in("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlNotIn(Object... value) {
        ew.notIn("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlBetween(Object value, Object value1) {
        ew.between("front_url", value, value1);
        return this;
    }

    public ChannelInfoCondition orFrontUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("front_url", value, value1);
        return this;
    }

    public ChannelInfoCondition andFrontUrlNotBetween(Object value, Object value1) {
        ew.notBetween("front_url", value, value1);
        return this;
    }

    public ChannelInfoCondition orFrontUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("front_url", value, value1);
        return this;
    }

    public ChannelInfoCondition andFrontUrlLike(String value) {
        ew.like("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("front_url", value);
        return this;
    }

    public ChannelInfoCondition andFrontUrlNotLike(String value) {
        ew.notLike("front_url", value);
        return this;
    }

    public ChannelInfoCondition orFrontUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("front_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlIsNull() {
        ew.isNull("back_url");
        return this;
    }

    public ChannelInfoCondition orBackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("back_url");
        return this;
    }

    public ChannelInfoCondition andBackUrlIsNotNull() {
        ew.isNotNull("back_url");
        return this;
    }

    public ChannelInfoCondition orBackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("back_url");
        return this;
    }

    public ChannelInfoCondition andBackUrlEq(Object value) {
        ew.eq("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlNe(Object value) {
        ew.ne("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlGt(Object value) {
        ew.gt("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlGe(Object value) {
        ew.ge("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlLt(Object value) {
        ew.lt("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlLe(Object value) {
        ew.le("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlIn(Object... value) {
        ew.in("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlNotIn(Object... value) {
        ew.notIn("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlBetween(Object value, Object value1) {
        ew.between("back_url", value, value1);
        return this;
    }

    public ChannelInfoCondition orBackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("back_url", value, value1);
        return this;
    }

    public ChannelInfoCondition andBackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("back_url", value, value1);
        return this;
    }

    public ChannelInfoCondition orBackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("back_url", value, value1);
        return this;
    }

    public ChannelInfoCondition andBackUrlLike(String value) {
        ew.like("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("back_url", value);
        return this;
    }

    public ChannelInfoCondition andBackUrlNotLike(String value) {
        ew.notLike("back_url", value);
        return this;
    }

    public ChannelInfoCondition orBackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("back_url", value);
        return this;
    }

    public ChannelInfoCondition andTridIsNull() {
        ew.isNull("trid");
        return this;
    }

    public ChannelInfoCondition orTridIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trid");
        return this;
    }

    public ChannelInfoCondition andTridIsNotNull() {
        ew.isNotNull("trid");
        return this;
    }

    public ChannelInfoCondition orTridIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trid");
        return this;
    }

    public ChannelInfoCondition andTridEq(Object value) {
        ew.eq("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridNe(Object value) {
        ew.ne("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridGt(Object value) {
        ew.gt("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridGe(Object value) {
        ew.ge("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridLt(Object value) {
        ew.lt("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridLe(Object value) {
        ew.le("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridIn(Object... value) {
        ew.in("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridNotIn(Object... value) {
        ew.notIn("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridBetween(Object value, Object value1) {
        ew.between("trid", value, value1);
        return this;
    }

    public ChannelInfoCondition orTridBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trid", value, value1);
        return this;
    }

    public ChannelInfoCondition andTridNotBetween(Object value, Object value1) {
        ew.notBetween("trid", value, value1);
        return this;
    }

    public ChannelInfoCondition orTridNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trid", value, value1);
        return this;
    }

    public ChannelInfoCondition andTridLike(String value) {
        ew.like("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trid", value);
        return this;
    }

    public ChannelInfoCondition andTridNotLike(String value) {
        ew.notLike("trid", value);
        return this;
    }

    public ChannelInfoCondition orTridNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trid", value);
        return this;
    }

    public ChannelInfoCondition andTrtpIsNull() {
        ew.isNull("trtp");
        return this;
    }

    public ChannelInfoCondition orTrtpIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trtp");
        return this;
    }

    public ChannelInfoCondition andTrtpIsNotNull() {
        ew.isNotNull("trtp");
        return this;
    }

    public ChannelInfoCondition orTrtpIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trtp");
        return this;
    }

    public ChannelInfoCondition andTrtpEq(Object value) {
        ew.eq("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpNe(Object value) {
        ew.ne("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpGt(Object value) {
        ew.gt("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpGe(Object value) {
        ew.ge("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpLt(Object value) {
        ew.lt("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpLe(Object value) {
        ew.le("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpIn(Object... value) {
        ew.in("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpNotIn(Object... value) {
        ew.notIn("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpBetween(Object value, Object value1) {
        ew.between("trtp", value, value1);
        return this;
    }

    public ChannelInfoCondition orTrtpBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trtp", value, value1);
        return this;
    }

    public ChannelInfoCondition andTrtpNotBetween(Object value, Object value1) {
        ew.notBetween("trtp", value, value1);
        return this;
    }

    public ChannelInfoCondition orTrtpNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trtp", value, value1);
        return this;
    }

    public ChannelInfoCondition andTrtpLike(String value) {
        ew.like("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trtp", value);
        return this;
    }

    public ChannelInfoCondition andTrtpNotLike(String value) {
        ew.notLike("trtp", value);
        return this;
    }

    public ChannelInfoCondition orTrtpNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trtp", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public ChannelInfoCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public ChannelInfoCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public ChannelInfoCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public ChannelInfoCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public ChannelInfoCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public ChannelInfoCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public ChannelInfoCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public ChannelInfoCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public ChannelInfoCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public ChannelInfoCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdIsNull() {
        ew.isNull("chn_fee_template_id");
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("chn_fee_template_id");
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdIsNotNull() {
        ew.isNotNull("chn_fee_template_id");
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("chn_fee_template_id");
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdEq(Object value) {
        ew.eq("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdNe(Object value) {
        ew.ne("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdGt(Object value) {
        ew.gt("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdGe(Object value) {
        ew.ge("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdLt(Object value) {
        ew.lt("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdLe(Object value) {
        ew.le("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdIn(Object... value) {
        ew.in("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdNotIn(Object... value) {
        ew.notIn("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdBetween(Object value, Object value1) {
        ew.between("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("chn_fee_template_id", value, value1);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdLike(String value) {
        ew.like("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andChnFeeTemplateIdNotLike(String value) {
        ew.notLike("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition orChnFeeTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("chn_fee_template_id", value);
        return this;
    }

    public ChannelInfoCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public ChannelInfoCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public ChannelInfoCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public ChannelInfoCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public ChannelInfoCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public ChannelInfoCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public ChannelInfoCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public ChannelInfoCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public ChannelInfoCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public ChannelInfoCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public ChannelInfoCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public ChannelInfoCondition andAccNoIsNull() {
        ew.isNull("acc_no");
        return this;
    }

    public ChannelInfoCondition orAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_no");
        return this;
    }

    public ChannelInfoCondition andAccNoIsNotNull() {
        ew.isNotNull("acc_no");
        return this;
    }

    public ChannelInfoCondition orAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_no");
        return this;
    }

    public ChannelInfoCondition andAccNoEq(Object value) {
        ew.eq("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoNe(Object value) {
        ew.ne("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoGt(Object value) {
        ew.gt("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoGe(Object value) {
        ew.ge("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoLt(Object value) {
        ew.lt("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoLe(Object value) {
        ew.le("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoIn(Object... value) {
        ew.in("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoNotIn(Object... value) {
        ew.notIn("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoBetween(Object value, Object value1) {
        ew.between("acc_no", value, value1);
        return this;
    }

    public ChannelInfoCondition orAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_no", value, value1);
        return this;
    }

    public ChannelInfoCondition andAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public ChannelInfoCondition orAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public ChannelInfoCondition andAccNoLike(String value) {
        ew.like("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andAccNoNotLike(String value) {
        ew.notLike("acc_no", value);
        return this;
    }

    public ChannelInfoCondition orAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_no", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeIsNull() {
        ew.isNull("user_code");
        return this;
    }

    public ChannelInfoCondition orUserCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_code");
        return this;
    }

    public ChannelInfoCondition andUserCodeIsNotNull() {
        ew.isNotNull("user_code");
        return this;
    }

    public ChannelInfoCondition orUserCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_code");
        return this;
    }

    public ChannelInfoCondition andUserCodeEq(Object value) {
        ew.eq("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeNe(Object value) {
        ew.ne("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeGt(Object value) {
        ew.gt("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeGe(Object value) {
        ew.ge("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeLt(Object value) {
        ew.lt("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeLe(Object value) {
        ew.le("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeIn(Object... value) {
        ew.in("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeNotIn(Object... value) {
        ew.notIn("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeBetween(Object value, Object value1) {
        ew.between("user_code", value, value1);
        return this;
    }

    public ChannelInfoCondition orUserCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_code", value, value1);
        return this;
    }

    public ChannelInfoCondition andUserCodeNotBetween(Object value, Object value1) {
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public ChannelInfoCondition orUserCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public ChannelInfoCondition andUserCodeLike(String value) {
        ew.like("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_code", value);
        return this;
    }

    public ChannelInfoCondition andUserCodeNotLike(String value) {
        ew.notLike("user_code", value);
        return this;
    }

    public ChannelInfoCondition orUserCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_code", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaIsNull() {
        ew.isNull("channel_quota");
        return this;
    }

    public ChannelInfoCondition orChannelQuotaIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_quota");
        return this;
    }

    public ChannelInfoCondition andChannelQuotaIsNotNull() {
        ew.isNotNull("channel_quota");
        return this;
    }

    public ChannelInfoCondition orChannelQuotaIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_quota");
        return this;
    }

    public ChannelInfoCondition andChannelQuotaEq(Object value) {
        ew.eq("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaNe(Object value) {
        ew.ne("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaGt(Object value) {
        ew.gt("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaGe(Object value) {
        ew.ge("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaLt(Object value) {
        ew.lt("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaLe(Object value) {
        ew.le("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaIn(Object... value) {
        ew.in("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaNotIn(Object... value) {
        ew.notIn("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaBetween(Object value, Object value1) {
        ew.between("channel_quota", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_quota", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaNotBetween(Object value, Object value1) {
        ew.notBetween("channel_quota", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_quota", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaLike(String value) {
        ew.like("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelQuotaNotLike(String value) {
        ew.notLike("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition orChannelQuotaNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_quota", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoIsNull() {
        ew.isNull("channel_mer_no");
        return this;
    }

    public ChannelInfoCondition orChannelMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_no");
        return this;
    }

    public ChannelInfoCondition andChannelMerNoIsNotNull() {
        ew.isNotNull("channel_mer_no");
        return this;
    }

    public ChannelInfoCondition orChannelMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_no");
        return this;
    }

    public ChannelInfoCondition andChannelMerNoEq(Object value) {
        ew.eq("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoNe(Object value) {
        ew.ne("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoGt(Object value) {
        ew.gt("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoGe(Object value) {
        ew.ge("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoLt(Object value) {
        ew.lt("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoLe(Object value) {
        ew.le("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoIn(Object... value) {
        ew.in("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoNotIn(Object... value) {
        ew.notIn("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoBetween(Object value, Object value1) {
        ew.between("channel_mer_no", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_no", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_no", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_no", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoLike(String value) {
        ew.like("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNoNotLike(String value) {
        ew.notLike("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_no", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameIsNull() {
        ew.isNull("channel_mer_name");
        return this;
    }

    public ChannelInfoCondition orChannelMerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_name");
        return this;
    }

    public ChannelInfoCondition andChannelMerNameIsNotNull() {
        ew.isNotNull("channel_mer_name");
        return this;
    }

    public ChannelInfoCondition orChannelMerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_name");
        return this;
    }

    public ChannelInfoCondition andChannelMerNameEq(Object value) {
        ew.eq("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameNe(Object value) {
        ew.ne("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameGt(Object value) {
        ew.gt("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameGe(Object value) {
        ew.ge("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameLt(Object value) {
        ew.lt("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameLe(Object value) {
        ew.le("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameIn(Object... value) {
        ew.in("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameNotIn(Object... value) {
        ew.notIn("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameBetween(Object value, Object value1) {
        ew.between("channel_mer_name", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_name", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_name", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_name", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameLike(String value) {
        ew.like("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerNameNotLike(String value) {
        ew.notLike("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameIsNull() {
        ew.isNull("channel_mer_short_name");
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_short_name");
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameIsNotNull() {
        ew.isNotNull("channel_mer_short_name");
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_short_name");
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameEq(Object value) {
        ew.eq("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameNe(Object value) {
        ew.ne("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameGt(Object value) {
        ew.gt("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameGe(Object value) {
        ew.ge("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameLt(Object value) {
        ew.lt("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameLe(Object value) {
        ew.le("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameIn(Object... value) {
        ew.in("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameNotIn(Object... value) {
        ew.notIn("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameBetween(Object value, Object value1) {
        ew.between("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_short_name", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameLike(String value) {
        ew.like("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerShortNameNotLike(String value) {
        ew.notLike("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerShortNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_short_name", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryIsNull() {
        ew.isNull("channel_mer_category");
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_mer_category");
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryIsNotNull() {
        ew.isNotNull("channel_mer_category");
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_mer_category");
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryEq(Object value) {
        ew.eq("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryNe(Object value) {
        ew.ne("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryGt(Object value) {
        ew.gt("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryGe(Object value) {
        ew.ge("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryLt(Object value) {
        ew.lt("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryLe(Object value) {
        ew.le("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryIn(Object... value) {
        ew.in("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryNotIn(Object... value) {
        ew.notIn("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryBetween(Object value, Object value1) {
        ew.between("channel_mer_category", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_mer_category", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryNotBetween(Object value, Object value1) {
        ew.notBetween("channel_mer_category", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_mer_category", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryLike(String value) {
        ew.like("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelMerCategoryNotLike(String value) {
        ew.notLike("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition orChannelMerCategoryNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_mer_category", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceIsNull() {
        ew.isNull("channel_capital_source");
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_capital_source");
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceIsNotNull() {
        ew.isNotNull("channel_capital_source");
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_capital_source");
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceEq(Object value) {
        ew.eq("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceNe(Object value) {
        ew.ne("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceGt(Object value) {
        ew.gt("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceGe(Object value) {
        ew.ge("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceLt(Object value) {
        ew.lt("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceLe(Object value) {
        ew.le("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceIn(Object... value) {
        ew.in("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceNotIn(Object... value) {
        ew.notIn("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceBetween(Object value, Object value1) {
        ew.between("channel_capital_source", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_capital_source", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceNotBetween(Object value, Object value1) {
        ew.notBetween("channel_capital_source", value, value1);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_capital_source", value, value1);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceLike(String value) {
        ew.like("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition andChannelCapitalSourceNotLike(String value) {
        ew.notLike("channel_capital_source", value);
        return this;
    }

    public ChannelInfoCondition orChannelCapitalSourceNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_capital_source", value);
        return this;
    }
}