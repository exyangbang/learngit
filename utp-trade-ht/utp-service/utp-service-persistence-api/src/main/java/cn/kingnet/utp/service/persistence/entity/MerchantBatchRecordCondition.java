package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class MerchantBatchRecordCondition {
    private PlusEntityWrapper<MerchantBatchRecord> ew;

    public MerchantBatchRecordCondition() {
        this.ew = new PlusEntityWrapper(MerchantBatchRecord.class);
    }

    public static MerchantBatchRecordCondition builder() {
        return new MerchantBatchRecordCondition();
    }

    public PlusEntityWrapper<MerchantBatchRecord> build() {
        return this.ew;
    }

    public MerchantBatchRecordCondition or() {
        this.ew.orNew();
        return this;
    }

    public MerchantBatchRecordCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(MerchantBatchRecord.class);
    }

    public MerchantBatchRecordCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public MerchantBatchRecordCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public MerchantBatchRecordCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public MerchantBatchRecordCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> MerchantBatchRecordCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> MerchantBatchRecordCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> MerchantBatchRecordCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public MerchantBatchRecordCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public MerchantBatchRecordCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public MerchantBatchRecordCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public MerchantBatchRecordCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public MerchantBatchRecordCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public MerchantBatchRecordCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public MerchantBatchRecordCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public MerchantBatchRecordCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public MerchantBatchRecordCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeIsNull() {
        ew.isNull("channel_code");
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_code");
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeIsNotNull() {
        ew.isNotNull("channel_code");
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_code");
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeEq(Object value) {
        ew.eq("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeNe(Object value) {
        ew.ne("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeGt(Object value) {
        ew.gt("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeGe(Object value) {
        ew.ge("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeLt(Object value) {
        ew.lt("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeLe(Object value) {
        ew.le("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeIn(Object... value) {
        ew.in("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeNotIn(Object... value) {
        ew.notIn("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeBetween(Object value, Object value1) {
        ew.between("channel_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeLike(String value) {
        ew.like("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelCodeNotLike(String value) {
        ew.notLike("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameIsNull() {
        ew.isNull("channel_name");
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_name");
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameIsNotNull() {
        ew.isNotNull("channel_name");
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_name");
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameEq(Object value) {
        ew.eq("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameNe(Object value) {
        ew.ne("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameGt(Object value) {
        ew.gt("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameGe(Object value) {
        ew.ge("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameLt(Object value) {
        ew.lt("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameLe(Object value) {
        ew.le("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameIn(Object... value) {
        ew.in("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameNotIn(Object... value) {
        ew.notIn("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameBetween(Object value, Object value1) {
        ew.between("channel_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameNotBetween(Object value, Object value1) {
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameLike(String value) {
        ew.like("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelNameNotLike(String value) {
        ew.notLike("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeIsNull() {
        ew.isNull("channel_resp_code");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_code");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeIsNotNull() {
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_code");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeEq(Object value) {
        ew.eq("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeNe(Object value) {
        ew.ne("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeGt(Object value) {
        ew.gt("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeGe(Object value) {
        ew.ge("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeLt(Object value) {
        ew.lt("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeLe(Object value) {
        ew.le("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeIn(Object... value) {
        ew.in("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeNotIn(Object... value) {
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeBetween(Object value, Object value1) {
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeLike(String value) {
        ew.like("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespCodeNotLike(String value) {
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdIsNull() {
        ew.isNull("channel_resp_id");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_id");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdIsNotNull() {
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_id");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdEq(Object value) {
        ew.eq("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdNe(Object value) {
        ew.ne("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdGt(Object value) {
        ew.gt("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdGe(Object value) {
        ew.ge("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdLt(Object value) {
        ew.lt("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdLe(Object value) {
        ew.le("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdIn(Object... value) {
        ew.in("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdNotIn(Object... value) {
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdBetween(Object value, Object value1) {
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdLike(String value) {
        ew.like("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespIdNotLike(String value) {
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgIsNull() {
        ew.isNull("channel_resp_msg");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_msg");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgIsNotNull() {
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_msg");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgEq(Object value) {
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgNe(Object value) {
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgGt(Object value) {
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgGe(Object value) {
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgLt(Object value) {
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgLe(Object value) {
        ew.le("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgIn(Object... value) {
        ew.in("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgNotIn(Object... value) {
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgBetween(Object value, Object value1) {
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_msg", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgLike(String value) {
        ew.like("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespMsgNotLike(String value) {
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespMsgNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_msg", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeIsNull() {
        ew.isNull("channel_resp_time");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_resp_time");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeIsNotNull() {
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_resp_time");
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeEq(Object value) {
        ew.eq("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeNe(Object value) {
        ew.ne("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeGt(Object value) {
        ew.gt("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeGe(Object value) {
        ew.ge("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeLt(Object value) {
        ew.lt("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeLe(Object value) {
        ew.le("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeIn(Object... value) {
        ew.in("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeNotIn(Object... value) {
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeBetween(Object value, Object value1) {
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_resp_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_resp_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeLike(String value) {
        ew.like("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andChannelRespTimeNotLike(String value) {
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orChannelRespTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_resp_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoIsNull() {
        ew.isNull("server_batch_no");
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_batch_no");
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoIsNotNull() {
        ew.isNotNull("server_batch_no");
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_batch_no");
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoEq(Object value) {
        ew.eq("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoNe(Object value) {
        ew.ne("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoGt(Object value) {
        ew.gt("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoGe(Object value) {
        ew.ge("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoLt(Object value) {
        ew.lt("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoLe(Object value) {
        ew.le("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoIn(Object... value) {
        ew.in("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoNotIn(Object... value) {
        ew.notIn("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoBetween(Object value, Object value1) {
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_batch_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_batch_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoLike(String value) {
        ew.like("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerBatchNoNotLike(String value) {
        ew.notLike("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_batch_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public MerchantBatchRecordCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public MerchantBatchRecordCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public MerchantBatchRecordCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public MerchantBatchRecordCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchIsNull() {
        ew.isNull("cn_tr_batch");
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cn_tr_batch");
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchIsNotNull() {
        ew.isNotNull("cn_tr_batch");
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cn_tr_batch");
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchEq(Object value) {
        ew.eq("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchNe(Object value) {
        ew.ne("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchGt(Object value) {
        ew.gt("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchGe(Object value) {
        ew.ge("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchLt(Object value) {
        ew.lt("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchLe(Object value) {
        ew.le("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchIn(Object... value) {
        ew.in("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchNotIn(Object... value) {
        ew.notIn("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchBetween(Object value, Object value1) {
        ew.between("cn_tr_batch", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cn_tr_batch", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchNotBetween(Object value, Object value1) {
        ew.notBetween("cn_tr_batch", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cn_tr_batch", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchLike(String value) {
        ew.like("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andCnTrBatchNotLike(String value) {
        ew.notLike("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition orCnTrBatchNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cn_tr_batch", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusIsNull() {
        ew.isNull("batch_status");
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_status");
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusIsNotNull() {
        ew.isNotNull("batch_status");
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_status");
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusEq(Object value) {
        ew.eq("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusNe(Object value) {
        ew.ne("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusGt(Object value) {
        ew.gt("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusGe(Object value) {
        ew.ge("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusLt(Object value) {
        ew.lt("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusLe(Object value) {
        ew.le("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusIn(Object... value) {
        ew.in("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusNotIn(Object... value) {
        ew.notIn("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusBetween(Object value, Object value1) {
        ew.between("batch_status", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_status", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusNotBetween(Object value, Object value1) {
        ew.notBetween("batch_status", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_status", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusLike(String value) {
        ew.like("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andBatchStatusNotLike(String value) {
        ew.notLike("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition orBatchStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_status", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public MerchantBatchRecordCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public MerchantBatchRecordCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantBatchRecordCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantBatchRecordCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoIsNull() {
        ew.isNull("acc_no");
        return this;
    }

    public MerchantBatchRecordCondition orAccNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("acc_no");
        return this;
    }

    public MerchantBatchRecordCondition andAccNoIsNotNull() {
        ew.isNotNull("acc_no");
        return this;
    }

    public MerchantBatchRecordCondition orAccNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("acc_no");
        return this;
    }

    public MerchantBatchRecordCondition andAccNoEq(Object value) {
        ew.eq("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoNe(Object value) {
        ew.ne("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoGt(Object value) {
        ew.gt("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoGe(Object value) {
        ew.ge("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoLt(Object value) {
        ew.lt("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoLe(Object value) {
        ew.le("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoIn(Object... value) {
        ew.in("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoNotIn(Object... value) {
        ew.notIn("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoBetween(Object value, Object value1) {
        ew.between("acc_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("acc_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoNotBetween(Object value, Object value1) {
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("acc_no", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoLike(String value) {
        ew.like("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andAccNoNotLike(String value) {
        ew.notLike("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition orAccNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("acc_no", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeIsNull() {
        ew.isNull("user_code");
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_code");
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeIsNotNull() {
        ew.isNotNull("user_code");
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_code");
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeEq(Object value) {
        ew.eq("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeNe(Object value) {
        ew.ne("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeGt(Object value) {
        ew.gt("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeGe(Object value) {
        ew.ge("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeLt(Object value) {
        ew.lt("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeLe(Object value) {
        ew.le("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeIn(Object... value) {
        ew.in("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeNotIn(Object... value) {
        ew.notIn("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeBetween(Object value, Object value1) {
        ew.between("user_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeNotBetween(Object value, Object value1) {
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_code", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeLike(String value) {
        ew.like("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCodeNotLike(String value) {
        ew.notLike("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_code", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameIsNull() {
        ew.isNull("file_name");
        return this;
    }

    public MerchantBatchRecordCondition orFileNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_name");
        return this;
    }

    public MerchantBatchRecordCondition andFileNameIsNotNull() {
        ew.isNotNull("file_name");
        return this;
    }

    public MerchantBatchRecordCondition orFileNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_name");
        return this;
    }

    public MerchantBatchRecordCondition andFileNameEq(Object value) {
        ew.eq("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameNe(Object value) {
        ew.ne("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameGt(Object value) {
        ew.gt("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameGe(Object value) {
        ew.ge("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameLt(Object value) {
        ew.lt("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameLe(Object value) {
        ew.le("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameIn(Object... value) {
        ew.in("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameNotIn(Object... value) {
        ew.notIn("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameBetween(Object value, Object value1) {
        ew.between("file_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameNotBetween(Object value, Object value1) {
        ew.notBetween("file_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_name", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameLike(String value) {
        ew.like("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andFileNameNotLike(String value) {
        ew.notLike("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition orFileNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_name", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountIsNull() {
        ew.isNull("count");
        return this;
    }

    public MerchantBatchRecordCondition orCountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("count");
        return this;
    }

    public MerchantBatchRecordCondition andCountIsNotNull() {
        ew.isNotNull("count");
        return this;
    }

    public MerchantBatchRecordCondition orCountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("count");
        return this;
    }

    public MerchantBatchRecordCondition andCountEq(Object value) {
        ew.eq("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountNe(Object value) {
        ew.ne("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountGt(Object value) {
        ew.gt("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountGe(Object value) {
        ew.ge("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountLt(Object value) {
        ew.lt("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountLe(Object value) {
        ew.le("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountIn(Object... value) {
        ew.in("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountNotIn(Object... value) {
        ew.notIn("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountBetween(Object value, Object value1) {
        ew.between("count", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orCountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("count", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andCountNotBetween(Object value, Object value1) {
        ew.notBetween("count", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orCountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("count", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andCountLike(String value) {
        ew.like("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andCountNotLike(String value) {
        ew.notLike("count", value);
        return this;
    }

    public MerchantBatchRecordCondition orCountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("count", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountIsNull() {
        ew.isNull("sum_amount");
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sum_amount");
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountIsNotNull() {
        ew.isNotNull("sum_amount");
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sum_amount");
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountEq(Object value) {
        ew.eq("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountNe(Object value) {
        ew.ne("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountGt(Object value) {
        ew.gt("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountGe(Object value) {
        ew.ge("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountLt(Object value) {
        ew.lt("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountLe(Object value) {
        ew.le("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountIn(Object... value) {
        ew.in("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountNotIn(Object... value) {
        ew.notIn("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountBetween(Object value, Object value1) {
        ew.between("sum_amount", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sum_amount", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountNotBetween(Object value, Object value1) {
        ew.notBetween("sum_amount", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sum_amount", value, value1);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountLike(String value) {
        ew.like("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition andSumAmountNotLike(String value) {
        ew.notLike("sum_amount", value);
        return this;
    }

    public MerchantBatchRecordCondition orSumAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sum_amount", value);
        return this;
    }
}