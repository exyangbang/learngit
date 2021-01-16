package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class TransReexchangeCondition {
    private PlusEntityWrapper<TransReexchange> ew;

    public TransReexchangeCondition() {
        this.ew = new PlusEntityWrapper(TransReexchange.class);
    }

    public static TransReexchangeCondition builder() {
        return new TransReexchangeCondition();
    }

    public PlusEntityWrapper<TransReexchange> build() {
        return this.ew;
    }

    public TransReexchangeCondition or() {
        this.ew.orNew();
        return this;
    }

    public TransReexchangeCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(TransReexchange.class);
    }

    public TransReexchangeCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public TransReexchangeCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public TransReexchangeCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public TransReexchangeCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> TransReexchangeCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> TransReexchangeCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> TransReexchangeCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public TransReexchangeCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public TransReexchangeCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public TransReexchangeCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public TransReexchangeCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public TransReexchangeCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public TransReexchangeCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public TransReexchangeCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public TransReexchangeCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public TransReexchangeCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public TransReexchangeCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public TransReexchangeCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public TransReexchangeCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public TransReexchangeCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public TransReexchangeCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public TransReexchangeCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public TransReexchangeCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public TransReexchangeCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public TransReexchangeCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public TransReexchangeCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public TransReexchangeCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public TransReexchangeCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public TransReexchangeCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public TransReexchangeCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public TransReexchangeCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public TransReexchangeCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public TransReexchangeCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransReexchangeCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransReexchangeCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public TransReexchangeCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public TransReexchangeCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public TransReexchangeCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public TransReexchangeCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public TransReexchangeCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public TransReexchangeCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public TransReexchangeCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public TransReexchangeCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public TransReexchangeCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public TransReexchangeCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public TransReexchangeCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public TransReexchangeCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public TransReexchangeCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public TransReexchangeCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public TransReexchangeCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public TransReexchangeCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public TransReexchangeCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public TransReexchangeCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public TransReexchangeCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public TransReexchangeCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public TransReexchangeCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public TransReexchangeCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public TransReexchangeCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public TransReexchangeCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public TransReexchangeCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public TransReexchangeCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransReexchangeCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransReexchangeCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeIsNull() {
        ew.isNull("client_trans_time");
        return this;
    }

    public TransReexchangeCondition orClientTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_time");
        return this;
    }

    public TransReexchangeCondition andClientTransTimeIsNotNull() {
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransReexchangeCondition orClientTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransReexchangeCondition andClientTransTimeEq(Object value) {
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeNe(Object value) {
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeGt(Object value) {
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeGe(Object value) {
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeLt(Object value) {
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeLe(Object value) {
        ew.le("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeIn(Object... value) {
        ew.in("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeNotIn(Object... value) {
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeBetween(Object value, Object value1) {
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeLike(String value) {
        ew.like("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andClientTransTimeNotLike(String value) {
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition orClientTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public TransReexchangeCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public TransReexchangeCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransReexchangeCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransReexchangeCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransReexchangeCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public TransReexchangeCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public TransReexchangeCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public TransReexchangeCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public TransReexchangeCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public TransReexchangeCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public TransReexchangeCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public TransReexchangeCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public TransReexchangeCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public TransReexchangeCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public TransReexchangeCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransReexchangeCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransReexchangeCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransReexchangeCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransReexchangeCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public TransReexchangeCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public TransReexchangeCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public TransReexchangeCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public TransReexchangeCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public TransReexchangeCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public TransReexchangeCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public TransReexchangeCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public TransReexchangeCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public TransReexchangeCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public TransReexchangeCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public TransReexchangeCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public TransReexchangeCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoIsNull() {
        ew.isNull("server_batch_no");
        return this;
    }

    public TransReexchangeCondition orServerBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_batch_no");
        return this;
    }

    public TransReexchangeCondition andServerBatchNoIsNotNull() {
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransReexchangeCondition orServerBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransReexchangeCondition andServerBatchNoEq(Object value) {
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoNe(Object value) {
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoGt(Object value) {
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoGe(Object value) {
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoLt(Object value) {
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoLe(Object value) {
        ew.le("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoIn(Object... value) {
        ew.in("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoNotIn(Object... value) {
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoBetween(Object value, Object value1) {
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoLike(String value) {
        ew.like("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerBatchNoNotLike(String value) {
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition orServerBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdIsNull() {
        ew.isNull("server_link_id");
        return this;
    }

    public TransReexchangeCondition orServerLinkIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_link_id");
        return this;
    }

    public TransReexchangeCondition andServerLinkIdIsNotNull() {
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransReexchangeCondition orServerLinkIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransReexchangeCondition andServerLinkIdEq(Object value) {
        ew.eq("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdNe(Object value) {
        ew.ne("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdGt(Object value) {
        ew.gt("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdGe(Object value) {
        ew.ge("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdLt(Object value) {
        ew.lt("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdLe(Object value) {
        ew.le("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdIn(Object... value) {
        ew.in("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdNotIn(Object... value) {
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdBetween(Object value, Object value1) {
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdLike(String value) {
        ew.like("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andServerLinkIdNotLike(String value) {
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition orServerLinkIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountIsNull() {
        ew.isNull("trans_amount");
        return this;
    }

    public TransReexchangeCondition orTransAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_amount");
        return this;
    }

    public TransReexchangeCondition andTransAmountIsNotNull() {
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransReexchangeCondition orTransAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransReexchangeCondition andTransAmountEq(Object value) {
        ew.eq("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountNe(Object value) {
        ew.ne("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountGt(Object value) {
        ew.gt("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountGe(Object value) {
        ew.ge("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountLt(Object value) {
        ew.lt("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountLe(Object value) {
        ew.le("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountIn(Object... value) {
        ew.in("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountNotIn(Object... value) {
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountBetween(Object value, Object value1) {
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransAmountNotBetween(Object value, Object value1) {
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransAmountLike(String value) {
        ew.like("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransAmountNotLike(String value) {
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition orTransAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountIsNull() {
        ew.isNull("real_amount");
        return this;
    }

    public TransReexchangeCondition orRealAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_amount");
        return this;
    }

    public TransReexchangeCondition andRealAmountIsNotNull() {
        ew.isNotNull("real_amount");
        return this;
    }

    public TransReexchangeCondition orRealAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_amount");
        return this;
    }

    public TransReexchangeCondition andRealAmountEq(Object value) {
        ew.eq("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountNe(Object value) {
        ew.ne("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountGt(Object value) {
        ew.gt("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountGe(Object value) {
        ew.ge("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountLt(Object value) {
        ew.lt("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountLe(Object value) {
        ew.le("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountIn(Object... value) {
        ew.in("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountNotIn(Object... value) {
        ew.notIn("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountBetween(Object value, Object value1) {
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition orRealAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition andRealAmountNotBetween(Object value, Object value1) {
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition orRealAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransReexchangeCondition andRealAmountLike(String value) {
        ew.like("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andRealAmountNotLike(String value) {
        ew.notLike("real_amount", value);
        return this;
    }

    public TransReexchangeCondition orRealAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_amount", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public TransReexchangeCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public TransReexchangeCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public TransReexchangeCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public TransReexchangeCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public TransReexchangeCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public TransReexchangeCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public TransReexchangeCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public TransReexchangeCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public TransReexchangeCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public TransReexchangeCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public TransReexchangeCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public TransReexchangeCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public TransReexchangeCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public TransReexchangeCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public TransReexchangeCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransReexchangeCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public TransReexchangeCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusIsNull() {
        ew.isNull("reconcile_status");
        return this;
    }

    public TransReexchangeCondition orReconcileStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_status");
        return this;
    }

    public TransReexchangeCondition andReconcileStatusIsNotNull() {
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransReexchangeCondition orReconcileStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransReexchangeCondition andReconcileStatusEq(Object value) {
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusNe(Object value) {
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusGt(Object value) {
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusGe(Object value) {
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusLt(Object value) {
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusLe(Object value) {
        ew.le("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusIn(Object... value) {
        ew.in("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusNotIn(Object... value) {
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusBetween(Object value, Object value1) {
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusLike(String value) {
        ew.like("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileStatusNotLike(String value) {
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition orReconcileStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeIsNull() {
        ew.isNull("reconcile_time");
        return this;
    }

    public TransReexchangeCondition orReconcileTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_time");
        return this;
    }

    public TransReexchangeCondition andReconcileTimeIsNotNull() {
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransReexchangeCondition orReconcileTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransReexchangeCondition andReconcileTimeEq(Object value) {
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeNe(Object value) {
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeGt(Object value) {
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeGe(Object value) {
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeLt(Object value) {
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeLe(Object value) {
        ew.le("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeIn(Object... value) {
        ew.in("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeNotIn(Object... value) {
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeBetween(Object value, Object value1) {
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeLike(String value) {
        ew.like("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileTimeNotLike(String value) {
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition orReconcileTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public TransReexchangeCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public TransReexchangeCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransReexchangeCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransReexchangeCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransReexchangeCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransReexchangeCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransReexchangeCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransReexchangeCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoIsNull() {
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoIsNotNull() {
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoEq(Object value) {
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoNe(Object value) {
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoGt(Object value) {
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoGe(Object value) {
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoLt(Object value) {
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoLe(Object value) {
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoIn(Object... value) {
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoNotIn(Object... value) {
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoBetween(Object value, Object value1) {
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoLike(String value) {
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeAcctNoNotLike(String value) {
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayeeAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameIsNull() {
        ew.isNull("payee_name");
        return this;
    }

    public TransReexchangeCondition orPayeeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_name");
        return this;
    }

    public TransReexchangeCondition andPayeeNameIsNotNull() {
        ew.isNotNull("payee_name");
        return this;
    }

    public TransReexchangeCondition orPayeeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_name");
        return this;
    }

    public TransReexchangeCondition andPayeeNameEq(Object value) {
        ew.eq("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameNe(Object value) {
        ew.ne("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameGt(Object value) {
        ew.gt("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameGe(Object value) {
        ew.ge("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameLt(Object value) {
        ew.lt("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameLe(Object value) {
        ew.le("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameIn(Object... value) {
        ew.in("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameNotIn(Object... value) {
        ew.notIn("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameBetween(Object value, Object value1) {
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayeeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayeeNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayeeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayeeNameLike(String value) {
        ew.like("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayeeNameNotLike(String value) {
        ew.notLike("payee_name", value);
        return this;
    }

    public TransReexchangeCondition orPayeeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoIsNull() {
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoIsNotNull() {
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoEq(Object value) {
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoNe(Object value) {
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoGt(Object value) {
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoGe(Object value) {
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoLt(Object value) {
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoLe(Object value) {
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoIn(Object... value) {
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoNotIn(Object... value) {
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoBetween(Object value, Object value1) {
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoLike(String value) {
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerAcctNoNotLike(String value) {
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition orPayerAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameIsNull() {
        ew.isNull("payer_name");
        return this;
    }

    public TransReexchangeCondition orPayerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_name");
        return this;
    }

    public TransReexchangeCondition andPayerNameIsNotNull() {
        ew.isNotNull("payer_name");
        return this;
    }

    public TransReexchangeCondition orPayerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_name");
        return this;
    }

    public TransReexchangeCondition andPayerNameEq(Object value) {
        ew.eq("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameNe(Object value) {
        ew.ne("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameGt(Object value) {
        ew.gt("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameGe(Object value) {
        ew.ge("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameLt(Object value) {
        ew.lt("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameLe(Object value) {
        ew.le("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameIn(Object... value) {
        ew.in("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameNotIn(Object... value) {
        ew.notIn("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameBetween(Object value, Object value1) {
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayerNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransReexchangeCondition orPayerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransReexchangeCondition andPayerNameLike(String value) {
        ew.like("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andPayerNameNotLike(String value) {
        ew.notLike("payer_name", value);
        return this;
    }

    public TransReexchangeCondition orPayerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_name", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public TransReexchangeCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public TransReexchangeCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public TransReexchangeCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public TransReexchangeCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public TransReexchangeCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateIsNull() {
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateIsNotNull() {
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateEq(Object value) {
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateNe(Object value) {
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateGt(Object value) {
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateGe(Object value) {
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateLt(Object value) {
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateLe(Object value) {
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateIn(Object... value) {
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateNotIn(Object... value) {
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateBetween(Object value, Object value1) {
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateLike(String value) {
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andChannelSettleDateNotLike(String value) {
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition orChannelSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusIsNull() {
        ew.isNull("solve_status");
        return this;
    }

    public TransReexchangeCondition orSolveStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("solve_status");
        return this;
    }

    public TransReexchangeCondition andSolveStatusIsNotNull() {
        ew.isNotNull("solve_status");
        return this;
    }

    public TransReexchangeCondition orSolveStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("solve_status");
        return this;
    }

    public TransReexchangeCondition andSolveStatusEq(Object value) {
        ew.eq("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusNe(Object value) {
        ew.ne("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusGt(Object value) {
        ew.gt("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusGe(Object value) {
        ew.ge("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusLt(Object value) {
        ew.lt("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusLe(Object value) {
        ew.le("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusIn(Object... value) {
        ew.in("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusNotIn(Object... value) {
        ew.notIn("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusBetween(Object value, Object value1) {
        ew.between("solve_status", value, value1);
        return this;
    }

    public TransReexchangeCondition orSolveStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("solve_status", value, value1);
        return this;
    }

    public TransReexchangeCondition andSolveStatusNotBetween(Object value, Object value1) {
        ew.notBetween("solve_status", value, value1);
        return this;
    }

    public TransReexchangeCondition orSolveStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("solve_status", value, value1);
        return this;
    }

    public TransReexchangeCondition andSolveStatusLike(String value) {
        ew.like("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andSolveStatusNotLike(String value) {
        ew.notLike("solve_status", value);
        return this;
    }

    public TransReexchangeCondition orSolveStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("solve_status", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public TransReexchangeCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public TransReexchangeCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransReexchangeCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransReexchangeCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransReexchangeCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransReexchangeCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransReexchangeCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransReexchangeCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public TransReexchangeCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public TransReexchangeCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransReexchangeCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransReexchangeCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public TransReexchangeCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public TransReexchangeCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public TransReexchangeCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public TransReexchangeCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public TransReexchangeCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public TransReexchangeCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransReexchangeCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransReexchangeCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public TransReexchangeCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public TransReexchangeCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public TransReexchangeCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public TransReexchangeCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public TransReexchangeCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransReexchangeCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public TransReexchangeCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public TransReexchangeCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }
}