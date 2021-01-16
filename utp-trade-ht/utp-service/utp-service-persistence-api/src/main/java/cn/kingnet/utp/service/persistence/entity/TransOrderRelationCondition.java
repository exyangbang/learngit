package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class TransOrderRelationCondition {
    private PlusEntityWrapper<TransOrderRelation> ew;

    public TransOrderRelationCondition() {
        this.ew = new PlusEntityWrapper(TransOrderRelation.class);
    }

    public static TransOrderRelationCondition builder() {
        return new TransOrderRelationCondition();
    }

    public PlusEntityWrapper<TransOrderRelation> build() {
        return this.ew;
    }

    public TransOrderRelationCondition or() {
        this.ew.orNew();
        return this;
    }

    public TransOrderRelationCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(TransOrderRelation.class);
    }

    public TransOrderRelationCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public TransOrderRelationCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public TransOrderRelationCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public TransOrderRelationCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> TransOrderRelationCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> TransOrderRelationCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> TransOrderRelationCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public TransOrderRelationCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public TransOrderRelationCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public TransOrderRelationCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public TransOrderRelationCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public TransOrderRelationCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public TransOrderRelationCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public TransOrderRelationCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public TransOrderRelationCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public TransOrderRelationCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public TransOrderRelationCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public TransOrderRelationCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public TransOrderRelationCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransOrderRelationCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransOrderRelationCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public TransOrderRelationCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public TransOrderRelationCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransOrderRelationCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransOrderRelationCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdIsNull() {
        ew.isNull("outside_trans_order_id");
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("outside_trans_order_id");
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdIsNotNull() {
        ew.isNotNull("outside_trans_order_id");
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("outside_trans_order_id");
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdEq(Object value) {
        ew.eq("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdNe(Object value) {
        ew.ne("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdGt(Object value) {
        ew.gt("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdGe(Object value) {
        ew.ge("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdLt(Object value) {
        ew.lt("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdLe(Object value) {
        ew.le("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdIn(Object... value) {
        ew.in("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdNotIn(Object... value) {
        ew.notIn("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdBetween(Object value, Object value1) {
        ew.between("outside_trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("outside_trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("outside_trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("outside_trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdLike(String value) {
        ew.like("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andOutsideTransOrderIdNotLike(String value) {
        ew.notLike("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orOutsideTransOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("outside_trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdIsNull() {
        ew.isNull("trans_order_id");
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_order_id");
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdIsNotNull() {
        ew.isNotNull("trans_order_id");
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_order_id");
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdEq(Object value) {
        ew.eq("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdNe(Object value) {
        ew.ne("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdGt(Object value) {
        ew.gt("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdGe(Object value) {
        ew.ge("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdLt(Object value) {
        ew.lt("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdLe(Object value) {
        ew.le("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdIn(Object... value) {
        ew.in("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdNotIn(Object... value) {
        ew.notIn("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdBetween(Object value, Object value1) {
        ew.between("trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_order_id", value, value1);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdLike(String value) {
        ew.like("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransOrderIdNotLike(String value) {
        ew.notLike("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition orTransOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_order_id", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountIsNull() {
        ew.isNull("trans_amount");
        return this;
    }

    public TransOrderRelationCondition orTransAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_amount");
        return this;
    }

    public TransOrderRelationCondition andTransAmountIsNotNull() {
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransOrderRelationCondition orTransAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransOrderRelationCondition andTransAmountEq(Object value) {
        ew.eq("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountNe(Object value) {
        ew.ne("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountGt(Object value) {
        ew.gt("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountGe(Object value) {
        ew.ge("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountLt(Object value) {
        ew.lt("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountLe(Object value) {
        ew.le("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountIn(Object... value) {
        ew.in("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountNotIn(Object... value) {
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountBetween(Object value, Object value1) {
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransOrderRelationCondition orTransAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransOrderRelationCondition andTransAmountNotBetween(Object value, Object value1) {
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransOrderRelationCondition orTransAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransOrderRelationCondition andTransAmountLike(String value) {
        ew.like("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andTransAmountNotLike(String value) {
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition orTransAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public TransOrderRelationCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public TransOrderRelationCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public TransOrderRelationCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public TransOrderRelationCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public TransOrderRelationCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public TransOrderRelationCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public TransOrderRelationCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransOrderRelationCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransOrderRelationCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public TransOrderRelationCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public TransOrderRelationCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public TransOrderRelationCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public TransOrderRelationCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransOrderRelationCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}