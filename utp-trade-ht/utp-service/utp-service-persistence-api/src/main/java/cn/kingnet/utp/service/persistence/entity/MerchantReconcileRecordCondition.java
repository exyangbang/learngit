package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class MerchantReconcileRecordCondition {
    private PlusEntityWrapper<MerchantReconcileRecord> ew;

    public MerchantReconcileRecordCondition() {
        this.ew = new PlusEntityWrapper(MerchantReconcileRecord.class);
    }

    public static MerchantReconcileRecordCondition builder() {
        return new MerchantReconcileRecordCondition();
    }

    public PlusEntityWrapper<MerchantReconcileRecord> build() {
        return this.ew;
    }

    public MerchantReconcileRecordCondition or() {
        this.ew.orNew();
        return this;
    }

    public MerchantReconcileRecordCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(MerchantReconcileRecord.class);
    }

    public MerchantReconcileRecordCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public MerchantReconcileRecordCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public MerchantReconcileRecordCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public MerchantReconcileRecordCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> MerchantReconcileRecordCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> MerchantReconcileRecordCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> MerchantReconcileRecordCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public MerchantReconcileRecordCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public MerchantReconcileRecordCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public MerchantReconcileRecordCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public MerchantReconcileRecordCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public MerchantReconcileRecordCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public MerchantReconcileRecordCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public MerchantReconcileRecordCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public MerchantReconcileRecordCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusIsNull() {
        ew.isNull("reconcile_status");
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_status");
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusIsNotNull() {
        ew.isNotNull("reconcile_status");
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_status");
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusEq(Object value) {
        ew.eq("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusNe(Object value) {
        ew.ne("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusGt(Object value) {
        ew.gt("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusGe(Object value) {
        ew.ge("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusLt(Object value) {
        ew.lt("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusLe(Object value) {
        ew.le("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusIn(Object... value) {
        ew.in("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusNotIn(Object... value) {
        ew.notIn("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusBetween(Object value, Object value1) {
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusLike(String value) {
        ew.like("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andReconcileStatusNotLike(String value) {
        ew.notLike("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition orReconcileStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_status", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameIsNull() {
        ew.isNull("job_name");
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("job_name");
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameIsNotNull() {
        ew.isNotNull("job_name");
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("job_name");
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameEq(Object value) {
        ew.eq("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameNe(Object value) {
        ew.ne("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameGt(Object value) {
        ew.gt("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameGe(Object value) {
        ew.ge("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameLt(Object value) {
        ew.lt("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameLe(Object value) {
        ew.le("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameIn(Object... value) {
        ew.in("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameNotIn(Object... value) {
        ew.notIn("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameBetween(Object value, Object value1) {
        ew.between("job_name", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("job_name", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameNotBetween(Object value, Object value1) {
        ew.notBetween("job_name", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("job_name", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameLike(String value) {
        ew.like("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobNameNotLike(String value) {
        ew.notLike("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("job_name", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsIsNull() {
        ew.isNull("job_params");
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("job_params");
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsIsNotNull() {
        ew.isNotNull("job_params");
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("job_params");
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsEq(Object value) {
        ew.eq("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsNe(Object value) {
        ew.ne("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsGt(Object value) {
        ew.gt("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsGe(Object value) {
        ew.ge("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsLt(Object value) {
        ew.lt("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsLe(Object value) {
        ew.le("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsIn(Object... value) {
        ew.in("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsNotIn(Object... value) {
        ew.notIn("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsBetween(Object value, Object value1) {
        ew.between("job_params", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("job_params", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsNotBetween(Object value, Object value1) {
        ew.notBetween("job_params", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("job_params", value, value1);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsLike(String value) {
        ew.like("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition andJobParamsNotLike(String value) {
        ew.notLike("job_params", value);
        return this;
    }

    public MerchantReconcileRecordCondition orJobParamsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("job_params", value);
        return this;
    }
}