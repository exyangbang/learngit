package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class FeeIncomeAccountMonthCollectionCondition {
    private PlusEntityWrapper<FeeIncomeAccountMonthCollection> ew;

    public FeeIncomeAccountMonthCollectionCondition() {
        this.ew = new PlusEntityWrapper(FeeIncomeAccountMonthCollection.class);
    }

    public static FeeIncomeAccountMonthCollectionCondition builder() {
        return new FeeIncomeAccountMonthCollectionCondition();
    }

    public PlusEntityWrapper<FeeIncomeAccountMonthCollection> build() {
        return this.ew;
    }

    public FeeIncomeAccountMonthCollectionCondition or() {
        this.ew.orNew();
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(FeeIncomeAccountMonthCollection.class);
    }

    public FeeIncomeAccountMonthCollectionCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> FeeIncomeAccountMonthCollectionCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> FeeIncomeAccountMonthCollectionCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> FeeIncomeAccountMonthCollectionCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthIsNull() {
        ew.isNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthIsNotNull() {
        ew.isNotNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("stat_month");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthEq(Object value) {
        ew.eq("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthNe(Object value) {
        ew.ne("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthGt(Object value) {
        ew.gt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthGe(Object value) {
        ew.ge("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthLt(Object value) {
        ew.lt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthLe(Object value) {
        ew.le("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthIn(Object... value) {
        ew.in("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthNotIn(Object... value) {
        ew.notIn("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthBetween(Object value, Object value1) {
        ew.between("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthNotBetween(Object value, Object value1) {
        ew.notBetween("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("stat_month", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthLike(String value) {
        ew.like("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andStatMonthNotLike(String value) {
        ew.notLike("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orStatMonthNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("stat_month", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdIsNull() {
        ew.isNull("fee_stat_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_stat_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdIsNotNull() {
        ew.isNotNull("fee_stat_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_stat_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdEq(Object value) {
        ew.eq("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdNe(Object value) {
        ew.ne("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdGt(Object value) {
        ew.gt("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdGe(Object value) {
        ew.ge("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdLt(Object value) {
        ew.lt("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdLe(Object value) {
        ew.le("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdIn(Object... value) {
        ew.in("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdNotIn(Object... value) {
        ew.notIn("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdBetween(Object value, Object value1) {
        ew.between("fee_stat_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_stat_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdNotBetween(Object value, Object value1) {
        ew.notBetween("fee_stat_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_stat_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdLike(String value) {
        ew.like("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andFeeStatIdNotLike(String value) {
        ew.notLike("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orFeeStatIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_stat_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdIsNull() {
        ew.isNull("trans_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdIsNotNull() {
        ew.isNotNull("trans_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_id");
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdEq(Object value) {
        ew.eq("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdNe(Object value) {
        ew.ne("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdGt(Object value) {
        ew.gt("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdGe(Object value) {
        ew.ge("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdLt(Object value) {
        ew.lt("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdLe(Object value) {
        ew.le("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdIn(Object... value) {
        ew.in("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdNotIn(Object... value) {
        ew.notIn("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdBetween(Object value, Object value1) {
        ew.between("trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_id", value, value1);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdLike(String value) {
        ew.like("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition andTransIdNotLike(String value) {
        ew.notLike("trans_id", value);
        return this;
    }

    public FeeIncomeAccountMonthCollectionCondition orTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_id", value);
        return this;
    }
}