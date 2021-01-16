package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class TransParamFailCondition {
    private PlusEntityWrapper<TransParamFail> ew;

    public TransParamFailCondition() {
        this.ew = new PlusEntityWrapper(TransParamFail.class);
    }

    public static TransParamFailCondition builder() {
        return new TransParamFailCondition();
    }

    public PlusEntityWrapper<TransParamFail> build() {
        return this.ew;
    }

    public TransParamFailCondition or() {
        this.ew.orNew();
        return this;
    }

    public TransParamFailCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(TransParamFail.class);
    }

    public TransParamFailCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public TransParamFailCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public TransParamFailCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public TransParamFailCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> TransParamFailCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> TransParamFailCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> TransParamFailCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public TransParamFailCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public TransParamFailCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public TransParamFailCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public TransParamFailCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public TransParamFailCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public TransParamFailCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public TransParamFailCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public TransParamFailCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public TransParamFailCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public TransParamFailCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public TransParamFailCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public TransParamFailCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public TransParamFailCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public TransParamFailCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public TransParamFailCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public TransParamFailCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public TransParamFailCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public TransParamFailCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public TransParamFailCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public TransParamFailCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public TransParamFailCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public TransParamFailCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public TransParamFailCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public TransParamFailCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public TransParamFailCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public TransParamFailCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransParamFailCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public TransParamFailCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public TransParamFailCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public TransParamFailCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public TransParamFailCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public TransParamFailCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public TransParamFailCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public TransParamFailCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public TransParamFailCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public TransParamFailCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public TransParamFailCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public TransParamFailCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public TransParamFailCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public TransParamFailCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public TransParamFailCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public TransParamFailCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public TransParamFailCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public TransParamFailCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public TransParamFailCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public TransParamFailCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public TransParamFailCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public TransParamFailCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public TransParamFailCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public TransParamFailCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public TransParamFailCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public TransParamFailCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public TransParamFailCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransParamFailCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public TransParamFailCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransParamFailCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public TransParamFailCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public TransParamFailCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public TransParamFailCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public TransParamFailCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public TransParamFailCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransParamFailCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public TransParamFailCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeIsNull() {
        ew.isNull("client_trans_time");
        return this;
    }

    public TransParamFailCondition orClientTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_time");
        return this;
    }

    public TransParamFailCondition andClientTransTimeIsNotNull() {
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransParamFailCondition orClientTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_time");
        return this;
    }

    public TransParamFailCondition andClientTransTimeEq(Object value) {
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeNe(Object value) {
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeGt(Object value) {
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeGe(Object value) {
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeLt(Object value) {
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeLe(Object value) {
        ew.le("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeIn(Object... value) {
        ew.in("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeNotIn(Object... value) {
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeBetween(Object value, Object value1) {
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition orClientTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition andClientTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition orClientTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition andClientTransTimeLike(String value) {
        ew.like("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andClientTransTimeNotLike(String value) {
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition orClientTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_time", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public TransParamFailCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public TransParamFailCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransParamFailCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public TransParamFailCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public TransParamFailCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public TransParamFailCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public TransParamFailCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public TransParamFailCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public TransParamFailCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public TransParamFailCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public TransParamFailCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public TransParamFailCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransParamFailCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public TransParamFailCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public TransParamFailCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public TransParamFailCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public TransParamFailCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public TransParamFailCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public TransParamFailCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public TransParamFailCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransParamFailCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public TransParamFailCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransParamFailCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public TransParamFailCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public TransParamFailCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public TransParamFailCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public TransParamFailCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public TransParamFailCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public TransParamFailCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public TransParamFailCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public TransParamFailCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public TransParamFailCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransParamFailCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public TransParamFailCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public TransParamFailCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public TransParamFailCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public TransParamFailCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public TransParamFailCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public TransParamFailCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public TransParamFailCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public TransParamFailCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public TransParamFailCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransParamFailCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public TransParamFailCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public TransParamFailCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public TransParamFailCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoIsNull() {
        ew.isNull("server_batch_no");
        return this;
    }

    public TransParamFailCondition orServerBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_batch_no");
        return this;
    }

    public TransParamFailCondition andServerBatchNoIsNotNull() {
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransParamFailCondition orServerBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_batch_no");
        return this;
    }

    public TransParamFailCondition andServerBatchNoEq(Object value) {
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoNe(Object value) {
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoGt(Object value) {
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoGe(Object value) {
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoLt(Object value) {
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoLe(Object value) {
        ew.le("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoIn(Object... value) {
        ew.in("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoNotIn(Object... value) {
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoBetween(Object value, Object value1) {
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransParamFailCondition orServerBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public TransParamFailCondition andServerBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransParamFailCondition orServerBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public TransParamFailCondition andServerBatchNoLike(String value) {
        ew.like("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerBatchNoNotLike(String value) {
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition orServerBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_batch_no", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdIsNull() {
        ew.isNull("server_link_id");
        return this;
    }

    public TransParamFailCondition orServerLinkIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_link_id");
        return this;
    }

    public TransParamFailCondition andServerLinkIdIsNotNull() {
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransParamFailCondition orServerLinkIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_link_id");
        return this;
    }

    public TransParamFailCondition andServerLinkIdEq(Object value) {
        ew.eq("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdNe(Object value) {
        ew.ne("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdGt(Object value) {
        ew.gt("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdGe(Object value) {
        ew.ge("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdLt(Object value) {
        ew.lt("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdLe(Object value) {
        ew.le("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdIn(Object... value) {
        ew.in("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdNotIn(Object... value) {
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdBetween(Object value, Object value1) {
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransParamFailCondition orServerLinkIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_link_id", value, value1);
        return this;
    }

    public TransParamFailCondition andServerLinkIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransParamFailCondition orServerLinkIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_link_id", value, value1);
        return this;
    }

    public TransParamFailCondition andServerLinkIdLike(String value) {
        ew.like("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andServerLinkIdNotLike(String value) {
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransParamFailCondition orServerLinkIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_link_id", value);
        return this;
    }

    public TransParamFailCondition andTransAmountIsNull() {
        ew.isNull("trans_amount");
        return this;
    }

    public TransParamFailCondition orTransAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_amount");
        return this;
    }

    public TransParamFailCondition andTransAmountIsNotNull() {
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransParamFailCondition orTransAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_amount");
        return this;
    }

    public TransParamFailCondition andTransAmountEq(Object value) {
        ew.eq("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountNe(Object value) {
        ew.ne("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountGt(Object value) {
        ew.gt("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountGe(Object value) {
        ew.ge("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountLt(Object value) {
        ew.lt("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountLe(Object value) {
        ew.le("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountIn(Object... value) {
        ew.in("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountNotIn(Object... value) {
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountBetween(Object value, Object value1) {
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransParamFailCondition orTransAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_amount", value, value1);
        return this;
    }

    public TransParamFailCondition andTransAmountNotBetween(Object value, Object value1) {
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransParamFailCondition orTransAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_amount", value, value1);
        return this;
    }

    public TransParamFailCondition andTransAmountLike(String value) {
        ew.like("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andTransAmountNotLike(String value) {
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransParamFailCondition orTransAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountIsNull() {
        ew.isNull("real_amount");
        return this;
    }

    public TransParamFailCondition orRealAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_amount");
        return this;
    }

    public TransParamFailCondition andRealAmountIsNotNull() {
        ew.isNotNull("real_amount");
        return this;
    }

    public TransParamFailCondition orRealAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_amount");
        return this;
    }

    public TransParamFailCondition andRealAmountEq(Object value) {
        ew.eq("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountNe(Object value) {
        ew.ne("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountGt(Object value) {
        ew.gt("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountGe(Object value) {
        ew.ge("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountLt(Object value) {
        ew.lt("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountLe(Object value) {
        ew.le("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountIn(Object... value) {
        ew.in("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountNotIn(Object... value) {
        ew.notIn("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountBetween(Object value, Object value1) {
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransParamFailCondition orRealAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_amount", value, value1);
        return this;
    }

    public TransParamFailCondition andRealAmountNotBetween(Object value, Object value1) {
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransParamFailCondition orRealAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_amount", value, value1);
        return this;
    }

    public TransParamFailCondition andRealAmountLike(String value) {
        ew.like("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_amount", value);
        return this;
    }

    public TransParamFailCondition andRealAmountNotLike(String value) {
        ew.notLike("real_amount", value);
        return this;
    }

    public TransParamFailCondition orRealAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_amount", value);
        return this;
    }

    public TransParamFailCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public TransParamFailCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public TransParamFailCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public TransParamFailCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public TransParamFailCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransParamFailCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public TransParamFailCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransParamFailCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public TransParamFailCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public TransParamFailCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public TransParamFailCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public TransParamFailCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public TransParamFailCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public TransParamFailCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public TransParamFailCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransParamFailCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public TransParamFailCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransParamFailCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public TransParamFailCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public TransParamFailCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public TransParamFailCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public TransParamFailCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public TransParamFailCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public TransParamFailCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public TransParamFailCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public TransParamFailCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public TransParamFailCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public TransParamFailCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeIsNull() {
        ew.isNull("channel_resp_time");
        return this;
    }

    public TransParamFailCondition orChannelRespTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_time");
        return this;
    }

    public TransParamFailCondition andChannelRespTimeIsNotNull() {
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public TransParamFailCondition orChannelRespTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public TransParamFailCondition andChannelRespTimeEq(Object value) {
        ew.eq("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeNe(Object value) {
        ew.ne("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeGt(Object value) {
        ew.gt("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeGe(Object value) {
        ew.ge("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeLt(Object value) {
        ew.lt("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeLe(Object value) {
        ew.le("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeIn(Object... value) {
        ew.in("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeNotIn(Object... value) {
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeBetween(Object value, Object value1) {
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeLike(String value) {
        ew.like("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespTimeNotLike(String value) {
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition orChannelRespTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeIsNull() {
        ew.isNull("channel_resp_code");
        return this;
    }

    public TransParamFailCondition orChannelRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_code");
        return this;
    }

    public TransParamFailCondition andChannelRespCodeIsNotNull() {
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public TransParamFailCondition orChannelRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public TransParamFailCondition andChannelRespCodeEq(Object value) {
        ew.eq("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeNe(Object value) {
        ew.ne("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeGt(Object value) {
        ew.gt("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeGe(Object value) {
        ew.ge("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeLt(Object value) {
        ew.lt("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeLe(Object value) {
        ew.le("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeIn(Object... value) {
        ew.in("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeNotIn(Object... value) {
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeBetween(Object value, Object value1) {
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeLike(String value) {
        ew.like("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespCodeNotLike(String value) {
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition orChannelRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdIsNull() {
        ew.isNull("channel_resp_id");
        return this;
    }

    public TransParamFailCondition orChannelRespIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_id");
        return this;
    }

    public TransParamFailCondition andChannelRespIdIsNotNull() {
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public TransParamFailCondition orChannelRespIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public TransParamFailCondition andChannelRespIdEq(Object value) {
        ew.eq("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdNe(Object value) {
        ew.ne("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdGt(Object value) {
        ew.gt("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdGe(Object value) {
        ew.ge("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdLt(Object value) {
        ew.lt("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdLe(Object value) {
        ew.le("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdIn(Object... value) {
        ew.in("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdNotIn(Object... value) {
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdBetween(Object value, Object value1) {
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespIdNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespIdLike(String value) {
        ew.like("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespIdNotLike(String value) {
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition orChannelRespIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgIsNull() {
        ew.isNull("channel_resp_msg");
        return this;
    }

    public TransParamFailCondition orChannelRespMsgIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_msg");
        return this;
    }

    public TransParamFailCondition andChannelRespMsgIsNotNull() {
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public TransParamFailCondition orChannelRespMsgIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public TransParamFailCondition andChannelRespMsgEq(Object value) {
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgNe(Object value) {
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgGt(Object value) {
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgGe(Object value) {
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgLt(Object value) {
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgLe(Object value) {
        ew.le("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgIn(Object... value) {
        ew.in("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgNotIn(Object... value) {
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgBetween(Object value, Object value1) {
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgLike(String value) {
        ew.like("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andChannelRespMsgNotLike(String value) {
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition orChannelRespMsgNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public TransParamFailCondition andRespCodeIsNull() {
        ew.isNull("resp_code");
        return this;
    }

    public TransParamFailCondition orRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_code");
        return this;
    }

    public TransParamFailCondition andRespCodeIsNotNull() {
        ew.isNotNull("resp_code");
        return this;
    }

    public TransParamFailCondition orRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_code");
        return this;
    }

    public TransParamFailCondition andRespCodeEq(Object value) {
        ew.eq("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeNe(Object value) {
        ew.ne("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeGt(Object value) {
        ew.gt("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeGe(Object value) {
        ew.ge("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeLt(Object value) {
        ew.lt("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeLe(Object value) {
        ew.le("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeIn(Object... value) {
        ew.in("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeNotIn(Object... value) {
        ew.notIn("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeBetween(Object value, Object value1) {
        ew.between("resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition orRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition andRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition orRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_code", value, value1);
        return this;
    }

    public TransParamFailCondition andRespCodeLike(String value) {
        ew.like("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespCodeNotLike(String value) {
        ew.notLike("resp_code", value);
        return this;
    }

    public TransParamFailCondition orRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_code", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionIsNull() {
        ew.isNull("resp_exception");
        return this;
    }

    public TransParamFailCondition orRespExceptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_exception");
        return this;
    }

    public TransParamFailCondition andRespExceptionIsNotNull() {
        ew.isNotNull("resp_exception");
        return this;
    }

    public TransParamFailCondition orRespExceptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_exception");
        return this;
    }

    public TransParamFailCondition andRespExceptionEq(Object value) {
        ew.eq("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionNe(Object value) {
        ew.ne("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionGt(Object value) {
        ew.gt("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionGe(Object value) {
        ew.ge("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionLt(Object value) {
        ew.lt("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionLe(Object value) {
        ew.le("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionIn(Object... value) {
        ew.in("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionNotIn(Object... value) {
        ew.notIn("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionBetween(Object value, Object value1) {
        ew.between("resp_exception", value, value1);
        return this;
    }

    public TransParamFailCondition orRespExceptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_exception", value, value1);
        return this;
    }

    public TransParamFailCondition andRespExceptionNotBetween(Object value, Object value1) {
        ew.notBetween("resp_exception", value, value1);
        return this;
    }

    public TransParamFailCondition orRespExceptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_exception", value, value1);
        return this;
    }

    public TransParamFailCondition andRespExceptionLike(String value) {
        ew.like("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespExceptionNotLike(String value) {
        ew.notLike("resp_exception", value);
        return this;
    }

    public TransParamFailCondition orRespExceptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_exception", value);
        return this;
    }

    public TransParamFailCondition andRespMessageIsNull() {
        ew.isNull("resp_message");
        return this;
    }

    public TransParamFailCondition orRespMessageIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("resp_message");
        return this;
    }

    public TransParamFailCondition andRespMessageIsNotNull() {
        ew.isNotNull("resp_message");
        return this;
    }

    public TransParamFailCondition orRespMessageIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("resp_message");
        return this;
    }

    public TransParamFailCondition andRespMessageEq(Object value) {
        ew.eq("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageNe(Object value) {
        ew.ne("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageGt(Object value) {
        ew.gt("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageGe(Object value) {
        ew.ge("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageLt(Object value) {
        ew.lt("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageLe(Object value) {
        ew.le("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageIn(Object... value) {
        ew.in("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageNotIn(Object... value) {
        ew.notIn("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageBetween(Object value, Object value1) {
        ew.between("resp_message", value, value1);
        return this;
    }

    public TransParamFailCondition orRespMessageBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("resp_message", value, value1);
        return this;
    }

    public TransParamFailCondition andRespMessageNotBetween(Object value, Object value1) {
        ew.notBetween("resp_message", value, value1);
        return this;
    }

    public TransParamFailCondition orRespMessageNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("resp_message", value, value1);
        return this;
    }

    public TransParamFailCondition andRespMessageLike(String value) {
        ew.like("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRespMessageNotLike(String value) {
        ew.notLike("resp_message", value);
        return this;
    }

    public TransParamFailCondition orRespMessageNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("resp_message", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusIsNull() {
        ew.isNull("revoke_status");
        return this;
    }

    public TransParamFailCondition orRevokeStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("revoke_status");
        return this;
    }

    public TransParamFailCondition andRevokeStatusIsNotNull() {
        ew.isNotNull("revoke_status");
        return this;
    }

    public TransParamFailCondition orRevokeStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("revoke_status");
        return this;
    }

    public TransParamFailCondition andRevokeStatusEq(Object value) {
        ew.eq("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusNe(Object value) {
        ew.ne("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusGt(Object value) {
        ew.gt("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusGe(Object value) {
        ew.ge("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusLt(Object value) {
        ew.lt("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusLe(Object value) {
        ew.le("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusIn(Object... value) {
        ew.in("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusNotIn(Object... value) {
        ew.notIn("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusBetween(Object value, Object value1) {
        ew.between("revoke_status", value, value1);
        return this;
    }

    public TransParamFailCondition orRevokeStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("revoke_status", value, value1);
        return this;
    }

    public TransParamFailCondition andRevokeStatusNotBetween(Object value, Object value1) {
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public TransParamFailCondition orRevokeStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("revoke_status", value, value1);
        return this;
    }

    public TransParamFailCondition andRevokeStatusLike(String value) {
        ew.like("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRevokeStatusNotLike(String value) {
        ew.notLike("revoke_status", value);
        return this;
    }

    public TransParamFailCondition orRevokeStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("revoke_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusIsNull() {
        ew.isNull("refund_status");
        return this;
    }

    public TransParamFailCondition orRefundStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("refund_status");
        return this;
    }

    public TransParamFailCondition andRefundStatusIsNotNull() {
        ew.isNotNull("refund_status");
        return this;
    }

    public TransParamFailCondition orRefundStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("refund_status");
        return this;
    }

    public TransParamFailCondition andRefundStatusEq(Object value) {
        ew.eq("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusNe(Object value) {
        ew.ne("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusGt(Object value) {
        ew.gt("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusGe(Object value) {
        ew.ge("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusLt(Object value) {
        ew.lt("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusLe(Object value) {
        ew.le("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusIn(Object... value) {
        ew.in("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusNotIn(Object... value) {
        ew.notIn("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusBetween(Object value, Object value1) {
        ew.between("refund_status", value, value1);
        return this;
    }

    public TransParamFailCondition orRefundStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("refund_status", value, value1);
        return this;
    }

    public TransParamFailCondition andRefundStatusNotBetween(Object value, Object value1) {
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public TransParamFailCondition orRefundStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("refund_status", value, value1);
        return this;
    }

    public TransParamFailCondition andRefundStatusLike(String value) {
        ew.like("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundStatusNotLike(String value) {
        ew.notLike("refund_status", value);
        return this;
    }

    public TransParamFailCondition orRefundStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("refund_status", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountIsNull() {
        ew.isNull("refund_amount");
        return this;
    }

    public TransParamFailCondition orRefundAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("refund_amount");
        return this;
    }

    public TransParamFailCondition andRefundAmountIsNotNull() {
        ew.isNotNull("refund_amount");
        return this;
    }

    public TransParamFailCondition orRefundAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("refund_amount");
        return this;
    }

    public TransParamFailCondition andRefundAmountEq(Object value) {
        ew.eq("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountNe(Object value) {
        ew.ne("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountGt(Object value) {
        ew.gt("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountGe(Object value) {
        ew.ge("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountLt(Object value) {
        ew.lt("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountLe(Object value) {
        ew.le("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountIn(Object... value) {
        ew.in("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountNotIn(Object... value) {
        ew.notIn("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountBetween(Object value, Object value1) {
        ew.between("refund_amount", value, value1);
        return this;
    }

    public TransParamFailCondition orRefundAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("refund_amount", value, value1);
        return this;
    }

    public TransParamFailCondition andRefundAmountNotBetween(Object value, Object value1) {
        ew.notBetween("refund_amount", value, value1);
        return this;
    }

    public TransParamFailCondition orRefundAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("refund_amount", value, value1);
        return this;
    }

    public TransParamFailCondition andRefundAmountLike(String value) {
        ew.like("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andRefundAmountNotLike(String value) {
        ew.notLike("refund_amount", value);
        return this;
    }

    public TransParamFailCondition orRefundAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("refund_amount", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusIsNull() {
        ew.isNull("reconcile_status");
        return this;
    }

    public TransParamFailCondition orReconcileStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_status");
        return this;
    }

    public TransParamFailCondition andReconcileStatusIsNotNull() {
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransParamFailCondition orReconcileStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_status");
        return this;
    }

    public TransParamFailCondition andReconcileStatusEq(Object value) {
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusNe(Object value) {
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusGt(Object value) {
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusGe(Object value) {
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusLt(Object value) {
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusLe(Object value) {
        ew.le("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusIn(Object... value) {
        ew.in("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusNotIn(Object... value) {
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusBetween(Object value, Object value1) {
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransParamFailCondition orReconcileStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_status", value, value1);
        return this;
    }

    public TransParamFailCondition andReconcileStatusNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransParamFailCondition orReconcileStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_status", value, value1);
        return this;
    }

    public TransParamFailCondition andReconcileStatusLike(String value) {
        ew.like("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andReconcileStatusNotLike(String value) {
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition orReconcileStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_status", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlIsNull() {
        ew.isNull("trans_callback_url");
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_callback_url");
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlIsNotNull() {
        ew.isNotNull("trans_callback_url");
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_callback_url");
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlEq(Object value) {
        ew.eq("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlNe(Object value) {
        ew.ne("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlGt(Object value) {
        ew.gt("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlGe(Object value) {
        ew.ge("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlLt(Object value) {
        ew.lt("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlLe(Object value) {
        ew.le("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlIn(Object... value) {
        ew.in("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlNotIn(Object... value) {
        ew.notIn("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlBetween(Object value, Object value1) {
        ew.between("trans_callback_url", value, value1);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_callback_url", value, value1);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlNotBetween(Object value, Object value1) {
        ew.notBetween("trans_callback_url", value, value1);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_callback_url", value, value1);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlLike(String value) {
        ew.like("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andTransCallbackUrlNotLike(String value) {
        ew.notLike("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition orTransCallbackUrlNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_callback_url", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeIsNull() {
        ew.isNull("reconcile_time");
        return this;
    }

    public TransParamFailCondition orReconcileTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_time");
        return this;
    }

    public TransParamFailCondition andReconcileTimeIsNotNull() {
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransParamFailCondition orReconcileTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_time");
        return this;
    }

    public TransParamFailCondition andReconcileTimeEq(Object value) {
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeNe(Object value) {
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeGt(Object value) {
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeGe(Object value) {
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeLt(Object value) {
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeLe(Object value) {
        ew.le("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeIn(Object... value) {
        ew.in("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeNotIn(Object... value) {
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeBetween(Object value, Object value1) {
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransParamFailCondition orReconcileTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_time", value, value1);
        return this;
    }

    public TransParamFailCondition andReconcileTimeNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransParamFailCondition orReconcileTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_time", value, value1);
        return this;
    }

    public TransParamFailCondition andReconcileTimeLike(String value) {
        ew.like("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileTimeNotLike(String value) {
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition orReconcileTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_time", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public TransParamFailCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public TransParamFailCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransParamFailCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public TransParamFailCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransParamFailCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public TransParamFailCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransParamFailCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public TransParamFailCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public TransParamFailCondition andDescriptionIsNull() {
        ew.isNull("description");
        return this;
    }

    public TransParamFailCondition orDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("description");
        return this;
    }

    public TransParamFailCondition andDescriptionIsNotNull() {
        ew.isNotNull("description");
        return this;
    }

    public TransParamFailCondition orDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("description");
        return this;
    }

    public TransParamFailCondition andDescriptionEq(Object value) {
        ew.eq("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionNe(Object value) {
        ew.ne("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionGt(Object value) {
        ew.gt("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionGe(Object value) {
        ew.ge("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionLt(Object value) {
        ew.lt("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionLe(Object value) {
        ew.le("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionIn(Object... value) {
        ew.in("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionNotIn(Object... value) {
        ew.notIn("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionBetween(Object value, Object value1) {
        ew.between("description", value, value1);
        return this;
    }

    public TransParamFailCondition orDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("description", value, value1);
        return this;
    }

    public TransParamFailCondition andDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("description", value, value1);
        return this;
    }

    public TransParamFailCondition orDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("description", value, value1);
        return this;
    }

    public TransParamFailCondition andDescriptionLike(String value) {
        ew.like("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("description", value);
        return this;
    }

    public TransParamFailCondition andDescriptionNotLike(String value) {
        ew.notLike("description", value);
        return this;
    }

    public TransParamFailCondition orDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("description", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoIsNull() {
        ew.isNull("batch_sub_no");
        return this;
    }

    public TransParamFailCondition orBatchSubNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_sub_no");
        return this;
    }

    public TransParamFailCondition andBatchSubNoIsNotNull() {
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public TransParamFailCondition orBatchSubNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_sub_no");
        return this;
    }

    public TransParamFailCondition andBatchSubNoEq(Object value) {
        ew.eq("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoNe(Object value) {
        ew.ne("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoGt(Object value) {
        ew.gt("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoGe(Object value) {
        ew.ge("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoLt(Object value) {
        ew.lt("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoLe(Object value) {
        ew.le("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoIn(Object... value) {
        ew.in("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoNotIn(Object... value) {
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoBetween(Object value, Object value1) {
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public TransParamFailCondition orBatchSubNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_sub_no", value, value1);
        return this;
    }

    public TransParamFailCondition andBatchSubNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public TransParamFailCondition orBatchSubNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_sub_no", value, value1);
        return this;
    }

    public TransParamFailCondition andBatchSubNoLike(String value) {
        ew.like("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andBatchSubNoNotLike(String value) {
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition orBatchSubNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_sub_no", value);
        return this;
    }

    public TransParamFailCondition andCurrencyIsNull() {
        ew.isNull("currency");
        return this;
    }

    public TransParamFailCondition orCurrencyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("currency");
        return this;
    }

    public TransParamFailCondition andCurrencyIsNotNull() {
        ew.isNotNull("currency");
        return this;
    }

    public TransParamFailCondition orCurrencyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("currency");
        return this;
    }

    public TransParamFailCondition andCurrencyEq(Object value) {
        ew.eq("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyNe(Object value) {
        ew.ne("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyGt(Object value) {
        ew.gt("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyGe(Object value) {
        ew.ge("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyLt(Object value) {
        ew.lt("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyLe(Object value) {
        ew.le("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyIn(Object... value) {
        ew.in("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyNotIn(Object... value) {
        ew.notIn("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyBetween(Object value, Object value1) {
        ew.between("currency", value, value1);
        return this;
    }

    public TransParamFailCondition orCurrencyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("currency", value, value1);
        return this;
    }

    public TransParamFailCondition andCurrencyNotBetween(Object value, Object value1) {
        ew.notBetween("currency", value, value1);
        return this;
    }

    public TransParamFailCondition orCurrencyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("currency", value, value1);
        return this;
    }

    public TransParamFailCondition andCurrencyLike(String value) {
        ew.like("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("currency", value);
        return this;
    }

    public TransParamFailCondition andCurrencyNotLike(String value) {
        ew.notLike("currency", value);
        return this;
    }

    public TransParamFailCondition orCurrencyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("currency", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public TransParamFailCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public TransParamFailCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransParamFailCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public TransParamFailCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransParamFailCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public TransParamFailCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransParamFailCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public TransParamFailCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransParamFailCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public TransParamFailCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public TransParamFailCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransParamFailCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public TransParamFailCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransParamFailCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public TransParamFailCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransParamFailCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public TransParamFailCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public TransParamFailCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public TransParamFailCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public TransParamFailCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public TransParamFailCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public TransParamFailCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public TransParamFailCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public TransParamFailCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransParamFailCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public TransParamFailCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public TransParamFailCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public TransParamFailCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public TransParamFailCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public TransParamFailCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public TransParamFailCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransParamFailCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public TransParamFailCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransParamFailCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public TransParamFailCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public TransParamFailCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public TransParamFailCondition andUserCodeIsNull() {
        ew.isNull("user_code");
        return this;
    }

    public TransParamFailCondition orUserCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_code");
        return this;
    }

    public TransParamFailCondition andUserCodeIsNotNull() {
        ew.isNotNull("user_code");
        return this;
    }

    public TransParamFailCondition orUserCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_code");
        return this;
    }

    public TransParamFailCondition andUserCodeEq(Object value) {
        ew.eq("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeNe(Object value) {
        ew.ne("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeGt(Object value) {
        ew.gt("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeGe(Object value) {
        ew.ge("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeLt(Object value) {
        ew.lt("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeLe(Object value) {
        ew.le("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeIn(Object... value) {
        ew.in("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeNotIn(Object... value) {
        ew.notIn("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeBetween(Object value, Object value1) {
        ew.between("user_code", value, value1);
        return this;
    }

    public TransParamFailCondition orUserCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_code", value, value1);
        return this;
    }

    public TransParamFailCondition andUserCodeNotBetween(Object value, Object value1) {
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public TransParamFailCondition orUserCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public TransParamFailCondition andUserCodeLike(String value) {
        ew.like("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_code", value);
        return this;
    }

    public TransParamFailCondition andUserCodeNotLike(String value) {
        ew.notLike("user_code", value);
        return this;
    }

    public TransParamFailCondition orUserCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_code", value);
        return this;
    }

    public TransParamFailCondition andAccNoIsNull() {
        ew.isNull("acc_no");
        return this;
    }

    public TransParamFailCondition orAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_no");
        return this;
    }

    public TransParamFailCondition andAccNoIsNotNull() {
        ew.isNotNull("acc_no");
        return this;
    }

    public TransParamFailCondition orAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_no");
        return this;
    }

    public TransParamFailCondition andAccNoEq(Object value) {
        ew.eq("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoNe(Object value) {
        ew.ne("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoGt(Object value) {
        ew.gt("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoGe(Object value) {
        ew.ge("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoLt(Object value) {
        ew.lt("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoLe(Object value) {
        ew.le("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoIn(Object... value) {
        ew.in("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoNotIn(Object... value) {
        ew.notIn("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoBetween(Object value, Object value1) {
        ew.between("acc_no", value, value1);
        return this;
    }

    public TransParamFailCondition orAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_no", value, value1);
        return this;
    }

    public TransParamFailCondition andAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public TransParamFailCondition orAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public TransParamFailCondition andAccNoLike(String value) {
        ew.like("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_no", value);
        return this;
    }

    public TransParamFailCondition andAccNoNotLike(String value) {
        ew.notLike("acc_no", value);
        return this;
    }

    public TransParamFailCondition orAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_no", value);
        return this;
    }

    public TransParamFailCondition andMerFeeIsNull() {
        ew.isNull("mer_fee");
        return this;
    }

    public TransParamFailCondition orMerFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_fee");
        return this;
    }

    public TransParamFailCondition andMerFeeIsNotNull() {
        ew.isNotNull("mer_fee");
        return this;
    }

    public TransParamFailCondition orMerFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_fee");
        return this;
    }

    public TransParamFailCondition andMerFeeEq(Object value) {
        ew.eq("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeNe(Object value) {
        ew.ne("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeGt(Object value) {
        ew.gt("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeGe(Object value) {
        ew.ge("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeLt(Object value) {
        ew.lt("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeLe(Object value) {
        ew.le("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeIn(Object... value) {
        ew.in("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeNotIn(Object... value) {
        ew.notIn("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeBetween(Object value, Object value1) {
        ew.between("mer_fee", value, value1);
        return this;
    }

    public TransParamFailCondition orMerFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_fee", value, value1);
        return this;
    }

    public TransParamFailCondition andMerFeeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public TransParamFailCondition orMerFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_fee", value, value1);
        return this;
    }

    public TransParamFailCondition andMerFeeLike(String value) {
        ew.like("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andMerFeeNotLike(String value) {
        ew.notLike("mer_fee", value);
        return this;
    }

    public TransParamFailCondition orMerFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeIsNull() {
        ew.isNull("channel_fee");
        return this;
    }

    public TransParamFailCondition orChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_fee");
        return this;
    }

    public TransParamFailCondition andChannelFeeIsNotNull() {
        ew.isNotNull("channel_fee");
        return this;
    }

    public TransParamFailCondition orChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_fee");
        return this;
    }

    public TransParamFailCondition andChannelFeeEq(Object value) {
        ew.eq("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeNe(Object value) {
        ew.ne("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeGt(Object value) {
        ew.gt("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeGe(Object value) {
        ew.ge("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeLt(Object value) {
        ew.lt("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeLe(Object value) {
        ew.le("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeIn(Object... value) {
        ew.in("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeNotIn(Object... value) {
        ew.notIn("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeBetween(Object value, Object value1) {
        ew.between("channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelFeeLike(String value) {
        ew.like("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andChannelFeeNotLike(String value) {
        ew.notLike("channel_fee", value);
        return this;
    }

    public TransParamFailCondition orChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_fee", value);
        return this;
    }

    public TransParamFailCondition andPcFlagIsNull() {
        ew.isNull("pc_flag");
        return this;
    }

    public TransParamFailCondition orPcFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pc_flag");
        return this;
    }

    public TransParamFailCondition andPcFlagIsNotNull() {
        ew.isNotNull("pc_flag");
        return this;
    }

    public TransParamFailCondition orPcFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pc_flag");
        return this;
    }

    public TransParamFailCondition andPcFlagEq(Object value) {
        ew.eq("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagNe(Object value) {
        ew.ne("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagGt(Object value) {
        ew.gt("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagGe(Object value) {
        ew.ge("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagLt(Object value) {
        ew.lt("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagLe(Object value) {
        ew.le("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagIn(Object... value) {
        ew.in("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagNotIn(Object... value) {
        ew.notIn("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagBetween(Object value, Object value1) {
        ew.between("pc_flag", value, value1);
        return this;
    }

    public TransParamFailCondition orPcFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pc_flag", value, value1);
        return this;
    }

    public TransParamFailCondition andPcFlagNotBetween(Object value, Object value1) {
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public TransParamFailCondition orPcFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pc_flag", value, value1);
        return this;
    }

    public TransParamFailCondition andPcFlagLike(String value) {
        ew.like("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andPcFlagNotLike(String value) {
        ew.notLike("pc_flag", value);
        return this;
    }

    public TransParamFailCondition orPcFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pc_flag", value);
        return this;
    }

    public TransParamFailCondition andUserTypeIsNull() {
        ew.isNull("user_type");
        return this;
    }

    public TransParamFailCondition orUserTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_type");
        return this;
    }

    public TransParamFailCondition andUserTypeIsNotNull() {
        ew.isNotNull("user_type");
        return this;
    }

    public TransParamFailCondition orUserTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_type");
        return this;
    }

    public TransParamFailCondition andUserTypeEq(Object value) {
        ew.eq("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeNe(Object value) {
        ew.ne("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeGt(Object value) {
        ew.gt("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeGe(Object value) {
        ew.ge("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeLt(Object value) {
        ew.lt("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeLe(Object value) {
        ew.le("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeIn(Object... value) {
        ew.in("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeNotIn(Object... value) {
        ew.notIn("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeBetween(Object value, Object value1) {
        ew.between("user_type", value, value1);
        return this;
    }

    public TransParamFailCondition orUserTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_type", value, value1);
        return this;
    }

    public TransParamFailCondition andUserTypeNotBetween(Object value, Object value1) {
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public TransParamFailCondition orUserTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public TransParamFailCondition andUserTypeLike(String value) {
        ew.like("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_type", value);
        return this;
    }

    public TransParamFailCondition andUserTypeNotLike(String value) {
        ew.notLike("user_type", value);
        return this;
    }

    public TransParamFailCondition orUserTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_type", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoIsNull() {
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_acct_no");
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoIsNotNull() {
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_acct_no");
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoEq(Object value) {
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoNe(Object value) {
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoGt(Object value) {
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoGe(Object value) {
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoLt(Object value) {
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoLe(Object value) {
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoIn(Object... value) {
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoNotIn(Object... value) {
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoBetween(Object value, Object value1) {
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoLike(String value) {
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeAcctNoNotLike(String value) {
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayeeAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameIsNull() {
        ew.isNull("payee_name");
        return this;
    }

    public TransParamFailCondition orPayeeNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_name");
        return this;
    }

    public TransParamFailCondition andPayeeNameIsNotNull() {
        ew.isNotNull("payee_name");
        return this;
    }

    public TransParamFailCondition orPayeeNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_name");
        return this;
    }

    public TransParamFailCondition andPayeeNameEq(Object value) {
        ew.eq("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameNe(Object value) {
        ew.ne("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameGt(Object value) {
        ew.gt("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameGe(Object value) {
        ew.ge("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameLt(Object value) {
        ew.lt("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameLe(Object value) {
        ew.le("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameIn(Object... value) {
        ew.in("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameNotIn(Object... value) {
        ew.notIn("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameBetween(Object value, Object value1) {
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeNameLike(String value) {
        ew.like("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeNameNotLike(String value) {
        ew.notLike("payee_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_name", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoIsNull() {
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransParamFailCondition orPayerAcctNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_acct_no");
        return this;
    }

    public TransParamFailCondition andPayerAcctNoIsNotNull() {
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransParamFailCondition orPayerAcctNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_acct_no");
        return this;
    }

    public TransParamFailCondition andPayerAcctNoEq(Object value) {
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoNe(Object value) {
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoGt(Object value) {
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoGe(Object value) {
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoLt(Object value) {
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoLe(Object value) {
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoIn(Object... value) {
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoNotIn(Object... value) {
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoBetween(Object value, Object value1) {
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoNotBetween(Object value, Object value1) {
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_acct_no", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoLike(String value) {
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerAcctNoNotLike(String value) {
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition orPayerAcctNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_acct_no", value);
        return this;
    }

    public TransParamFailCondition andPayerNameIsNull() {
        ew.isNull("payer_name");
        return this;
    }

    public TransParamFailCondition orPayerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_name");
        return this;
    }

    public TransParamFailCondition andPayerNameIsNotNull() {
        ew.isNotNull("payer_name");
        return this;
    }

    public TransParamFailCondition orPayerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_name");
        return this;
    }

    public TransParamFailCondition andPayerNameEq(Object value) {
        ew.eq("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameNe(Object value) {
        ew.ne("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameGt(Object value) {
        ew.gt("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameGe(Object value) {
        ew.ge("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameLt(Object value) {
        ew.lt("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameLe(Object value) {
        ew.le("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameIn(Object... value) {
        ew.in("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameNotIn(Object... value) {
        ew.notIn("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameBetween(Object value, Object value1) {
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerNameLike(String value) {
        ew.like("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_name", value);
        return this;
    }

    public TransParamFailCondition andPayerNameNotLike(String value) {
        ew.notLike("payer_name", value);
        return this;
    }

    public TransParamFailCondition orPayerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_name", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public TransParamFailCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public TransParamFailCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public TransParamFailCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public TransParamFailCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransParamFailCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public TransParamFailCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransParamFailCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public TransParamFailCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public TransParamFailCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public TransParamFailCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdIsNull() {
        ew.isNull("split_info_id");
        return this;
    }

    public TransParamFailCondition orSplitInfoIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_info_id");
        return this;
    }

    public TransParamFailCondition andSplitInfoIdIsNotNull() {
        ew.isNotNull("split_info_id");
        return this;
    }

    public TransParamFailCondition orSplitInfoIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_info_id");
        return this;
    }

    public TransParamFailCondition andSplitInfoIdEq(Object value) {
        ew.eq("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdNe(Object value) {
        ew.ne("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdGt(Object value) {
        ew.gt("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdGe(Object value) {
        ew.ge("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdLt(Object value) {
        ew.lt("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdLe(Object value) {
        ew.le("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdIn(Object... value) {
        ew.in("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdNotIn(Object... value) {
        ew.notIn("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdBetween(Object value, Object value1) {
        ew.between("split_info_id", value, value1);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_info_id", value, value1);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdNotBetween(Object value, Object value1) {
        ew.notBetween("split_info_id", value, value1);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_info_id", value, value1);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdLike(String value) {
        ew.like("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andSplitInfoIdNotLike(String value) {
        ew.notLike("split_info_id", value);
        return this;
    }

    public TransParamFailCondition orSplitInfoIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_info_id", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeIsNull() {
        ew.isNull("mer_settle_type");
        return this;
    }

    public TransParamFailCondition orMerSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_settle_type");
        return this;
    }

    public TransParamFailCondition andMerSettleTypeIsNotNull() {
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public TransParamFailCondition orMerSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_settle_type");
        return this;
    }

    public TransParamFailCondition andMerSettleTypeEq(Object value) {
        ew.eq("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeNe(Object value) {
        ew.ne("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeGt(Object value) {
        ew.gt("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeGe(Object value) {
        ew.ge("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeLt(Object value) {
        ew.lt("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeLe(Object value) {
        ew.le("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeIn(Object... value) {
        ew.in("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeNotIn(Object... value) {
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeBetween(Object value, Object value1) {
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeLike(String value) {
        ew.like("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerSettleTypeNotLike(String value) {
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition orMerSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_settle_type", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeIsNull() {
        ew.isNull("mer_charge_mode");
        return this;
    }

    public TransParamFailCondition orMerChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_charge_mode");
        return this;
    }

    public TransParamFailCondition andMerChargeModeIsNotNull() {
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public TransParamFailCondition orMerChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_charge_mode");
        return this;
    }

    public TransParamFailCondition andMerChargeModeEq(Object value) {
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeNe(Object value) {
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeGt(Object value) {
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeGe(Object value) {
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeLt(Object value) {
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeLe(Object value) {
        ew.le("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeIn(Object... value) {
        ew.in("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeNotIn(Object... value) {
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeBetween(Object value, Object value1) {
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition orMerChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition andMerChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition orMerChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition andMerChargeModeLike(String value) {
        ew.like("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andMerChargeModeNotLike(String value) {
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orMerChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeIsNull() {
        ew.isNull("channel_settle_type");
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_type");
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeIsNotNull() {
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_type");
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeEq(Object value) {
        ew.eq("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeNe(Object value) {
        ew.ne("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeGt(Object value) {
        ew.gt("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeGe(Object value) {
        ew.ge("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeLt(Object value) {
        ew.lt("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeLe(Object value) {
        ew.le("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeIn(Object... value) {
        ew.in("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeNotIn(Object... value) {
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeBetween(Object value, Object value1) {
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_type", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeLike(String value) {
        ew.like("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleTypeNotLike(String value) {
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_type", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeIsNull() {
        ew.isNull("channel_charge_mode");
        return this;
    }

    public TransParamFailCondition orChannelChargeModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_charge_mode");
        return this;
    }

    public TransParamFailCondition andChannelChargeModeIsNotNull() {
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public TransParamFailCondition orChannelChargeModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_charge_mode");
        return this;
    }

    public TransParamFailCondition andChannelChargeModeEq(Object value) {
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeNe(Object value) {
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeGt(Object value) {
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeGe(Object value) {
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeLt(Object value) {
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeLe(Object value) {
        ew.le("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeIn(Object... value) {
        ew.in("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeNotIn(Object... value) {
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeBetween(Object value, Object value1) {
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_charge_mode", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeLike(String value) {
        ew.like("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelChargeModeNotLike(String value) {
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition orChannelChargeModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_charge_mode", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateIsNull() {
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransParamFailCondition orChannelSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_settle_date");
        return this;
    }

    public TransParamFailCondition andChannelSettleDateIsNotNull() {
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransParamFailCondition orChannelSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_settle_date");
        return this;
    }

    public TransParamFailCondition andChannelSettleDateEq(Object value) {
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateNe(Object value) {
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateGt(Object value) {
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateGe(Object value) {
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateLt(Object value) {
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateLe(Object value) {
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateIn(Object... value) {
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateNotIn(Object... value) {
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateBetween(Object value, Object value1) {
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_settle_date", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_settle_date", value, value1);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateLike(String value) {
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andChannelSettleDateNotLike(String value) {
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition orChannelSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_settle_date", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeIsNull() {
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("orgin_channel_fee");
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeIsNotNull() {
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("orgin_channel_fee");
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeEq(Object value) {
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeNe(Object value) {
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeGt(Object value) {
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeGe(Object value) {
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeLt(Object value) {
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeLe(Object value) {
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeIn(Object... value) {
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeNotIn(Object... value) {
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeBetween(Object value, Object value1) {
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("orgin_channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeNotBetween(Object value, Object value1) {
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("orgin_channel_fee", value, value1);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeLike(String value) {
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andOrginChannelFeeNotLike(String value) {
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition orOrginChannelFeeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("orgin_channel_fee", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountIsNull() {
        ew.isNull("payer_account");
        return this;
    }

    public TransParamFailCondition orPayerAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_account");
        return this;
    }

    public TransParamFailCondition andPayerAccountIsNotNull() {
        ew.isNotNull("payer_account");
        return this;
    }

    public TransParamFailCondition orPayerAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_account");
        return this;
    }

    public TransParamFailCondition andPayerAccountEq(Object value) {
        ew.eq("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountNe(Object value) {
        ew.ne("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountGt(Object value) {
        ew.gt("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountGe(Object value) {
        ew.ge("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountLt(Object value) {
        ew.lt("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountLe(Object value) {
        ew.le("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountIn(Object... value) {
        ew.in("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountNotIn(Object... value) {
        ew.notIn("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountBetween(Object value, Object value1) {
        ew.between("payer_account", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_account", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_account", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerAccountLike(String value) {
        ew.like("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayerAccountNotLike(String value) {
        ew.notLike("payer_account", value);
        return this;
    }

    public TransParamFailCondition orPayerAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountIsNull() {
        ew.isNull("payee_account");
        return this;
    }

    public TransParamFailCondition orPayeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_account");
        return this;
    }

    public TransParamFailCondition andPayeeAccountIsNotNull() {
        ew.isNotNull("payee_account");
        return this;
    }

    public TransParamFailCondition orPayeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_account");
        return this;
    }

    public TransParamFailCondition andPayeeAccountEq(Object value) {
        ew.eq("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountNe(Object value) {
        ew.ne("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountGt(Object value) {
        ew.gt("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountGe(Object value) {
        ew.ge("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountLt(Object value) {
        ew.lt("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountLe(Object value) {
        ew.le("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountIn(Object... value) {
        ew.in("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountNotIn(Object... value) {
        ew.notIn("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountBetween(Object value, Object value1) {
        ew.between("payee_account", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_account", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_account", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeAccountLike(String value) {
        ew.like("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_account", value);
        return this;
    }

    public TransParamFailCondition andPayeeAccountNotLike(String value) {
        ew.notLike("payee_account", value);
        return this;
    }

    public TransParamFailCondition orPayeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountIsNull() {
        ew.isNull("fee_account");
        return this;
    }

    public TransParamFailCondition orFeeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account");
        return this;
    }

    public TransParamFailCondition andFeeAccountIsNotNull() {
        ew.isNotNull("fee_account");
        return this;
    }

    public TransParamFailCondition orFeeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account");
        return this;
    }

    public TransParamFailCondition andFeeAccountEq(Object value) {
        ew.eq("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNe(Object value) {
        ew.ne("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountGt(Object value) {
        ew.gt("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountGe(Object value) {
        ew.ge("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountLt(Object value) {
        ew.lt("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountLe(Object value) {
        ew.le("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountIn(Object... value) {
        ew.in("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNotIn(Object... value) {
        ew.notIn("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountBetween(Object value, Object value1) {
        ew.between("fee_account", value, value1);
        return this;
    }

    public TransParamFailCondition orFeeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account", value, value1);
        return this;
    }

    public TransParamFailCondition andFeeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public TransParamFailCondition orFeeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account", value, value1);
        return this;
    }

    public TransParamFailCondition andFeeAccountLike(String value) {
        ew.like("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNotLike(String value) {
        ew.notLike("fee_account", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountIsNull() {
        ew.isNull("income_account");
        return this;
    }

    public TransParamFailCondition orIncomeAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account");
        return this;
    }

    public TransParamFailCondition andIncomeAccountIsNotNull() {
        ew.isNotNull("income_account");
        return this;
    }

    public TransParamFailCondition orIncomeAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account");
        return this;
    }

    public TransParamFailCondition andIncomeAccountEq(Object value) {
        ew.eq("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNe(Object value) {
        ew.ne("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountGt(Object value) {
        ew.gt("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountGe(Object value) {
        ew.ge("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountLt(Object value) {
        ew.lt("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountLe(Object value) {
        ew.le("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountIn(Object... value) {
        ew.in("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNotIn(Object... value) {
        ew.notIn("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountBetween(Object value, Object value1) {
        ew.between("income_account", value, value1);
        return this;
    }

    public TransParamFailCondition orIncomeAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account", value, value1);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNotBetween(Object value, Object value1) {
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account", value, value1);
        return this;
    }

    public TransParamFailCondition andIncomeAccountLike(String value) {
        ew.like("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNotLike(String value) {
        ew.notLike("income_account", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileIsNull() {
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("need_channel_reconcile");
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileIsNotNull() {
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("need_channel_reconcile");
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileEq(Object value) {
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileNe(Object value) {
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileGt(Object value) {
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileGe(Object value) {
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileLt(Object value) {
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileLe(Object value) {
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileIn(Object... value) {
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileNotIn(Object... value) {
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileBetween(Object value, Object value1) {
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("need_channel_reconcile", value, value1);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileNotBetween(Object value, Object value1) {
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("need_channel_reconcile", value, value1);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileLike(String value) {
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andNeedChannelReconcileNotLike(String value) {
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition orNeedChannelReconcileNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("need_channel_reconcile", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoIsNull() {
        ew.isNull("show_payer_account_no");
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_no");
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoIsNotNull() {
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_no");
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoEq(Object value) {
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoNe(Object value) {
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoGt(Object value) {
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoGe(Object value) {
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoLt(Object value) {
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoLe(Object value) {
        ew.le("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoIn(Object... value) {
        ew.in("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoNotIn(Object... value) {
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoBetween(Object value, Object value1) {
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoLike(String value) {
        ew.like("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNoNotLike(String value) {
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameIsNull() {
        ew.isNull("show_payer_account_name");
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payer_account_name");
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameIsNotNull() {
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payer_account_name");
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameEq(Object value) {
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameNe(Object value) {
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameGt(Object value) {
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameGe(Object value) {
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameLt(Object value) {
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameLe(Object value) {
        ew.le("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameIn(Object... value) {
        ew.in("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameNotIn(Object... value) {
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameBetween(Object value, Object value1) {
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payer_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payer_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameLike(String value) {
        ew.like("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayerAccountNameNotLike(String value) {
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayerAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payer_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoIsNull() {
        ew.isNull("show_payee_account_no");
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_no");
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoIsNotNull() {
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_no");
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoEq(Object value) {
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoNe(Object value) {
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoGt(Object value) {
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoGe(Object value) {
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoLt(Object value) {
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoLe(Object value) {
        ew.le("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoIn(Object... value) {
        ew.in("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoNotIn(Object... value) {
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoBetween(Object value, Object value1) {
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_no", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoLike(String value) {
        ew.like("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNoNotLike(String value) {
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_no", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameIsNull() {
        ew.isNull("show_payee_account_name");
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("show_payee_account_name");
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameIsNotNull() {
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("show_payee_account_name");
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameEq(Object value) {
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameNe(Object value) {
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameGt(Object value) {
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameGe(Object value) {
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameLt(Object value) {
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameLe(Object value) {
        ew.le("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameIn(Object... value) {
        ew.in("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameNotIn(Object... value) {
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameBetween(Object value, Object value1) {
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("show_payee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("show_payee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameLike(String value) {
        ew.like("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andShowPayeeAccountNameNotLike(String value) {
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition orShowPayeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("show_payee_account_name", value);
        return this;
    }

    public TransParamFailCondition andOrderIdIsNull() {
        ew.isNull("order_id");
        return this;
    }

    public TransParamFailCondition orOrderIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_id");
        return this;
    }

    public TransParamFailCondition andOrderIdIsNotNull() {
        ew.isNotNull("order_id");
        return this;
    }

    public TransParamFailCondition orOrderIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_id");
        return this;
    }

    public TransParamFailCondition andOrderIdEq(Object value) {
        ew.eq("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdNe(Object value) {
        ew.ne("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdGt(Object value) {
        ew.gt("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdGe(Object value) {
        ew.ge("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdLt(Object value) {
        ew.lt("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdLe(Object value) {
        ew.le("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdIn(Object... value) {
        ew.in("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdNotIn(Object... value) {
        ew.notIn("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdBetween(Object value, Object value1) {
        ew.between("order_id", value, value1);
        return this;
    }

    public TransParamFailCondition orOrderIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_id", value, value1);
        return this;
    }

    public TransParamFailCondition andOrderIdNotBetween(Object value, Object value1) {
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public TransParamFailCondition orOrderIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_id", value, value1);
        return this;
    }

    public TransParamFailCondition andOrderIdLike(String value) {
        ew.like("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_id", value);
        return this;
    }

    public TransParamFailCondition andOrderIdNotLike(String value) {
        ew.notLike("order_id", value);
        return this;
    }

    public TransParamFailCondition orOrderIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_id", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagIsNull() {
        ew.isNull("elc_make_flag");
        return this;
    }

    public TransParamFailCondition orElcMakeFlagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("elc_make_flag");
        return this;
    }

    public TransParamFailCondition andElcMakeFlagIsNotNull() {
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public TransParamFailCondition orElcMakeFlagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("elc_make_flag");
        return this;
    }

    public TransParamFailCondition andElcMakeFlagEq(Object value) {
        ew.eq("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagNe(Object value) {
        ew.ne("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagGt(Object value) {
        ew.gt("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagGe(Object value) {
        ew.ge("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagLt(Object value) {
        ew.lt("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagLe(Object value) {
        ew.le("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagIn(Object... value) {
        ew.in("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagNotIn(Object... value) {
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagBetween(Object value, Object value1) {
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("elc_make_flag", value, value1);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagNotBetween(Object value, Object value1) {
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("elc_make_flag", value, value1);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagLike(String value) {
        ew.like("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andElcMakeFlagNotLike(String value) {
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition orElcMakeFlagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("elc_make_flag", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameIsNull() {
        ew.isNull("fee_account_name");
        return this;
    }

    public TransParamFailCondition orFeeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("fee_account_name");
        return this;
    }

    public TransParamFailCondition andFeeAccountNameIsNotNull() {
        ew.isNotNull("fee_account_name");
        return this;
    }

    public TransParamFailCondition orFeeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("fee_account_name");
        return this;
    }

    public TransParamFailCondition andFeeAccountNameEq(Object value) {
        ew.eq("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameNe(Object value) {
        ew.ne("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameGt(Object value) {
        ew.gt("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameGe(Object value) {
        ew.ge("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameLt(Object value) {
        ew.lt("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameLe(Object value) {
        ew.le("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameIn(Object... value) {
        ew.in("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameNotIn(Object... value) {
        ew.notIn("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameBetween(Object value, Object value1) {
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("fee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("fee_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameLike(String value) {
        ew.like("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andFeeAccountNameNotLike(String value) {
        ew.notLike("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition orFeeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("fee_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameIsNull() {
        ew.isNull("income_account_name");
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("income_account_name");
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameIsNotNull() {
        ew.isNotNull("income_account_name");
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("income_account_name");
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameEq(Object value) {
        ew.eq("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameNe(Object value) {
        ew.ne("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameGt(Object value) {
        ew.gt("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameGe(Object value) {
        ew.ge("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameLt(Object value) {
        ew.lt("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameLe(Object value) {
        ew.le("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameIn(Object... value) {
        ew.in("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameNotIn(Object... value) {
        ew.notIn("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameBetween(Object value, Object value1) {
        ew.between("income_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("income_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameNotBetween(Object value, Object value1) {
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("income_account_name", value, value1);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameLike(String value) {
        ew.like("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andIncomeAccountNameNotLike(String value) {
        ew.notLike("income_account_name", value);
        return this;
    }

    public TransParamFailCondition orIncomeAccountNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("income_account_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameIsNull() {
        ew.isNull("payer_opbk_name");
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payer_opbk_name");
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameIsNotNull() {
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payer_opbk_name");
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameEq(Object value) {
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameNe(Object value) {
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameGt(Object value) {
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameGe(Object value) {
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameLt(Object value) {
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameLe(Object value) {
        ew.le("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameIn(Object... value) {
        ew.in("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameNotIn(Object... value) {
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameBetween(Object value, Object value1) {
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payer_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payer_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameLike(String value) {
        ew.like("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayerOpbkNameNotLike(String value) {
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayerOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payer_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameIsNull() {
        ew.isNull("payee_opbk_name");
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payee_opbk_name");
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameIsNotNull() {
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payee_opbk_name");
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameEq(Object value) {
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameNe(Object value) {
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameGt(Object value) {
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameGe(Object value) {
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameLt(Object value) {
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameLe(Object value) {
        ew.le("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameIn(Object... value) {
        ew.in("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameNotIn(Object... value) {
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameBetween(Object value, Object value1) {
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payee_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameNotBetween(Object value, Object value1) {
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payee_opbk_name", value, value1);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameLike(String value) {
        ew.like("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andPayeeOpbkNameNotLike(String value) {
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition orPayeeOpbkNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payee_opbk_name", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionIsNull() {
        ew.isNull("summary_description");
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("summary_description");
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionIsNotNull() {
        ew.isNotNull("summary_description");
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("summary_description");
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionEq(Object value) {
        ew.eq("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionNe(Object value) {
        ew.ne("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionGt(Object value) {
        ew.gt("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionGe(Object value) {
        ew.ge("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionLt(Object value) {
        ew.lt("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionLe(Object value) {
        ew.le("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionIn(Object... value) {
        ew.in("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionNotIn(Object... value) {
        ew.notIn("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionBetween(Object value, Object value1) {
        ew.between("summary_description", value, value1);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("summary_description", value, value1);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("summary_description", value, value1);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionLike(String value) {
        ew.like("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("summary_description", value);
        return this;
    }

    public TransParamFailCondition andSummaryDescriptionNotLike(String value) {
        ew.notLike("summary_description", value);
        return this;
    }

    public TransParamFailCondition orSummaryDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("summary_description", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusIsNull() {
        ew.isNull("history_status");
        return this;
    }

    public TransParamFailCondition orHistoryStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("history_status");
        return this;
    }

    public TransParamFailCondition andHistoryStatusIsNotNull() {
        ew.isNotNull("history_status");
        return this;
    }

    public TransParamFailCondition orHistoryStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("history_status");
        return this;
    }

    public TransParamFailCondition andHistoryStatusEq(Object value) {
        ew.eq("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusNe(Object value) {
        ew.ne("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusGt(Object value) {
        ew.gt("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusGe(Object value) {
        ew.ge("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusLt(Object value) {
        ew.lt("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusLe(Object value) {
        ew.le("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusIn(Object... value) {
        ew.in("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusNotIn(Object... value) {
        ew.notIn("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusBetween(Object value, Object value1) {
        ew.between("history_status", value, value1);
        return this;
    }

    public TransParamFailCondition orHistoryStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("history_status", value, value1);
        return this;
    }

    public TransParamFailCondition andHistoryStatusNotBetween(Object value, Object value1) {
        ew.notBetween("history_status", value, value1);
        return this;
    }

    public TransParamFailCondition orHistoryStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("history_status", value, value1);
        return this;
    }

    public TransParamFailCondition andHistoryStatusLike(String value) {
        ew.like("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("history_status", value);
        return this;
    }

    public TransParamFailCondition andHistoryStatusNotLike(String value) {
        ew.notLike("history_status", value);
        return this;
    }

    public TransParamFailCondition orHistoryStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("history_status", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeIsNull() {
        ew.isNull("query_time");
        return this;
    }

    public TransParamFailCondition orQueryTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("query_time");
        return this;
    }

    public TransParamFailCondition andQueryTimeIsNotNull() {
        ew.isNotNull("query_time");
        return this;
    }

    public TransParamFailCondition orQueryTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("query_time");
        return this;
    }

    public TransParamFailCondition andQueryTimeEq(Object value) {
        ew.eq("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeNe(Object value) {
        ew.ne("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeGt(Object value) {
        ew.gt("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeGe(Object value) {
        ew.ge("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeLt(Object value) {
        ew.lt("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeLe(Object value) {
        ew.le("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeIn(Object... value) {
        ew.in("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeNotIn(Object... value) {
        ew.notIn("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeBetween(Object value, Object value1) {
        ew.between("query_time", value, value1);
        return this;
    }

    public TransParamFailCondition orQueryTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("query_time", value, value1);
        return this;
    }

    public TransParamFailCondition andQueryTimeNotBetween(Object value, Object value1) {
        ew.notBetween("query_time", value, value1);
        return this;
    }

    public TransParamFailCondition orQueryTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("query_time", value, value1);
        return this;
    }

    public TransParamFailCondition andQueryTimeLike(String value) {
        ew.like("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("query_time", value);
        return this;
    }

    public TransParamFailCondition andQueryTimeNotLike(String value) {
        ew.notLike("query_time", value);
        return this;
    }

    public TransParamFailCondition orQueryTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("query_time", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpIsNull() {
        ew.isNull("remote_ip");
        return this;
    }

    public TransParamFailCondition orRemoteIpIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remote_ip");
        return this;
    }

    public TransParamFailCondition andRemoteIpIsNotNull() {
        ew.isNotNull("remote_ip");
        return this;
    }

    public TransParamFailCondition orRemoteIpIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remote_ip");
        return this;
    }

    public TransParamFailCondition andRemoteIpEq(Object value) {
        ew.eq("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpNe(Object value) {
        ew.ne("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpGt(Object value) {
        ew.gt("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpGe(Object value) {
        ew.ge("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpLt(Object value) {
        ew.lt("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpLe(Object value) {
        ew.le("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpIn(Object... value) {
        ew.in("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpNotIn(Object... value) {
        ew.notIn("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpBetween(Object value, Object value1) {
        ew.between("remote_ip", value, value1);
        return this;
    }

    public TransParamFailCondition orRemoteIpBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remote_ip", value, value1);
        return this;
    }

    public TransParamFailCondition andRemoteIpNotBetween(Object value, Object value1) {
        ew.notBetween("remote_ip", value, value1);
        return this;
    }

    public TransParamFailCondition orRemoteIpNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remote_ip", value, value1);
        return this;
    }

    public TransParamFailCondition andRemoteIpLike(String value) {
        ew.like("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andRemoteIpNotLike(String value) {
        ew.notLike("remote_ip", value);
        return this;
    }

    public TransParamFailCondition orRemoteIpNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remote_ip", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeIsNull() {
        ew.isNull("payment_type");
        return this;
    }

    public TransParamFailCondition orPaymentTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_type");
        return this;
    }

    public TransParamFailCondition andPaymentTypeIsNotNull() {
        ew.isNotNull("payment_type");
        return this;
    }

    public TransParamFailCondition orPaymentTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_type");
        return this;
    }

    public TransParamFailCondition andPaymentTypeEq(Object value) {
        ew.eq("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeNe(Object value) {
        ew.ne("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeGt(Object value) {
        ew.gt("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeGe(Object value) {
        ew.ge("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeLt(Object value) {
        ew.lt("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeLe(Object value) {
        ew.le("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeIn(Object... value) {
        ew.in("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeNotIn(Object... value) {
        ew.notIn("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeBetween(Object value, Object value1) {
        ew.between("payment_type", value, value1);
        return this;
    }

    public TransParamFailCondition orPaymentTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_type", value, value1);
        return this;
    }

    public TransParamFailCondition andPaymentTypeNotBetween(Object value, Object value1) {
        ew.notBetween("payment_type", value, value1);
        return this;
    }

    public TransParamFailCondition orPaymentTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_type", value, value1);
        return this;
    }

    public TransParamFailCondition andPaymentTypeLike(String value) {
        ew.like("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentTypeNotLike(String value) {
        ew.notLike("payment_type", value);
        return this;
    }

    public TransParamFailCondition orPaymentTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_type", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodIsNull() {
        ew.isNull("payment_period");
        return this;
    }

    public TransParamFailCondition orPaymentPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_period");
        return this;
    }

    public TransParamFailCondition andPaymentPeriodIsNotNull() {
        ew.isNotNull("payment_period");
        return this;
    }

    public TransParamFailCondition orPaymentPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_period");
        return this;
    }

    public TransParamFailCondition andPaymentPeriodEq(Object value) {
        ew.eq("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodNe(Object value) {
        ew.ne("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodGt(Object value) {
        ew.gt("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodGe(Object value) {
        ew.ge("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodLt(Object value) {
        ew.lt("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodLe(Object value) {
        ew.le("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodIn(Object... value) {
        ew.in("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodNotIn(Object... value) {
        ew.notIn("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodBetween(Object value, Object value1) {
        ew.between("payment_period", value, value1);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_period", value, value1);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("payment_period", value, value1);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_period", value, value1);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodLike(String value) {
        ew.like("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentPeriodNotLike(String value) {
        ew.notLike("payment_period", value);
        return this;
    }

    public TransParamFailCondition orPaymentPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_period", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusIsNull() {
        ew.isNull("payment_settle_status");
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("payment_settle_status");
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusIsNotNull() {
        ew.isNotNull("payment_settle_status");
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("payment_settle_status");
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusEq(Object value) {
        ew.eq("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusNe(Object value) {
        ew.ne("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusGt(Object value) {
        ew.gt("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusGe(Object value) {
        ew.ge("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusLt(Object value) {
        ew.lt("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusLe(Object value) {
        ew.le("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusIn(Object... value) {
        ew.in("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusNotIn(Object... value) {
        ew.notIn("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusBetween(Object value, Object value1) {
        ew.between("payment_settle_status", value, value1);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("payment_settle_status", value, value1);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusNotBetween(Object value, Object value1) {
        ew.notBetween("payment_settle_status", value, value1);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("payment_settle_status", value, value1);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusLike(String value) {
        ew.like("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition andPaymentSettleStatusNotLike(String value) {
        ew.notLike("payment_settle_status", value);
        return this;
    }

    public TransParamFailCondition orPaymentSettleStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("payment_settle_status", value);
        return this;
    }
}