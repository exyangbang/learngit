package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class MerchantAccountInfoCondition {
    private PlusEntityWrapper<MerchantAccountInfo> ew;

    public MerchantAccountInfoCondition() {
        this.ew = new PlusEntityWrapper(MerchantAccountInfo.class);
    }

    public static MerchantAccountInfoCondition builder() {
        return new MerchantAccountInfoCondition();
    }

    public PlusEntityWrapper<MerchantAccountInfo> build() {
        return this.ew;
    }

    public MerchantAccountInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public MerchantAccountInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(MerchantAccountInfo.class);
    }

    public MerchantAccountInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public MerchantAccountInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public MerchantAccountInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public MerchantAccountInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> MerchantAccountInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> MerchantAccountInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> MerchantAccountInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public MerchantAccountInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public MerchantAccountInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public MerchantAccountInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public MerchantAccountInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public MerchantAccountInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public MerchantAccountInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public MerchantAccountInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public MerchantAccountInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public MerchantAccountInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public MerchantAccountInfoCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public MerchantAccountInfoCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantAccountInfoCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantAccountInfoCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public MerchantAccountInfoCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public MerchantAccountInfoCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public MerchantAccountInfoCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public MerchantAccountInfoCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeIsNull() {
        ew.isNull("account_type");
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_type");
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeIsNotNull() {
        ew.isNotNull("account_type");
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_type");
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeEq(Object value) {
        ew.eq("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeNe(Object value) {
        ew.ne("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeGt(Object value) {
        ew.gt("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeGe(Object value) {
        ew.ge("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeLt(Object value) {
        ew.lt("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeLe(Object value) {
        ew.le("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeIn(Object... value) {
        ew.in("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeNotIn(Object... value) {
        ew.notIn("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeBetween(Object value, Object value1) {
        ew.between("account_type", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_type", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeNotBetween(Object value, Object value1) {
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_type", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeLike(String value) {
        ew.like("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountTypeNotLike(String value) {
        ew.notLike("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_type", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoIsNull() {
        ew.isNull("account_no");
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_no");
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoIsNotNull() {
        ew.isNotNull("account_no");
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_no");
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoEq(Object value) {
        ew.eq("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoNe(Object value) {
        ew.ne("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoGt(Object value) {
        ew.gt("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoGe(Object value) {
        ew.ge("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoLt(Object value) {
        ew.lt("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoLe(Object value) {
        ew.le("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoIn(Object... value) {
        ew.in("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoNotIn(Object... value) {
        ew.notIn("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoBetween(Object value, Object value1) {
        ew.between("account_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_no", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoLike(String value) {
        ew.like("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNoNotLike(String value) {
        ew.notLike("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_no", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameIsNull() {
        ew.isNull("account_name");
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account_name");
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameIsNotNull() {
        ew.isNotNull("account_name");
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account_name");
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameEq(Object value) {
        ew.eq("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameNe(Object value) {
        ew.ne("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameGt(Object value) {
        ew.gt("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameGe(Object value) {
        ew.ge("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameLt(Object value) {
        ew.lt("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameLe(Object value) {
        ew.le("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameIn(Object... value) {
        ew.in("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameNotIn(Object... value) {
        ew.notIn("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameBetween(Object value, Object value1) {
        ew.between("account_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameLike(String value) {
        ew.like("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andAccountNameNotLike(String value) {
        ew.notLike("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeIsNull() {
        ew.isNull("bank_code");
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_code");
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeIsNotNull() {
        ew.isNotNull("bank_code");
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_code");
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeEq(Object value) {
        ew.eq("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeNe(Object value) {
        ew.ne("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeGt(Object value) {
        ew.gt("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeGe(Object value) {
        ew.ge("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeLt(Object value) {
        ew.lt("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeLe(Object value) {
        ew.le("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeIn(Object... value) {
        ew.in("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeNotIn(Object... value) {
        ew.notIn("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeBetween(Object value, Object value1) {
        ew.between("bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeLike(String value) {
        ew.like("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankCodeNotLike(String value) {
        ew.notLike("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameIsNull() {
        ew.isNull("bank_name");
        return this;
    }

    public MerchantAccountInfoCondition orBankNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bank_name");
        return this;
    }

    public MerchantAccountInfoCondition andBankNameIsNotNull() {
        ew.isNotNull("bank_name");
        return this;
    }

    public MerchantAccountInfoCondition orBankNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bank_name");
        return this;
    }

    public MerchantAccountInfoCondition andBankNameEq(Object value) {
        ew.eq("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameNe(Object value) {
        ew.ne("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameGt(Object value) {
        ew.gt("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameGe(Object value) {
        ew.ge("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameLt(Object value) {
        ew.lt("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameLe(Object value) {
        ew.le("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameIn(Object... value) {
        ew.in("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameNotIn(Object... value) {
        ew.notIn("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameBetween(Object value, Object value1) {
        ew.between("bank_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bank_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameNotBetween(Object value, Object value1) {
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bank_name", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameLike(String value) {
        ew.like("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andBankNameNotLike(String value) {
        ew.notLike("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition orBankNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bank_name", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeIsNull() {
        ew.isNull("receive_bank_code");
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("receive_bank_code");
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeIsNotNull() {
        ew.isNotNull("receive_bank_code");
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("receive_bank_code");
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeEq(Object value) {
        ew.eq("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeNe(Object value) {
        ew.ne("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeGt(Object value) {
        ew.gt("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeGe(Object value) {
        ew.ge("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeLt(Object value) {
        ew.lt("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeLe(Object value) {
        ew.le("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeIn(Object... value) {
        ew.in("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeNotIn(Object... value) {
        ew.notIn("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeBetween(Object value, Object value1) {
        ew.between("receive_bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("receive_bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeNotBetween(Object value, Object value1) {
        ew.notBetween("receive_bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("receive_bank_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeLike(String value) {
        ew.like("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andReceiveBankCodeNotLike(String value) {
        ew.notLike("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orReceiveBankCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("receive_bank_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtIsNull() {
        ew.isNull("auth_amt");
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_amt");
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtIsNotNull() {
        ew.isNotNull("auth_amt");
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_amt");
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtEq(Object value) {
        ew.eq("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtNe(Object value) {
        ew.ne("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtGt(Object value) {
        ew.gt("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtGe(Object value) {
        ew.ge("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtLt(Object value) {
        ew.lt("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtLe(Object value) {
        ew.le("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtIn(Object... value) {
        ew.in("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtNotIn(Object... value) {
        ew.notIn("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtBetween(Object value, Object value1) {
        ew.between("auth_amt", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_amt", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtNotBetween(Object value, Object value1) {
        ew.notBetween("auth_amt", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_amt", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtLike(String value) {
        ew.like("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthAmtNotLike(String value) {
        ew.notLike("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthAmtNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_amt", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusIsNull() {
        ew.isNull("bind_status");
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bind_status");
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusIsNotNull() {
        ew.isNotNull("bind_status");
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bind_status");
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusEq(Object value) {
        ew.eq("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusNe(Object value) {
        ew.ne("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusGt(Object value) {
        ew.gt("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusGe(Object value) {
        ew.ge("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusLt(Object value) {
        ew.lt("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusLe(Object value) {
        ew.le("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusIn(Object... value) {
        ew.in("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusNotIn(Object... value) {
        ew.notIn("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusBetween(Object value, Object value1) {
        ew.between("bind_status", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bind_status", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusNotBetween(Object value, Object value1) {
        ew.notBetween("bind_status", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bind_status", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusLike(String value) {
        ew.like("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andBindStatusNotLike(String value) {
        ew.notLike("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition orBindStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bind_status", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountIsNull() {
        ew.isNull("auth_count");
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_count");
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountIsNotNull() {
        ew.isNotNull("auth_count");
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_count");
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountEq(Object value) {
        ew.eq("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountNe(Object value) {
        ew.ne("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountGt(Object value) {
        ew.gt("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountGe(Object value) {
        ew.ge("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountLt(Object value) {
        ew.lt("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountLe(Object value) {
        ew.le("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountIn(Object... value) {
        ew.in("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountNotIn(Object... value) {
        ew.notIn("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountBetween(Object value, Object value1) {
        ew.between("auth_count", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_count", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountNotBetween(Object value, Object value1) {
        ew.notBetween("auth_count", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_count", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountLike(String value) {
        ew.like("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andAuthCountNotLike(String value) {
        ew.notLike("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition orAuthCountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_count", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateIsNull() {
        ew.isNull("req_bind_date");
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("req_bind_date");
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateIsNotNull() {
        ew.isNotNull("req_bind_date");
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("req_bind_date");
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateEq(Object value) {
        ew.eq("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateNe(Object value) {
        ew.ne("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateGt(Object value) {
        ew.gt("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateGe(Object value) {
        ew.ge("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateLt(Object value) {
        ew.lt("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateLe(Object value) {
        ew.le("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateIn(Object... value) {
        ew.in("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateNotIn(Object... value) {
        ew.notIn("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateBetween(Object value, Object value1) {
        ew.between("req_bind_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("req_bind_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateNotBetween(Object value, Object value1) {
        ew.notBetween("req_bind_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("req_bind_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateLike(String value) {
        ew.like("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andReqBindDateNotLike(String value) {
        ew.notLike("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orReqBindDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("req_bind_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateIsNull() {
        ew.isNull("freeze_date");
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("freeze_date");
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateIsNotNull() {
        ew.isNotNull("freeze_date");
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("freeze_date");
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateEq(Object value) {
        ew.eq("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateNe(Object value) {
        ew.ne("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateGt(Object value) {
        ew.gt("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateGe(Object value) {
        ew.ge("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateLt(Object value) {
        ew.lt("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateLe(Object value) {
        ew.le("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateIn(Object... value) {
        ew.in("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateNotIn(Object... value) {
        ew.notIn("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateBetween(Object value, Object value1) {
        ew.between("freeze_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("freeze_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateNotBetween(Object value, Object value1) {
        ew.notBetween("freeze_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("freeze_date", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateLike(String value) {
        ew.like("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andFreezeDateNotLike(String value) {
        ew.notLike("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition orFreezeDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("freeze_date", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeIsNull() {
        ew.isNull("channel_resp_code");
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_code");
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeIsNotNull() {
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeEq(Object value) {
        ew.eq("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeNe(Object value) {
        ew.ne("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeGt(Object value) {
        ew.gt("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeGe(Object value) {
        ew.ge("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeLt(Object value) {
        ew.lt("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeLe(Object value) {
        ew.le("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeIn(Object... value) {
        ew.in("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeNotIn(Object... value) {
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeBetween(Object value, Object value1) {
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeLike(String value) {
        ew.like("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespCodeNotLike(String value) {
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgIsNull() {
        ew.isNull("channel_resp_msg");
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_msg");
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgIsNotNull() {
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgEq(Object value) {
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgNe(Object value) {
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgGt(Object value) {
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgGe(Object value) {
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgLt(Object value) {
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgLe(Object value) {
        ew.le("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgIn(Object... value) {
        ew.in("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgNotIn(Object... value) {
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgBetween(Object value, Object value1) {
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgLike(String value) {
        ew.like("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition andChannelRespMsgNotLike(String value) {
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public MerchantAccountInfoCondition orChannelRespMsgNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_msg", value);
        return this;
    }
}