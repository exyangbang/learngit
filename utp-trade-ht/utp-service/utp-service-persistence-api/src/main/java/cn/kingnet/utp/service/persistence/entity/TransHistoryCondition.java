package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class TransHistoryCondition {
    private PlusEntityWrapper<TransHistory> ew;

    public TransHistoryCondition() {
        this.ew = new PlusEntityWrapper(TransHistory.class);
    }

    public static TransHistoryCondition builder() {
        return new TransHistoryCondition();
    }

    public PlusEntityWrapper<TransHistory> build() {
        return this.ew;
    }

    public TransHistoryCondition or() {
        this.ew.orNew();
        return this;
    }

    public TransHistoryCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(TransHistory.class);
    }

    public TransHistoryCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public TransHistoryCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public TransHistoryCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public TransHistoryCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> TransHistoryCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> TransHistoryCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> TransHistoryCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public TransHistoryCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public TransHistoryCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public TransHistoryCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public TransHistoryCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public TransHistoryCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public TransHistoryCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public TransHistoryCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public TransHistoryCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public TransHistoryCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public TransHistoryCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public TransHistoryCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public TransHistoryCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public TransHistoryCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public TransHistoryCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public TransHistoryCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public TransHistoryCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public TransHistoryCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public TransHistoryCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public TransHistoryCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public TransHistoryCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public TransHistoryCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public TransHistoryCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public TransHistoryCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public TransHistoryCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public TransHistoryCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public TransHistoryCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransHistoryCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransHistoryCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public TransHistoryCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public TransHistoryCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public TransHistoryCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public TransHistoryCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public TransHistoryCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public TransHistoryCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public TransHistoryCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public TransHistoryCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public TransHistoryCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public TransHistoryCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public TransHistoryCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public TransHistoryCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public TransHistoryCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public TransHistoryCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public TransHistoryCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public TransHistoryCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public TransHistoryCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public TransHistoryCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public TransHistoryCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public TransHistoryCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public TransHistoryCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public TransHistoryCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public TransHistoryCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public TransHistoryCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public TransHistoryCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransHistoryCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransHistoryCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransHistoryCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransHistoryCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public TransHistoryCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public TransHistoryCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public TransHistoryCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public TransHistoryCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransHistoryCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransHistoryCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeIsNull() {
        ew.isNull("client_trans_time");
        return this;
    }

    public TransHistoryCondition orClientTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_time");
        return this;
    }

    public TransHistoryCondition andClientTransTimeIsNotNull() {
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransHistoryCondition orClientTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransHistoryCondition andClientTransTimeEq(Object value) {
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeNe(Object value) {
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeGt(Object value) {
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeGe(Object value) {
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeLt(Object value) {
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeLe(Object value) {
        ew.le("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeIn(Object... value) {
        ew.in("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeNotIn(Object... value) {
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeBetween(Object value, Object value1) {
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition orClientTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition andClientTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition orClientTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition andClientTransTimeLike(String value) {
        ew.like("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andClientTransTimeNotLike(String value) {
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition orClientTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public TransHistoryCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public TransHistoryCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransHistoryCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransHistoryCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransHistoryCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransHistoryCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public TransHistoryCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public TransHistoryCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public TransHistoryCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public TransHistoryCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public TransHistoryCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public TransHistoryCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransHistoryCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransHistoryCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public TransHistoryCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public TransHistoryCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public TransHistoryCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public TransHistoryCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public TransHistoryCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public TransHistoryCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransHistoryCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransHistoryCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransHistoryCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransHistoryCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public TransHistoryCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public TransHistoryCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public TransHistoryCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public TransHistoryCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public TransHistoryCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public TransHistoryCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public TransHistoryCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public TransHistoryCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransHistoryCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransHistoryCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public TransHistoryCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public TransHistoryCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public TransHistoryCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public TransHistoryCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public TransHistoryCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public TransHistoryCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public TransHistoryCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public TransHistoryCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransHistoryCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransHistoryCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public TransHistoryCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public TransHistoryCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoIsNull() {
        ew.isNull("server_batch_no");
        return this;
    }

    public TransHistoryCondition orServerBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_batch_no");
        return this;
    }

    public TransHistoryCondition andServerBatchNoIsNotNull() {
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransHistoryCondition orServerBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransHistoryCondition andServerBatchNoEq(Object value) {
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoNe(Object value) {
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoGt(Object value) {
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoGe(Object value) {
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoLt(Object value) {
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoLe(Object value) {
        ew.le("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoIn(Object... value) {
        ew.in("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoNotIn(Object... value) {
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoBetween(Object value, Object value1) {
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransHistoryCondition orServerBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransHistoryCondition andServerBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransHistoryCondition orServerBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransHistoryCondition andServerBatchNoLike(String value) {
        ew.like("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerBatchNoNotLike(String value) {
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition orServerBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdIsNull() {
        ew.isNull("server_link_id");
        return this;
    }

    public TransHistoryCondition orServerLinkIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_link_id");
        return this;
    }

    public TransHistoryCondition andServerLinkIdIsNotNull() {
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransHistoryCondition orServerLinkIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransHistoryCondition andServerLinkIdEq(Object value) {
        ew.eq("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdNe(Object value) {
        ew.ne("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdGt(Object value) {
        ew.gt("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdGe(Object value) {
        ew.ge("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdLt(Object value) {
        ew.lt("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdLe(Object value) {
        ew.le("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdIn(Object... value) {
        ew.in("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdNotIn(Object... value) {
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdBetween(Object value, Object value1) {
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransHistoryCondition orServerLinkIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransHistoryCondition andServerLinkIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransHistoryCondition orServerLinkIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransHistoryCondition andServerLinkIdLike(String value) {
        ew.like("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andServerLinkIdNotLike(String value) {
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransHistoryCondition orServerLinkIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransHistoryCondition andTransAmountIsNull() {
        ew.isNull("trans_amount");
        return this;
    }

    public TransHistoryCondition orTransAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_amount");
        return this;
    }

    public TransHistoryCondition andTransAmountIsNotNull() {
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransHistoryCondition orTransAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransHistoryCondition andTransAmountEq(Object value) {
        ew.eq("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountNe(Object value) {
        ew.ne("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountGt(Object value) {
        ew.gt("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountGe(Object value) {
        ew.ge("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountLt(Object value) {
        ew.lt("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountLe(Object value) {
        ew.le("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountIn(Object... value) {
        ew.in("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountNotIn(Object... value) {
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountBetween(Object value, Object value1) {
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransHistoryCondition orTransAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransHistoryCondition andTransAmountNotBetween(Object value, Object value1) {
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransHistoryCondition orTransAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransHistoryCondition andTransAmountLike(String value) {
        ew.like("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andTransAmountNotLike(String value) {
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransHistoryCondition orTransAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountIsNull() {
        ew.isNull("real_amount");
        return this;
    }

    public TransHistoryCondition orRealAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_amount");
        return this;
    }

    public TransHistoryCondition andRealAmountIsNotNull() {
        ew.isNotNull("real_amount");
        return this;
    }

    public TransHistoryCondition orRealAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_amount");
        return this;
    }

    public TransHistoryCondition andRealAmountEq(Object value) {
        ew.eq("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountNe(Object value) {
        ew.ne("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountGt(Object value) {
        ew.gt("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountGe(Object value) {
        ew.ge("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountLt(Object value) {
        ew.lt("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountLe(Object value) {
        ew.le("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountIn(Object... value) {
        ew.in("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountNotIn(Object... value) {
        ew.notIn("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountBetween(Object value, Object value1) {
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransHistoryCondition orRealAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransHistoryCondition andRealAmountNotBetween(Object value, Object value1) {
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransHistoryCondition orRealAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransHistoryCondition andRealAmountLike(String value) {
        ew.like("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_amount", value);
        return this;
    }

    public TransHistoryCondition andRealAmountNotLike(String value) {
        ew.notLike("real_amount", value);
        return this;
    }

    public TransHistoryCondition orRealAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_amount", value);
        return this;
    }

    public TransHistoryCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public TransHistoryCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public TransHistoryCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public TransHistoryCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public TransHistoryCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransHistoryCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransHistoryCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransHistoryCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransHistoryCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public TransHistoryCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public TransHistoryCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public TransHistoryCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public TransHistoryCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public TransHistoryCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public TransHistoryCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransHistoryCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransHistoryCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransHistoryCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransHistoryCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public TransHistoryCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public TransHistoryCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public TransHistoryCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public TransHistoryCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public TransHistoryCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public TransHistoryCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransHistoryCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public TransHistoryCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public TransHistoryCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeIsNull() {
        ew.isNull("channel_resp_time");
        return this;
    }

    public TransHistoryCondition orChannelRespTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_time");
        return this;
    }

    public TransHistoryCondition andChannelRespTimeIsNotNull() {
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public TransHistoryCondition orChannelRespTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public TransHistoryCondition andChannelRespTimeEq(Object value) {
        ew.eq("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeNe(Object value) {
        ew.ne("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeGt(Object value) {
        ew.gt("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeGe(Object value) {
        ew.ge("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeLt(Object value) {
        ew.lt("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeLe(Object value) {
        ew.le("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeIn(Object... value) {
        ew.in("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeNotIn(Object... value) {
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeBetween(Object value, Object value1) {
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeLike(String value) {
        ew.like("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespTimeNotLike(String value) {
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition orChannelRespTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeIsNull() {
        ew.isNull("channel_resp_code");
        return this;
    }

    public TransHistoryCondition orChannelRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_code");
        return this;
    }

    public TransHistoryCondition andChannelRespCodeIsNotNull() {
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public TransHistoryCondition orChannelRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public TransHistoryCondition andChannelRespCodeEq(Object value) {
        ew.eq("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeNe(Object value) {
        ew.ne("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeGt(Object value) {
        ew.gt("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeGe(Object value) {
        ew.ge("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeLt(Object value) {
        ew.lt("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeLe(Object value) {
        ew.le("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeIn(Object... value) {
        ew.in("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeNotIn(Object... value) {
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeBetween(Object value, Object value1) {
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeLike(String value) {
        ew.like("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespCodeNotLike(String value) {
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition orChannelRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdIsNull() {
        ew.isNull("channel_resp_id");
        return this;
    }

    public TransHistoryCondition orChannelRespIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_id");
        return this;
    }

    public TransHistoryCondition andChannelRespIdIsNotNull() {
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public TransHistoryCondition orChannelRespIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public TransHistoryCondition andChannelRespIdEq(Object value) {
        ew.eq("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdNe(Object value) {
        ew.ne("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdGt(Object value) {
        ew.gt("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdGe(Object value) {
        ew.ge("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdLt(Object value) {
        ew.lt("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdLe(Object value) {
        ew.le("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdIn(Object... value) {
        ew.in("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdNotIn(Object... value) {
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdBetween(Object value, Object value1) {
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespIdNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespIdLike(String value) {
        ew.like("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespIdNotLike(String value) {
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition orChannelRespIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgIsNull() {
        ew.isNull("channel_resp_msg");
        return this;
    }

    public TransHistoryCondition orChannelRespMsgIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_msg");
        return this;
    }

    public TransHistoryCondition andChannelRespMsgIsNotNull() {
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public TransHistoryCondition orChannelRespMsgIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public TransHistoryCondition andChannelRespMsgEq(Object value) {
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgNe(Object value) {
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgGt(Object value) {
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgGe(Object value) {
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgLt(Object value) {
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgLe(Object value) {
        ew.le("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgIn(Object... value) {
        ew.in("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgNotIn(Object... value) {
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgBetween(Object value, Object value1) {
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgLike(String value) {
        ew.like("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andChannelRespMsgNotLike(String value) {
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition orChannelRespMsgNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public TransHistoryCondition andRespCodeIsNull() {
        ew.isNull("resp_code");
        return this;
    }

    public TransHistoryCondition orRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_code");
        return this;
    }

    public TransHistoryCondition andRespCodeIsNotNull() {
        ew.isNotNull("resp_code");
        return this;
    }

    public TransHistoryCondition orRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_code");
        return this;
    }

    public TransHistoryCondition andRespCodeEq(Object value) {
        ew.eq("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeNe(Object value) {
        ew.ne("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeGt(Object value) {
        ew.gt("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeGe(Object value) {
        ew.ge("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeLt(Object value) {
        ew.lt("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeLe(Object value) {
        ew.le("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeIn(Object... value) {
        ew.in("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeNotIn(Object... value) {
        ew.notIn("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeBetween(Object value, Object value1) {
        ew.between("resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition orRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition andRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition orRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public TransHistoryCondition andRespCodeLike(String value) {
        ew.like("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespCodeNotLike(String value) {
        ew.notLike("resp_code", value);
        return this;
    }

    public TransHistoryCondition orRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_code", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionIsNull() {
        ew.isNull("resp_exception");
        return this;
    }

    public TransHistoryCondition orRespExceptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_exception");
        return this;
    }

    public TransHistoryCondition andRespExceptionIsNotNull() {
        ew.isNotNull("resp_exception");
        return this;
    }

    public TransHistoryCondition orRespExceptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_exception");
        return this;
    }

    public TransHistoryCondition andRespExceptionEq(Object value) {
        ew.eq("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionNe(Object value) {
        ew.ne("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionGt(Object value) {
        ew.gt("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionGe(Object value) {
        ew.ge("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionLt(Object value) {
        ew.lt("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionLe(Object value) {
        ew.le("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionIn(Object... value) {
        ew.in("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionNotIn(Object... value) {
        ew.notIn("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionBetween(Object value, Object value1) {
        ew.between("resp_exception", value, value1);
        return this;
    }

    public TransHistoryCondition orRespExceptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_exception", value, value1);
        return this;
    }

    public TransHistoryCondition andRespExceptionNotBetween(Object value, Object value1) {
        ew.notBetween("resp_exception", value, value1);
        return this;
    }

    public TransHistoryCondition orRespExceptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_exception", value, value1);
        return this;
    }

    public TransHistoryCondition andRespExceptionLike(String value) {
        ew.like("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespExceptionNotLike(String value) {
        ew.notLike("resp_exception", value);
        return this;
    }

    public TransHistoryCondition orRespExceptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_exception", value);
        return this;
    }

    public TransHistoryCondition andRespMessageIsNull() {
        ew.isNull("resp_message");
        return this;
    }

    public TransHistoryCondition orRespMessageIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_message");
        return this;
    }

    public TransHistoryCondition andRespMessageIsNotNull() {
        ew.isNotNull("resp_message");
        return this;
    }

    public TransHistoryCondition orRespMessageIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_message");
        return this;
    }

    public TransHistoryCondition andRespMessageEq(Object value) {
        ew.eq("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageNe(Object value) {
        ew.ne("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageGt(Object value) {
        ew.gt("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageGe(Object value) {
        ew.ge("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageLt(Object value) {
        ew.lt("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageLe(Object value) {
        ew.le("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageIn(Object... value) {
        ew.in("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageNotIn(Object... value) {
        ew.notIn("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageBetween(Object value, Object value1) {
        ew.between("resp_message", value, value1);
        return this;
    }

    public TransHistoryCondition orRespMessageBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_message", value, value1);
        return this;
    }

    public TransHistoryCondition andRespMessageNotBetween(Object value, Object value1) {
        ew.notBetween("resp_message", value, value1);
        return this;
    }

    public TransHistoryCondition orRespMessageNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_message", value, value1);
        return this;
    }

    public TransHistoryCondition andRespMessageLike(String value) {
        ew.like("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRespMessageNotLike(String value) {
        ew.notLike("resp_message", value);
        return this;
    }

    public TransHistoryCondition orRespMessageNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_message", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusIsNull() {
        ew.isNull("revoke_status");
        return this;
    }

    public TransHistoryCondition orRevokeStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("revoke_status");
        return this;
    }

    public TransHistoryCondition andRevokeStatusIsNotNull() {
        ew.isNotNull("revoke_status");
        return this;
    }

    public TransHistoryCondition orRevokeStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("revoke_status");
        return this;
    }

    public TransHistoryCondition andRevokeStatusEq(Object value) {
        ew.eq("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusNe(Object value) {
        ew.ne("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusGt(Object value) {
        ew.gt("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusGe(Object value) {
        ew.ge("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusLt(Object value) {
        ew.lt("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusLe(Object value) {
        ew.le("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusIn(Object... value) {
        ew.in("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusNotIn(Object... value) {
        ew.notIn("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusBetween(Object value, Object value1) {
        ew.between("revoke_status", value, value1);
        return this;
    }

    public TransHistoryCondition orRevokeStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("revoke_status", value, value1);
        return this;
    }

    public TransHistoryCondition andRevokeStatusNotBetween(Object value, Object value1) {
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public TransHistoryCondition orRevokeStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public TransHistoryCondition andRevokeStatusLike(String value) {
        ew.like("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRevokeStatusNotLike(String value) {
        ew.notLike("revoke_status", value);
        return this;
    }

    public TransHistoryCondition orRevokeStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("revoke_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusIsNull() {
        ew.isNull("refund_status");
        return this;
    }

    public TransHistoryCondition orRefundStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("refund_status");
        return this;
    }

    public TransHistoryCondition andRefundStatusIsNotNull() {
        ew.isNotNull("refund_status");
        return this;
    }

    public TransHistoryCondition orRefundStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("refund_status");
        return this;
    }

    public TransHistoryCondition andRefundStatusEq(Object value) {
        ew.eq("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusNe(Object value) {
        ew.ne("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusGt(Object value) {
        ew.gt("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusGe(Object value) {
        ew.ge("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusLt(Object value) {
        ew.lt("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusLe(Object value) {
        ew.le("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusIn(Object... value) {
        ew.in("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusNotIn(Object... value) {
        ew.notIn("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusBetween(Object value, Object value1) {
        ew.between("refund_status", value, value1);
        return this;
    }

    public TransHistoryCondition orRefundStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("refund_status", value, value1);
        return this;
    }

    public TransHistoryCondition andRefundStatusNotBetween(Object value, Object value1) {
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public TransHistoryCondition orRefundStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public TransHistoryCondition andRefundStatusLike(String value) {
        ew.like("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundStatusNotLike(String value) {
        ew.notLike("refund_status", value);
        return this;
    }

    public TransHistoryCondition orRefundStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("refund_status", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountIsNull() {
        ew.isNull("refund_amount");
        return this;
    }

    public TransHistoryCondition orRefundAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("refund_amount");
        return this;
    }

    public TransHistoryCondition andRefundAmountIsNotNull() {
        ew.isNotNull("refund_amount");
        return this;
    }

    public TransHistoryCondition orRefundAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("refund_amount");
        return this;
    }

    public TransHistoryCondition andRefundAmountEq(Object value) {
        ew.eq("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountNe(Object value) {
        ew.ne("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountGt(Object value) {
        ew.gt("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountGe(Object value) {
        ew.ge("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountLt(Object value) {
        ew.lt("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountLe(Object value) {
        ew.le("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountIn(Object... value) {
        ew.in("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountNotIn(Object... value) {
        ew.notIn("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountBetween(Object value, Object value1) {
        ew.between("refund_amount", value, value1);
        return this;
    }

    public TransHistoryCondition orRefundAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("refund_amount", value, value1);
        return this;
    }

    public TransHistoryCondition andRefundAmountNotBetween(Object value, Object value1) {
        ew.notBetween("refund_amount", value, value1);
        return this;
    }

    public TransHistoryCondition orRefundAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("refund_amount", value, value1);
        return this;
    }

    public TransHistoryCondition andRefundAmountLike(String value) {
        ew.like("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andRefundAmountNotLike(String value) {
        ew.notLike("refund_amount", value);
        return this;
    }

    public TransHistoryCondition orRefundAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("refund_amount", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusIsNull() {
        ew.isNull("reconcile_status");
        return this;
    }

    public TransHistoryCondition orReconcileStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_status");
        return this;
    }

    public TransHistoryCondition andReconcileStatusIsNotNull() {
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransHistoryCondition orReconcileStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransHistoryCondition andReconcileStatusEq(Object value) {
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusNe(Object value) {
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusGt(Object value) {
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusGe(Object value) {
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusLt(Object value) {
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusLe(Object value) {
        ew.le("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusIn(Object... value) {
        ew.in("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusNotIn(Object... value) {
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusBetween(Object value, Object value1) {
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransHistoryCondition orReconcileStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransHistoryCondition andReconcileStatusNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransHistoryCondition orReconcileStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransHistoryCondition andReconcileStatusLike(String value) {
        ew.like("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andReconcileStatusNotLike(String value) {
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition orReconcileStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlIsNull() {
        ew.isNull("trans_callback_url");
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_callback_url");
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlIsNotNull() {
        ew.isNotNull("trans_callback_url");
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_callback_url");
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlEq(Object value) {
        ew.eq("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlNe(Object value) {
        ew.ne("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlGt(Object value) {
        ew.gt("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlGe(Object value) {
        ew.ge("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlLt(Object value) {
        ew.lt("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlLe(Object value) {
        ew.le("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlIn(Object... value) {
        ew.in("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlNotIn(Object... value) {
        ew.notIn("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlBetween(Object value, Object value1) {
        ew.between("trans_callback_url", value, value1);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_callback_url", value, value1);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("trans_callback_url", value, value1);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_callback_url", value, value1);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlLike(String value) {
        ew.like("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andTransCallbackUrlNotLike(String value) {
        ew.notLike("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition orTransCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_callback_url", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeIsNull() {
        ew.isNull("reconcile_time");
        return this;
    }

    public TransHistoryCondition orReconcileTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_time");
        return this;
    }

    public TransHistoryCondition andReconcileTimeIsNotNull() {
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransHistoryCondition orReconcileTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransHistoryCondition andReconcileTimeEq(Object value) {
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeNe(Object value) {
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeGt(Object value) {
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeGe(Object value) {
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeLt(Object value) {
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeLe(Object value) {
        ew.le("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeIn(Object... value) {
        ew.in("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeNotIn(Object... value) {
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeBetween(Object value, Object value1) {
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransHistoryCondition orReconcileTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransHistoryCondition andReconcileTimeNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransHistoryCondition orReconcileTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransHistoryCondition andReconcileTimeLike(String value) {
        ew.like("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileTimeNotLike(String value) {
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition orReconcileTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public TransHistoryCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public TransHistoryCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransHistoryCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransHistoryCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransHistoryCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransHistoryCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransHistoryCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransHistoryCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransHistoryCondition andDescriptionIsNull() {
        ew.isNull("description");
        return this;
    }

    public TransHistoryCondition orDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("description");
        return this;
    }

    public TransHistoryCondition andDescriptionIsNotNull() {
        ew.isNotNull("description");
        return this;
    }

    public TransHistoryCondition orDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("description");
        return this;
    }

    public TransHistoryCondition andDescriptionEq(Object value) {
        ew.eq("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionNe(Object value) {
        ew.ne("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionGt(Object value) {
        ew.gt("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionGe(Object value) {
        ew.ge("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionLt(Object value) {
        ew.lt("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionLe(Object value) {
        ew.le("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionIn(Object... value) {
        ew.in("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionNotIn(Object... value) {
        ew.notIn("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionBetween(Object value, Object value1) {
        ew.between("description", value, value1);
        return this;
    }

    public TransHistoryCondition orDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("description", value, value1);
        return this;
    }

    public TransHistoryCondition andDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("description", value, value1);
        return this;
    }

    public TransHistoryCondition orDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("description", value, value1);
        return this;
    }

    public TransHistoryCondition andDescriptionLike(String value) {
        ew.like("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("description", value);
        return this;
    }

    public TransHistoryCondition andDescriptionNotLike(String value) {
        ew.notLike("description", value);
        return this;
    }

    public TransHistoryCondition orDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("description", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoIsNull() {
        ew.isNull("batch_sub_no");
        return this;
    }

    public TransHistoryCondition orBatchSubNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_sub_no");
        return this;
    }

    public TransHistoryCondition andBatchSubNoIsNotNull() {
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public TransHistoryCondition orBatchSubNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public TransHistoryCondition andBatchSubNoEq(Object value) {
        ew.eq("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoNe(Object value) {
        ew.ne("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoGt(Object value) {
        ew.gt("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoGe(Object value) {
        ew.ge("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoLt(Object value) {
        ew.lt("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoLe(Object value) {
        ew.le("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoIn(Object... value) {
        ew.in("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoNotIn(Object... value) {
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoBetween(Object value, Object value1) {
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public TransHistoryCondition orBatchSubNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public TransHistoryCondition andBatchSubNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public TransHistoryCondition orBatchSubNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public TransHistoryCondition andBatchSubNoLike(String value) {
        ew.like("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andBatchSubNoNotLike(String value) {
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition orBatchSubNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public TransHistoryCondition andCurrencyIsNull() {
        ew.isNull("currency");
        return this;
    }

    public TransHistoryCondition orCurrencyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("currency");
        return this;
    }

    public TransHistoryCondition andCurrencyIsNotNull() {
        ew.isNotNull("currency");
        return this;
    }

    public TransHistoryCondition orCurrencyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("currency");
        return this;
    }

    public TransHistoryCondition andCurrencyEq(Object value) {
        ew.eq("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyNe(Object value) {
        ew.ne("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyGt(Object value) {
        ew.gt("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyGe(Object value) {
        ew.ge("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyLt(Object value) {
        ew.lt("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyLe(Object value) {
        ew.le("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyIn(Object... value) {
        ew.in("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyNotIn(Object... value) {
        ew.notIn("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyBetween(Object value, Object value1) {
        ew.between("currency", value, value1);
        return this;
    }

    public TransHistoryCondition orCurrencyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("currency", value, value1);
        return this;
    }

    public TransHistoryCondition andCurrencyNotBetween(Object value, Object value1) {
        ew.notBetween("currency", value, value1);
        return this;
    }

    public TransHistoryCondition orCurrencyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("currency", value, value1);
        return this;
    }

    public TransHistoryCondition andCurrencyLike(String value) {
        ew.like("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("currency", value);
        return this;
    }

    public TransHistoryCondition andCurrencyNotLike(String value) {
        ew.notLike("currency", value);
        return this;
    }

    public TransHistoryCondition orCurrencyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("currency", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public TransHistoryCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public TransHistoryCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransHistoryCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransHistoryCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransHistoryCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransHistoryCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransHistoryCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransHistoryCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransHistoryCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public TransHistoryCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public TransHistoryCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransHistoryCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransHistoryCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransHistoryCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransHistoryCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransHistoryCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransHistoryCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransHistoryCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public TransHistoryCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public TransHistoryCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public TransHistoryCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public TransHistoryCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public TransHistoryCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public TransHistoryCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransHistoryCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransHistoryCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public TransHistoryCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public TransHistoryCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public TransHistoryCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public TransHistoryCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public TransHistoryCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransHistoryCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransHistoryCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransHistoryCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransHistoryCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public TransHistoryCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public TransHistoryCondition andUserCodeIsNull() {
        ew.isNull("user_code");
        return this;
    }

    public TransHistoryCondition orUserCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_code");
        return this;
    }

    public TransHistoryCondition andUserCodeIsNotNull() {
        ew.isNotNull("user_code");
        return this;
    }

    public TransHistoryCondition orUserCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_code");
        return this;
    }

    public TransHistoryCondition andUserCodeEq(Object value) {
        ew.eq("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeNe(Object value) {
        ew.ne("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeGt(Object value) {
        ew.gt("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeGe(Object value) {
        ew.ge("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeLt(Object value) {
        ew.lt("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeLe(Object value) {
        ew.le("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeIn(Object... value) {
        ew.in("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeNotIn(Object... value) {
        ew.notIn("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeBetween(Object value, Object value1) {
        ew.between("user_code", value, value1);
        return this;
    }

    public TransHistoryCondition orUserCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_code", value, value1);
        return this;
    }

    public TransHistoryCondition andUserCodeNotBetween(Object value, Object value1) {
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public TransHistoryCondition orUserCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public TransHistoryCondition andUserCodeLike(String value) {
        ew.like("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_code", value);
        return this;
    }

    public TransHistoryCondition andUserCodeNotLike(String value) {
        ew.notLike("user_code", value);
        return this;
    }

    public TransHistoryCondition orUserCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_code", value);
        return this;
    }

    public TransHistoryCondition andAccNoIsNull() {
        ew.isNull("acc_no");
        return this;
    }

    public TransHistoryCondition orAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_no");
        return this;
    }

    public TransHistoryCondition andAccNoIsNotNull() {
        ew.isNotNull("acc_no");
        return this;
    }

    public TransHistoryCondition orAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_no");
        return this;
    }

    public TransHistoryCondition andAccNoEq(Object value) {
        ew.eq("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoNe(Object value) {
        ew.ne("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoGt(Object value) {
        ew.gt("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoGe(Object value) {
        ew.ge("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoLt(Object value) {
        ew.lt("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoLe(Object value) {
        ew.le("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoIn(Object... value) {
        ew.in("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoNotIn(Object... value) {
        ew.notIn("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoBetween(Object value, Object value1) {
        ew.between("acc_no", value, value1);
        return this;
    }

    public TransHistoryCondition orAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_no", value, value1);
        return this;
    }

    public TransHistoryCondition andAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public TransHistoryCondition orAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public TransHistoryCondition andAccNoLike(String value) {
        ew.like("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_no", value);
        return this;
    }

    public TransHistoryCondition andAccNoNotLike(String value) {
        ew.notLike("acc_no", value);
        return this;
    }

    public TransHistoryCondition orAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_no", value);
        return this;
    }

    public TransHistoryCondition andMerFeeIsNull() {
        ew.isNull("mer_fee");
        return this;
    }

    public TransHistoryCondition orMerFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_fee");
        return this;
    }

    public TransHistoryCondition andMerFeeIsNotNull() {
        ew.isNotNull("mer_fee");
        return this;
    }

    public TransHistoryCondition orMerFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_fee");
        return this;
    }

    public TransHistoryCondition andMerFeeEq(Object value) {
        ew.eq("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeNe(Object value) {
        ew.ne("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeGt(Object value) {
        ew.gt("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeGe(Object value) {
        ew.ge("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeLt(Object value) {
        ew.lt("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeLe(Object value) {
        ew.le("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeIn(Object... value) {
        ew.in("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeNotIn(Object... value) {
        ew.notIn("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeBetween(Object value, Object value1) {
        ew.between("mer_fee", value, value1);
        return this;
    }

    public TransHistoryCondition orMerFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_fee", value, value1);
        return this;
    }

    public TransHistoryCondition andMerFeeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public TransHistoryCondition orMerFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public TransHistoryCondition andMerFeeLike(String value) {
        ew.like("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andMerFeeNotLike(String value) {
        ew.notLike("mer_fee", value);
        return this;
    }

    public TransHistoryCondition orMerFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeIsNull() {
        ew.isNull("channel_fee");
        return this;
    }

    public TransHistoryCondition orChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_fee");
        return this;
    }

    public TransHistoryCondition andChannelFeeIsNotNull() {
        ew.isNotNull("channel_fee");
        return this;
    }

    public TransHistoryCondition orChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_fee");
        return this;
    }

    public TransHistoryCondition andChannelFeeEq(Object value) {
        ew.eq("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeNe(Object value) {
        ew.ne("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeGt(Object value) {
        ew.gt("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeGe(Object value) {
        ew.ge("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeLt(Object value) {
        ew.lt("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeLe(Object value) {
        ew.le("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeIn(Object... value) {
        ew.in("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeNotIn(Object... value) {
        ew.notIn("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeBetween(Object value, Object value1) {
        ew.between("channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelFeeLike(String value) {
        ew.like("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andChannelFeeNotLike(String value) {
        ew.notLike("channel_fee", value);
        return this;
    }

    public TransHistoryCondition orChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_fee", value);
        return this;
    }

    public TransHistoryCondition andPcFlagIsNull() {
        ew.isNull("pc_flag");
        return this;
    }

    public TransHistoryCondition orPcFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pc_flag");
        return this;
    }

    public TransHistoryCondition andPcFlagIsNotNull() {
        ew.isNotNull("pc_flag");
        return this;
    }

    public TransHistoryCondition orPcFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pc_flag");
        return this;
    }

    public TransHistoryCondition andPcFlagEq(Object value) {
        ew.eq("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagNe(Object value) {
        ew.ne("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagGt(Object value) {
        ew.gt("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagGe(Object value) {
        ew.ge("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagLt(Object value) {
        ew.lt("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagLe(Object value) {
        ew.le("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagIn(Object... value) {
        ew.in("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagNotIn(Object... value) {
        ew.notIn("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagBetween(Object value, Object value1) {
        ew.between("pc_flag", value, value1);
        return this;
    }

    public TransHistoryCondition orPcFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pc_flag", value, value1);
        return this;
    }

    public TransHistoryCondition andPcFlagNotBetween(Object value, Object value1) {
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public TransHistoryCondition orPcFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public TransHistoryCondition andPcFlagLike(String value) {
        ew.like("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andPcFlagNotLike(String value) {
        ew.notLike("pc_flag", value);
        return this;
    }

    public TransHistoryCondition orPcFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pc_flag", value);
        return this;
    }

    public TransHistoryCondition andUserTypeIsNull() {
        ew.isNull("user_type");
        return this;
    }

    public TransHistoryCondition orUserTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_type");
        return this;
    }

    public TransHistoryCondition andUserTypeIsNotNull() {
        ew.isNotNull("user_type");
        return this;
    }

    public TransHistoryCondition orUserTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_type");
        return this;
    }

    public TransHistoryCondition andUserTypeEq(Object value) {
        ew.eq("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeNe(Object value) {
        ew.ne("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeGt(Object value) {
        ew.gt("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeGe(Object value) {
        ew.ge("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeLt(Object value) {
        ew.lt("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeLe(Object value) {
        ew.le("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeIn(Object... value) {
        ew.in("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeNotIn(Object... value) {
        ew.notIn("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeBetween(Object value, Object value1) {
        ew.between("user_type", value, value1);
        return this;
    }

    public TransHistoryCondition orUserTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_type", value, value1);
        return this;
    }

    public TransHistoryCondition andUserTypeNotBetween(Object value, Object value1) {
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public TransHistoryCondition orUserTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public TransHistoryCondition andUserTypeLike(String value) {
        ew.like("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_type", value);
        return this;
    }

    public TransHistoryCondition andUserTypeNotLike(String value) {
        ew.notLike("user_type", value);
        return this;
    }

    public TransHistoryCondition orUserTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_type", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoIsNull() {
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoIsNotNull() {
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoEq(Object value) {
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoNe(Object value) {
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoGt(Object value) {
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoGe(Object value) {
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoLt(Object value) {
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoLe(Object value) {
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoIn(Object... value) {
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoNotIn(Object... value) {
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoBetween(Object value, Object value1) {
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoLike(String value) {
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeAcctNoNotLike(String value) {
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayeeAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameIsNull() {
        ew.isNull("payee_name");
        return this;
    }

    public TransHistoryCondition orPayeeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_name");
        return this;
    }

    public TransHistoryCondition andPayeeNameIsNotNull() {
        ew.isNotNull("payee_name");
        return this;
    }

    public TransHistoryCondition orPayeeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_name");
        return this;
    }

    public TransHistoryCondition andPayeeNameEq(Object value) {
        ew.eq("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameNe(Object value) {
        ew.ne("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameGt(Object value) {
        ew.gt("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameGe(Object value) {
        ew.ge("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameLt(Object value) {
        ew.lt("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameLe(Object value) {
        ew.le("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameIn(Object... value) {
        ew.in("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameNotIn(Object... value) {
        ew.notIn("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameBetween(Object value, Object value1) {
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeNameLike(String value) {
        ew.like("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeNameNotLike(String value) {
        ew.notLike("payee_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_name", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoIsNull() {
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransHistoryCondition orPayerAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransHistoryCondition andPayerAcctNoIsNotNull() {
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransHistoryCondition orPayerAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransHistoryCondition andPayerAcctNoEq(Object value) {
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoNe(Object value) {
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoGt(Object value) {
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoGe(Object value) {
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoLt(Object value) {
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoLe(Object value) {
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoIn(Object... value) {
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoNotIn(Object... value) {
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoBetween(Object value, Object value1) {
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoLike(String value) {
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerAcctNoNotLike(String value) {
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition orPayerAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransHistoryCondition andPayerNameIsNull() {
        ew.isNull("payer_name");
        return this;
    }

    public TransHistoryCondition orPayerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_name");
        return this;
    }

    public TransHistoryCondition andPayerNameIsNotNull() {
        ew.isNotNull("payer_name");
        return this;
    }

    public TransHistoryCondition orPayerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_name");
        return this;
    }

    public TransHistoryCondition andPayerNameEq(Object value) {
        ew.eq("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameNe(Object value) {
        ew.ne("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameGt(Object value) {
        ew.gt("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameGe(Object value) {
        ew.ge("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameLt(Object value) {
        ew.lt("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameLe(Object value) {
        ew.le("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameIn(Object... value) {
        ew.in("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameNotIn(Object... value) {
        ew.notIn("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameBetween(Object value, Object value1) {
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerNameLike(String value) {
        ew.like("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_name", value);
        return this;
    }

    public TransHistoryCondition andPayerNameNotLike(String value) {
        ew.notLike("payer_name", value);
        return this;
    }

    public TransHistoryCondition orPayerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_name", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public TransHistoryCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public TransHistoryCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public TransHistoryCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public TransHistoryCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransHistoryCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransHistoryCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransHistoryCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransHistoryCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public TransHistoryCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public TransHistoryCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdIsNull() {
        ew.isNull("split_info_id");
        return this;
    }

    public TransHistoryCondition orSplitInfoIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_info_id");
        return this;
    }

    public TransHistoryCondition andSplitInfoIdIsNotNull() {
        ew.isNotNull("split_info_id");
        return this;
    }

    public TransHistoryCondition orSplitInfoIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_info_id");
        return this;
    }

    public TransHistoryCondition andSplitInfoIdEq(Object value) {
        ew.eq("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdNe(Object value) {
        ew.ne("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdGt(Object value) {
        ew.gt("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdGe(Object value) {
        ew.ge("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdLt(Object value) {
        ew.lt("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdLe(Object value) {
        ew.le("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdIn(Object... value) {
        ew.in("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdNotIn(Object... value) {
        ew.notIn("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdBetween(Object value, Object value1) {
        ew.between("split_info_id", value, value1);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_info_id", value, value1);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdNotBetween(Object value, Object value1) {
        ew.notBetween("split_info_id", value, value1);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_info_id", value, value1);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdLike(String value) {
        ew.like("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andSplitInfoIdNotLike(String value) {
        ew.notLike("split_info_id", value);
        return this;
    }

    public TransHistoryCondition orSplitInfoIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_info_id", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeIsNull() {
        ew.isNull("mer_settle_type");
        return this;
    }

    public TransHistoryCondition orMerSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_settle_type");
        return this;
    }

    public TransHistoryCondition andMerSettleTypeIsNotNull() {
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public TransHistoryCondition orMerSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public TransHistoryCondition andMerSettleTypeEq(Object value) {
        ew.eq("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeNe(Object value) {
        ew.ne("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeGt(Object value) {
        ew.gt("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeGe(Object value) {
        ew.ge("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeLt(Object value) {
        ew.lt("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeLe(Object value) {
        ew.le("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeIn(Object... value) {
        ew.in("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeNotIn(Object... value) {
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeBetween(Object value, Object value1) {
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeLike(String value) {
        ew.like("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerSettleTypeNotLike(String value) {
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition orMerSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeIsNull() {
        ew.isNull("mer_charge_mode");
        return this;
    }

    public TransHistoryCondition orMerChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_charge_mode");
        return this;
    }

    public TransHistoryCondition andMerChargeModeIsNotNull() {
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public TransHistoryCondition orMerChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public TransHistoryCondition andMerChargeModeEq(Object value) {
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeNe(Object value) {
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeGt(Object value) {
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeGe(Object value) {
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeLt(Object value) {
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeLe(Object value) {
        ew.le("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeIn(Object... value) {
        ew.in("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeNotIn(Object... value) {
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeBetween(Object value, Object value1) {
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition orMerChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition andMerChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition orMerChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition andMerChargeModeLike(String value) {
        ew.like("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andMerChargeModeNotLike(String value) {
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orMerChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeIsNull() {
        ew.isNull("channel_settle_type");
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_type");
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeIsNotNull() {
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeEq(Object value) {
        ew.eq("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeNe(Object value) {
        ew.ne("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeGt(Object value) {
        ew.gt("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeGe(Object value) {
        ew.ge("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeLt(Object value) {
        ew.lt("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeLe(Object value) {
        ew.le("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeIn(Object... value) {
        ew.in("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeNotIn(Object... value) {
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeBetween(Object value, Object value1) {
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeLike(String value) {
        ew.like("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleTypeNotLike(String value) {
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeIsNull() {
        ew.isNull("channel_charge_mode");
        return this;
    }

    public TransHistoryCondition orChannelChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_charge_mode");
        return this;
    }

    public TransHistoryCondition andChannelChargeModeIsNotNull() {
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public TransHistoryCondition orChannelChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public TransHistoryCondition andChannelChargeModeEq(Object value) {
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeNe(Object value) {
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeGt(Object value) {
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeGe(Object value) {
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeLt(Object value) {
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeLe(Object value) {
        ew.le("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeIn(Object... value) {
        ew.in("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeNotIn(Object... value) {
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeBetween(Object value, Object value1) {
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeLike(String value) {
        ew.like("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelChargeModeNotLike(String value) {
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition orChannelChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateIsNull() {
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransHistoryCondition orChannelSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransHistoryCondition andChannelSettleDateIsNotNull() {
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransHistoryCondition orChannelSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransHistoryCondition andChannelSettleDateEq(Object value) {
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateNe(Object value) {
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateGt(Object value) {
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateGe(Object value) {
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateLt(Object value) {
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateLe(Object value) {
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateIn(Object... value) {
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateNotIn(Object... value) {
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateBetween(Object value, Object value1) {
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateLike(String value) {
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andChannelSettleDateNotLike(String value) {
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition orChannelSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeIsNull() {
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeIsNotNull() {
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeEq(Object value) {
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeNe(Object value) {
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeGt(Object value) {
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeGe(Object value) {
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeLt(Object value) {
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeLe(Object value) {
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeIn(Object... value) {
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeNotIn(Object... value) {
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeBetween(Object value, Object value1) {
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeLike(String value) {
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andOrginChannelFeeNotLike(String value) {
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition orOrginChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountIsNull() {
        ew.isNull("income_account");
        return this;
    }

    public TransHistoryCondition orIncomeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account");
        return this;
    }

    public TransHistoryCondition andIncomeAccountIsNotNull() {
        ew.isNotNull("income_account");
        return this;
    }

    public TransHistoryCondition orIncomeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account");
        return this;
    }

    public TransHistoryCondition andIncomeAccountEq(Object value) {
        ew.eq("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNe(Object value) {
        ew.ne("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountGt(Object value) {
        ew.gt("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountGe(Object value) {
        ew.ge("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountLt(Object value) {
        ew.lt("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountLe(Object value) {
        ew.le("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountIn(Object... value) {
        ew.in("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNotIn(Object... value) {
        ew.notIn("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountBetween(Object value, Object value1) {
        ew.between("income_account", value, value1);
        return this;
    }

    public TransHistoryCondition orIncomeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account", value, value1);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public TransHistoryCondition andIncomeAccountLike(String value) {
        ew.like("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNotLike(String value) {
        ew.notLike("income_account", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountIsNull() {
        ew.isNull("payer_account");
        return this;
    }

    public TransHistoryCondition orPayerAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_account");
        return this;
    }

    public TransHistoryCondition andPayerAccountIsNotNull() {
        ew.isNotNull("payer_account");
        return this;
    }

    public TransHistoryCondition orPayerAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_account");
        return this;
    }

    public TransHistoryCondition andPayerAccountEq(Object value) {
        ew.eq("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountNe(Object value) {
        ew.ne("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountGt(Object value) {
        ew.gt("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountGe(Object value) {
        ew.ge("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountLt(Object value) {
        ew.lt("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountLe(Object value) {
        ew.le("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountIn(Object... value) {
        ew.in("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountNotIn(Object... value) {
        ew.notIn("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountBetween(Object value, Object value1) {
        ew.between("payer_account", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_account", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerAccountLike(String value) {
        ew.like("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayerAccountNotLike(String value) {
        ew.notLike("payer_account", value);
        return this;
    }

    public TransHistoryCondition orPayerAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountIsNull() {
        ew.isNull("payee_account");
        return this;
    }

    public TransHistoryCondition orPayeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_account");
        return this;
    }

    public TransHistoryCondition andPayeeAccountIsNotNull() {
        ew.isNotNull("payee_account");
        return this;
    }

    public TransHistoryCondition orPayeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_account");
        return this;
    }

    public TransHistoryCondition andPayeeAccountEq(Object value) {
        ew.eq("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountNe(Object value) {
        ew.ne("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountGt(Object value) {
        ew.gt("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountGe(Object value) {
        ew.ge("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountLt(Object value) {
        ew.lt("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountLe(Object value) {
        ew.le("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountIn(Object... value) {
        ew.in("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountNotIn(Object... value) {
        ew.notIn("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountBetween(Object value, Object value1) {
        ew.between("payee_account", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_account", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeAccountLike(String value) {
        ew.like("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_account", value);
        return this;
    }

    public TransHistoryCondition andPayeeAccountNotLike(String value) {
        ew.notLike("payee_account", value);
        return this;
    }

    public TransHistoryCondition orPayeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountIsNull() {
        ew.isNull("fee_account");
        return this;
    }

    public TransHistoryCondition orFeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account");
        return this;
    }

    public TransHistoryCondition andFeeAccountIsNotNull() {
        ew.isNotNull("fee_account");
        return this;
    }

    public TransHistoryCondition orFeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account");
        return this;
    }

    public TransHistoryCondition andFeeAccountEq(Object value) {
        ew.eq("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNe(Object value) {
        ew.ne("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountGt(Object value) {
        ew.gt("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountGe(Object value) {
        ew.ge("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountLt(Object value) {
        ew.lt("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountLe(Object value) {
        ew.le("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountIn(Object... value) {
        ew.in("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNotIn(Object... value) {
        ew.notIn("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountBetween(Object value, Object value1) {
        ew.between("fee_account", value, value1);
        return this;
    }

    public TransHistoryCondition orFeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account", value, value1);
        return this;
    }

    public TransHistoryCondition andFeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public TransHistoryCondition orFeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public TransHistoryCondition andFeeAccountLike(String value) {
        ew.like("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNotLike(String value) {
        ew.notLike("fee_account", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileIsNull() {
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileIsNotNull() {
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileEq(Object value) {
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileNe(Object value) {
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileGt(Object value) {
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileGe(Object value) {
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileLt(Object value) {
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileLe(Object value) {
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileIn(Object... value) {
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileNotIn(Object... value) {
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileBetween(Object value, Object value1) {
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileNotBetween(Object value, Object value1) {
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileLike(String value) {
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andNeedChannelReconcileNotLike(String value) {
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition orNeedChannelReconcileNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoIsNull() {
        ew.isNull("show_payer_account_no");
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_no");
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoIsNotNull() {
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoEq(Object value) {
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoNe(Object value) {
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoGt(Object value) {
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoGe(Object value) {
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoLt(Object value) {
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoLe(Object value) {
        ew.le("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoIn(Object... value) {
        ew.in("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoNotIn(Object... value) {
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoBetween(Object value, Object value1) {
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoLike(String value) {
        ew.like("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNoNotLike(String value) {
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameIsNull() {
        ew.isNull("show_payer_account_name");
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_name");
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameIsNotNull() {
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameEq(Object value) {
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameNe(Object value) {
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameGt(Object value) {
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameGe(Object value) {
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameLt(Object value) {
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameLe(Object value) {
        ew.le("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameIn(Object... value) {
        ew.in("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameNotIn(Object... value) {
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameBetween(Object value, Object value1) {
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameLike(String value) {
        ew.like("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayerAccountNameNotLike(String value) {
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayerAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoIsNull() {
        ew.isNull("show_payee_account_no");
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_no");
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoIsNotNull() {
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoEq(Object value) {
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoNe(Object value) {
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoGt(Object value) {
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoGe(Object value) {
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoLt(Object value) {
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoLe(Object value) {
        ew.le("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoIn(Object... value) {
        ew.in("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoNotIn(Object... value) {
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoBetween(Object value, Object value1) {
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoLike(String value) {
        ew.like("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNoNotLike(String value) {
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameIsNull() {
        ew.isNull("show_payee_account_name");
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_name");
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameIsNotNull() {
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameEq(Object value) {
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameNe(Object value) {
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameGt(Object value) {
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameGe(Object value) {
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameLt(Object value) {
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameLe(Object value) {
        ew.le("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameIn(Object... value) {
        ew.in("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameNotIn(Object... value) {
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameBetween(Object value, Object value1) {
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameLike(String value) {
        ew.like("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andShowPayeeAccountNameNotLike(String value) {
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition orShowPayeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public TransHistoryCondition andOrderIdIsNull() {
        ew.isNull("order_id");
        return this;
    }

    public TransHistoryCondition orOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_id");
        return this;
    }

    public TransHistoryCondition andOrderIdIsNotNull() {
        ew.isNotNull("order_id");
        return this;
    }

    public TransHistoryCondition orOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_id");
        return this;
    }

    public TransHistoryCondition andOrderIdEq(Object value) {
        ew.eq("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdNe(Object value) {
        ew.ne("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdGt(Object value) {
        ew.gt("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdGe(Object value) {
        ew.ge("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdLt(Object value) {
        ew.lt("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdLe(Object value) {
        ew.le("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdIn(Object... value) {
        ew.in("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdNotIn(Object... value) {
        ew.notIn("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdBetween(Object value, Object value1) {
        ew.between("order_id", value, value1);
        return this;
    }

    public TransHistoryCondition orOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_id", value, value1);
        return this;
    }

    public TransHistoryCondition andOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public TransHistoryCondition orOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public TransHistoryCondition andOrderIdLike(String value) {
        ew.like("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_id", value);
        return this;
    }

    public TransHistoryCondition andOrderIdNotLike(String value) {
        ew.notLike("order_id", value);
        return this;
    }

    public TransHistoryCondition orOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_id", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagIsNull() {
        ew.isNull("elc_make_flag");
        return this;
    }

    public TransHistoryCondition orElcMakeFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("elc_make_flag");
        return this;
    }

    public TransHistoryCondition andElcMakeFlagIsNotNull() {
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public TransHistoryCondition orElcMakeFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public TransHistoryCondition andElcMakeFlagEq(Object value) {
        ew.eq("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagNe(Object value) {
        ew.ne("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagGt(Object value) {
        ew.gt("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagGe(Object value) {
        ew.ge("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagLt(Object value) {
        ew.lt("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagLe(Object value) {
        ew.le("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagIn(Object... value) {
        ew.in("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagNotIn(Object... value) {
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagBetween(Object value, Object value1) {
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagNotBetween(Object value, Object value1) {
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagLike(String value) {
        ew.like("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andElcMakeFlagNotLike(String value) {
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition orElcMakeFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameIsNull() {
        ew.isNull("fee_account_name");
        return this;
    }

    public TransHistoryCondition orFeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account_name");
        return this;
    }

    public TransHistoryCondition andFeeAccountNameIsNotNull() {
        ew.isNotNull("fee_account_name");
        return this;
    }

    public TransHistoryCondition orFeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account_name");
        return this;
    }

    public TransHistoryCondition andFeeAccountNameEq(Object value) {
        ew.eq("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameNe(Object value) {
        ew.ne("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameGt(Object value) {
        ew.gt("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameGe(Object value) {
        ew.ge("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameLt(Object value) {
        ew.lt("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameLe(Object value) {
        ew.le("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameIn(Object... value) {
        ew.in("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameNotIn(Object... value) {
        ew.notIn("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameBetween(Object value, Object value1) {
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameLike(String value) {
        ew.like("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andFeeAccountNameNotLike(String value) {
        ew.notLike("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition orFeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameIsNull() {
        ew.isNull("income_account_name");
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account_name");
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameIsNotNull() {
        ew.isNotNull("income_account_name");
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account_name");
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameEq(Object value) {
        ew.eq("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameNe(Object value) {
        ew.ne("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameGt(Object value) {
        ew.gt("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameGe(Object value) {
        ew.ge("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameLt(Object value) {
        ew.lt("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameLe(Object value) {
        ew.le("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameIn(Object... value) {
        ew.in("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameNotIn(Object... value) {
        ew.notIn("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameBetween(Object value, Object value1) {
        ew.between("income_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameLike(String value) {
        ew.like("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andIncomeAccountNameNotLike(String value) {
        ew.notLike("income_account_name", value);
        return this;
    }

    public TransHistoryCondition orIncomeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameIsNull() {
        ew.isNull("payer_opbk_name");
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_opbk_name");
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameIsNotNull() {
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameEq(Object value) {
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameNe(Object value) {
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameGt(Object value) {
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameGe(Object value) {
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameLt(Object value) {
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameLe(Object value) {
        ew.le("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameIn(Object... value) {
        ew.in("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameNotIn(Object... value) {
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameBetween(Object value, Object value1) {
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameLike(String value) {
        ew.like("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayerOpbkNameNotLike(String value) {
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayerOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameIsNull() {
        ew.isNull("payee_opbk_name");
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_opbk_name");
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameIsNotNull() {
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameEq(Object value) {
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameNe(Object value) {
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameGt(Object value) {
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameGe(Object value) {
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameLt(Object value) {
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameLe(Object value) {
        ew.le("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameIn(Object... value) {
        ew.in("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameNotIn(Object... value) {
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameBetween(Object value, Object value1) {
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameLike(String value) {
        ew.like("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andPayeeOpbkNameNotLike(String value) {
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition orPayeeOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionIsNull() {
        ew.isNull("summary_description");
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("summary_description");
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionIsNotNull() {
        ew.isNotNull("summary_description");
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("summary_description");
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionEq(Object value) {
        ew.eq("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionNe(Object value) {
        ew.ne("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionGt(Object value) {
        ew.gt("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionGe(Object value) {
        ew.ge("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionLt(Object value) {
        ew.lt("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionLe(Object value) {
        ew.le("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionIn(Object... value) {
        ew.in("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionNotIn(Object... value) {
        ew.notIn("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionBetween(Object value, Object value1) {
        ew.between("summary_description", value, value1);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("summary_description", value, value1);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionLike(String value) {
        ew.like("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("summary_description", value);
        return this;
    }

    public TransHistoryCondition andSummaryDescriptionNotLike(String value) {
        ew.notLike("summary_description", value);
        return this;
    }

    public TransHistoryCondition orSummaryDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("summary_description", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusIsNull() {
        ew.isNull("history_status");
        return this;
    }

    public TransHistoryCondition orHistoryStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("history_status");
        return this;
    }

    public TransHistoryCondition andHistoryStatusIsNotNull() {
        ew.isNotNull("history_status");
        return this;
    }

    public TransHistoryCondition orHistoryStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("history_status");
        return this;
    }

    public TransHistoryCondition andHistoryStatusEq(Object value) {
        ew.eq("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusNe(Object value) {
        ew.ne("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusGt(Object value) {
        ew.gt("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusGe(Object value) {
        ew.ge("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusLt(Object value) {
        ew.lt("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusLe(Object value) {
        ew.le("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusIn(Object... value) {
        ew.in("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusNotIn(Object... value) {
        ew.notIn("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusBetween(Object value, Object value1) {
        ew.between("history_status", value, value1);
        return this;
    }

    public TransHistoryCondition orHistoryStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("history_status", value, value1);
        return this;
    }

    public TransHistoryCondition andHistoryStatusNotBetween(Object value, Object value1) {
        ew.notBetween("history_status", value, value1);
        return this;
    }

    public TransHistoryCondition orHistoryStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("history_status", value, value1);
        return this;
    }

    public TransHistoryCondition andHistoryStatusLike(String value) {
        ew.like("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("history_status", value);
        return this;
    }

    public TransHistoryCondition andHistoryStatusNotLike(String value) {
        ew.notLike("history_status", value);
        return this;
    }

    public TransHistoryCondition orHistoryStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("history_status", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeIsNull() {
        ew.isNull("query_time");
        return this;
    }

    public TransHistoryCondition orQueryTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("query_time");
        return this;
    }

    public TransHistoryCondition andQueryTimeIsNotNull() {
        ew.isNotNull("query_time");
        return this;
    }

    public TransHistoryCondition orQueryTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("query_time");
        return this;
    }

    public TransHistoryCondition andQueryTimeEq(Object value) {
        ew.eq("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeNe(Object value) {
        ew.ne("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeGt(Object value) {
        ew.gt("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeGe(Object value) {
        ew.ge("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeLt(Object value) {
        ew.lt("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeLe(Object value) {
        ew.le("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeIn(Object... value) {
        ew.in("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeNotIn(Object... value) {
        ew.notIn("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeBetween(Object value, Object value1) {
        ew.between("query_time", value, value1);
        return this;
    }

    public TransHistoryCondition orQueryTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("query_time", value, value1);
        return this;
    }

    public TransHistoryCondition andQueryTimeNotBetween(Object value, Object value1) {
        ew.notBetween("query_time", value, value1);
        return this;
    }

    public TransHistoryCondition orQueryTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("query_time", value, value1);
        return this;
    }

    public TransHistoryCondition andQueryTimeLike(String value) {
        ew.like("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("query_time", value);
        return this;
    }

    public TransHistoryCondition andQueryTimeNotLike(String value) {
        ew.notLike("query_time", value);
        return this;
    }

    public TransHistoryCondition orQueryTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("query_time", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpIsNull() {
        ew.isNull("remote_ip");
        return this;
    }

    public TransHistoryCondition orRemoteIpIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remote_ip");
        return this;
    }

    public TransHistoryCondition andRemoteIpIsNotNull() {
        ew.isNotNull("remote_ip");
        return this;
    }

    public TransHistoryCondition orRemoteIpIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remote_ip");
        return this;
    }

    public TransHistoryCondition andRemoteIpEq(Object value) {
        ew.eq("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpNe(Object value) {
        ew.ne("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpGt(Object value) {
        ew.gt("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpGe(Object value) {
        ew.ge("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpLt(Object value) {
        ew.lt("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpLe(Object value) {
        ew.le("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpIn(Object... value) {
        ew.in("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpNotIn(Object... value) {
        ew.notIn("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpBetween(Object value, Object value1) {
        ew.between("remote_ip", value, value1);
        return this;
    }

    public TransHistoryCondition orRemoteIpBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remote_ip", value, value1);
        return this;
    }

    public TransHistoryCondition andRemoteIpNotBetween(Object value, Object value1) {
        ew.notBetween("remote_ip", value, value1);
        return this;
    }

    public TransHistoryCondition orRemoteIpNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remote_ip", value, value1);
        return this;
    }

    public TransHistoryCondition andRemoteIpLike(String value) {
        ew.like("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andRemoteIpNotLike(String value) {
        ew.notLike("remote_ip", value);
        return this;
    }

    public TransHistoryCondition orRemoteIpNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remote_ip", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeIsNull() {
        ew.isNull("payment_type");
        return this;
    }

    public TransHistoryCondition orPaymentTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_type");
        return this;
    }

    public TransHistoryCondition andPaymentTypeIsNotNull() {
        ew.isNotNull("payment_type");
        return this;
    }

    public TransHistoryCondition orPaymentTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_type");
        return this;
    }

    public TransHistoryCondition andPaymentTypeEq(Object value) {
        ew.eq("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeNe(Object value) {
        ew.ne("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeGt(Object value) {
        ew.gt("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeGe(Object value) {
        ew.ge("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeLt(Object value) {
        ew.lt("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeLe(Object value) {
        ew.le("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeIn(Object... value) {
        ew.in("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeNotIn(Object... value) {
        ew.notIn("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeBetween(Object value, Object value1) {
        ew.between("payment_type", value, value1);
        return this;
    }

    public TransHistoryCondition orPaymentTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_type", value, value1);
        return this;
    }

    public TransHistoryCondition andPaymentTypeNotBetween(Object value, Object value1) {
        ew.notBetween("payment_type", value, value1);
        return this;
    }

    public TransHistoryCondition orPaymentTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_type", value, value1);
        return this;
    }

    public TransHistoryCondition andPaymentTypeLike(String value) {
        ew.like("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentTypeNotLike(String value) {
        ew.notLike("payment_type", value);
        return this;
    }

    public TransHistoryCondition orPaymentTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_type", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodIsNull() {
        ew.isNull("payment_period");
        return this;
    }

    public TransHistoryCondition orPaymentPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_period");
        return this;
    }

    public TransHistoryCondition andPaymentPeriodIsNotNull() {
        ew.isNotNull("payment_period");
        return this;
    }

    public TransHistoryCondition orPaymentPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_period");
        return this;
    }

    public TransHistoryCondition andPaymentPeriodEq(Object value) {
        ew.eq("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodNe(Object value) {
        ew.ne("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodGt(Object value) {
        ew.gt("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodGe(Object value) {
        ew.ge("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodLt(Object value) {
        ew.lt("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodLe(Object value) {
        ew.le("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodIn(Object... value) {
        ew.in("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodNotIn(Object... value) {
        ew.notIn("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodBetween(Object value, Object value1) {
        ew.between("payment_period", value, value1);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_period", value, value1);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("payment_period", value, value1);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_period", value, value1);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodLike(String value) {
        ew.like("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentPeriodNotLike(String value) {
        ew.notLike("payment_period", value);
        return this;
    }

    public TransHistoryCondition orPaymentPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_period", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusIsNull() {
        ew.isNull("payment_settle_status");
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_settle_status");
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusIsNotNull() {
        ew.isNotNull("payment_settle_status");
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_settle_status");
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusEq(Object value) {
        ew.eq("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusNe(Object value) {
        ew.ne("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusGt(Object value) {
        ew.gt("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusGe(Object value) {
        ew.ge("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusLt(Object value) {
        ew.lt("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusLe(Object value) {
        ew.le("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusIn(Object... value) {
        ew.in("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusNotIn(Object... value) {
        ew.notIn("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusBetween(Object value, Object value1) {
        ew.between("payment_settle_status", value, value1);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_settle_status", value, value1);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusNotBetween(Object value, Object value1) {
        ew.notBetween("payment_settle_status", value, value1);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_settle_status", value, value1);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusLike(String value) {
        ew.like("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition andPaymentSettleStatusNotLike(String value) {
        ew.notLike("payment_settle_status", value);
        return this;
    }

    public TransHistoryCondition orPaymentSettleStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_settle_status", value);
        return this;
    }
}