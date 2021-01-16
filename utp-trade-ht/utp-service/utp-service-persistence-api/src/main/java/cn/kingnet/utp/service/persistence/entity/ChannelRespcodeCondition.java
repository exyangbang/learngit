package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ChannelRespcodeCondition {
    private PlusEntityWrapper<ChannelRespcode> ew;

    public ChannelRespcodeCondition() {
        this.ew = new PlusEntityWrapper(ChannelRespcode.class);
    }

    public static ChannelRespcodeCondition builder() {
        return new ChannelRespcodeCondition();
    }

    public PlusEntityWrapper<ChannelRespcode> build() {
        return this.ew;
    }

    public ChannelRespcodeCondition or() {
        this.ew.orNew();
        return this;
    }

    public ChannelRespcodeCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ChannelRespcode.class);
    }

    public ChannelRespcodeCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ChannelRespcodeCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ChannelRespcodeCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ChannelRespcodeCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ChannelRespcodeCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ChannelRespcodeCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ChannelRespcodeCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ChannelRespcodeCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ChannelRespcodeCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ChannelRespcodeCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ChannelRespcodeCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ChannelRespcodeCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ChannelRespcodeCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ChannelRespcodeCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ChannelRespcodeCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ChannelRespcodeCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ChannelRespcodeCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public ChannelRespcodeCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public ChannelRespcodeCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public ChannelRespcodeCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public ChannelRespcodeCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeIsNull() {
        ew.isNull("channel_respcode");
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_respcode");
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeIsNotNull() {
        ew.isNotNull("channel_respcode");
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_respcode");
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeEq(Object value) {
        ew.eq("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeNe(Object value) {
        ew.ne("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeGt(Object value) {
        ew.gt("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeGe(Object value) {
        ew.ge("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeLt(Object value) {
        ew.lt("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeLe(Object value) {
        ew.le("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeIn(Object... value) {
        ew.in("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeNotIn(Object... value) {
        ew.notIn("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeBetween(Object value, Object value1) {
        ew.between("channel_respcode", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_respcode", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeNotBetween(Object value, Object value1) {
        ew.notBetween("channel_respcode", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_respcode", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeLike(String value) {
        ew.like("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespcodeNotLike(String value) {
        ew.notLike("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespcodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_respcode", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescIsNull() {
        ew.isNull("channel_respdesc");
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_respdesc");
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescIsNotNull() {
        ew.isNotNull("channel_respdesc");
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_respdesc");
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescEq(Object value) {
        ew.eq("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescNe(Object value) {
        ew.ne("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescGt(Object value) {
        ew.gt("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescGe(Object value) {
        ew.ge("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescLt(Object value) {
        ew.lt("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescLe(Object value) {
        ew.le("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescIn(Object... value) {
        ew.in("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescNotIn(Object... value) {
        ew.notIn("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescBetween(Object value, Object value1) {
        ew.between("channel_respdesc", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_respdesc", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescNotBetween(Object value, Object value1) {
        ew.notBetween("channel_respdesc", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_respdesc", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescLike(String value) {
        ew.like("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andChannelRespdescNotLike(String value) {
        ew.notLike("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition orChannelRespdescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_respdesc", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public ChannelRespcodeCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public ChannelRespcodeCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public ChannelRespcodeCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public ChannelRespcodeCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public ChannelRespcodeCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public ChannelRespcodeCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public ChannelRespcodeCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public ChannelRespcodeCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public ChannelRespcodeCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public ChannelRespcodeCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public ChannelRespcodeCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ChannelRespcodeCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ChannelRespcodeCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelRespcodeCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ChannelRespcodeCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ChannelRespcodeCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}