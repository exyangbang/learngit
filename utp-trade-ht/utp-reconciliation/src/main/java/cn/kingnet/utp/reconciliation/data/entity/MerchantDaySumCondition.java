package cn.kingnet.utp.reconciliation.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class MerchantDaySumCondition {
    private PlusEntityWrapper<MerchantDaySum> ew;

    public MerchantDaySumCondition() {
        this.ew = new PlusEntityWrapper(MerchantDaySum.class);
    }

    public static MerchantDaySumCondition builder() {
        return new MerchantDaySumCondition();
    }

    public PlusEntityWrapper<MerchantDaySum> build() {
        return this.ew;
    }

    public MerchantDaySumCondition or() {
        this.ew.orNew();
        return this;
    }

    public MerchantDaySumCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(MerchantDaySum.class);
    }

    public MerchantDaySumCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public MerchantDaySumCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public MerchantDaySumCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public MerchantDaySumCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> MerchantDaySumCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> MerchantDaySumCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> MerchantDaySumCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public MerchantDaySumCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public MerchantDaySumCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public MerchantDaySumCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public MerchantDaySumCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public MerchantDaySumCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public MerchantDaySumCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public MerchantDaySumCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public MerchantDaySumCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public MerchantDaySumCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public MerchantDaySumCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantDaySumCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantDaySumCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public MerchantDaySumCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public MerchantDaySumCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public MerchantDaySumCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public MerchantDaySumCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public MerchantDaySumCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public MerchantDaySumCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public MerchantDaySumCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public MerchantDaySumCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public MerchantDaySumCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public MerchantDaySumCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public MerchantDaySumCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public MerchantDaySumCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public MerchantDaySumCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantDaySumCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantDaySumCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantDaySumCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantDaySumCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantDaySumCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantDaySumCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public MerchantDaySumCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public MerchantDaySumCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public MerchantDaySumCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public MerchantDaySumCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public MerchantDaySumCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public MerchantDaySumCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public MerchantDaySumCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public MerchantDaySumCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public MerchantDaySumCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public MerchantDaySumCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public MerchantDaySumCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public MerchantDaySumCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public MerchantDaySumCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public MerchantDaySumCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountIsNull() {
        ew.isNull("total_count");
        return this;
    }

    public MerchantDaySumCondition orTotalCountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("total_count");
        return this;
    }

    public MerchantDaySumCondition andTotalCountIsNotNull() {
        ew.isNotNull("total_count");
        return this;
    }

    public MerchantDaySumCondition orTotalCountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("total_count");
        return this;
    }

    public MerchantDaySumCondition andTotalCountEq(Object value) {
        ew.eq("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountNe(Object value) {
        ew.ne("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountGt(Object value) {
        ew.gt("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountGe(Object value) {
        ew.ge("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountLt(Object value) {
        ew.lt("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountLe(Object value) {
        ew.le("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountIn(Object... value) {
        ew.in("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountNotIn(Object... value) {
        ew.notIn("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountBetween(Object value, Object value1) {
        ew.between("total_count", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTotalCountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("total_count", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTotalCountNotBetween(Object value, Object value1) {
        ew.notBetween("total_count", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTotalCountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("total_count", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTotalCountLike(String value) {
        ew.like("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalCountNotLike(String value) {
        ew.notLike("total_count", value);
        return this;
    }

    public MerchantDaySumCondition orTotalCountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("total_count", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountIsNull() {
        ew.isNull("total_amount");
        return this;
    }

    public MerchantDaySumCondition orTotalAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("total_amount");
        return this;
    }

    public MerchantDaySumCondition andTotalAmountIsNotNull() {
        ew.isNotNull("total_amount");
        return this;
    }

    public MerchantDaySumCondition orTotalAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("total_amount");
        return this;
    }

    public MerchantDaySumCondition andTotalAmountEq(Object value) {
        ew.eq("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountNe(Object value) {
        ew.ne("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountGt(Object value) {
        ew.gt("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountGe(Object value) {
        ew.ge("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountLt(Object value) {
        ew.lt("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountLe(Object value) {
        ew.le("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountIn(Object... value) {
        ew.in("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountNotIn(Object... value) {
        ew.notIn("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountBetween(Object value, Object value1) {
        ew.between("total_amount", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("total_amount", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountNotBetween(Object value, Object value1) {
        ew.notBetween("total_amount", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("total_amount", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountLike(String value) {
        ew.like("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalAmountNotLike(String value) {
        ew.notLike("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition orTotalAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("total_amount", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeIsNull() {
        ew.isNull("total_fee");
        return this;
    }

    public MerchantDaySumCondition orTotalFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("total_fee");
        return this;
    }

    public MerchantDaySumCondition andTotalFeeIsNotNull() {
        ew.isNotNull("total_fee");
        return this;
    }

    public MerchantDaySumCondition orTotalFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("total_fee");
        return this;
    }

    public MerchantDaySumCondition andTotalFeeEq(Object value) {
        ew.eq("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeNe(Object value) {
        ew.ne("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeGt(Object value) {
        ew.gt("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeGe(Object value) {
        ew.ge("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeLt(Object value) {
        ew.lt("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeLe(Object value) {
        ew.le("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeIn(Object... value) {
        ew.in("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeNotIn(Object... value) {
        ew.notIn("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeBetween(Object value, Object value1) {
        ew.between("total_fee", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("total_fee", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeNotBetween(Object value, Object value1) {
        ew.notBetween("total_fee", value, value1);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("total_fee", value, value1);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeLike(String value) {
        ew.like("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andTotalFeeNotLike(String value) {
        ew.notLike("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition orTotalFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("total_fee", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantDaySumCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantDaySumCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantDaySumCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantDaySumCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public MerchantDaySumCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public MerchantDaySumCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantDaySumCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantDaySumCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantDaySumCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantDaySumCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public MerchantDaySumCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public MerchantDaySumCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantDaySumCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantDaySumCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantDaySumCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }
}