package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class TransCurrentCondition {
    private PlusEntityWrapper<TransCurrent> ew;

    public TransCurrentCondition() {
        this.ew = new PlusEntityWrapper(TransCurrent.class);
    }

    public static TransCurrentCondition builder() {
        return new TransCurrentCondition();
    }

    public PlusEntityWrapper<TransCurrent> build() {
        return this.ew;
    }

    public TransCurrentCondition or() {
        this.ew.orNew();
        return this;
    }

    public TransCurrentCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(TransCurrent.class);
    }

    public TransCurrentCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public TransCurrentCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public TransCurrentCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public TransCurrentCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> TransCurrentCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> TransCurrentCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> TransCurrentCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public TransCurrentCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public TransCurrentCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public TransCurrentCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public TransCurrentCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public TransCurrentCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public TransCurrentCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public TransCurrentCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public TransCurrentCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public TransCurrentCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public TransCurrentCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public TransCurrentCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public TransCurrentCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public TransCurrentCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public TransCurrentCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public TransCurrentCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public TransCurrentCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public TransCurrentCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public TransCurrentCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public TransCurrentCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public TransCurrentCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public TransCurrentCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public TransCurrentCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public TransCurrentCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public TransCurrentCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public TransCurrentCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public TransCurrentCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransCurrentCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransCurrentCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public TransCurrentCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public TransCurrentCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public TransCurrentCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public TransCurrentCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public TransCurrentCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public TransCurrentCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public TransCurrentCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public TransCurrentCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public TransCurrentCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public TransCurrentCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public TransCurrentCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public TransCurrentCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public TransCurrentCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public TransCurrentCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public TransCurrentCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public TransCurrentCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public TransCurrentCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public TransCurrentCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public TransCurrentCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public TransCurrentCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public TransCurrentCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public TransCurrentCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public TransCurrentCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public TransCurrentCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public TransCurrentCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransCurrentCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransCurrentCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransCurrentCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransCurrentCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public TransCurrentCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public TransCurrentCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public TransCurrentCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public TransCurrentCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransCurrentCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransCurrentCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeIsNull() {
        ew.isNull("client_trans_time");
        return this;
    }

    public TransCurrentCondition orClientTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_time");
        return this;
    }

    public TransCurrentCondition andClientTransTimeIsNotNull() {
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransCurrentCondition orClientTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransCurrentCondition andClientTransTimeEq(Object value) {
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeNe(Object value) {
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeGt(Object value) {
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeGe(Object value) {
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeLt(Object value) {
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeLe(Object value) {
        ew.le("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeIn(Object... value) {
        ew.in("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeNotIn(Object... value) {
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeBetween(Object value, Object value1) {
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition orClientTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition andClientTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition orClientTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition andClientTransTimeLike(String value) {
        ew.like("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andClientTransTimeNotLike(String value) {
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition orClientTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public TransCurrentCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public TransCurrentCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransCurrentCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransCurrentCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransCurrentCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransCurrentCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public TransCurrentCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public TransCurrentCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public TransCurrentCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public TransCurrentCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public TransCurrentCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public TransCurrentCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransCurrentCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransCurrentCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public TransCurrentCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public TransCurrentCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public TransCurrentCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public TransCurrentCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public TransCurrentCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public TransCurrentCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransCurrentCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransCurrentCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransCurrentCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransCurrentCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public TransCurrentCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public TransCurrentCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public TransCurrentCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public TransCurrentCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public TransCurrentCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public TransCurrentCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public TransCurrentCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public TransCurrentCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransCurrentCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransCurrentCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public TransCurrentCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public TransCurrentCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public TransCurrentCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public TransCurrentCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public TransCurrentCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public TransCurrentCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public TransCurrentCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public TransCurrentCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransCurrentCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransCurrentCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public TransCurrentCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public TransCurrentCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoIsNull() {
        ew.isNull("server_batch_no");
        return this;
    }

    public TransCurrentCondition orServerBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_batch_no");
        return this;
    }

    public TransCurrentCondition andServerBatchNoIsNotNull() {
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransCurrentCondition orServerBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransCurrentCondition andServerBatchNoEq(Object value) {
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoNe(Object value) {
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoGt(Object value) {
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoGe(Object value) {
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoLt(Object value) {
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoLe(Object value) {
        ew.le("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoIn(Object... value) {
        ew.in("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoNotIn(Object... value) {
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoBetween(Object value, Object value1) {
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransCurrentCondition orServerBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransCurrentCondition andServerBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransCurrentCondition orServerBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransCurrentCondition andServerBatchNoLike(String value) {
        ew.like("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerBatchNoNotLike(String value) {
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition orServerBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdIsNull() {
        ew.isNull("server_link_id");
        return this;
    }

    public TransCurrentCondition orServerLinkIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_link_id");
        return this;
    }

    public TransCurrentCondition andServerLinkIdIsNotNull() {
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransCurrentCondition orServerLinkIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransCurrentCondition andServerLinkIdEq(Object value) {
        ew.eq("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdNe(Object value) {
        ew.ne("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdGt(Object value) {
        ew.gt("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdGe(Object value) {
        ew.ge("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdLt(Object value) {
        ew.lt("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdLe(Object value) {
        ew.le("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdIn(Object... value) {
        ew.in("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdNotIn(Object... value) {
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdBetween(Object value, Object value1) {
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransCurrentCondition orServerLinkIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransCurrentCondition andServerLinkIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransCurrentCondition orServerLinkIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransCurrentCondition andServerLinkIdLike(String value) {
        ew.like("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andServerLinkIdNotLike(String value) {
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransCurrentCondition orServerLinkIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransCurrentCondition andTransAmountIsNull() {
        ew.isNull("trans_amount");
        return this;
    }

    public TransCurrentCondition orTransAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_amount");
        return this;
    }

    public TransCurrentCondition andTransAmountIsNotNull() {
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransCurrentCondition orTransAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransCurrentCondition andTransAmountEq(Object value) {
        ew.eq("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountNe(Object value) {
        ew.ne("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountGt(Object value) {
        ew.gt("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountGe(Object value) {
        ew.ge("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountLt(Object value) {
        ew.lt("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountLe(Object value) {
        ew.le("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountIn(Object... value) {
        ew.in("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountNotIn(Object... value) {
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountBetween(Object value, Object value1) {
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransCurrentCondition orTransAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransCurrentCondition andTransAmountNotBetween(Object value, Object value1) {
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransCurrentCondition orTransAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransCurrentCondition andTransAmountLike(String value) {
        ew.like("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andTransAmountNotLike(String value) {
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransCurrentCondition orTransAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountIsNull() {
        ew.isNull("real_amount");
        return this;
    }

    public TransCurrentCondition orRealAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_amount");
        return this;
    }

    public TransCurrentCondition andRealAmountIsNotNull() {
        ew.isNotNull("real_amount");
        return this;
    }

    public TransCurrentCondition orRealAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_amount");
        return this;
    }

    public TransCurrentCondition andRealAmountEq(Object value) {
        ew.eq("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountNe(Object value) {
        ew.ne("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountGt(Object value) {
        ew.gt("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountGe(Object value) {
        ew.ge("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountLt(Object value) {
        ew.lt("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountLe(Object value) {
        ew.le("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountIn(Object... value) {
        ew.in("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountNotIn(Object... value) {
        ew.notIn("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountBetween(Object value, Object value1) {
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransCurrentCondition orRealAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransCurrentCondition andRealAmountNotBetween(Object value, Object value1) {
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransCurrentCondition orRealAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransCurrentCondition andRealAmountLike(String value) {
        ew.like("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_amount", value);
        return this;
    }

    public TransCurrentCondition andRealAmountNotLike(String value) {
        ew.notLike("real_amount", value);
        return this;
    }

    public TransCurrentCondition orRealAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_amount", value);
        return this;
    }

    public TransCurrentCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public TransCurrentCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public TransCurrentCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public TransCurrentCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public TransCurrentCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransCurrentCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransCurrentCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransCurrentCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransCurrentCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public TransCurrentCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public TransCurrentCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public TransCurrentCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public TransCurrentCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public TransCurrentCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public TransCurrentCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransCurrentCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransCurrentCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransCurrentCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransCurrentCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public TransCurrentCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public TransCurrentCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public TransCurrentCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public TransCurrentCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public TransCurrentCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public TransCurrentCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransCurrentCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public TransCurrentCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public TransCurrentCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeIsNull() {
        ew.isNull("channel_resp_time");
        return this;
    }

    public TransCurrentCondition orChannelRespTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_time");
        return this;
    }

    public TransCurrentCondition andChannelRespTimeIsNotNull() {
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public TransCurrentCondition orChannelRespTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public TransCurrentCondition andChannelRespTimeEq(Object value) {
        ew.eq("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeNe(Object value) {
        ew.ne("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeGt(Object value) {
        ew.gt("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeGe(Object value) {
        ew.ge("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeLt(Object value) {
        ew.lt("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeLe(Object value) {
        ew.le("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeIn(Object... value) {
        ew.in("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeNotIn(Object... value) {
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeBetween(Object value, Object value1) {
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeLike(String value) {
        ew.like("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespTimeNotLike(String value) {
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition orChannelRespTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeIsNull() {
        ew.isNull("channel_resp_code");
        return this;
    }

    public TransCurrentCondition orChannelRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_code");
        return this;
    }

    public TransCurrentCondition andChannelRespCodeIsNotNull() {
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public TransCurrentCondition orChannelRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public TransCurrentCondition andChannelRespCodeEq(Object value) {
        ew.eq("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeNe(Object value) {
        ew.ne("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeGt(Object value) {
        ew.gt("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeGe(Object value) {
        ew.ge("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeLt(Object value) {
        ew.lt("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeLe(Object value) {
        ew.le("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeIn(Object... value) {
        ew.in("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeNotIn(Object... value) {
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeBetween(Object value, Object value1) {
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeLike(String value) {
        ew.like("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespCodeNotLike(String value) {
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition orChannelRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdIsNull() {
        ew.isNull("channel_resp_id");
        return this;
    }

    public TransCurrentCondition orChannelRespIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_id");
        return this;
    }

    public TransCurrentCondition andChannelRespIdIsNotNull() {
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public TransCurrentCondition orChannelRespIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public TransCurrentCondition andChannelRespIdEq(Object value) {
        ew.eq("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdNe(Object value) {
        ew.ne("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdGt(Object value) {
        ew.gt("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdGe(Object value) {
        ew.ge("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdLt(Object value) {
        ew.lt("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdLe(Object value) {
        ew.le("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdIn(Object... value) {
        ew.in("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdNotIn(Object... value) {
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdBetween(Object value, Object value1) {
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespIdNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespIdLike(String value) {
        ew.like("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespIdNotLike(String value) {
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition orChannelRespIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgIsNull() {
        ew.isNull("channel_resp_msg");
        return this;
    }

    public TransCurrentCondition orChannelRespMsgIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_msg");
        return this;
    }

    public TransCurrentCondition andChannelRespMsgIsNotNull() {
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public TransCurrentCondition orChannelRespMsgIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public TransCurrentCondition andChannelRespMsgEq(Object value) {
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgNe(Object value) {
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgGt(Object value) {
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgGe(Object value) {
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgLt(Object value) {
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgLe(Object value) {
        ew.le("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgIn(Object... value) {
        ew.in("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgNotIn(Object... value) {
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgBetween(Object value, Object value1) {
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgLike(String value) {
        ew.like("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andChannelRespMsgNotLike(String value) {
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition orChannelRespMsgNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public TransCurrentCondition andRespCodeIsNull() {
        ew.isNull("resp_code");
        return this;
    }

    public TransCurrentCondition orRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_code");
        return this;
    }

    public TransCurrentCondition andRespCodeIsNotNull() {
        ew.isNotNull("resp_code");
        return this;
    }

    public TransCurrentCondition orRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_code");
        return this;
    }

    public TransCurrentCondition andRespCodeEq(Object value) {
        ew.eq("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeNe(Object value) {
        ew.ne("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeGt(Object value) {
        ew.gt("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeGe(Object value) {
        ew.ge("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeLt(Object value) {
        ew.lt("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeLe(Object value) {
        ew.le("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeIn(Object... value) {
        ew.in("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeNotIn(Object... value) {
        ew.notIn("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeBetween(Object value, Object value1) {
        ew.between("resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition orRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition andRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition orRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public TransCurrentCondition andRespCodeLike(String value) {
        ew.like("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespCodeNotLike(String value) {
        ew.notLike("resp_code", value);
        return this;
    }

    public TransCurrentCondition orRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_code", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionIsNull() {
        ew.isNull("resp_exception");
        return this;
    }

    public TransCurrentCondition orRespExceptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_exception");
        return this;
    }

    public TransCurrentCondition andRespExceptionIsNotNull() {
        ew.isNotNull("resp_exception");
        return this;
    }

    public TransCurrentCondition orRespExceptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_exception");
        return this;
    }

    public TransCurrentCondition andRespExceptionEq(Object value) {
        ew.eq("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionNe(Object value) {
        ew.ne("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionGt(Object value) {
        ew.gt("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionGe(Object value) {
        ew.ge("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionLt(Object value) {
        ew.lt("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionLe(Object value) {
        ew.le("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionIn(Object... value) {
        ew.in("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionNotIn(Object... value) {
        ew.notIn("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionBetween(Object value, Object value1) {
        ew.between("resp_exception", value, value1);
        return this;
    }

    public TransCurrentCondition orRespExceptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_exception", value, value1);
        return this;
    }

    public TransCurrentCondition andRespExceptionNotBetween(Object value, Object value1) {
        ew.notBetween("resp_exception", value, value1);
        return this;
    }

    public TransCurrentCondition orRespExceptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_exception", value, value1);
        return this;
    }

    public TransCurrentCondition andRespExceptionLike(String value) {
        ew.like("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespExceptionNotLike(String value) {
        ew.notLike("resp_exception", value);
        return this;
    }

    public TransCurrentCondition orRespExceptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_exception", value);
        return this;
    }

    public TransCurrentCondition andRespMessageIsNull() {
        ew.isNull("resp_message");
        return this;
    }

    public TransCurrentCondition orRespMessageIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_message");
        return this;
    }

    public TransCurrentCondition andRespMessageIsNotNull() {
        ew.isNotNull("resp_message");
        return this;
    }

    public TransCurrentCondition orRespMessageIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_message");
        return this;
    }

    public TransCurrentCondition andRespMessageEq(Object value) {
        ew.eq("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageNe(Object value) {
        ew.ne("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageGt(Object value) {
        ew.gt("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageGe(Object value) {
        ew.ge("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageLt(Object value) {
        ew.lt("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageLe(Object value) {
        ew.le("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageIn(Object... value) {
        ew.in("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageNotIn(Object... value) {
        ew.notIn("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageBetween(Object value, Object value1) {
        ew.between("resp_message", value, value1);
        return this;
    }

    public TransCurrentCondition orRespMessageBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_message", value, value1);
        return this;
    }

    public TransCurrentCondition andRespMessageNotBetween(Object value, Object value1) {
        ew.notBetween("resp_message", value, value1);
        return this;
    }

    public TransCurrentCondition orRespMessageNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_message", value, value1);
        return this;
    }

    public TransCurrentCondition andRespMessageLike(String value) {
        ew.like("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRespMessageNotLike(String value) {
        ew.notLike("resp_message", value);
        return this;
    }

    public TransCurrentCondition orRespMessageNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_message", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusIsNull() {
        ew.isNull("revoke_status");
        return this;
    }

    public TransCurrentCondition orRevokeStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("revoke_status");
        return this;
    }

    public TransCurrentCondition andRevokeStatusIsNotNull() {
        ew.isNotNull("revoke_status");
        return this;
    }

    public TransCurrentCondition orRevokeStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("revoke_status");
        return this;
    }

    public TransCurrentCondition andRevokeStatusEq(Object value) {
        ew.eq("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusNe(Object value) {
        ew.ne("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusGt(Object value) {
        ew.gt("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusGe(Object value) {
        ew.ge("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusLt(Object value) {
        ew.lt("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusLe(Object value) {
        ew.le("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusIn(Object... value) {
        ew.in("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusNotIn(Object... value) {
        ew.notIn("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusBetween(Object value, Object value1) {
        ew.between("revoke_status", value, value1);
        return this;
    }

    public TransCurrentCondition orRevokeStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("revoke_status", value, value1);
        return this;
    }

    public TransCurrentCondition andRevokeStatusNotBetween(Object value, Object value1) {
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public TransCurrentCondition orRevokeStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public TransCurrentCondition andRevokeStatusLike(String value) {
        ew.like("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRevokeStatusNotLike(String value) {
        ew.notLike("revoke_status", value);
        return this;
    }

    public TransCurrentCondition orRevokeStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("revoke_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusIsNull() {
        ew.isNull("refund_status");
        return this;
    }

    public TransCurrentCondition orRefundStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("refund_status");
        return this;
    }

    public TransCurrentCondition andRefundStatusIsNotNull() {
        ew.isNotNull("refund_status");
        return this;
    }

    public TransCurrentCondition orRefundStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("refund_status");
        return this;
    }

    public TransCurrentCondition andRefundStatusEq(Object value) {
        ew.eq("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusNe(Object value) {
        ew.ne("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusGt(Object value) {
        ew.gt("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusGe(Object value) {
        ew.ge("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusLt(Object value) {
        ew.lt("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusLe(Object value) {
        ew.le("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusIn(Object... value) {
        ew.in("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusNotIn(Object... value) {
        ew.notIn("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusBetween(Object value, Object value1) {
        ew.between("refund_status", value, value1);
        return this;
    }

    public TransCurrentCondition orRefundStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("refund_status", value, value1);
        return this;
    }

    public TransCurrentCondition andRefundStatusNotBetween(Object value, Object value1) {
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public TransCurrentCondition orRefundStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public TransCurrentCondition andRefundStatusLike(String value) {
        ew.like("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundStatusNotLike(String value) {
        ew.notLike("refund_status", value);
        return this;
    }

    public TransCurrentCondition orRefundStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("refund_status", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountIsNull() {
        ew.isNull("refund_amount");
        return this;
    }

    public TransCurrentCondition orRefundAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("refund_amount");
        return this;
    }

    public TransCurrentCondition andRefundAmountIsNotNull() {
        ew.isNotNull("refund_amount");
        return this;
    }

    public TransCurrentCondition orRefundAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("refund_amount");
        return this;
    }

    public TransCurrentCondition andRefundAmountEq(Object value) {
        ew.eq("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountNe(Object value) {
        ew.ne("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountGt(Object value) {
        ew.gt("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountGe(Object value) {
        ew.ge("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountLt(Object value) {
        ew.lt("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountLe(Object value) {
        ew.le("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountIn(Object... value) {
        ew.in("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountNotIn(Object... value) {
        ew.notIn("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountBetween(Object value, Object value1) {
        ew.between("refund_amount", value, value1);
        return this;
    }

    public TransCurrentCondition orRefundAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("refund_amount", value, value1);
        return this;
    }

    public TransCurrentCondition andRefundAmountNotBetween(Object value, Object value1) {
        ew.notBetween("refund_amount", value, value1);
        return this;
    }

    public TransCurrentCondition orRefundAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("refund_amount", value, value1);
        return this;
    }

    public TransCurrentCondition andRefundAmountLike(String value) {
        ew.like("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andRefundAmountNotLike(String value) {
        ew.notLike("refund_amount", value);
        return this;
    }

    public TransCurrentCondition orRefundAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("refund_amount", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusIsNull() {
        ew.isNull("reconcile_status");
        return this;
    }

    public TransCurrentCondition orReconcileStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_status");
        return this;
    }

    public TransCurrentCondition andReconcileStatusIsNotNull() {
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransCurrentCondition orReconcileStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransCurrentCondition andReconcileStatusEq(Object value) {
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusNe(Object value) {
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusGt(Object value) {
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusGe(Object value) {
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusLt(Object value) {
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusLe(Object value) {
        ew.le("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusIn(Object... value) {
        ew.in("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusNotIn(Object... value) {
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusBetween(Object value, Object value1) {
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransCurrentCondition orReconcileStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransCurrentCondition andReconcileStatusNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransCurrentCondition orReconcileStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransCurrentCondition andReconcileStatusLike(String value) {
        ew.like("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andReconcileStatusNotLike(String value) {
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition orReconcileStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlIsNull() {
        ew.isNull("trans_callback_url");
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_callback_url");
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlIsNotNull() {
        ew.isNotNull("trans_callback_url");
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_callback_url");
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlEq(Object value) {
        ew.eq("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlNe(Object value) {
        ew.ne("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlGt(Object value) {
        ew.gt("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlGe(Object value) {
        ew.ge("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlLt(Object value) {
        ew.lt("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlLe(Object value) {
        ew.le("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlIn(Object... value) {
        ew.in("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlNotIn(Object... value) {
        ew.notIn("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlBetween(Object value, Object value1) {
        ew.between("trans_callback_url", value, value1);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_callback_url", value, value1);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("trans_callback_url", value, value1);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_callback_url", value, value1);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlLike(String value) {
        ew.like("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andTransCallbackUrlNotLike(String value) {
        ew.notLike("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition orTransCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_callback_url", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeIsNull() {
        ew.isNull("reconcile_time");
        return this;
    }

    public TransCurrentCondition orReconcileTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_time");
        return this;
    }

    public TransCurrentCondition andReconcileTimeIsNotNull() {
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransCurrentCondition orReconcileTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransCurrentCondition andReconcileTimeEq(Object value) {
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeNe(Object value) {
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeGt(Object value) {
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeGe(Object value) {
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeLt(Object value) {
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeLe(Object value) {
        ew.le("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeIn(Object... value) {
        ew.in("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeNotIn(Object... value) {
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeBetween(Object value, Object value1) {
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransCurrentCondition orReconcileTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransCurrentCondition andReconcileTimeNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransCurrentCondition orReconcileTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransCurrentCondition andReconcileTimeLike(String value) {
        ew.like("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileTimeNotLike(String value) {
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition orReconcileTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public TransCurrentCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public TransCurrentCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransCurrentCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransCurrentCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransCurrentCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransCurrentCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransCurrentCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransCurrentCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransCurrentCondition andDescriptionIsNull() {
        ew.isNull("description");
        return this;
    }

    public TransCurrentCondition orDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("description");
        return this;
    }

    public TransCurrentCondition andDescriptionIsNotNull() {
        ew.isNotNull("description");
        return this;
    }

    public TransCurrentCondition orDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("description");
        return this;
    }

    public TransCurrentCondition andDescriptionEq(Object value) {
        ew.eq("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionNe(Object value) {
        ew.ne("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionGt(Object value) {
        ew.gt("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionGe(Object value) {
        ew.ge("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionLt(Object value) {
        ew.lt("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionLe(Object value) {
        ew.le("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionIn(Object... value) {
        ew.in("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionNotIn(Object... value) {
        ew.notIn("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionBetween(Object value, Object value1) {
        ew.between("description", value, value1);
        return this;
    }

    public TransCurrentCondition orDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("description", value, value1);
        return this;
    }

    public TransCurrentCondition andDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("description", value, value1);
        return this;
    }

    public TransCurrentCondition orDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("description", value, value1);
        return this;
    }

    public TransCurrentCondition andDescriptionLike(String value) {
        ew.like("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("description", value);
        return this;
    }

    public TransCurrentCondition andDescriptionNotLike(String value) {
        ew.notLike("description", value);
        return this;
    }

    public TransCurrentCondition orDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("description", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoIsNull() {
        ew.isNull("batch_sub_no");
        return this;
    }

    public TransCurrentCondition orBatchSubNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_sub_no");
        return this;
    }

    public TransCurrentCondition andBatchSubNoIsNotNull() {
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public TransCurrentCondition orBatchSubNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public TransCurrentCondition andBatchSubNoEq(Object value) {
        ew.eq("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoNe(Object value) {
        ew.ne("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoGt(Object value) {
        ew.gt("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoGe(Object value) {
        ew.ge("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoLt(Object value) {
        ew.lt("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoLe(Object value) {
        ew.le("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoIn(Object... value) {
        ew.in("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoNotIn(Object... value) {
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoBetween(Object value, Object value1) {
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public TransCurrentCondition orBatchSubNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public TransCurrentCondition andBatchSubNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public TransCurrentCondition orBatchSubNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public TransCurrentCondition andBatchSubNoLike(String value) {
        ew.like("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andBatchSubNoNotLike(String value) {
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition orBatchSubNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public TransCurrentCondition andCurrencyIsNull() {
        ew.isNull("currency");
        return this;
    }

    public TransCurrentCondition orCurrencyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("currency");
        return this;
    }

    public TransCurrentCondition andCurrencyIsNotNull() {
        ew.isNotNull("currency");
        return this;
    }

    public TransCurrentCondition orCurrencyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("currency");
        return this;
    }

    public TransCurrentCondition andCurrencyEq(Object value) {
        ew.eq("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyNe(Object value) {
        ew.ne("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyGt(Object value) {
        ew.gt("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyGe(Object value) {
        ew.ge("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyLt(Object value) {
        ew.lt("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyLe(Object value) {
        ew.le("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyIn(Object... value) {
        ew.in("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyNotIn(Object... value) {
        ew.notIn("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyBetween(Object value, Object value1) {
        ew.between("currency", value, value1);
        return this;
    }

    public TransCurrentCondition orCurrencyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("currency", value, value1);
        return this;
    }

    public TransCurrentCondition andCurrencyNotBetween(Object value, Object value1) {
        ew.notBetween("currency", value, value1);
        return this;
    }

    public TransCurrentCondition orCurrencyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("currency", value, value1);
        return this;
    }

    public TransCurrentCondition andCurrencyLike(String value) {
        ew.like("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("currency", value);
        return this;
    }

    public TransCurrentCondition andCurrencyNotLike(String value) {
        ew.notLike("currency", value);
        return this;
    }

    public TransCurrentCondition orCurrencyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("currency", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public TransCurrentCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public TransCurrentCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransCurrentCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransCurrentCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransCurrentCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransCurrentCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransCurrentCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransCurrentCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransCurrentCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public TransCurrentCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public TransCurrentCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransCurrentCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransCurrentCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransCurrentCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransCurrentCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransCurrentCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransCurrentCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransCurrentCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public TransCurrentCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public TransCurrentCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public TransCurrentCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public TransCurrentCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public TransCurrentCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public TransCurrentCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransCurrentCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransCurrentCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public TransCurrentCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public TransCurrentCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public TransCurrentCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public TransCurrentCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public TransCurrentCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransCurrentCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransCurrentCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransCurrentCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransCurrentCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public TransCurrentCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public TransCurrentCondition andUserCodeIsNull() {
        ew.isNull("user_code");
        return this;
    }

    public TransCurrentCondition orUserCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_code");
        return this;
    }

    public TransCurrentCondition andUserCodeIsNotNull() {
        ew.isNotNull("user_code");
        return this;
    }

    public TransCurrentCondition orUserCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_code");
        return this;
    }

    public TransCurrentCondition andUserCodeEq(Object value) {
        ew.eq("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeNe(Object value) {
        ew.ne("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeGt(Object value) {
        ew.gt("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeGe(Object value) {
        ew.ge("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeLt(Object value) {
        ew.lt("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeLe(Object value) {
        ew.le("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeIn(Object... value) {
        ew.in("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeNotIn(Object... value) {
        ew.notIn("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeBetween(Object value, Object value1) {
        ew.between("user_code", value, value1);
        return this;
    }

    public TransCurrentCondition orUserCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_code", value, value1);
        return this;
    }

    public TransCurrentCondition andUserCodeNotBetween(Object value, Object value1) {
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public TransCurrentCondition orUserCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public TransCurrentCondition andUserCodeLike(String value) {
        ew.like("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_code", value);
        return this;
    }

    public TransCurrentCondition andUserCodeNotLike(String value) {
        ew.notLike("user_code", value);
        return this;
    }

    public TransCurrentCondition orUserCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_code", value);
        return this;
    }

    public TransCurrentCondition andAccNoIsNull() {
        ew.isNull("acc_no");
        return this;
    }

    public TransCurrentCondition orAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_no");
        return this;
    }

    public TransCurrentCondition andAccNoIsNotNull() {
        ew.isNotNull("acc_no");
        return this;
    }

    public TransCurrentCondition orAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_no");
        return this;
    }

    public TransCurrentCondition andAccNoEq(Object value) {
        ew.eq("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoNe(Object value) {
        ew.ne("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoGt(Object value) {
        ew.gt("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoGe(Object value) {
        ew.ge("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoLt(Object value) {
        ew.lt("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoLe(Object value) {
        ew.le("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoIn(Object... value) {
        ew.in("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoNotIn(Object... value) {
        ew.notIn("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoBetween(Object value, Object value1) {
        ew.between("acc_no", value, value1);
        return this;
    }

    public TransCurrentCondition orAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_no", value, value1);
        return this;
    }

    public TransCurrentCondition andAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public TransCurrentCondition orAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public TransCurrentCondition andAccNoLike(String value) {
        ew.like("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_no", value);
        return this;
    }

    public TransCurrentCondition andAccNoNotLike(String value) {
        ew.notLike("acc_no", value);
        return this;
    }

    public TransCurrentCondition orAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_no", value);
        return this;
    }

    public TransCurrentCondition andMerFeeIsNull() {
        ew.isNull("mer_fee");
        return this;
    }

    public TransCurrentCondition orMerFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_fee");
        return this;
    }

    public TransCurrentCondition andMerFeeIsNotNull() {
        ew.isNotNull("mer_fee");
        return this;
    }

    public TransCurrentCondition orMerFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_fee");
        return this;
    }

    public TransCurrentCondition andMerFeeEq(Object value) {
        ew.eq("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeNe(Object value) {
        ew.ne("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeGt(Object value) {
        ew.gt("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeGe(Object value) {
        ew.ge("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeLt(Object value) {
        ew.lt("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeLe(Object value) {
        ew.le("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeIn(Object... value) {
        ew.in("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeNotIn(Object... value) {
        ew.notIn("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeBetween(Object value, Object value1) {
        ew.between("mer_fee", value, value1);
        return this;
    }

    public TransCurrentCondition orMerFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_fee", value, value1);
        return this;
    }

    public TransCurrentCondition andMerFeeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public TransCurrentCondition orMerFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public TransCurrentCondition andMerFeeLike(String value) {
        ew.like("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andMerFeeNotLike(String value) {
        ew.notLike("mer_fee", value);
        return this;
    }

    public TransCurrentCondition orMerFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeIsNull() {
        ew.isNull("channel_fee");
        return this;
    }

    public TransCurrentCondition orChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_fee");
        return this;
    }

    public TransCurrentCondition andChannelFeeIsNotNull() {
        ew.isNotNull("channel_fee");
        return this;
    }

    public TransCurrentCondition orChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_fee");
        return this;
    }

    public TransCurrentCondition andChannelFeeEq(Object value) {
        ew.eq("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeNe(Object value) {
        ew.ne("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeGt(Object value) {
        ew.gt("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeGe(Object value) {
        ew.ge("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeLt(Object value) {
        ew.lt("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeLe(Object value) {
        ew.le("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeIn(Object... value) {
        ew.in("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeNotIn(Object... value) {
        ew.notIn("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeBetween(Object value, Object value1) {
        ew.between("channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelFeeLike(String value) {
        ew.like("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andChannelFeeNotLike(String value) {
        ew.notLike("channel_fee", value);
        return this;
    }

    public TransCurrentCondition orChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_fee", value);
        return this;
    }

    public TransCurrentCondition andPcFlagIsNull() {
        ew.isNull("pc_flag");
        return this;
    }

    public TransCurrentCondition orPcFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pc_flag");
        return this;
    }

    public TransCurrentCondition andPcFlagIsNotNull() {
        ew.isNotNull("pc_flag");
        return this;
    }

    public TransCurrentCondition orPcFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pc_flag");
        return this;
    }

    public TransCurrentCondition andPcFlagEq(Object value) {
        ew.eq("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagNe(Object value) {
        ew.ne("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagGt(Object value) {
        ew.gt("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagGe(Object value) {
        ew.ge("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagLt(Object value) {
        ew.lt("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagLe(Object value) {
        ew.le("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagIn(Object... value) {
        ew.in("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagNotIn(Object... value) {
        ew.notIn("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagBetween(Object value, Object value1) {
        ew.between("pc_flag", value, value1);
        return this;
    }

    public TransCurrentCondition orPcFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pc_flag", value, value1);
        return this;
    }

    public TransCurrentCondition andPcFlagNotBetween(Object value, Object value1) {
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public TransCurrentCondition orPcFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public TransCurrentCondition andPcFlagLike(String value) {
        ew.like("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andPcFlagNotLike(String value) {
        ew.notLike("pc_flag", value);
        return this;
    }

    public TransCurrentCondition orPcFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pc_flag", value);
        return this;
    }

    public TransCurrentCondition andUserTypeIsNull() {
        ew.isNull("user_type");
        return this;
    }

    public TransCurrentCondition orUserTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_type");
        return this;
    }

    public TransCurrentCondition andUserTypeIsNotNull() {
        ew.isNotNull("user_type");
        return this;
    }

    public TransCurrentCondition orUserTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_type");
        return this;
    }

    public TransCurrentCondition andUserTypeEq(Object value) {
        ew.eq("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeNe(Object value) {
        ew.ne("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeGt(Object value) {
        ew.gt("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeGe(Object value) {
        ew.ge("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeLt(Object value) {
        ew.lt("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeLe(Object value) {
        ew.le("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeIn(Object... value) {
        ew.in("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeNotIn(Object... value) {
        ew.notIn("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeBetween(Object value, Object value1) {
        ew.between("user_type", value, value1);
        return this;
    }

    public TransCurrentCondition orUserTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_type", value, value1);
        return this;
    }

    public TransCurrentCondition andUserTypeNotBetween(Object value, Object value1) {
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public TransCurrentCondition orUserTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public TransCurrentCondition andUserTypeLike(String value) {
        ew.like("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_type", value);
        return this;
    }

    public TransCurrentCondition andUserTypeNotLike(String value) {
        ew.notLike("user_type", value);
        return this;
    }

    public TransCurrentCondition orUserTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_type", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoIsNull() {
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoIsNotNull() {
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoEq(Object value) {
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoNe(Object value) {
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoGt(Object value) {
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoGe(Object value) {
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoLt(Object value) {
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoLe(Object value) {
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoIn(Object... value) {
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoNotIn(Object... value) {
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoBetween(Object value, Object value1) {
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoLike(String value) {
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeAcctNoNotLike(String value) {
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayeeAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameIsNull() {
        ew.isNull("payee_name");
        return this;
    }

    public TransCurrentCondition orPayeeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_name");
        return this;
    }

    public TransCurrentCondition andPayeeNameIsNotNull() {
        ew.isNotNull("payee_name");
        return this;
    }

    public TransCurrentCondition orPayeeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_name");
        return this;
    }

    public TransCurrentCondition andPayeeNameEq(Object value) {
        ew.eq("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameNe(Object value) {
        ew.ne("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameGt(Object value) {
        ew.gt("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameGe(Object value) {
        ew.ge("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameLt(Object value) {
        ew.lt("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameLe(Object value) {
        ew.le("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameIn(Object... value) {
        ew.in("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameNotIn(Object... value) {
        ew.notIn("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameBetween(Object value, Object value1) {
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeNameLike(String value) {
        ew.like("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeNameNotLike(String value) {
        ew.notLike("payee_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_name", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoIsNull() {
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransCurrentCondition orPayerAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransCurrentCondition andPayerAcctNoIsNotNull() {
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransCurrentCondition orPayerAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransCurrentCondition andPayerAcctNoEq(Object value) {
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoNe(Object value) {
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoGt(Object value) {
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoGe(Object value) {
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoLt(Object value) {
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoLe(Object value) {
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoIn(Object... value) {
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoNotIn(Object... value) {
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoBetween(Object value, Object value1) {
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoLike(String value) {
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerAcctNoNotLike(String value) {
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition orPayerAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransCurrentCondition andPayerNameIsNull() {
        ew.isNull("payer_name");
        return this;
    }

    public TransCurrentCondition orPayerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_name");
        return this;
    }

    public TransCurrentCondition andPayerNameIsNotNull() {
        ew.isNotNull("payer_name");
        return this;
    }

    public TransCurrentCondition orPayerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_name");
        return this;
    }

    public TransCurrentCondition andPayerNameEq(Object value) {
        ew.eq("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameNe(Object value) {
        ew.ne("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameGt(Object value) {
        ew.gt("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameGe(Object value) {
        ew.ge("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameLt(Object value) {
        ew.lt("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameLe(Object value) {
        ew.le("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameIn(Object... value) {
        ew.in("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameNotIn(Object... value) {
        ew.notIn("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameBetween(Object value, Object value1) {
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerNameLike(String value) {
        ew.like("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_name", value);
        return this;
    }

    public TransCurrentCondition andPayerNameNotLike(String value) {
        ew.notLike("payer_name", value);
        return this;
    }

    public TransCurrentCondition orPayerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_name", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public TransCurrentCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public TransCurrentCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public TransCurrentCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public TransCurrentCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransCurrentCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransCurrentCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransCurrentCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransCurrentCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public TransCurrentCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public TransCurrentCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdIsNull() {
        ew.isNull("split_info_id");
        return this;
    }

    public TransCurrentCondition orSplitInfoIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_info_id");
        return this;
    }

    public TransCurrentCondition andSplitInfoIdIsNotNull() {
        ew.isNotNull("split_info_id");
        return this;
    }

    public TransCurrentCondition orSplitInfoIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_info_id");
        return this;
    }

    public TransCurrentCondition andSplitInfoIdEq(Object value) {
        ew.eq("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdNe(Object value) {
        ew.ne("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdGt(Object value) {
        ew.gt("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdGe(Object value) {
        ew.ge("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdLt(Object value) {
        ew.lt("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdLe(Object value) {
        ew.le("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdIn(Object... value) {
        ew.in("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdNotIn(Object... value) {
        ew.notIn("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdBetween(Object value, Object value1) {
        ew.between("split_info_id", value, value1);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_info_id", value, value1);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdNotBetween(Object value, Object value1) {
        ew.notBetween("split_info_id", value, value1);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_info_id", value, value1);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdLike(String value) {
        ew.like("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andSplitInfoIdNotLike(String value) {
        ew.notLike("split_info_id", value);
        return this;
    }

    public TransCurrentCondition orSplitInfoIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_info_id", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeIsNull() {
        ew.isNull("mer_settle_type");
        return this;
    }

    public TransCurrentCondition orMerSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_settle_type");
        return this;
    }

    public TransCurrentCondition andMerSettleTypeIsNotNull() {
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public TransCurrentCondition orMerSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public TransCurrentCondition andMerSettleTypeEq(Object value) {
        ew.eq("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeNe(Object value) {
        ew.ne("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeGt(Object value) {
        ew.gt("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeGe(Object value) {
        ew.ge("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeLt(Object value) {
        ew.lt("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeLe(Object value) {
        ew.le("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeIn(Object... value) {
        ew.in("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeNotIn(Object... value) {
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeBetween(Object value, Object value1) {
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeLike(String value) {
        ew.like("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerSettleTypeNotLike(String value) {
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition orMerSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeIsNull() {
        ew.isNull("mer_charge_mode");
        return this;
    }

    public TransCurrentCondition orMerChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_charge_mode");
        return this;
    }

    public TransCurrentCondition andMerChargeModeIsNotNull() {
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public TransCurrentCondition orMerChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public TransCurrentCondition andMerChargeModeEq(Object value) {
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeNe(Object value) {
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeGt(Object value) {
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeGe(Object value) {
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeLt(Object value) {
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeLe(Object value) {
        ew.le("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeIn(Object... value) {
        ew.in("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeNotIn(Object... value) {
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeBetween(Object value, Object value1) {
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition orMerChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition andMerChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition orMerChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition andMerChargeModeLike(String value) {
        ew.like("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andMerChargeModeNotLike(String value) {
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orMerChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeIsNull() {
        ew.isNull("channel_settle_type");
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_type");
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeIsNotNull() {
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeEq(Object value) {
        ew.eq("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeNe(Object value) {
        ew.ne("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeGt(Object value) {
        ew.gt("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeGe(Object value) {
        ew.ge("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeLt(Object value) {
        ew.lt("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeLe(Object value) {
        ew.le("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeIn(Object... value) {
        ew.in("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeNotIn(Object... value) {
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeBetween(Object value, Object value1) {
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeLike(String value) {
        ew.like("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleTypeNotLike(String value) {
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeIsNull() {
        ew.isNull("channel_charge_mode");
        return this;
    }

    public TransCurrentCondition orChannelChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_charge_mode");
        return this;
    }

    public TransCurrentCondition andChannelChargeModeIsNotNull() {
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public TransCurrentCondition orChannelChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public TransCurrentCondition andChannelChargeModeEq(Object value) {
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeNe(Object value) {
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeGt(Object value) {
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeGe(Object value) {
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeLt(Object value) {
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeLe(Object value) {
        ew.le("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeIn(Object... value) {
        ew.in("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeNotIn(Object... value) {
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeBetween(Object value, Object value1) {
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeLike(String value) {
        ew.like("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelChargeModeNotLike(String value) {
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition orChannelChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateIsNull() {
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransCurrentCondition orChannelSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransCurrentCondition andChannelSettleDateIsNotNull() {
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransCurrentCondition orChannelSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransCurrentCondition andChannelSettleDateEq(Object value) {
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateNe(Object value) {
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateGt(Object value) {
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateGe(Object value) {
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateLt(Object value) {
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateLe(Object value) {
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateIn(Object... value) {
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateNotIn(Object... value) {
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateBetween(Object value, Object value1) {
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateLike(String value) {
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andChannelSettleDateNotLike(String value) {
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition orChannelSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeIsNull() {
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeIsNotNull() {
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeEq(Object value) {
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeNe(Object value) {
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeGt(Object value) {
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeGe(Object value) {
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeLt(Object value) {
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeLe(Object value) {
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeIn(Object... value) {
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeNotIn(Object... value) {
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeBetween(Object value, Object value1) {
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeLike(String value) {
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andOrginChannelFeeNotLike(String value) {
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition orOrginChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountIsNull() {
        ew.isNull("payer_account");
        return this;
    }

    public TransCurrentCondition orPayerAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_account");
        return this;
    }

    public TransCurrentCondition andPayerAccountIsNotNull() {
        ew.isNotNull("payer_account");
        return this;
    }

    public TransCurrentCondition orPayerAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_account");
        return this;
    }

    public TransCurrentCondition andPayerAccountEq(Object value) {
        ew.eq("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountNe(Object value) {
        ew.ne("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountGt(Object value) {
        ew.gt("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountGe(Object value) {
        ew.ge("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountLt(Object value) {
        ew.lt("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountLe(Object value) {
        ew.le("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountIn(Object... value) {
        ew.in("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountNotIn(Object... value) {
        ew.notIn("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountBetween(Object value, Object value1) {
        ew.between("payer_account", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_account", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerAccountLike(String value) {
        ew.like("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayerAccountNotLike(String value) {
        ew.notLike("payer_account", value);
        return this;
    }

    public TransCurrentCondition orPayerAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountIsNull() {
        ew.isNull("payee_account");
        return this;
    }

    public TransCurrentCondition orPayeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_account");
        return this;
    }

    public TransCurrentCondition andPayeeAccountIsNotNull() {
        ew.isNotNull("payee_account");
        return this;
    }

    public TransCurrentCondition orPayeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_account");
        return this;
    }

    public TransCurrentCondition andPayeeAccountEq(Object value) {
        ew.eq("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountNe(Object value) {
        ew.ne("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountGt(Object value) {
        ew.gt("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountGe(Object value) {
        ew.ge("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountLt(Object value) {
        ew.lt("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountLe(Object value) {
        ew.le("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountIn(Object... value) {
        ew.in("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountNotIn(Object... value) {
        ew.notIn("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountBetween(Object value, Object value1) {
        ew.between("payee_account", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_account", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeAccountLike(String value) {
        ew.like("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_account", value);
        return this;
    }

    public TransCurrentCondition andPayeeAccountNotLike(String value) {
        ew.notLike("payee_account", value);
        return this;
    }

    public TransCurrentCondition orPayeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountIsNull() {
        ew.isNull("fee_account");
        return this;
    }

    public TransCurrentCondition orFeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account");
        return this;
    }

    public TransCurrentCondition andFeeAccountIsNotNull() {
        ew.isNotNull("fee_account");
        return this;
    }

    public TransCurrentCondition orFeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account");
        return this;
    }

    public TransCurrentCondition andFeeAccountEq(Object value) {
        ew.eq("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNe(Object value) {
        ew.ne("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountGt(Object value) {
        ew.gt("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountGe(Object value) {
        ew.ge("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountLt(Object value) {
        ew.lt("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountLe(Object value) {
        ew.le("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountIn(Object... value) {
        ew.in("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNotIn(Object... value) {
        ew.notIn("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountBetween(Object value, Object value1) {
        ew.between("fee_account", value, value1);
        return this;
    }

    public TransCurrentCondition orFeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account", value, value1);
        return this;
    }

    public TransCurrentCondition andFeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public TransCurrentCondition orFeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public TransCurrentCondition andFeeAccountLike(String value) {
        ew.like("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNotLike(String value) {
        ew.notLike("fee_account", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountIsNull() {
        ew.isNull("income_account");
        return this;
    }

    public TransCurrentCondition orIncomeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account");
        return this;
    }

    public TransCurrentCondition andIncomeAccountIsNotNull() {
        ew.isNotNull("income_account");
        return this;
    }

    public TransCurrentCondition orIncomeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account");
        return this;
    }

    public TransCurrentCondition andIncomeAccountEq(Object value) {
        ew.eq("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNe(Object value) {
        ew.ne("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountGt(Object value) {
        ew.gt("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountGe(Object value) {
        ew.ge("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountLt(Object value) {
        ew.lt("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountLe(Object value) {
        ew.le("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountIn(Object... value) {
        ew.in("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNotIn(Object... value) {
        ew.notIn("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountBetween(Object value, Object value1) {
        ew.between("income_account", value, value1);
        return this;
    }

    public TransCurrentCondition orIncomeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account", value, value1);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public TransCurrentCondition andIncomeAccountLike(String value) {
        ew.like("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNotLike(String value) {
        ew.notLike("income_account", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileIsNull() {
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileIsNotNull() {
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileEq(Object value) {
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileNe(Object value) {
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileGt(Object value) {
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileGe(Object value) {
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileLt(Object value) {
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileLe(Object value) {
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileIn(Object... value) {
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileNotIn(Object... value) {
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileBetween(Object value, Object value1) {
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileNotBetween(Object value, Object value1) {
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileLike(String value) {
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andNeedChannelReconcileNotLike(String value) {
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition orNeedChannelReconcileNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoIsNull() {
        ew.isNull("show_payer_account_no");
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_no");
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoIsNotNull() {
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoEq(Object value) {
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoNe(Object value) {
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoGt(Object value) {
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoGe(Object value) {
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoLt(Object value) {
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoLe(Object value) {
        ew.le("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoIn(Object... value) {
        ew.in("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoNotIn(Object... value) {
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoBetween(Object value, Object value1) {
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoLike(String value) {
        ew.like("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNoNotLike(String value) {
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameIsNull() {
        ew.isNull("show_payer_account_name");
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_name");
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameIsNotNull() {
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameEq(Object value) {
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameNe(Object value) {
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameGt(Object value) {
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameGe(Object value) {
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameLt(Object value) {
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameLe(Object value) {
        ew.le("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameIn(Object... value) {
        ew.in("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameNotIn(Object... value) {
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameBetween(Object value, Object value1) {
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameLike(String value) {
        ew.like("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayerAccountNameNotLike(String value) {
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayerAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoIsNull() {
        ew.isNull("show_payee_account_no");
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_no");
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoIsNotNull() {
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoEq(Object value) {
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoNe(Object value) {
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoGt(Object value) {
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoGe(Object value) {
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoLt(Object value) {
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoLe(Object value) {
        ew.le("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoIn(Object... value) {
        ew.in("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoNotIn(Object... value) {
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoBetween(Object value, Object value1) {
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoLike(String value) {
        ew.like("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNoNotLike(String value) {
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameIsNull() {
        ew.isNull("show_payee_account_name");
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_name");
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameIsNotNull() {
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameEq(Object value) {
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameNe(Object value) {
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameGt(Object value) {
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameGe(Object value) {
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameLt(Object value) {
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameLe(Object value) {
        ew.le("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameIn(Object... value) {
        ew.in("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameNotIn(Object... value) {
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameBetween(Object value, Object value1) {
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameLike(String value) {
        ew.like("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andShowPayeeAccountNameNotLike(String value) {
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition orShowPayeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public TransCurrentCondition andOrderIdIsNull() {
        ew.isNull("order_id");
        return this;
    }

    public TransCurrentCondition orOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_id");
        return this;
    }

    public TransCurrentCondition andOrderIdIsNotNull() {
        ew.isNotNull("order_id");
        return this;
    }

    public TransCurrentCondition orOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_id");
        return this;
    }

    public TransCurrentCondition andOrderIdEq(Object value) {
        ew.eq("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdNe(Object value) {
        ew.ne("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdGt(Object value) {
        ew.gt("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdGe(Object value) {
        ew.ge("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdLt(Object value) {
        ew.lt("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdLe(Object value) {
        ew.le("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdIn(Object... value) {
        ew.in("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdNotIn(Object... value) {
        ew.notIn("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdBetween(Object value, Object value1) {
        ew.between("order_id", value, value1);
        return this;
    }

    public TransCurrentCondition orOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_id", value, value1);
        return this;
    }

    public TransCurrentCondition andOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public TransCurrentCondition orOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public TransCurrentCondition andOrderIdLike(String value) {
        ew.like("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_id", value);
        return this;
    }

    public TransCurrentCondition andOrderIdNotLike(String value) {
        ew.notLike("order_id", value);
        return this;
    }

    public TransCurrentCondition orOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_id", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagIsNull() {
        ew.isNull("elc_make_flag");
        return this;
    }

    public TransCurrentCondition orElcMakeFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("elc_make_flag");
        return this;
    }

    public TransCurrentCondition andElcMakeFlagIsNotNull() {
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public TransCurrentCondition orElcMakeFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public TransCurrentCondition andElcMakeFlagEq(Object value) {
        ew.eq("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagNe(Object value) {
        ew.ne("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagGt(Object value) {
        ew.gt("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagGe(Object value) {
        ew.ge("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagLt(Object value) {
        ew.lt("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagLe(Object value) {
        ew.le("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagIn(Object... value) {
        ew.in("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagNotIn(Object... value) {
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagBetween(Object value, Object value1) {
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagNotBetween(Object value, Object value1) {
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagLike(String value) {
        ew.like("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andElcMakeFlagNotLike(String value) {
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition orElcMakeFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameIsNull() {
        ew.isNull("fee_account_name");
        return this;
    }

    public TransCurrentCondition orFeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account_name");
        return this;
    }

    public TransCurrentCondition andFeeAccountNameIsNotNull() {
        ew.isNotNull("fee_account_name");
        return this;
    }

    public TransCurrentCondition orFeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account_name");
        return this;
    }

    public TransCurrentCondition andFeeAccountNameEq(Object value) {
        ew.eq("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameNe(Object value) {
        ew.ne("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameGt(Object value) {
        ew.gt("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameGe(Object value) {
        ew.ge("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameLt(Object value) {
        ew.lt("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameLe(Object value) {
        ew.le("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameIn(Object... value) {
        ew.in("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameNotIn(Object... value) {
        ew.notIn("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameBetween(Object value, Object value1) {
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameLike(String value) {
        ew.like("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andFeeAccountNameNotLike(String value) {
        ew.notLike("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition orFeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameIsNull() {
        ew.isNull("income_account_name");
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account_name");
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameIsNotNull() {
        ew.isNotNull("income_account_name");
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account_name");
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameEq(Object value) {
        ew.eq("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameNe(Object value) {
        ew.ne("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameGt(Object value) {
        ew.gt("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameGe(Object value) {
        ew.ge("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameLt(Object value) {
        ew.lt("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameLe(Object value) {
        ew.le("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameIn(Object... value) {
        ew.in("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameNotIn(Object... value) {
        ew.notIn("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameBetween(Object value, Object value1) {
        ew.between("income_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameLike(String value) {
        ew.like("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andIncomeAccountNameNotLike(String value) {
        ew.notLike("income_account_name", value);
        return this;
    }

    public TransCurrentCondition orIncomeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameIsNull() {
        ew.isNull("payer_opbk_name");
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_opbk_name");
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameIsNotNull() {
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameEq(Object value) {
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameNe(Object value) {
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameGt(Object value) {
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameGe(Object value) {
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameLt(Object value) {
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameLe(Object value) {
        ew.le("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameIn(Object... value) {
        ew.in("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameNotIn(Object... value) {
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameBetween(Object value, Object value1) {
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameLike(String value) {
        ew.like("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayerOpbkNameNotLike(String value) {
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayerOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameIsNull() {
        ew.isNull("payee_opbk_name");
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_opbk_name");
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameIsNotNull() {
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameEq(Object value) {
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameNe(Object value) {
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameGt(Object value) {
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameGe(Object value) {
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameLt(Object value) {
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameLe(Object value) {
        ew.le("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameIn(Object... value) {
        ew.in("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameNotIn(Object... value) {
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameBetween(Object value, Object value1) {
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameLike(String value) {
        ew.like("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andPayeeOpbkNameNotLike(String value) {
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition orPayeeOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionIsNull() {
        ew.isNull("summary_description");
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("summary_description");
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionIsNotNull() {
        ew.isNotNull("summary_description");
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("summary_description");
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionEq(Object value) {
        ew.eq("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionNe(Object value) {
        ew.ne("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionGt(Object value) {
        ew.gt("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionGe(Object value) {
        ew.ge("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionLt(Object value) {
        ew.lt("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionLe(Object value) {
        ew.le("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionIn(Object... value) {
        ew.in("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionNotIn(Object... value) {
        ew.notIn("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionBetween(Object value, Object value1) {
        ew.between("summary_description", value, value1);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("summary_description", value, value1);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionLike(String value) {
        ew.like("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("summary_description", value);
        return this;
    }

    public TransCurrentCondition andSummaryDescriptionNotLike(String value) {
        ew.notLike("summary_description", value);
        return this;
    }

    public TransCurrentCondition orSummaryDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("summary_description", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusIsNull() {
        ew.isNull("history_status");
        return this;
    }

    public TransCurrentCondition orHistoryStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("history_status");
        return this;
    }

    public TransCurrentCondition andHistoryStatusIsNotNull() {
        ew.isNotNull("history_status");
        return this;
    }

    public TransCurrentCondition orHistoryStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("history_status");
        return this;
    }

    public TransCurrentCondition andHistoryStatusEq(Object value) {
        ew.eq("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusNe(Object value) {
        ew.ne("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusGt(Object value) {
        ew.gt("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusGe(Object value) {
        ew.ge("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusLt(Object value) {
        ew.lt("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusLe(Object value) {
        ew.le("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusIn(Object... value) {
        ew.in("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusNotIn(Object... value) {
        ew.notIn("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusBetween(Object value, Object value1) {
        ew.between("history_status", value, value1);
        return this;
    }

    public TransCurrentCondition orHistoryStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("history_status", value, value1);
        return this;
    }

    public TransCurrentCondition andHistoryStatusNotBetween(Object value, Object value1) {
        ew.notBetween("history_status", value, value1);
        return this;
    }

    public TransCurrentCondition orHistoryStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("history_status", value, value1);
        return this;
    }

    public TransCurrentCondition andHistoryStatusLike(String value) {
        ew.like("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("history_status", value);
        return this;
    }

    public TransCurrentCondition andHistoryStatusNotLike(String value) {
        ew.notLike("history_status", value);
        return this;
    }

    public TransCurrentCondition orHistoryStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("history_status", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeIsNull() {
        ew.isNull("query_time");
        return this;
    }

    public TransCurrentCondition orQueryTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("query_time");
        return this;
    }

    public TransCurrentCondition andQueryTimeIsNotNull() {
        ew.isNotNull("query_time");
        return this;
    }

    public TransCurrentCondition orQueryTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("query_time");
        return this;
    }

    public TransCurrentCondition andQueryTimeEq(Object value) {
        ew.eq("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeNe(Object value) {
        ew.ne("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeGt(Object value) {
        ew.gt("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeGe(Object value) {
        ew.ge("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeLt(Object value) {
        ew.lt("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeLe(Object value) {
        ew.le("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeIn(Object... value) {
        ew.in("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeNotIn(Object... value) {
        ew.notIn("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeBetween(Object value, Object value1) {
        ew.between("query_time", value, value1);
        return this;
    }

    public TransCurrentCondition orQueryTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("query_time", value, value1);
        return this;
    }

    public TransCurrentCondition andQueryTimeNotBetween(Object value, Object value1) {
        ew.notBetween("query_time", value, value1);
        return this;
    }

    public TransCurrentCondition orQueryTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("query_time", value, value1);
        return this;
    }

    public TransCurrentCondition andQueryTimeLike(String value) {
        ew.like("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("query_time", value);
        return this;
    }

    public TransCurrentCondition andQueryTimeNotLike(String value) {
        ew.notLike("query_time", value);
        return this;
    }

    public TransCurrentCondition orQueryTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("query_time", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpIsNull() {
        ew.isNull("remote_ip");
        return this;
    }

    public TransCurrentCondition orRemoteIpIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remote_ip");
        return this;
    }

    public TransCurrentCondition andRemoteIpIsNotNull() {
        ew.isNotNull("remote_ip");
        return this;
    }

    public TransCurrentCondition orRemoteIpIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remote_ip");
        return this;
    }

    public TransCurrentCondition andRemoteIpEq(Object value) {
        ew.eq("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpNe(Object value) {
        ew.ne("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpGt(Object value) {
        ew.gt("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpGe(Object value) {
        ew.ge("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpLt(Object value) {
        ew.lt("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpLe(Object value) {
        ew.le("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpIn(Object... value) {
        ew.in("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpNotIn(Object... value) {
        ew.notIn("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpBetween(Object value, Object value1) {
        ew.between("remote_ip", value, value1);
        return this;
    }

    public TransCurrentCondition orRemoteIpBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remote_ip", value, value1);
        return this;
    }

    public TransCurrentCondition andRemoteIpNotBetween(Object value, Object value1) {
        ew.notBetween("remote_ip", value, value1);
        return this;
    }

    public TransCurrentCondition orRemoteIpNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remote_ip", value, value1);
        return this;
    }

    public TransCurrentCondition andRemoteIpLike(String value) {
        ew.like("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andRemoteIpNotLike(String value) {
        ew.notLike("remote_ip", value);
        return this;
    }

    public TransCurrentCondition orRemoteIpNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remote_ip", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeIsNull() {
        ew.isNull("payment_type");
        return this;
    }

    public TransCurrentCondition orPaymentTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_type");
        return this;
    }

    public TransCurrentCondition andPaymentTypeIsNotNull() {
        ew.isNotNull("payment_type");
        return this;
    }

    public TransCurrentCondition orPaymentTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_type");
        return this;
    }

    public TransCurrentCondition andPaymentTypeEq(Object value) {
        ew.eq("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeNe(Object value) {
        ew.ne("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeGt(Object value) {
        ew.gt("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeGe(Object value) {
        ew.ge("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeLt(Object value) {
        ew.lt("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeLe(Object value) {
        ew.le("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeIn(Object... value) {
        ew.in("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeNotIn(Object... value) {
        ew.notIn("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeBetween(Object value, Object value1) {
        ew.between("payment_type", value, value1);
        return this;
    }

    public TransCurrentCondition orPaymentTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_type", value, value1);
        return this;
    }

    public TransCurrentCondition andPaymentTypeNotBetween(Object value, Object value1) {
        ew.notBetween("payment_type", value, value1);
        return this;
    }

    public TransCurrentCondition orPaymentTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_type", value, value1);
        return this;
    }

    public TransCurrentCondition andPaymentTypeLike(String value) {
        ew.like("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentTypeNotLike(String value) {
        ew.notLike("payment_type", value);
        return this;
    }

    public TransCurrentCondition orPaymentTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_type", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodIsNull() {
        ew.isNull("payment_period");
        return this;
    }

    public TransCurrentCondition orPaymentPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_period");
        return this;
    }

    public TransCurrentCondition andPaymentPeriodIsNotNull() {
        ew.isNotNull("payment_period");
        return this;
    }

    public TransCurrentCondition orPaymentPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_period");
        return this;
    }

    public TransCurrentCondition andPaymentPeriodEq(Object value) {
        ew.eq("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodNe(Object value) {
        ew.ne("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodGt(Object value) {
        ew.gt("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodGe(Object value) {
        ew.ge("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodLt(Object value) {
        ew.lt("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodLe(Object value) {
        ew.le("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodIn(Object... value) {
        ew.in("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodNotIn(Object... value) {
        ew.notIn("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodBetween(Object value, Object value1) {
        ew.between("payment_period", value, value1);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_period", value, value1);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("payment_period", value, value1);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_period", value, value1);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodLike(String value) {
        ew.like("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentPeriodNotLike(String value) {
        ew.notLike("payment_period", value);
        return this;
    }

    public TransCurrentCondition orPaymentPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_period", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusIsNull() {
        ew.isNull("payment_settle_status");
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_settle_status");
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusIsNotNull() {
        ew.isNotNull("payment_settle_status");
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_settle_status");
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusEq(Object value) {
        ew.eq("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusNe(Object value) {
        ew.ne("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusGt(Object value) {
        ew.gt("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusGe(Object value) {
        ew.ge("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusLt(Object value) {
        ew.lt("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusLe(Object value) {
        ew.le("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusIn(Object... value) {
        ew.in("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusNotIn(Object... value) {
        ew.notIn("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusBetween(Object value, Object value1) {
        ew.between("payment_settle_status", value, value1);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_settle_status", value, value1);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusNotBetween(Object value, Object value1) {
        ew.notBetween("payment_settle_status", value, value1);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_settle_status", value, value1);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusLike(String value) {
        ew.like("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition andPaymentSettleStatusNotLike(String value) {
        ew.notLike("payment_settle_status", value);
        return this;
    }

    public TransCurrentCondition orPaymentSettleStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_settle_status", value);
        return this;
    }
}