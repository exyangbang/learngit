package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ChannelIncomeFlowCondition {
    private PlusEntityWrapper<ChannelIncomeFlow> ew;

    public ChannelIncomeFlowCondition() {
        this.ew = new PlusEntityWrapper(ChannelIncomeFlow.class);
    }

    public static ChannelIncomeFlowCondition builder() {
        return new ChannelIncomeFlowCondition();
    }

    public PlusEntityWrapper<ChannelIncomeFlow> build() {
        return this.ew;
    }

    public ChannelIncomeFlowCondition or() {
        this.ew.orNew();
        return this;
    }

    public ChannelIncomeFlowCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ChannelIncomeFlow.class);
    }

    public ChannelIncomeFlowCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ChannelIncomeFlowCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ChannelIncomeFlowCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ChannelIncomeFlowCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ChannelIncomeFlowCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ChannelIncomeFlowCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ChannelIncomeFlowCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ChannelIncomeFlowCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ChannelIncomeFlowCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ChannelIncomeFlowCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ChannelIncomeFlowCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ChannelIncomeFlowCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ChannelIncomeFlowCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ChannelIncomeFlowCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ChannelIncomeFlowCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoIsNull() {
        ew.isNull("acc_no");
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_no");
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoIsNotNull() {
        ew.isNotNull("acc_no");
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_no");
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoEq(Object value) {
        ew.eq("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoNe(Object value) {
        ew.ne("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoGt(Object value) {
        ew.gt("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoGe(Object value) {
        ew.ge("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoLt(Object value) {
        ew.lt("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoLe(Object value) {
        ew.le("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoIn(Object... value) {
        ew.in("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoNotIn(Object... value) {
        ew.notIn("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoBetween(Object value, Object value1) {
        ew.between("acc_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoLike(String value) {
        ew.like("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNoNotLike(String value) {
        ew.notLike("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameIsNull() {
        ew.isNull("acc_name");
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_name");
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameIsNotNull() {
        ew.isNotNull("acc_name");
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_name");
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameEq(Object value) {
        ew.eq("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameNe(Object value) {
        ew.ne("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameGt(Object value) {
        ew.gt("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameGe(Object value) {
        ew.ge("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameLt(Object value) {
        ew.lt("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameLe(Object value) {
        ew.le("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameIn(Object... value) {
        ew.in("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameNotIn(Object... value) {
        ew.notIn("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameBetween(Object value, Object value1) {
        ew.between("acc_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameNotBetween(Object value, Object value1) {
        ew.notBetween("acc_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameLike(String value) {
        ew.like("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccNameNotLike(String value) {
        ew.notLike("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtIsNull() {
        ew.isNull("amt");
        return this;
    }

    public ChannelIncomeFlowCondition orAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amt");
        return this;
    }

    public ChannelIncomeFlowCondition andAmtIsNotNull() {
        ew.isNotNull("amt");
        return this;
    }

    public ChannelIncomeFlowCondition orAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amt");
        return this;
    }

    public ChannelIncomeFlowCondition andAmtEq(Object value) {
        ew.eq("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtNe(Object value) {
        ew.ne("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtGt(Object value) {
        ew.gt("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtGe(Object value) {
        ew.ge("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtLt(Object value) {
        ew.lt("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtLe(Object value) {
        ew.le("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtIn(Object... value) {
        ew.in("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtNotIn(Object... value) {
        ew.notIn("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtBetween(Object value, Object value1) {
        ew.between("amt", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amt", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtNotBetween(Object value, Object value1) {
        ew.notBetween("amt", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amt", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtLike(String value) {
        ew.like("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAmtNotLike(String value) {
        ew.notLike("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amt", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoIsNull() {
        ew.isNull("core_no");
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("core_no");
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoIsNotNull() {
        ew.isNotNull("core_no");
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("core_no");
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoEq(Object value) {
        ew.eq("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoNe(Object value) {
        ew.ne("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoGt(Object value) {
        ew.gt("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoGe(Object value) {
        ew.ge("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoLt(Object value) {
        ew.lt("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoLe(Object value) {
        ew.le("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoIn(Object... value) {
        ew.in("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoNotIn(Object... value) {
        ew.notIn("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoBetween(Object value, Object value1) {
        ew.between("core_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("core_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoNotBetween(Object value, Object value1) {
        ew.notBetween("core_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("core_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoLike(String value) {
        ew.like("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andCoreNoNotLike(String value) {
        ew.notLike("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orCoreNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("core_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidIsNull() {
        ew.isNull("rid");
        return this;
    }

    public ChannelIncomeFlowCondition orRidIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("rid");
        return this;
    }

    public ChannelIncomeFlowCondition andRidIsNotNull() {
        ew.isNotNull("rid");
        return this;
    }

    public ChannelIncomeFlowCondition orRidIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("rid");
        return this;
    }

    public ChannelIncomeFlowCondition andRidEq(Object value) {
        ew.eq("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidNe(Object value) {
        ew.ne("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidGt(Object value) {
        ew.gt("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidGe(Object value) {
        ew.ge("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidLt(Object value) {
        ew.lt("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidLe(Object value) {
        ew.le("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidIn(Object... value) {
        ew.in("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidNotIn(Object... value) {
        ew.notIn("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidBetween(Object value, Object value1) {
        ew.between("rid", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orRidBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("rid", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andRidNotBetween(Object value, Object value1) {
        ew.notBetween("rid", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orRidNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("rid", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andRidLike(String value) {
        ew.like("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRidNotLike(String value) {
        ew.notLike("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRidNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("rid", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoIsNull() {
        ew.isNull("ex_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ex_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoIsNotNull() {
        ew.isNotNull("ex_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ex_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoEq(Object value) {
        ew.eq("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoNe(Object value) {
        ew.ne("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoGt(Object value) {
        ew.gt("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoGe(Object value) {
        ew.ge("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoLt(Object value) {
        ew.lt("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoLe(Object value) {
        ew.le("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoIn(Object... value) {
        ew.in("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoNotIn(Object... value) {
        ew.notIn("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoBetween(Object value, Object value1) {
        ew.between("ex_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ex_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("ex_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ex_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoLike(String value) {
        ew.like("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNoNotLike(String value) {
        ew.notLike("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ex_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameIsNull() {
        ew.isNull("ex_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ex_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameIsNotNull() {
        ew.isNotNull("ex_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ex_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameEq(Object value) {
        ew.eq("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameNe(Object value) {
        ew.ne("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameGt(Object value) {
        ew.gt("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameGe(Object value) {
        ew.ge("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameLt(Object value) {
        ew.lt("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameLe(Object value) {
        ew.le("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameIn(Object... value) {
        ew.in("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameNotIn(Object... value) {
        ew.notIn("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameBetween(Object value, Object value1) {
        ew.between("ex_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ex_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameNotBetween(Object value, Object value1) {
        ew.notBetween("ex_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ex_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameLike(String value) {
        ew.like("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andExAcctNameNotLike(String value) {
        ew.notLike("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orExAcctNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ex_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoIsNull() {
        ew.isNull("clear_bankno");
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("clear_bankno");
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoIsNotNull() {
        ew.isNotNull("clear_bankno");
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("clear_bankno");
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoEq(Object value) {
        ew.eq("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoNe(Object value) {
        ew.ne("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoGt(Object value) {
        ew.gt("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoGe(Object value) {
        ew.ge("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoLt(Object value) {
        ew.lt("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoLe(Object value) {
        ew.le("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoIn(Object... value) {
        ew.in("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoNotIn(Object... value) {
        ew.notIn("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoBetween(Object value, Object value1) {
        ew.between("clear_bankno", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("clear_bankno", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoNotBetween(Object value, Object value1) {
        ew.notBetween("clear_bankno", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("clear_bankno", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoLike(String value) {
        ew.like("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andClearBanknoNotLike(String value) {
        ew.notLike("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition orClearBanknoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("clear_bankno", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameIsNull() {
        ew.isNull("bank_name");
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_name");
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameIsNotNull() {
        ew.isNotNull("bank_name");
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_name");
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameEq(Object value) {
        ew.eq("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameNe(Object value) {
        ew.ne("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameGt(Object value) {
        ew.gt("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameGe(Object value) {
        ew.ge("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameLt(Object value) {
        ew.lt("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameLe(Object value) {
        ew.le("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameIn(Object... value) {
        ew.in("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameNotIn(Object... value) {
        ew.notIn("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameBetween(Object value, Object value1) {
        ew.between("bank_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameLike(String value) {
        ew.like("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBankNameNotLike(String value) {
        ew.notLike("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoIsNull() {
        ew.isNull("tran_no");
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("tran_no");
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoIsNotNull() {
        ew.isNotNull("tran_no");
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("tran_no");
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoEq(Object value) {
        ew.eq("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoNe(Object value) {
        ew.ne("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoGt(Object value) {
        ew.gt("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoGe(Object value) {
        ew.ge("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoLt(Object value) {
        ew.lt("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoLe(Object value) {
        ew.le("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoIn(Object... value) {
        ew.in("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoNotIn(Object... value) {
        ew.notIn("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoBetween(Object value, Object value1) {
        ew.between("tran_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("tran_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoNotBetween(Object value, Object value1) {
        ew.notBetween("tran_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("tran_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoLike(String value) {
        ew.like("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranNoNotLike(String value) {
        ew.notLike("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("tran_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateIsNull() {
        ew.isNull("tran_date");
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("tran_date");
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateIsNotNull() {
        ew.isNotNull("tran_date");
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("tran_date");
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateEq(Object value) {
        ew.eq("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateNe(Object value) {
        ew.ne("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateGt(Object value) {
        ew.gt("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateGe(Object value) {
        ew.ge("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateLt(Object value) {
        ew.lt("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateLe(Object value) {
        ew.le("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateIn(Object... value) {
        ew.in("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateNotIn(Object... value) {
        ew.notIn("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateBetween(Object value, Object value1) {
        ew.between("tran_date", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("tran_date", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateNotBetween(Object value, Object value1) {
        ew.notBetween("tran_date", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("tran_date", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateLike(String value) {
        ew.like("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andTranDateNotLike(String value) {
        ew.notLike("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition orTranDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("tran_date", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoIsNull() {
        ew.isNull("auto_payee_acct_ao");
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auto_payee_acct_ao");
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoIsNotNull() {
        ew.isNotNull("auto_payee_acct_ao");
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auto_payee_acct_ao");
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoEq(Object value) {
        ew.eq("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoNe(Object value) {
        ew.ne("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoGt(Object value) {
        ew.gt("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoGe(Object value) {
        ew.ge("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoLt(Object value) {
        ew.lt("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoLe(Object value) {
        ew.le("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoIn(Object... value) {
        ew.in("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoNotIn(Object... value) {
        ew.notIn("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoBetween(Object value, Object value1) {
        ew.between("auto_payee_acct_ao", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auto_payee_acct_ao", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoNotBetween(Object value, Object value1) {
        ew.notBetween("auto_payee_acct_ao", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auto_payee_acct_ao", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoLike(String value) {
        ew.like("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctAoNotLike(String value) {
        ew.notLike("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctAoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auto_payee_acct_ao", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameIsNull() {
        ew.isNull("auto_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auto_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameIsNotNull() {
        ew.isNotNull("auto_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auto_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameEq(Object value) {
        ew.eq("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameNe(Object value) {
        ew.ne("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameGt(Object value) {
        ew.gt("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameGe(Object value) {
        ew.ge("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameLt(Object value) {
        ew.lt("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameLe(Object value) {
        ew.le("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameIn(Object... value) {
        ew.in("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameNotIn(Object... value) {
        ew.notIn("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameBetween(Object value, Object value1) {
        ew.between("auto_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auto_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameNotBetween(Object value, Object value1) {
        ew.notBetween("auto_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auto_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameLike(String value) {
        ew.like("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAutoPayeeAcctNameNotLike(String value) {
        ew.notLike("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAutoPayeeAcctNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auto_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoIsNull() {
        ew.isNull("manual_payee_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("manual_payee_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoIsNotNull() {
        ew.isNotNull("manual_payee_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("manual_payee_acct_no");
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoEq(Object value) {
        ew.eq("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoNe(Object value) {
        ew.ne("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoGt(Object value) {
        ew.gt("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoGe(Object value) {
        ew.ge("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoLt(Object value) {
        ew.lt("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoLe(Object value) {
        ew.le("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoIn(Object... value) {
        ew.in("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoNotIn(Object... value) {
        ew.notIn("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoBetween(Object value, Object value1) {
        ew.between("manual_payee_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("manual_payee_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("manual_payee_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("manual_payee_acct_no", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoLike(String value) {
        ew.like("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNoNotLike(String value) {
        ew.notLike("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("manual_payee_acct_no", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameIsNull() {
        ew.isNull("manual_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("manual_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameIsNotNull() {
        ew.isNotNull("manual_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("manual_payee_acct_name");
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameEq(Object value) {
        ew.eq("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameNe(Object value) {
        ew.ne("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameGt(Object value) {
        ew.gt("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameGe(Object value) {
        ew.ge("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameLt(Object value) {
        ew.lt("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameLe(Object value) {
        ew.le("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameIn(Object... value) {
        ew.in("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameNotIn(Object... value) {
        ew.notIn("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameBetween(Object value, Object value1) {
        ew.between("manual_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("manual_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameNotBetween(Object value, Object value1) {
        ew.notBetween("manual_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("manual_payee_acct_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameLike(String value) {
        ew.like("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andManualPayeeAcctNameNotLike(String value) {
        ew.notLike("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orManualPayeeAcctNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("manual_payee_acct_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagIsNull() {
        ew.isNull("biz_flag");
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("biz_flag");
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagIsNotNull() {
        ew.isNotNull("biz_flag");
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("biz_flag");
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagEq(Object value) {
        ew.eq("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagNe(Object value) {
        ew.ne("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagGt(Object value) {
        ew.gt("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagGe(Object value) {
        ew.ge("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagLt(Object value) {
        ew.lt("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagLe(Object value) {
        ew.le("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagIn(Object... value) {
        ew.in("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagNotIn(Object... value) {
        ew.notIn("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagBetween(Object value, Object value1) {
        ew.between("biz_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("biz_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagNotBetween(Object value, Object value1) {
        ew.notBetween("biz_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("biz_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagLike(String value) {
        ew.like("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andBizFlagNotLike(String value) {
        ew.notLike("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orBizFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("biz_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagIsNull() {
        ew.isNull("elc_make_flag");
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("elc_make_flag");
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagIsNotNull() {
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagEq(Object value) {
        ew.eq("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagNe(Object value) {
        ew.ne("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagGt(Object value) {
        ew.gt("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagGe(Object value) {
        ew.ge("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagLt(Object value) {
        ew.lt("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagLe(Object value) {
        ew.le("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagIn(Object... value) {
        ew.in("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagNotIn(Object... value) {
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagBetween(Object value, Object value1) {
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagNotBetween(Object value, Object value1) {
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagLike(String value) {
        ew.like("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andElcMakeFlagNotLike(String value) {
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orElcMakeFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagIsNull() {
        ew.isNull("handle_flag");
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("handle_flag");
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagIsNotNull() {
        ew.isNotNull("handle_flag");
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("handle_flag");
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagEq(Object value) {
        ew.eq("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagNe(Object value) {
        ew.ne("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagGt(Object value) {
        ew.gt("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagGe(Object value) {
        ew.ge("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagLt(Object value) {
        ew.lt("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagLe(Object value) {
        ew.le("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagIn(Object... value) {
        ew.in("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagNotIn(Object... value) {
        ew.notIn("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagBetween(Object value, Object value1) {
        ew.between("handle_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("handle_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagNotBetween(Object value, Object value1) {
        ew.notBetween("handle_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("handle_flag", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagLike(String value) {
        ew.like("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andHandleFlagNotLike(String value) {
        ew.notLike("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition orHandleFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("handle_flag", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameIsNull() {
        ew.isNull("industry_name");
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_name");
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameIsNotNull() {
        ew.isNotNull("industry_name");
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_name");
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameEq(Object value) {
        ew.eq("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameNe(Object value) {
        ew.ne("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameGt(Object value) {
        ew.gt("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameGe(Object value) {
        ew.ge("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameLt(Object value) {
        ew.lt("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameLe(Object value) {
        ew.le("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameIn(Object... value) {
        ew.in("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameNotIn(Object... value) {
        ew.notIn("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameBetween(Object value, Object value1) {
        ew.between("industry_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameNotBetween(Object value, Object value1) {
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameLike(String value) {
        ew.like("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andIndustryNameNotLike(String value) {
        ew.notLike("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition orIndustryNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_name", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeIsNull() {
        ew.isNull("account_type");
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_type");
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeIsNotNull() {
        ew.isNotNull("account_type");
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_type");
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeEq(Object value) {
        ew.eq("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeNe(Object value) {
        ew.ne("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeGt(Object value) {
        ew.gt("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeGe(Object value) {
        ew.ge("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeLt(Object value) {
        ew.lt("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeLe(Object value) {
        ew.le("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeIn(Object... value) {
        ew.in("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeNotIn(Object... value) {
        ew.notIn("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeBetween(Object value, Object value1) {
        ew.between("account_type", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_type", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeNotBetween(Object value, Object value1) {
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeLike(String value) {
        ew.like("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition andAccountTypeNotLike(String value) {
        ew.notLike("account_type", value);
        return this;
    }

    public ChannelIncomeFlowCondition orAccountTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_type", value);
        return this;
    }
}